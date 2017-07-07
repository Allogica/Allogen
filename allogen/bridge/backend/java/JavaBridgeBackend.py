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
from allogen.bridge.idl.Objects import IDLDestructor, IDLTypename, IDLClass
from allogen.codegen.Constructs import Function, Raw, MethodArgument, TypeName, Constructor, Destructor, Comment, \
    Namespace
from allogen.codegen.FileSourceCodeWriter import FileSourceCodeWriter
from allogen.codegen.StreamSourceCodeWriter import StreamSourceCodeWriter
from allogen.codegen.languages.CppLanguage import CppImplementationFileLanguage, CppHeaderFileLanguage

import os

jni_return_types = {
    'void': 'void',
    'string': 'jstring',
    'long': 'jlong',
    'uint32_t': 'jint'
}

cpp_type_maps = {
    'string': 'std::string'
}

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

    def handle_class(self, context, cls):
        cls.jni_methods = []

        for constructor in cls.constructors:
            constructor.name = '_init'
            jni_impl = self.create_jni_function(cls, constructor, len(cls.constructors) >= 2, context)
            cls.jni_methods.append(jni_impl)

            # fixup the constructor return type
            jni_impl.ret.name = 'jlong'

            if not constructor.body:
                constructor.body = T_init_new.substitute({
                    'cpp_class_name': cls.fully_qualified_name,
                    'cpp_arg_names': ", ".join(map(lambda a: a.name, constructor.arguments)),
                })

            jni_impl.body = [
                Raw(T_init.substitute({
                    'cpp_class_name': cls.fully_qualified_name,
                    'cpp_signature': ", ".join(map(lambda a: get_cpp_type(a.type, context), constructor.arguments)),
                    'cpp_args': ", ".join(
                        map(lambda a: get_cpp_type(a.type, context) + " " + a.name, constructor.arguments)),
                    'cpp_arg_names': ", ".join(map(lambda a: a.name, constructor.arguments)),
                    'cpp_arg_names_comma': ", ".join([''] + map(lambda a: a.name, constructor.arguments)),
                    'cpp_body': constructor.body
                }))
            ]

        cls.destructor.name = 'finalize'
        jni_destructor_impl = self.create_jni_function(cls, cls.destructor, False, context)
        cls.jni_methods.append(jni_destructor_impl)

        jni_destructor_impl.body = [
            Raw(T_destroy.substitute({
                'cpp_class_name': cls.fully_qualified_name,
                'cpp_signature': ", ".join(map(lambda a: get_cpp_type(a.type, context), cls.destructor.arguments)),
                'cpp_args': ", ".join(
                    [''] + map(lambda a: get_cpp_type(a.type, context) + " " + a.name, cls.destructor.arguments)),
                'cpp_arg_names': ", ".join([''] + map(lambda a: a.name, cls.destructor.arguments)),
            }))
        ]

        for (method_name, overloads) in cls.methods_dict.iteritems():
            for method in overloads:
                jni_impl = self.create_jni_function(cls, method, len(overloads) >= 2, context)
                cls.jni_methods.append(jni_impl)

                if not method.body:
                    method.body = T_forward.substitute({
                        'method_name': method.name,
                        'method_args': ", ".join(map(lambda a: a.name, method.arguments)),
                    })

                jni_impl.body = [
                    Raw(T_bridge.substitute({
                        'cpp_class_name': cls.fully_qualified_name,
                        'cpp_return_type': get_cpp_type(method.ret, context),
                        'cpp_signature': ", ".join(map(lambda a: get_cpp_type(a.type, context), method.arguments)),
                        'cpp_args': ", ".join(
                            [''] + map(lambda a: get_cpp_type(a.type, context) + " " + a.name, method.arguments)),
                        'cpp_arg_names': ", ".join([''] + map(lambda a: a.name, method.arguments)),
                        'cpp_body': cls.get_method(method.name).body
                    }))
                ]

    def create_jni_function(self, cls, method, has_overloads, context):
        # we need a return type remapping
        jni_return = get_jni_type(method.ret, context, cls.cpp_namespace)
        if method.ret is not None and method.ret.name in context.classes:
            cls.types_used += [method.ret.name]

        # we also need to remap and append all function arguments...
        jni_args = []
        for arg in method.arguments:
            jni_args += [
                MethodArgument(name=arg.name, type=TypeName(name=get_jni_type(arg.type, context, cls.cpp_namespace))),
            ]

        package_name = ".".join(map(lambda ns: ns.lower(), cls.namespaces))

        # if the function has an overload, the name must be further mangled
        if has_overloads:
            jni_name = jni_method_overload_name_mangling(cls.obj.name, package_name=package_name,
                                                         method_name=method.name,
                                                         args=method.arguments)
        else:
            jni_name = jni_method_name_mangling(cls.obj.name, package_name=package_name, method_name=method.name)

        return Function(
            name=jni_name, ret=jni_return + ' JNICALL', cpp_extern='extern "C" JNIEXPORT ',
            args=[
                     MethodArgument(name="_env_", type=TypeName(name="JNIEnv", pointer=True)),
                     MethodArgument(name="_jthis_", type=TypeName(name="jobject"))
                 ] + jni_args,
            body=[method.body])

    def codegen(self, context, cls):
        path = os.path.join(context.bridge_out_dir, cls.obj.name)

        with open(path + '.hpp', 'w') as file:
            generator = CppHeaderFileLanguage()
            stream = StreamSourceCodeWriter(file, generator=generator)

            stream(Comment(content=codegen_notice, multiline=True), stream.nl, stream.nl)

            file_style_class_name = "/".join(map(lambda ns: ns.lower(), cls.namespaces) + ['']) + cls.name

            idl_includes = []
            for include in context.idl.includes:
                if include.angled:
                    idl_includes.append('#include <' + include.path + '>')
                else:
                    idl_includes.append('#include "' + include.path + '"')

            file.writelines(map(lambda l: l + '\n',
                                [
                                    '#pragma once',
                                    '',
                                    '#include <Allogen/JNI.h>',
                                    ''
                                ]
                                +
                                map(lambda x: '#include "' + x.path + '"', context.idl.includes)
                                +
                                ['']
                                +
                                map(lambda x: '#include "' + x.name + '.hpp"', cls.types_used) + [
                                    '',
                                    'ALLOGEN_BRIDGED_CLASS_CONVERTER(' + cls.fully_qualified_name + ', "' + file_style_class_name + '")',
                                    ''
                                ]))

            cls.bridge_header = cls.name + '.hpp'

        with open(path + '.cpp', 'w') as file:
            generator = CppImplementationFileLanguage()
            stream = StreamSourceCodeWriter(file, generator=generator)

            stream(Comment(content=codegen_notice, multiline=True), stream.nl, stream.nl)

            # file.write('#include <jni.h>\n')
            # file.write('#include <Allogen/JNI/Converter.h>\n')
            # file.write('#include <Allogen/JNI/WrappedMethod.h>\n')
            # file.write('#include "../example.h"\n')

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


def get_cpp_type(type, context):
    if type.name in cpp_type_maps:
        return cpp_type_maps[type.name]
    if isinstance(type.linked_type, IDLClass):
        return type.linked_type.fully_qualified_name
    return type.name


def get_jni_type(type, context, scope=''):
    if type is None:
        return 'void'

    if type.linked_type and isinstance(type.linked_type, IDLClass):
        return 'jobject'
    if type.name in jni_return_types:
        return jni_return_types[type.name]
    else:
        found = context.find_type(type.name, scope=scope)
        if found:
            return 'jobject'

        raise Exception("Unknown return type: " + type.name)


mangling_map = {
    'string': {'complex': True, 'value': 'Ljava_lang_String'},
    'uint32_t': {'complex': False, 'value': 'I'}
}


def jni_method_name_mangling(class_name, package_name, method_name):
    if method_name is None:
        method_name = 'finalize'

    class_name = class_name.replace('_', '_1')
    method_name = method_name.replace('_', '_1')

    package = []
    if package_name is not None:
        package_name = package_name.replace('_', '_1')
        package = package_name.split(".")

    name = "Java_" + ("_".join(package + [class_name, method_name]))

    return name


def jni_method_overload_name_mangling(class_name, package_name, method_name, args=list()):
    if method_name is None:
        method_name = 'finalize'

    use_numbered_separator = False

    def fix_underscore(name, use_numbered_separator):
        if '_' in name:
            use_numbered_separator = True
            fixed_name = ''
            for c in name:
                fixed_name += c
                if c == '_':
                    fixed_name = '_1'
            name = fixed_name
        return name, use_numbered_separator

    package = []
    if package_name is not None:
        package_name, use_numbered_separator = fix_underscore(package_name, use_numbered_separator)
        package = package_name.split(".")

    class_name, use_numbered_separator = fix_underscore(class_name, use_numbered_separator)
    method_name, use_numbered_separator = fix_underscore(method_name, use_numbered_separator)

    name = "Java_" + ("_".join(package + [class_name, method_name])) + '__'

    i = 2
    overloads = []
    for arg in args:
        arg_name = arg.type.name

        overload_name = ''
        if arg_name in mangling_map:
            overload_name += mangling_map[arg_name]['value']
            if use_numbered_separator and mangling_map[arg_name]['complex']:
                overload_name += '_' + str(i)
                i = i + 1

            overloads.append(overload_name)
        else:
            raise Exception('Invalid mangling type: ' + arg_name)

    return name + ("__".join(overloads))
