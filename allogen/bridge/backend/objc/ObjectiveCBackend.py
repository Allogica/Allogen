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

from allogen.bridge.backend.Backend import Backend
from allogen.bridge.backend.objc.ObjectiveCBridgeBackend import ObjectiveCBridgeBackend
from allogen.bridge.backend.objc.ObjectiveCTargetBackend import ObjectiveCTargetBackend
from allogen.bridge.backend.objc.types.ObjectiveCBlock import ObjectiveCBlock
from allogen.bridge.backend.objc.types.ObjectiveCUserDefinedType import ObjectiveCUserDefinedType
from allogen.bridge.frontend.CompilerType import UserDefinedType
from allogen.bridge.frontend.types.Primitives import PrimitiveType
from allogen.bridge.idl.Objects import *


class ObjectiveCBackend(Backend):
    def register_builtins(self, context: allogen.bridge.frontend.CompilerContext.CompilerContext, builtins):
        context.user_defined_type_class = ObjectiveCUserDefinedType

        builtins['void'] = lambda context, typename: PrimitiveType(
            context=context, typename=typename,
            bridge_type='void', target_type='void')
        builtins['bool'] = lambda context, typename: PrimitiveType(
            context=context, typename=typename,
            bridge_type='bool', target_type='boolean')

        builtins['string'] = lambda context, typename: PrimitiveType(
            context=context, typename=typename,
            bridge_type='std::string', target_type='NSString*')

        for bits in [8, 16, 32, 64]:
            builtins['int' + str(bits) + '_t'] = lambda context, typename, bits=bits: PrimitiveType(
                context=context, typename=typename,
                bridge_type='int' + str(bits) + '_t', target_type='int' + str(bits) + '_t')
            builtins['uint' + str(bits) + '_t'] = lambda context, typename, bits=bits: PrimitiveType(
                context=context, typename=typename,
                bridge_type='uint' + str(bits) + '_t', target_type='uint' + str(bits) + '_t')

        builtins['lambda'] = lambda context, typename: ObjectiveCBlock(context, typename)
        # builtins['shared_ptr'] = lambda context, typename: SharedPtrType(context, typename)

    def create_target_backend(self):
        return ObjectiveCTargetBackend()

    def create_bridge_backend(self):
        return ObjectiveCBridgeBackend()

    def namespace(self, namespace: IDLNamespace):
        pass

    def clazz_pre(self, namespace: IDLNamespace, clazz: IDLClass):
        clazz.objc_name = 'AE'+clazz.name

        clazz.target_object.name = clazz.objc_name
        clazz.target_object.parents = ['NSObject']

        clazz.objc_cpp_typename = TypeName(name=clazz.fully_qualified_name, pointer=True)

        clazz.objc_header_file_location = "/".join(clazz.namespaces + ['']) + clazz.objc_name + '.h'
        clazz.objc_private_header_file_location = "/".join(clazz.namespaces + ['']) + clazz.objc_name + '+Private.h'
        clazz.objc_impl_file_location = "/".join(clazz.namespaces + ['']) + clazz.objc_name + '.mm'

        clazz.private_object = Class(
            name=clazz.objc_name+'(Private)',
            members=[
                Constructor(args=[
                    MethodArgument(name='cppObject', type=TypeName(clazz.fully_qualified_name, pointer=True))
                ]),
                Method(name='toCppObject', ret=TypeName(clazz.fully_qualified_name, pointer=True))
            ]
        )

    def interface(self, namespace: IDLNamespace, interface: IDLInterface):
        interface.objc_name = interface.name

    def constructor(self, namespace: IDLNamespace, clazz: IDLClass, constructor: IDLConstructor):
        constructor.objc_name = constructor.name

    def destructor(self, namespace: IDLNamespace, clazz: IDLClass, destructor: IDLDestructor):
        destructor.objc_name = destructor.name

    def method(self, namespace: IDLNamespace, clazz: IDLClass, method: IDLMethod):
        method.objc_name = method.name
        self.typename(namespace, clazz, method, None, method.ret)

        if isinstance(method.ret.linked_type, UserDefinedType):
            method.target_object.ret.pointer = True
            method.target_object.ret.name = method.ret.linked_type.objc_name

    def argument(self, namespace: IDLNamespace, clazz: IDLClass, method: IDLMethod, argument: IDLMethodArgument):
        argument.objc_name = argument.name
        self.typename(namespace, clazz, method, argument, argument.type)

        if isinstance(argument.type.linked_type, UserDefinedType):
            argument.target_object.type.pointer = True
            argument.target_object.type.name = argument.type.linked_type.objc_name

            if 'Callback' in argument.annotations:
                # workaround for ObjectiveC prefix
                argument.target_object.type.name = argument.type.linked_type.get_target_name()

        if isinstance(argument.type.linked_type, ObjectiveCBlock):
            argument.target_object.type.name = argument.type.linked_type.get_target_name()

    def typename(self, namespace: IDLNamespace, clazz: IDLClass, method: IDLMethod, argument: IDLMethodArgument,
                 typename: IDLTypename):
        typename.objc_name = typename.name
        self.context.resolve(typename)
