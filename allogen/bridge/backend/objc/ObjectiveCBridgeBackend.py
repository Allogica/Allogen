# Copyright (c) 2017, Allogica
#
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without modification,
# are permitted provided that the following conditions are met:
#
#     * Redistributions of source code must retain the above copyright notice,
#       this list of conditions and the following disclaimer.
#     * Redistributions in binary form must reproduce the above copyright notice,
#       this list of conditions and the following disclaimer in the documentation
#       and/or other materials provided with the distribution.
#     * Neither the name of Allogen nor the names of its contributors
#       may be used to endorse or promote products derived from this software
#       without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
# A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
# EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
# PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
# PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
# NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
from string import Template

from allogen.bridge.backend.BridgeBackend import BridgeBackend
from allogen.bridge.backend.Constants import codegen_notice
from allogen.bridge.frontend.CompilerContext import CompilerContext
from allogen.bridge.idl.Objects import IDLClass
import os

from allogen.codegen.Constructs import Import, Field, Raw, Comment
from allogen.codegen.StreamSourceCodeWriter import StreamSourceCodeWriter
from allogen.codegen.languages.ObjectiveCLanguage import ObjectiveCImplementationLanguageSourceGenerator

T_init_new = Template(
    """return new ${cpp_class_name}(${cpp_arg_names});"""
)

T_init = Template(
    """if(self) {
        BridgedConstructor<${cpp_class_name}(${cpp_signature})>::call(self, [](${cpp_args}) {${cpp_body}}${cpp_arg_names_comma});
    }
    return self;"""
)

T_bridge = Template(
    """return BridgedMethod<${cpp_class_name}, ${cpp_return_type}(${cpp_signature})>::call(self, [](${cpp_class_name}* wself${cpp_args}) {${cpp_body}}${cpp_arg_names});"""
)

T_bridge_static = Template(
    """return BridgedMethod<${cpp_class_name}, ${cpp_return_type}(${cpp_signature})>::call([](${cpp_args}) {${cpp_body}}${cpp_arg_names});"""
)

T_destroy = Template(
    """BridgedMethod<${cpp_class_name}, void()>::call(self, [](${cpp_class_name} *wself) { delete wself; });"""
)

T_forward = Template(
    """return wself->${method_name}(${method_args});"""
)


class ObjectiveCBridgeBackend(BridgeBackend):
    def run(self, context: CompilerContext):
        pass

    def handle_class(self, context: CompilerContext, clazz: IDLClass):
        clazz.target_object.objc_vars = [
            Field(name='_cppObject', type=clazz.objc_cpp_typename)
        ]

        for constructor in clazz.constructors:
            if not constructor.body:
                constructor.body = T_init_new.substitute({
                    'cpp_class_name': clazz.fully_qualified_name,
                    'cpp_arg_names': ", ".join(list(map(lambda a: a.name, constructor.arguments))),
                })

            constructor.target_object.body = [
                Raw(T_init.substitute({
                    'cpp_class_name': clazz.fully_qualified_name,
                    'cpp_signature': ", ".join(map(lambda a: a.type.linked_type.get_bridge_name(), constructor.arguments)),
                    'cpp_args': ", ".join(map(lambda a: a.type.linked_type.get_bridge_name() + " " + a.name, constructor.arguments)),
                    'cpp_arg_names': ", ".join(map(lambda a: a.name, constructor.arguments)),
                    'cpp_arg_names_comma': ", ".join([''] + list(map(lambda a: a.name, constructor.arguments))),
                    'cpp_body': constructor.body
                }))
            ]

        clazz.destructor.target_object.body = [
            Raw(T_destroy.substitute({
                'cpp_class_name': clazz.fully_qualified_name
            })),
            '[super dealloc];', '\n'
        ]

        for method in clazz.methods:
            if not method.body:
                method.body = T_forward.substitute({
                    'method_name': method.name,
                    'method_args': ", ".join(map(lambda a: a.name, method.arguments)),
                })

            if not method.static:
                method.target_object.body = [
                    Raw(T_bridge.substitute({
                        'cpp_class_name': clazz.fully_qualified_name,
                        'cpp_return_type': method.ret.linked_type.get_bridge_name(),
                        'cpp_signature': ", ".join(map(lambda a: a.type.linked_type.get_bridge_name(), method.arguments)),
                        'cpp_args': ", ".join(
                            [''] + list(map(lambda a: a.type.linked_type.get_bridge_name() + " " + a.name, method.arguments))),
                        'cpp_arg_names': ", ".join(
                            [''] + list(map(lambda a: a.type.linked_type.bridge_argument(method, clazz, method, a),
                                            method.arguments))),
                        'cpp_body': method.body
                    }))
                ]
            else:
                method.target_object.body = [
                    Raw(T_bridge_static.substitute({
                        'cpp_class_name': clazz.fully_qualified_name,
                        'cpp_return_type': method.ret.linked_type.get_bridge_name(),
                        'cpp_signature': ", ".join(map(lambda a: a.type.linked_type.get_bridge_name(), method.arguments)),
                        'cpp_args': ", ".join(
                            [''] + list(map(lambda a: a.type.linked_type.get_bridge_name() + " " + a.name, method.arguments))),
                        'cpp_arg_names': ", ".join(
                            [''] + list(map(lambda a: a.type.linked_type.bridge_argument(method, clazz, method, a),
                                            method.arguments))),
                        'cpp_body': method.body
                    }))
                ]


        clazz.private_object.members[0].body = [
            '_cppObject = cppObject; return self;'
        ]
        clazz.private_object.members[1].body = [
            'return _cppObject;'
        ]

    def codegen(self, context: CompilerContext, clazz: IDLClass):
        header_path = os.path.join(context.bridge_out_dir, clazz.objc_impl_file_location)
        dirname = os.path.dirname(header_path)

        if not os.path.exists(dirname):
            os.makedirs(dirname)

        generator = ObjectiveCImplementationLanguageSourceGenerator()

        with open(header_path, 'w') as f:
            writer = StreamSourceCodeWriter(stream=f, generator=generator)

            writer(Comment(codegen_notice, multiline=True), writer.nl, writer.nl)
            writer(Import('Allogen/ObjectiveC.hpp', quoted=False), writer.nl)
            writer(Import(clazz.objc_name + '.h', quoted=True))
            writer(Import(clazz.objc_name + '+Private.h', quoted=True))
            writer(writer.nl)
            writer(map(lambda x: Import(x.path, quoted=True), context.idl.includes))
            writer(writer.nl)
            writer('using namespace Allogen::ObjectiveC;', writer.nl, writer.nl)

            writer('// Since Objective-C does not allow classes to be nested inside a C++ namespace,', writer.nl,
                   '// we emulate the behabviour by importing all parent namespaces.', writer.nl)

            accumulated = []
            for ns in clazz.namespaces:
                accumulated.append(ns)
                writer('using namespace ', ('::'.join(accumulated)), ';', writer.nl)

            writer(writer.nl)


            writer(clazz.target_object)
            writer(clazz.private_object)
