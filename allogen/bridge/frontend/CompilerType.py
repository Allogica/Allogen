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

import allogen
from allogen.bridge.idl.Objects import IDLTypename, IDLMethod, IDLMethodArgument, IDLClass
from allogen.codegen.Constructs import LanguageConstruct


class CompilerType(object):
    typename = None  # type: allogen.bridge.idl.Objects.IDLTypename
    forward = None  # type: str

    def __init__(self, context, typename: IDLTypename, scope=None):
        self.context = context
        self.typename = typename
        self.scope = scope

    def __str__(self):
        return str(self.__dict__)

    def get_bridge_name(self) -> str:
        return self.typename.name

    def get_target_name(self) -> str:
        return self.typename.name

    def target_return(self, object: LanguageConstruct, method: IDLMethod):
        pass

    def target_argument(self, object: LanguageConstruct, method: IDLMethod, argument: IDLMethodArgument):
        argument.forward = argument.name

    def bridge_return(self, object: LanguageConstruct, method: IDLMethod):
        pass

    def bridge_argument(self, object: LanguageConstruct, clazz: IDLClass, method: IDLMethod,
                        argument: IDLMethodArgument):
        return argument.name

    def lookup(self, context):
        pass


class UserDefinedType(CompilerType):
    def __init__(self, user_type: IDLClass, **kwargs):
        super(UserDefinedType, self).__init__(**kwargs)
        self.user_type = user_type

    def get_bridge_name(self):
        return self.user_type.fully_qualified_name

    def get_target_name(self):
        return self.user_type.name

    def filter(self, object):
        pass

    def __getattr__(self, item):
        return getattr(self.user_type, item)


class BuiltinType(CompilerType):
    def __init__(self, **kwargs):
        super(BuiltinType, self).__init__(**kwargs)
