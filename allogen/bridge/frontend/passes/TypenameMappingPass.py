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
from allogen.bridge.frontend.CompilerPass import CompilerPass
from allogen.bridge.frontend.CompilerType import UserDefinedType
from allogen.bridge.idl.Objects import IDLNamespace, IDLClass, IDLConstructor, IDLDestructor


class TypenameMappingPass(CompilerPass):
    """
    This compiler pass checks all types used in the IDL file
    """

    def __init__(self):
        self.missing_typenames = []
        self.mapped_typenames = []

        self.namespaces = []
        pass

    def run(self, context):
        """:type context allogen.bridge.frontend.CompilerContext.CompilerContext"""

        context.classes = {}
        self.context = context

        for decl in context.idl.declarations:
            if decl.__class__ == IDLNamespace:
                self.enter_namespace(context, decl)
            elif decl.__class__ == IDLClass:
                self.create_class(context, decl, None)

        for clazz in context.all_classes.values():
            clazz.typename = UserDefinedType(user_type=clazz, context=context, typename=None)

        self.create_type_tree(context)
        self.resolve_types(context)

        # perform the second phase lookup
        # print context.types
        for type in context.mapped_types:
            type.lookup(context)

    def create_type_tree(self, context):
        for clazz in context.classes.values():
            namespaces = clazz.cpp_namespace.split('::')

            ns_dict = context.types
            for namespace in namespaces:
                if not namespace in ns_dict:
                    ns_dict[namespace] = dict()
                ns_dict = ns_dict[namespace]

            ns_dict[clazz.name] = clazz

    def resolve_types(self, context):
        for (class_name, clazz) in context.classes.items():
            clazz.types_used = []

            for method in clazz.constructors + [clazz.destructor] + clazz.methods:
                if method.ret is not None:
                    type = self.map_typename(method.ret, scope=clazz.cpp_namespace)
                    if type and type not in clazz.types_used and isinstance(type, UserDefinedType):
                        clazz.types_used.append(type.user_type)

                for argument in method.arguments:
                    if argument.type is not None:
                        type = self.map_typename(argument.type, scope=clazz.cpp_namespace)
                        if type and type not in clazz.types_used and isinstance(type, UserDefinedType):
                            clazz.types_used.append(type.user_type)

            # we dont include ourselves on this list
            if clazz in clazz.types_used:
                clazz.types_used.remove(clazz)

    def map_typename(self, typename, scope):
        """:type typename allogen.bridge.idl.Objects.IDLTypename"""
        self.context.resolve(typename, scope)
        return typename.linked_type

    def enter_namespace(self, context, namespace):
        """
        :type namespace IDLNamespace
        """
        for decl in namespace.contents:
            if decl.__class__ == IDLNamespace:
                self.enter_namespace(context, decl)
            elif decl.__class__ == IDLClass:
                self.create_class(context, decl, namespace.name)

    def create_class(self, context, cls, namespace):
        """
        :type cls IDLClass
        """

        fully_qualified_name = cls.name
        cls.namespaces = []
        if namespace:
            fully_qualified_name = namespace + "::" + fully_qualified_name
            cls.namespaces = namespace.split('::')

        context.classes[fully_qualified_name] = cls
        cls.cpp_namespace = namespace
        cls.fully_qualified_name = fully_qualified_name

    def get_order(self):
        return 300
