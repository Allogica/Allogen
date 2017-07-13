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

import typing

from allogen.bridge.backend.Backend import Backend
from allogen.bridge.backend.java.JavaBridgeBackend import JavaBridgeBackend
from allogen.bridge.backend.java.JavaTargetBackend import JavaTargetBackend
from allogen.bridge.backend.java.types.JavaLambda import JavaLambda
from allogen.bridge.frontend.CompilerType import UserDefinedType, CompilerType
from allogen.bridge.frontend.types.Primitives import PrimitiveType
from allogen.bridge.idl.Objects import *


class JavaBackend(Backend):
    # Z 	                    boolean
    # B	                        byte
    # C	                        char
    # S 	                    short
    # I	                        int
    # J	                        long
    # F	                        float
    # D	                        double
    # L fully-qualified-class;  fully-qualified-class
    # [ type	                type[]
    # ( arg-types ) ret-type	method type
    def register_builtins(self, builtins: typing.List[CompilerType]):
        builtins['void'] = lambda context, typename: PrimitiveType(
            context=context, typename=typename,
            jni_type='void', bridge_type='void', target_type='void',
            java_signature='V', java_complex_mangling=False)
        builtins['bool'] = lambda context, typename: PrimitiveType(
            context=context, typename=typename,
            jni_type='jboolean', bridge_type='bool', target_type='boolean',
            java_signature='Z', java_complex_mangling=False)

        builtins['string'] = lambda context, typename: PrimitiveType(
            context=context, typename=typename,
            jni_type='jstring', bridge_type='std::string', target_type='String',
            java_signature='Ljava/lang/String;', java_complex_mangling=True)

        java_signature_names = {
            8: 'B',
            16: 'S',
            32: 'I',
            64: 'J'
        }
        for (bits, java) in {8: 'byte', 16: 'short', 32: 'int', 64: 'long'}.items():
            builtins['int' + str(bits) + '_t'] = lambda context, typename, bits=bits, java=java: PrimitiveType(
                context=context, typename=typename,
                jni_type='j' + java, bridge_type='int' + str(bits) + '_t', target_type=java,
                java_signature=java_signature_names[bits], java_complex_mangling=False)
            builtins['uint' + str(bits) + '_t'] = lambda context, typename, bits=bits, java=java: PrimitiveType(
                context=context, typename=typename,
                jni_type='j' + java, bridge_type='uint' + str(bits) + '_t', target_type=java,
                java_signature=java_signature_names[bits], java_complex_mangling=False)

        builtins['lambda'] = lambda context, typename: JavaLambda(context, typename)

    def create_target_backend(self):
        return JavaTargetBackend()

    def create_bridge_backend(self):
        return JavaBridgeBackend()

    def output_files_for_clazz(self, clazz: IDLClass):
        return [
            clazz.java_file_location,
            clazz.java_cpp_file_location,
            clazz.java_header_file_location
        ]

    # visitors
    def namespace(self, namespace: IDLNamespace):
        namespace.java_name = namespace.name

    def clazz_pre(self, namespace: IDLNamespace, clazz: IDLClass):
        clazz.java_name = clazz.name
        clazz.java_packages = list(map(lambda ns: ns.lower(), clazz.namespaces))
        clazz.java_package_name = ".".join(clazz.java_packages)
        clazz.java_fully_qualified_name = clazz.java_package_name + '.' + clazz.name

        clazz.java_class_file = "/".join(list(map(lambda ns: ns.lower(), clazz.namespaces)) + ['']) + clazz.java_name
        clazz.java_file_location = "/".join(
            list(map(lambda ns: ns.lower(), clazz.namespaces)) + ['']) + clazz.java_name + '.java'

        clazz.java_jni_file_location = "/".join(clazz.namespaces + ['']) + clazz.name
        clazz.java_cpp_file_location = "/".join(clazz.namespaces + ['']) + clazz.name + '.cpp'
        clazz.java_header_file_location = "/".join(clazz.namespaces + ['']) + clazz.name + '.hpp'

    def interface(self, namespace: IDLNamespace, interface: IDLInterface):
        self.clazz(namespace, interface)
        pass

    def constructor(self, namespace: IDLNamespace, clazz: IDLClass, constructor: IDLConstructor):
        constructor.name = '_init'
        self.method(namespace, clazz, constructor, constructor=True)

    def destructor(self, namespace: IDLNamespace, clazz: IDLClass, destructor: IDLDestructor):
        destructor.name = 'finalize'
        self.method(namespace, clazz, destructor)

    def method(self, namespace: IDLNamespace, clazz: IDLClass, method: IDLMethod,
               constructor=False):
        method.java_name = method.name
        self.typename(namespace, clazz, method, None, method.ret)

        if not constructor and not isinstance(clazz, IDLInterface):
            method.target_object.native = True

        method.java_jni_name = jni_method_name_mangling(
            clazz=clazz,
            package_name=clazz.java_package_name,
            method=method)

        all_methods = dict(clazz.methods_dict)
        all_methods['_init'] = clazz.constructors

        # fix overloads
        if method.name in all_methods and len(all_methods[method.name]) >= 2:
            method.java_jni_name = jni_method_overload_name_mangling(
                clazz=clazz,
                package_name=clazz.java_package_name,
                method=method
            )

    def argument(self, namespace: IDLNamespace, clazz: IDLClass, method: IDLMethod, argument: IDLMethodArgument):
        """:type argument allogen.bridge.idl.Objects.IDLMethodArgument"""
        argument.java_name = argument.name
        self.typename(namespace, clazz, method, argument, argument.type)

        if 'Callback' in argument.annotations:
            callback = argument.annotations['Callback']
            callback_function = argument.type.linked_type

            # register a new helper interface
            callback_interface = IDLInterface(
                name=callback.attributes['interface'],
                methods=[
                    IDLMethod(
                        name=callback.attributes['method'],
                        ret=callback_function.lambda_return_type,
                        arguments=callback_function.lambda_arguments
                    )
                ]
            )

            callback_interface.namespaces = clazz.namespaces
            callback_interface.for_class = clazz
            callback_interface.for_method = method
            callback_interface.for_argument = argument

            argument.callback_interface = callback_interface
            argument.type.name = callback_interface.name
            argument.target_object.type.name = callback_interface.name

            self.compiler.synthesize_interface(callback_interface)
            self.context.add_sister_class(callback_interface)

            self.clazz_pre(namespace, callback_interface)

    def typename(self, namespace: IDLNamespace, clazz: IDLClass, method: IDLMethod, argument: IDLMethodArgument,
                 typename: IDLTypename):
        # remap to Java type
        typename.java_cpp_type = typename.linked_type.get_bridge_name()

        if typename.linked_type and isinstance(typename.linked_type, PrimitiveType):
            typename.java_jni_type = typename.linked_type.jni_type
        elif typename.linked_type and isinstance(typename.linked_type, UserDefinedType):
            typename.java_jni_type = 'jobject'
            typename.linked_type.java_signature = 'L' + (
                '/'.join(typename.linked_type.user_type.java_packages)
            ) + '/' + typename.name + ';'
            typename.linked_type.java_complex_mangling = True
        else:
            typename.java_jni_type = 'jobject'

        typename.java_type = typename.linked_type.get_target_name()


def jni_method_name_mangling(clazz: IDLClass, package_name: str, method: IDLMethod):
    class_name = clazz.java_name.replace('_', '_1')
    method_name = method.java_name.replace('_', '_1')

    package = []
    if package_name is not None:
        package_name = package_name.replace('_', '_1')
        package = package_name.split(".")

    name = "Java_" + ("_".join(package + [class_name, method_name]))

    return name


def jni_method_overload_name_mangling(clazz, package_name, method):
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

    class_name, use_numbered_separator = fix_underscore(clazz.java_name, use_numbered_separator)
    method_name, use_numbered_separator = fix_underscore(method.java_name, use_numbered_separator)

    name = "Java_" + ("_".join(package + [class_name, method_name])) + '__'

    i = 2
    overloads = []
    for arg in method.arguments:
        overload_name = ''
        mangled_name = arg.type.linked_type.java_signature
        mangled_name = mangled_name.replace('/', '_')
        if isinstance(arg.type.linked_type, UserDefinedType):
            mangled_name = mangled_name[:-1]

        overload_name += mangled_name
        if use_numbered_separator and arg.type.linked_type.java_complex_mangling:
            overload_name += '_' + str(i)
            i = i + 1

        overloads.append(overload_name)

    return name + ("__".join(overloads))
