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
from allogen.bridge.idl.Objects import IDLTypename, IDLClass
from allogen.codegen.Constructs import Function, Raw, MethodArgument, TypeName, Comment, Namespace
from allogen.codegen.StreamSourceCodeWriter import StreamSourceCodeWriter
from allogen.codegen.languages.CppLanguage import CppImplementationFileLanguage, CppHeaderFileLanguage

import os

T_init_new = Template(
    """return new ${cpp_class_name}(${cpp_arg_names});"""
)

T_init = Template(
    """return WrappedMethod<void, ${cpp_class_name}(${cpp_signature})>::call(_env_, _jthis_, [](${cpp_args}) {${cpp_body}}${cpp_arg_names_comma});"""
)

T_bridge = Template(
    """return WrappedMethod<${cpp_class_name}, ${cpp_return_type}(${cpp_signature})>::call(_env_, _jthis_, [](${cpp_class_name}* wself${cpp_args}) {${cpp_body}}${cpp_arg_names});"""
)

T_destroy = Template(
    """return WrappedMethod<${cpp_class_name}, void()>::call(_env_, _jthis_, [](${cpp_class_name} *wself) { delete wself; });"""
)

T_forward = Template(
    """return wself->${method_name}(${method_args});"""
)


class JavaBridgeBackend(BridgeBackend):
    def full_pass(self, context):
        pass

    def handle_class(self, context: CompilerContext, cls: IDLClass):
        cls.jni_methods = []

        for constructor in cls.constructors:
            jni_impl = self.create_jni_function(cls, constructor, context)
            cls.jni_methods.append(jni_impl)

            # fixup the constructor return type
            jni_impl.ret.name = 'jlong'

            if not constructor.body:
                constructor.body = T_init_new.substitute({
                    'cpp_class_name': cls.fully_qualified_name,
                    'cpp_arg_names': ", ".join(list(map(lambda a: a.name, constructor.arguments))),
                })

            jni_impl.body = [
                Raw(T_init.substitute({
                    'cpp_class_name': cls.fully_qualified_name,
                    'cpp_signature': ", ".join(map(lambda a: a.type.java_cpp_type, constructor.arguments)),
                    'cpp_args': ", ".join(
                        map(lambda a: a.type.java_cpp_type + " " + a.name, constructor.arguments)),
                    'cpp_arg_names': ", ".join(map(lambda a: a.name, constructor.arguments)),
                    'cpp_arg_names_comma': ", ".join([''] + list(map(lambda a: a.name, constructor.arguments))),
                    'cpp_body': constructor.body
                }))
            ]

        cls.destructor.name = 'finalize'
        jni_destructor_impl = self.create_jni_function(cls, cls.destructor, context)
        cls.jni_methods.append(jni_destructor_impl)

        jni_destructor_impl.body = [
            Raw(T_destroy.substitute({
                'cpp_class_name': cls.fully_qualified_name,
                'cpp_signature': ", ".join(map(lambda a: a.type.java_cpp_type, cls.destructor.arguments)),
                'cpp_args': ", ".join(
                    [''] + list(map(lambda a: a.type.java_cpp_type + " " + a.name, cls.destructor.arguments))),
                'cpp_arg_names': ", ".join([''] + list(map(lambda a: a.name, cls.destructor.arguments))),
            }))
        ]

        for (method_name, overloads) in cls.methods_dict.items():
            for method in overloads:
                jni_impl = self.create_jni_function(cls, method, context)
                cls.jni_methods.append(jni_impl)

                if not method.body:
                    method.body = T_forward.substitute({
                        'method_name': method.name,
                        'method_args': ", ".join(map(lambda a: a.name, method.arguments)),
                    })

                jni_impl.body = [
                    Raw(T_bridge.substitute({
                        'cpp_class_name': cls.fully_qualified_name,
                        'cpp_return_type': method.ret.java_cpp_type,
                        'cpp_signature': ", ".join(map(lambda a: a.type.java_cpp_type, method.arguments)),
                        'cpp_args': ", ".join(
                            [''] + list(map(lambda a: a.type.java_cpp_type + " " + a.name, method.arguments))),
                        'cpp_arg_names': ", ".join(
                            [''] + list(map(lambda a: a.type.linked_type.bridge_argument(jni_impl, cls, method, a),
                                       method.arguments))),
                        'cpp_body': cls.get_method(method.name).body
                    }))
                ]

    def create_jni_function(self, cls, method, context):
        # we need a return type remapping
        jni_return = method.ret.java_jni_type
        if method.ret is not None and method.ret.name in context.classes:
            cls.types_used += [method.ret.name]

        # we also need to remap and append all function arguments...
        jni_args = []
        for arg in method.arguments:
            jni_args += [
                MethodArgument(name=arg.name, type=TypeName(name=arg.type.java_jni_type)),
            ]

        package_name = ".".join(map(lambda ns: ns.lower(), cls.namespaces))

        return Function(
            name=method.java_jni_name, ret=jni_return + ' JNICALL', cpp_extern='extern "C" JNIEXPORT ',
            args=[
                     MethodArgument(name="_env_", type=TypeName(name="JNIEnv", pointer=True)),
                     MethodArgument(name="_jthis_", type=TypeName(name="jobject"))
                 ] + jni_args,
            body=[method.body])

    def codegen(self, context: CompilerContext, cls: IDLClass):
        path = os.path.join(context.bridge_out_dir, cls.java_jni_file_location)
        dirname = os.path.dirname(path)

        if not os.path.exists(dirname):
            os.makedirs(dirname)

        with open(path + '.hpp', 'w') as file:
            generator = CppHeaderFileLanguage()
            stream = StreamSourceCodeWriter(file, generator=generator)

            stream(Comment(content=codegen_notice, multiline=True), stream.nl, stream.nl)

            idl_includes = []
            for include in context.idl.includes:
                if include.angled:
                    idl_includes.append('#include <' + include.path + '>')
                else:
                    idl_includes.append('#include "' + include.path + '"')


            file.writelines(list(map(lambda l: l + '\n',
                                [
                                    '#pragma once',
                                    '',
                                    '#include <Allogen/JNI.hpp>',
                                    ''
                                ]
                                +
                                list(map(lambda x: '#include "' + x.path + '"', context.idl.includes))
                                +
                                ['']
                                +
                                list(map(lambda x: '#include "' + x.name + '.hpp"',
                                    filter(lambda x: isinstance(x, IDLClass), cls.types_used))) + [
                                    '',
                                    'ALLOGEN_BRIDGED_CLASS_CONVERTER(' + cls.fully_qualified_name + ', "' + cls.java_class_file + '")',
                                    ''
                                ])))

            cls.bridge_header = cls.name + '.hpp'

        with open(path + '.cpp', 'w') as file:
            generator = CppImplementationFileLanguage()
            stream = StreamSourceCodeWriter(file, generator=generator)

            stream(Comment(content=codegen_notice, multiline=True), stream.nl, stream.nl)

            file.writelines(map(lambda l: l + '\n', [
                '#include "' + cls.bridge_header + '"',
                '',
                'using namespace Allogen::JNI;',
                ''
            ]))

            package = Namespace('Allogen', content=[Namespace('Example', content=[stream.joined(
                [stream.nl, stream.nl],
                cls.jni_methods
            )])])
            stream(package)
