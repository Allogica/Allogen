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

from . import CppLanguage
import copy

from functools import partial

visibility_scope_mapping = {
    VisibilityPublic: 'public',
    VisibilityPrivate: 'private',
    VisibilityProtected: 'protected',
    VisibilityDefault: 'default',
    None: 'public'
}

type_mapping = {
    'std::string': 'NSString',
    'string': 'NSString'
}


class ObjectiveCLanguageSourceGenerator(LanguageSourceGenerator):
    def __init__(self):
        super(ObjectiveCLanguageSourceGenerator, self).__init__()
        self.first_parameter = False
        self.first_parameter_constructor = False

        # Objective-C has no nesting neither namespaces. If we find a nested class or enum,
        # we move it to the root and generate it again.
        self.moved_to_root = []

    def _objc_property_attributes(self, writer, property):
        return writer.joined(
            ', ', [
                (property.readonly, 'readonly', 'readwrite'),
                (property.weak, 'weak', 'strong'),
                (property.atomic, 'atomic'),
                (property.nonatomic, 'nonatomic'),
                (property.getter, ['getter=', property.getter]),
                (property.setter, ['setter=', property.setter]),
                (property.copy, 'copy', 'assign'),
                (property.retain, 'retain'),
                (property.unsafe_unretained, 'unsafe_unretained')
            ]
        )

    def _objc_method_signature(self, writer, method, with_colon=True, constructor=False):
        self.first_parameter = True
        self.first_parameter_constructor = constructor

        writer(
            (method.static, '+', '-'),
            ' (', method.ret, ')', method.name, (len(method.args) > 0 and constructor, 'With'),
            writer.indented(writer.joined(
                [writer.nl, writer.tab, ' ' * (4 + len(method.name))], method.args
            )),
            (with_colon, ';')
        )

    def _objc_enum_naming(self, name, enum=None):
        if enum is None:
            enum = self.get_parent_node()

        def first_letter_upper(s):
            return s[0].capitalize() + s[1:]

        return enum.name + ("".join(map(first_letter_upper, name.lower().split('_'))))

    def typename(self, writer, type):
        writer(
            type.name,
            (type.pointer, '*'),
            (type.reference, '*')  # this is not very accurate, but this is the closest thing to a reference
        )

    def import_(self, writer, imp):
        writer(
            '#import ',
            (imp.quoted, '"', '<'),
            imp.symbol,
            (imp.quoted, '"', '>'),
            writer.nl
        )

    def clazz(self, writer, cls):
        parent = self.get_parent_node()
        if isinstance(parent, Class):
            ccls = copy.deepcopy(cls)
            ccls.name = parent.name + cls.name
            self.moved_to_root.append(ccls)
            return False
        return True

    def constructor_initializer(self, writer, initializer):
        writer(
            initializer.member, ' = ', initializer.local, ';'
        )

    def argument(self, writer, arg):
        message_arg_name = arg.name
        if arg.objc_in_message_name:
            message_arg_name = arg.objc_in_message_name
        if self.first_parameter and self.first_parameter_constructor:
            message_arg_name = message_arg_name[0].capitalize() + message_arg_name[1:]
            self.first_parameter = False
        elif self.first_parameter and not self.first_parameter_constructor:
            message_arg_name = ''
            self.first_parameter = False

        writer(
            message_arg_name, ':', '(', arg.type, ')', arg.name
        )

    def constructor_delegated_initializer(self, writer, const):
        pass

    def func(self, writer, member):
        pass  # TODO implement

    def namespace(self, writer, namespace):
        writer(namespace.content)
        for o in self.moved_to_root:
            writer(o)
        self.moved_to_root = []

    def enum(self, writer, enum):
        parent = self.get_parent_node()
        if isinstance(parent, Class):
            enum = copy.deepcopy(enum)
            enum.name = parent.name + enum.name
            self.moved_to_root.append(enum)
            return False
        return True

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


class ObjectiveCInterfaceLanguageSourceGenerator(ObjectiveCLanguageSourceGenerator):
    def __init__(self, **kwargs):
        super(ObjectiveCInterfaceLanguageSourceGenerator, self).__init__()

    def clazz(self, writer, cls):
        if not super(ObjectiveCInterfaceLanguageSourceGenerator, self).clazz(writer, cls):
            return False

        doc_nl = write_doxygen_like_documentation_block(writer, cls)
        writer(
            writer.tab,
            '@interface ', cls.name, [
                (cls.parents, [' : ', cls.parents])
            ], writer.nl,

            writer.joined(
                [writer.nl], cls.members
            ),

            writer.nl, writer.tab,
            '@end',

            doc_nl
        )

    def member_var(self, writer, member):
        doc_ln = write_doxygen_like_documentation_block(writer, member)
        writer(
            writer.tab,
            '@property ',
            '(', self._objc_property_attributes(writer, member), ') ',
            member.type, ' ', member.name, ';',
            doc_ln
        )

    def constructor(self, writer, const):
        doc_nl = write_doxygen_like_documentation_block(writer, const)

        const.name = 'init'
        const.ret = 'id'

        self._objc_method_signature(writer, const, constructor=True)

        writer(
            doc_nl
        )

    def destructor(self, writer, dest):
        dest.name = 'dealloc'
        dest.ret = 'void'

        doc_nl = write_doxygen_like_documentation_block(writer, dest)
        self._objc_method_signature(writer, dest)
        writer(doc_nl)

    def member_func(self, writer, member):
        doc_nl = write_doxygen_like_documentation_block(writer, member)
        self._objc_method_signature(writer, member)
        writer(
            doc_nl
        )

    def alias(self, writer, alias):
        writer(
            'typedef ', alias.name, ' ', alias.to, ';'
        )

    def enum(self, writer, enum):
        if not super(ObjectiveCInterfaceLanguageSourceGenerator, self).enum(writer, enum):
            return False

        doc_ln = write_doxygen_like_documentation_block(writer, enum)
        writer(
            writer.tab,
            'typedef NS_ENUM(', (
                enum.type, [' : ', enum.type], 'NSInteger'
            ), ', ', enum.name, ')',
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
        write_doxygen_like_documentation_block(writer, enum_def)
        writer(
            writer.tab,
            self._objc_enum_naming(enum_def.name),
            (enum_def.value, [' = ', enum_def.value])
        )


class ObjectiveCImplementationLanguageSourceGenerator(ObjectiveCLanguageSourceGenerator):
    def __init__(self, **kwargs):
        super(ObjectiveCImplementationLanguageSourceGenerator, self).__init__()

    def _objc_method_body(self, writer, method, extras=None):
        writer(
            ' {', writer.nl,
            writer.indented(
                writer.joined(
                    writer.nl, map(
                        lambda x: [writer.tab, x],
                        method.body
                    )
                )
            ),
            writer.nl, writer.tab, '}'
        )

    def clazz(self, writer, cls):
        if not super(ObjectiveCImplementationLanguageSourceGenerator, self).clazz(writer, cls):
            return False

        doc_nl = write_doxygen_like_documentation_block(writer, cls)
        writer(
            writer.tab,
            '@implementation ', cls.name
        )

        if cls.objc_vars:
            writer([
                ' {', writer.nl,
                writer.indented(
                map(
                    lambda x: [writer.tab, x.type, ' ', x.name, ';', writer.nl],
                    cls.objc_vars
                )
                ),
                writer.tab, '}', writer.nl
            ])

        writer(
            writer.nl,

            writer.joined(
                [writer.nl], cls.members
            ),

            writer.nl, writer.tab,
            '@end',

            doc_nl
        )

    def member_var(self, writer, member):
        pass

    def constructor(self, writer, const):
        const.name = 'init'
        const.ret = 'id'

        self._objc_method_signature(writer, const, with_colon=False, constructor=True)
        self._objc_method_body(writer, const)
        writer(writer.nl)

    def destructor(self, writer, dest):
        dest.name = 'dealloc'
        dest.ret = 'void'

        self._objc_method_signature(writer, dest, with_colon=False)
        self._objc_method_body(writer, dest)
        writer(writer.nl)

    def member_func(self, writer, member):
        self._objc_method_signature(writer, member, with_colon=False)
        self._objc_method_body(writer, member)
        writer(writer.nl)

    def alias(self, writer, alias):
        pass

    def enum(self, writer, enum):
        pass

    def enum_def(self, writer, enum_def):
        pass
