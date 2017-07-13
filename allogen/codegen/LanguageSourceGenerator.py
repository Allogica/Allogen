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

from allogen.codegen.Constructs import *


class LanguageSourceGenerator(object):
    def __init__(self):
        self.node_stack = []

    def get_current_node(self):
        return self.node_stack[-1]

    def get_last_node_of_kind(self, kind):
        for node in reversed(self.node_stack):
            if isinstance(node, kind):
                return node
        return None

    def get_parent_node(self):
        if -2 in self.node_stack:
            return self.node_stack[-2]
        return None

    def first_pass(self, node):
        pass

    def codegen(self, writer, node):
        impl_mapping = {
            TypeName: self.typename,
            Import: self.import_,

            Class: self.clazz,
            TemplateSpecializationClass: self.template_spec_class,
            Field: self.member_var,
            TemplateMethod: self.member_func_template,

            Constructor: self.constructor,
            ConstructorInitializer: self.constructor_initializer,
            ConstructorDelegatedInitializer: self.constructor_delegated_initializer,
            Destructor: self.destructor,

            Method: self.member_func,
            Function: self.func,

            MethodArgument: self.argument,
            Alias: self.alias,
            Namespace: self.namespace,
            Enumeration: self.enum,
            EnumerationDefinition: self.enum_def,

            Return: self.return_statement,
            Assignment: self.assignment,
            EqualComparisonOperator: self.equal_comparison,

            If: self.if_statement,

            Raw: self.raw,
            Comment: self.comment
        }

        for (type, impl) in impl_mapping.items():
            if node.__class__ == type:
                self.node_stack.append(node)
                ret = impl(writer, node)
                if ret is None:
                    ret = True
                self.node_stack.pop()
                return ret
        return False

    def typename(self, writer, type):
        writer(type.name)

    def import_(self, writer, imp):
        raise Exception("Imports are not supported by the generator implementation")

    def clazz(self, writer, cls):
        raise Exception("Classes are not supported by the generator implementation")

    def template_spec_class(self, writer, cls):
        raise Exception("Template specialized classes are not supported by the generator implementation")

    def member_var(self, writer, member):
        raise Exception("Member variables are not supported by the generator implementation")

    def member_func(self, writer, member):
        raise Exception("Member funcitons are not supported by the generator implementation")

    def member_func_template(self, writer, member):
        raise Exception("Template member functions are not supported by the generator implementation")

    def constructor(self, writer, const):
        raise Exception("Constructors are not supported by the generator implementation")

    def constructor_initializer(self, writer, initializer):
        raise Exception("Constructor initializers are not supported by the generator implementation")

    def constructor_delegated_initializer(self, writer, const):
        raise Exception("Delegated constructor initializers are not supported by the generator implementation")

    def destructor(self, writer, dest):
        raise Exception("Destructors are not supported by the generator implementation")

    def func(self, writer, member):
        raise Exception("Functions are not supported by the generator implementation")

    def argument(self, writer, arg):
        raise Exception("Method arguments are not supported by the generator implementation")

    def alias(self, writer, alias):
        raise Exception("Aliases are not supported by the generator implementation")

    def namespace(self, writer, namespace):
        raise Exception("Namespaces are not supported by the generator implementation")

    def return_statement(self, writer, ret):
        raise Exception("Return expressions are not supported by the generator implementation")

    def assignment(self, writer, assign):
        raise Exception("Assignment expressions are not supported by the generator implementation")

    def if_statement(self, writer, if_expr):
        raise Exception("If expressions are not supported by the generator implementation")

    def equal_comparison(self, writer, comparison):
        raise Exception("Equal comparison expressions are not supported by the generator implementation")

    def raw(self, writer, raw):
        writer.write(raw.content)

    def enum(self, writer, enum):
        raise Exception("Enumerations are not supported by the generator implementation")

    def enum_def(self, writer, enum_def):
        raise Exception("Enumeration definitions are not supported by the generator implementation")

    def comment(self, writer, comment):
        raise Exception("Comment blocks are not supported by the generator implementation")


def write_doxygen_like_documentation_block(writer, node):
    if node.documentation is not None:
        writer(writer.tab, '/**', writer.nl)
        writer(
            list(map(lambda x: [writer.tab, ' * ', x, writer.nl], node.documentation.split('\n')))
        )

        if node.args is not None and len(node.args) > 0:
            writer(writer.tab, " * ", writer.nl)

            for arg in node.args:
                if arg.documentation is not None:
                    writer(writer.tab, " * @param ", arg.name, " ", arg.documentation, writer.nl)

        if node.ret_documentation is not None:
            writer(writer.tab, " * ", writer.nl)
            writer(writer.tab, " * @return ", node.ret_documentation, writer.nl)

        writer(writer.tab, " */", writer.nl)

        return (True, writer.nl)
    return (True, None)
