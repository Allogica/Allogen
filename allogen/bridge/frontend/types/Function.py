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

from allogen.bridge.frontend.CompilerType import BuiltinType
from pyparsing import *
from allogen.bridge.idl.Parser import *

lambda_syntax = (
    typename('type') + Literal('(').suppress() + (
        InterfaceDict(delimitedList(ZeroOrMore(method_argument)), param='name')
    )('arguments') + Literal(')').suppress()
)


class FunctionType(BuiltinType):
    def __init__(self, context, typename, **kwargs):
        super(FunctionType, self).__init__(context=context, typename=typename, **kwargs)

        parsed = lambda_syntax.parseString(typename.template_arguments)
        parser = Parser()

        self.lambda_return_type = parser.parse_typename(parsed.type)
        self.lambda_arguments = parser.parse_arguments(parsed)

    def lookup(self, context):
        self.context.resolve(self.lambda_return_type, scope=self.scope)
        for argument in self.lambda_arguments:
            self.context.resolve(argument.type, scope=self.scope)

    def get_bridge_name(self):
        arg_types = ", ".join(map(lambda t: t.type.linked_type.get_bridge_name(), self.lambda_arguments))
        return 'std::function<'+self.lambda_return_type.linked_type.get_bridge_name()+'(' + arg_types + ')>'
