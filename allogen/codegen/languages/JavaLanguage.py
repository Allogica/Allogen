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

from allogen.codegen.LanguageSourceGenerator import *
from allogen.codegen.Constructs import *

from functools import partial

visibility_scope_mapping = {
    VisibilityPublic: 'public',
    VisibilityPrivate: 'private',
    VisibilityProtected: 'protected',
    VisibilityDefault: 'default',
    None: 'public'
}

type_mapping = {
    'int8_t': 'byte',
    'uint8_t': 'byte',

    'int16_t': 'short',
    'uint16_t': 'short',

    'int32_t': 'int',
    'uint32_t': 'int',

    'int64_t': 'long',
    'uint64_t': 'long',

    'size_t': 'long',
    'char': 'char',

    'std::string': 'String',
    'string': 'String'
}


class JavaLanguageSourceGenerator(LanguageSourceGenerator):
    def __init__(self, dialect=14):
        super(JavaLanguageSourceGenerator, self).__init__()
        self.dialect = dialect

    def typename(self, writer, type):
        writer(
            (type.final, 'final ')
        )
        if type.name in type_mapping:
            writer(type_mapping[type.name])
        else:
            writer(type.name)

    def clazz(self, writer, cls):
        doc_nl = writeDoxygenLikeDocumentationBlock(writer, cls)
        writer(
            writer.tab,
            visibility_scope_mapping[cls.visibility],
            (cls.final, ' final'),
            ' class ', cls.name, ' {', writer.nl,
            writer.indented(writer.joined(
                writer.nl,
                cls.members
            )), writer.nl, writer.tab, '}',
            doc_nl
        )

    def member_var(self, writer, member):
        doc_nl = writeDoxygenLikeDocumentationBlock(writer, member)
        writer(
            writer.tab,
            visibility_scope_mapping[member.visibility],
            (member.final, ' final'), ' ',
            member.type, ' ', member.name,
            (
                member.default_value, [
                    ' = ', member.default_value
                ]
            ), ';',
            doc_nl
        )

    def _func_body(self, writer, func):
        writer(
            (
                func.body is not None, [
                    ' {', writer.nl,
                    writer.indented(
                        writer.joined(
                            writer.nl, map(
                                lambda x: [writer.tab, x],
                                func.body
                            )
                        )
                    ),
                    writer.nl, writer.tab, '}'
                ], [
                    ';'
                ]
            )
        )

    def member_func(self, writer, member):
        doc_nl = writeDoxygenLikeDocumentationBlock(writer, member)
        writer(
            writer.tab,
            visibility_scope_mapping[member.visibility],
            (member.final, ' final'), ' ',
            member.ret, ' ', member.name,
            '(', writer.joined(
                ', ', member.args
            ), ')',
            partial(self.__class__._func_body, self, writer, member),
            doc_nl
        )

    def constructor(self, writer, const):
        cls = self.get_last_node_of_kind(Class)

        doc_nl = writeDoxygenLikeDocumentationBlock(writer, const)
        writer(
            writer.tab,
            visibility_scope_mapping[const.visibility],
            ' ', cls.name,
            '(', writer.joined(
                ', ', const.args
            ), ')',
            partial(self.__class__._func_body, self, writer, const),
            doc_nl
        )

    def constructor_initializer(self, writer, initializer):
        raise Exception("Constructor initializers are not supported by the generator implementation")

    def constructor_delegated_initializer(self, writer, const):
        raise Exception("Delegated constructor initializers are not supported by the generator implementation")

    def destructor(self, writer, dest):
        doc_nl = writeDoxygenLikeDocumentationBlock(writer, dest)
        writer(
            writer.tab,
            '@Override', writer.nl, writer.tab,
            visibility_scope_mapping[dest.visibility], ' ',
            'void finalize() throws Throwable',
            partial(self.__class__._func_body, self, writer, dest),
            doc_nl,
        )

    def argument(self, writer, arg):
        writer(
            (arg.final, 'final '),
            arg.type, ' ', arg.name
        )

    def namespace(self, writer, namespace):
        writer(namespace.content)

    def return_statement(self, writer, ret):
        raise Exception("Return expressions are not supported by the generator implementation")

    def assignment(self, writer, assign):
        raise Exception("Assignment expressions are not supported by the generator implementation")

    def if_statement(self, writer, if_expr):
        raise Exception("If expressions are not supported by the generator implementation")

    def equal_comparison(self, writer, comparison):
        raise Exception("Equal comparison expressions are not supported by the generator implementation")

    def enum(self, writer, enum):
        doc_nl = writeDoxygenLikeDocumentationBlock(writer, enum)
        writer(
            writer.tab,
            'enum ', enum.name, ' {', writer.nl,
            writer.indented(
                writer.joined(
                    [',', writer.nl, writer.nl], enum.definitions
                ),
                ';', writer.nl
            ),
            writer.tab, '}',
            doc_nl
        )

    def enum_def(self, writer, d):
        doc_nl = writeDoxygenLikeDocumentationBlock(writer, d)
        writer(
            writer.tab,
            d.name,
            (
                d.value, [
                    ' = ', d.value
                ]
            )
        )

    def comment(self, writer, comment):
        writer((
            comment.multiline is True, [
                '/*', writer.nl,
                map(lambda x: [writer.tab, ' * ', x, writer.nl], comment.content.split('\n')),
                writer.tab, " */"
            ], [
                writer.joined(
                    [writer.nl, writer.tab],
                    map(lambda x: ['// ', x], comment.content.split('\n'))
                )
            ]
        ))

    def return_statement(self, writer, ret):
        writer(
            'return'
        )
        if ret.expression is not None:
            writer(' ', ret.expression)
        writer(';')

    def assignment(self, writer, assign):
        writer(
            assign.to, ' = ',
            assign.expression, ';'
        )

    def if_statement(self, writer, if_expr):
        writer(
            'if(', if_expr.conditions, ') {', writer.nl,
            writer.indented(
                map(
                    lambda x: [writer.tab, x],
                    if_expr.then_expr
                )
            ),
            writer.nl, writer.tab, '}'
        )
        if if_expr.else_expr is not None:
            writer(
                ' else {', writer.nl,
                writer.indented(
                    map(
                        lambda x: [writer.tab, x],
                        if_expr.else_expr
                    )
                ),
                writer.nl, writer.tab, '}'
            )

    def equal_comparison(self, writer, comparison):
        writer(
            comparison.a, ' == ', comparison.b
        )
