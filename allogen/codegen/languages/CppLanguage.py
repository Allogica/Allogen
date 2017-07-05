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

from functools import partial

from allogen.codegen.LanguageSourceGenerator import *
from allogen.codegen.LanguageNamingConvention import *

from allogen.codegen.Constructs import *

visibility_scope_mapping = {
    VisibilityPublic: 'public',
    VisibilityPrivate: 'private',
    VisibilityProtected: 'protected'
}


class CppLanguageSourceGenerator(LanguageSourceGenerator):
    def __init__(self, dialect=14):
        super(CppLanguageSourceGenerator, self).__init__()
        self.dialect = dialect

    def typename(self, writer, type):
        writer(
            (type.const, 'const '),
            (type.mutable, 'mutable '),
            type.name,
            (type.reference, '&'),
            (type.pointer, '*')
        )

    def func_body(self, writer, func, forced=False):
        if func.body is not None:
            writer(
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
            )
        elif func.trivial is True:
            writer(' = default;')
        elif func.abstract is True:
            writer(' = 0;')
        else:
            if forced:
                writer(" { }")
            else:
                writer(";")

    def func_attributes(self, writer, func):
        writer(
            func.cpp_extern,
            (func.virtual, 'virtual '),
            (func.static, 'static '),
            (func.inline, 'inline ')
        )

    def func_specifiers(self, writer, func):
        writer(
            (func.final, ' final'),
            (func.override, ' override'),
            (func.const, ' const')
        )

    def constructor_initializer(self, writer, initializer):
        writer(
            initializer.member, '(', (
                initializer.move, 'std::move('
            ),
            initializer.local,
            (
                initializer.move, ')'
            ), ')'
        )

    def constructor_delegated_initializer(self, writer, initializer):
        writer(
            initializer.name, '(',
            ", ".join(initializer.arguments),
            ')'
        )

    def constructor_initializers(self, writer, constructor):
        writer(
            ' :', writer.nl,
            writer.indented(writer.indented(
                writer.joined(
                    [', ', writer.nl],
                    map(
                        lambda x: [writer.tab, x],
                        constructor.initializers
                    )
                )
            )),
            (
                not constructor.body, [
                    ' {}'
                ]
            )
        )

    def _argument(self, writer, arg, include_default_value=True):
        writer(
            arg.type, " ", arg.name, (
                include_default_value and arg.default_value, [
                    ' = ', arg.default_value
                ]
            )
        )

    def namespace(self, writer, namespace):
        ns_new_line = writer.nl
        if len(namespace.content) == 1 and isinstance(namespace.content[0], Namespace):
            ns_new_line = None

        writer(
            "namespace ", namespace.name, " {", ns_new_line
        )

        if ns_new_line is not None:
            writer(namespace.content)

        else:
            writer(
                " ",  # add separator to avoid ... {namespace... problems
                writer.indented(
                    namespace.content
                ),
                ns_new_line
            )

        writer(
            ns_new_line, "}"
        )

    def return_statement(self, writer, ret):
        writer(
            'return', (
                ret.expression is not None, [
                    ' ', ret.expression
                ]
            ),
            ';'
        )

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
            writer.nl, writer.tab, '}',
            (
                if_expr.else_expr is not None, [
                    ' else {', writer.nl,
                    writer.indented(
                        map(
                            lambda x: [writer.tab, x],
                            if_expr.else_expr
                        )
                    ),
                    writer.nl, writer.tab, '}'
                ]
            )
        )

    def equal_comparison(self, writer, comparison):
        writer(
            comparison.a, ' == ', comparison.b
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

    def change_visiblity_scope(self, writer, scope, force=False):
        if scope is None:
            return

        cls = self.get_parent_node()
        if cls is None or not isinstance(cls, Class):
            return

        if scope not in visibility_scope_mapping:
            return

        if cls.__last_vis_scope != scope or force is True:
            writer(writer.deindented(
                writer.tab, visibility_scope_mapping[scope], ':', writer.nl
            ))
            cls.__last_vis_scope = scope


class CppHeaderFileLanguage(CppLanguageSourceGenerator):
    def clazz(self, writer, cls):
        self.change_visiblity_scope(writer, cls.visibility, cls.force_visibility_change)

        doc_ln = writeDoxygenLikeDocumentationBlock(writer, cls)
        writer(
            writer.tab, "class ", cls.name,
            partial(self.__class__.class_body, self, writer, cls),
            doc_ln
        )

    def template_spec_class(self, writer, cls):
        self.change_visiblity_scope(writer, cls.visibility, cls.force_visibility_change)

        doc_ln = writeDoxygenLikeDocumentationBlock(writer, cls)
        writer(
            writer.tab, 'template<', cls.template, '>', writer.nl,
            writer.tab, "class ", cls.name, '<', cls.specialization, '>',
            partial(self.__class__.class_body, self, writer, cls),
            doc_ln
        )

    def class_body(self, writer, cls):
        writer(
            (
                len(cls.parents) > 0, [
                    ' : ', writer.joined(
                        [', '], map(
                            lambda x: ['public ', x],
                            cls.parents
                        )
                    )
                ]
            ),
            " {", writer.nl,
            writer.indented(
                writer.joined(
                    '\n', cls.members
                )
            ),
            writer.nl,
            writer.tab, '};'
        )

    def member_var(self, writer, member):
        self.change_visiblity_scope(writer, member.visibility, member.force_visibility_change)

        doc_ln = writeDoxygenLikeDocumentationBlock(writer, member)
        writer(
            writer.tab,
            member.type, " ", member.name,
            (
                (member.out_of_line is not None and member.default_value), [
                    " = ", member.default_value
                ]
            ),
            ';',
            doc_ln
        )

    def member_func(self, writer, member, template=None):
        self.change_visiblity_scope(writer, member.visibility, member.force_visibility_change)

        doc_ln = writeDoxygenLikeDocumentationBlock(writer, member)
        writer(
            (
                template, [
                    writer.tab, template, writer.nl
                ]
            ),
            writer.tab,
            partial(self.__class__.func_attributes, self, writer, member),
            member.ret, " ",
            member.name,
            '(',
            writer.joined(
                ', ', member.args
            ),
            ')',
            partial(self.__class__.func_specifiers, self, writer, member),
            (
                member.inline, [
                    partial(self.__class__.func_body, self, writer, member, forced=True),
                ], [';']
            ),
            doc_ln
        )

    def member_func_template(self, writer, member):
        self.member_func(writer, member, member.template)

    def constructor(self, writer, const):
        cls = self.get_last_node_of_kind(Class)

        self.change_visiblity_scope(writer, const.visibility, const.force_visibility_change)

        doc_ln = writeDoxygenLikeDocumentationBlock(writer, const)
        writer(
            writer.tab,
            partial(self.__class__.func_attributes, self, writer, const),
            cls.name, '(',
            writer.joined(
                ', ', const.args
            ),
            ')',
            (
                const.inline, [
                    (
                        const.initializers is not None, [
                            partial(self.__class__.constructor_initializers, self, writer, const)
                        ]
                    ),
                    partial(self.__class__.func_body, self, writer, const, forced=True)
                ], [';']
            ),
            doc_ln
        )

    def destructor(self, writer, dest):
        cls = self.get_last_node_of_kind(Class)
        self.change_visiblity_scope(writer, dest.visibility, dest.force_visibility_change)

        doc_ln = writeDoxygenLikeDocumentationBlock(writer, dest)
        writer(
            writer.tab,
            partial(self.__class__.func_attributes, self, writer, dest),
            '~' + cls.name + '()',
            partial(self.__class__.func_specifiers, self, writer, dest),
            (
                dest.inline, [
                    partial(self.__class__.func_body, self, writer, dest, forced=True)
                ], [';']
            ),
            doc_ln
        )

    def func(self, writer, func):
        doc_ln = writeDoxygenLikeDocumentationBlock(writer, func)
        writer(
            writer.tab,
            partial(self.__class__.func_attributes, self, writer, func),
            func.ret, " ",
            func.name,
            '(',
            writer.joined(
                ', ', func.args
            ),
            ')',
            partial(self.__class__.func_specifiers, self, writer, func),
            (
                func.inline, [
                    partial(self.__class__.func_body, self, writer, func, forced=True),
                ], [';']
            ),
            doc_ln
        )

    def argument(self, writer, arg):
        super(CppHeaderFileLanguage, self)._argument(writer, arg, True)

    def alias(self, writer, alias):
        writer((
            not alias.out_of_line, [
                partial(writeDoxygenLikeDocumentationBlock, writer, alias),
                "using ", alias.name + " = ", alias.to + ";"
            ]
        ))

    def enum(self, writer, enum):
        self.change_visiblity_scope(writer, enum.visibility, enum.force_visibility_change)

        doc_ln = writeDoxygenLikeDocumentationBlock(writer, enum)
        writer(
            writer.tab,
            (
                enum.cppNonTypesafe, ['enum'], ['enum class'],
            ),
            ' ', enum.name,
            (enum.type, [' : ', enum.type]),
            ' {', writer.nl, writer.indented(
                writer.joined(
                    [',', writer.nl, writer.nl],
                    enum.definitions
                ),
                ';'
            ),
            writer.nl, writer.tab, '}',
            doc_ln
        )

    def enum_def(self, writer, enum_def):
        writeDoxygenLikeDocumentationBlock(writer, enum_def)
        writer(
            writer.tab,
            enum_def.name,
            (enum_def.value, [' = ', enum_def.value])
        )


class CppImplementationFileLanguage(CppLanguageSourceGenerator):
    def clazz(self, writer, cls):
        writer(
            writer.joined([writer.nl, writer.nl], cls.members)
        )
        return False

    def template_spec_class(self, writer, cls):
        return self.clazz(writer, cls)

    def member_var(self, writer, member):
        if not member.out_of_line or not member.default_value:
            return False
        cls = self.get_last_node_of_kind(Class)

        writer(
            writer.tab,
            member.type, " ", cls.name, '::', member.name,
            ' = ', member.default_value, ';'
        )

    def member_func(self, writer, member, template=None):
        if member.inline:
            return False

        cls = self.get_last_node_of_kind(Class)

        writer(
            (template, [writer.tab, template, writer.nl]),
            writer.tab,
            member.ret, " ",
            cls.name, '::', member.name,
            '(',
            writer.joined(
                ', ', member.args
            ),
            ')',
            partial(self.__class__.func_specifiers, self, writer, member),
            partial(self.__class__.func_body, self, writer, member, forced=True),
        )

    def member_func_template(self, writer, member):
        self.member_func(writer, member, member.template)

    def constructor(self, writer, const):
        if const.inline:
            return False

        cls = self.get_last_node_of_kind(Class)

        writer(
            writer.tab,
            cls.name, '::', cls.name, '(',
            writer.joined(
                ', ', const.args
            ),
            ')',
            (
                const.initializers is not None, [
                    partial(self.__class__.constructor_initializers, self, writer, const),
                ]
            ),
            partial(self.__class__.func_body, self, writer, const, forced=True)
        )

    def destructor(self, writer, dest):
        if dest.inline:
            return False

        cls = self.get_last_node_of_kind(Class)

        writer(
            writer.tab,
            '~', cls.name, '::', cls.name,
            '()',
            partial(self.__class__.func_specifiers, self, writer, dest),
            partial(self.__class__.func_body, self, writer, dest, forced=True),
        )

    def func(self, writer, func, template=None):
        if func.inline:
            return False

        writer(
            (template, [writer.tab, template, writer.nl]),
            writer.tab,
            partial(self.__class__.func_attributes, self, writer, func),
            func.ret, " ", func.name,
            '(',
            writer.joined(
                ', ', func.args
            ),
            ')',
            partial(self.__class__.func_specifiers, self, writer, func),
            partial(self.__class__.func_body, self, writer, func, forced=True),
        )

    def argument(self, writer, arg):
        super(CppImplementationFileLanguage, self)._argument(writer, arg, False)

    def enum(self, writer, enum):
        return False

    def enum_definition(self, writer, enum):
        return False


class StandardCppLanguageNamingConvention(LanguageNamingConvention):
    def _standard_naming(self, name):
        return "_".join(map(lambda x: x.lower(), name))

    def class_name(self, name):
        return self._standard_naming(name)

    def enum_name(self, name):
        return self._standard_naming(name)

    def enum_definition(self, name):
        return self._standard_naming(name)

    def member_func_name(self, name):
        return self._standard_naming(name)

    def member_var_name(self, name):
        return self._standard_naming(name)

    def argument_name(self, name):
        return self._standard_naming(name)


class AllogicaCppLanguageNamingConvention(LanguageNamingConvention):
    def _camel_case(self, ss):
        return "".join(map(lambda x: x.capitalize(), ss))

    def _lower_camel_case(self, ss):
        output = self._camel_case(ss)
        return output[0].lower() + output[1:]

    def class_name(self, name):
        return self._camel_case(name)

    def enum_name(self, name):
        return self._camel_case(name)

    def enum_definition(self, name):
        return "_".join(map(lambda x: x.upper(), name))

    def member_func_name(self, name):
        return self._lower_camel_case(name)

    def member_var_name(self, name):
        return self._lower_camel_case(name)

    def argument_name(self, name):
        return self._lower_camel_case(name)
