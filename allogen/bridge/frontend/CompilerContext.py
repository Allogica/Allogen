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
from allogen.bridge.frontend.CompilerType import UserDefinedType
from allogen.bridge.frontend.types.Primitives import *
from allogen.bridge.idl.Objects import *

class CompilerContext(object):
    compiler = None  # type: Compiler
    backend = None  # type: Backend

    types = {}  # type: list(IDLClass)
    builtin_types = {}  # type: list(BuiltinType)
    mapped_types = []  #type: list(CompilerType)

    classes = {}  # type: dict(str, IDLClass)
    interfaces = {}  # type: dict(str, IDLInterface)

    all_classes = {}  # type: dict(str, IDLClass)

    idl = None  # type: IDL
    file = None  # type: str
    source = None  # type: str

    def __init__(self):
        self.types = {}
        self.builtin_types = {}

    def add_builtin_type(self, name, clazz):
        if name not in self.builtin_types:
            self.builtin_types[name] = clazz

    def create_builtin_type(self, typename, scope=None):
        """
        :param typename: IDLTypename
        :return:
        """
        if typename.name in self.builtin_types:
            constructor = self.builtin_types[typename.name]

            t = constructor(self, typename)
            t.scope = scope

            self.mapped_types.append(t)
            return t

        return None

    def find_type(self, name, scope=''):
        if scope is None:
            scope = ""
        namespaces = scope.split('::')
        ns_dict = self.types
        for namespace in namespaces:
            if name in ns_dict:
                return ns_dict[name]

            if not namespace in ns_dict:
                return None
            ns_dict = ns_dict[namespace]

        if name in ns_dict:
            return ns_dict[name]
        return None

    def resolve(self, typename, scope=''):
        if typename.linked_type:
            return typename.linked_type

        found = self.find_type(typename.name, scope=scope)
        if found:
            typename.linked_type = found.typename
            return found.typename

        builtin = self.create_builtin_type(typename, scope=scope)
        if builtin:
            typename.linked_type = builtin
            return builtin

        raise Exception("Could not resolve type "+typename.name)

    def add_sister_class(self, sister_class):
        self.interfaces[sister_class.name] = sister_class
