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

VisibilityPublic = 'public'
VisibilityPrivate = 'private'
VisibilityProtected = 'protected'
VisibilityDefault = 'default'


class LanguageConstruct(object):
    def __init__(self, **kwargs):
        self.extra = kwargs

    def __getattr__(self, name):
        # self.extra['abc'] can be accessed via self.abc
        if name in self.extra:
            return self.extra[name]
        return None

    def __copy__(self):
        newone = type(self).__new__(type(self))
        newone.__dict__.update(self.__dict__)
        return newone

    def __deepcopy__(self, memo):
        from copy import deepcopy

        newone = type(self).__new__(type(self))
        newone.__dict__.update(deepcopy(self.__dict__))
        return newone


class Class(LanguageConstruct):
    def __init__(self, name, members, parents=None, visibility=VisibilityPublic, **kwargs):
        super(Class, self).__init__(**kwargs)
        self.name = name
        self.members = members
        self.parents = parents
        if self.parents is None:
            self.parents = []
        self.visibility = visibility


class TypeName(LanguageConstruct):
    def __init__(self, name, const=False, mutable=False, reference=False, pointer=False, **kwargs):
        super(TypeName, self).__init__(**kwargs)
        self.name = name
        self.const = const
        self.mutable = mutable
        self.reference = reference
        self.pointer = pointer


class TemplateSpecializationClass(Class):
    def __init__(self, template, specialization, **kwargs):
        super(TemplateSpecializationClass, self).__init__(**kwargs)
        self.template = template
        self.specialization = specialization


class Field(LanguageConstruct):
    def __init__(self, name, type, visibility=VisibilityPrivate, **kwargs):
        super(Field, self).__init__(**kwargs)
        self.name = name
        self.type = type
        if isinstance(self.type, str):
            self.type = TypeName(self.type)
        self.visibility = visibility


class Function(LanguageConstruct):
    def __init__(self, name, ret, args=list(), body=None, **kwargs):
        super(Function, self).__init__(**kwargs)
        self.name = name
        self.ret = ret
        if isinstance(self.ret, str):
            self.ret = TypeName(self.ret)

        self.args = args
        self.body = body
        if self.body is None:
            self.body = []


class Method(Function):
    def __init__(self, name, ret, virtual=False, visibility=VisibilityPublic, **kwargs):
        super(Method, self).__init__(name, ret, **kwargs)
        self.virtual = virtual
        self.visibility = visibility


class TemplateMethod(Method):
    def __init__(self, template, **kwargs):
        super(TemplateMethod, self).__init__(**kwargs)
        self.template = template


class Constructor(Method):
    def __init__(self, initializers=None, **kwargs):
        super(Constructor, self).__init__(name=None, ret=None, **kwargs)
        self.initializers = initializers
        if self.initializers is None:
            self.initializers = []

        def fix_strings(s):
            if not isinstance(s, ConstructorInitializer) and not isinstance(s, ConstructorDelegatedInitializer):
                return ConstructorInitializer(s)
            return s

        self.initializers = list(map(fix_strings, self.initializers))


class ConstructorInitializer(LanguageConstruct):
    def __init__(self, local, member=None, move=False, **kwargs):
        super(ConstructorInitializer, self).__init__(**kwargs)
        self.local = local
        self.member = member
        if self.member is None:
            self.member = local
        self.move = move


class ConstructorDelegatedInitializer(LanguageConstruct):
    def __init__(self, name, arguments=None, **kwargs):
        super(ConstructorDelegatedInitializer, self).__init__(**kwargs)
        self.name = name
        self.arguments = arguments
        if self.arguments is None:
            self.arguments = []


class Destructor(Method):
    def __init__(self, **kwargs):
        super(Destructor, self).__init__(name=None, ret=None, **kwargs)


class MethodArgument(LanguageConstruct):
    def __init__(self, name, type, **kwargs):
        super(MethodArgument, self).__init__(**kwargs)
        self.name = name
        self.type = type
        if isinstance(self.type, str):
            self.type = TypeName(self.type)


class Alias(LanguageConstruct):
    def __init__(self, name, to, **kwargs):
        super(Alias, self).__init__(**kwargs)
        self.name = name
        self.to = to


class Namespace(LanguageConstruct):
    def __init__(self, name, content, **kwargs):
        super(Namespace, self).__init__(**kwargs)
        self.name = name
        self.content = content


class Raw(LanguageConstruct):
    def __init__(self, content, **kwargs):
        super(Raw, self).__init__(**kwargs)
        self.content = content


class TemplateArgument(LanguageConstruct):
    def __init__(self, kind, name, default=None, **kwargs):
        super(TemplateArgument, self).__init__(**kwargs)
        self.kind = kind
        self.name = name
        self.default = default


class TemplateSpecializationArgument(LanguageConstruct):
    def __init__(self, **kwargs):
        super(TemplateSpecializationArgument, self).__init__(**kwargs)


class TemplateSpecializationMethod(Method):
    def __init__(self, **kwargs):
        super(TemplateSpecializationMethod, self).__init__(**kwargs)


class TemplateConstructor(Constructor):
    def __init__(self, **kwargs):
        super(TemplateConstructor, self).__init__(**kwargs)


class If(LanguageConstruct):
    def __init__(self, conditions, then_expr=None, else_expr=None, **kwargs):
        super(If, self).__init__(**kwargs)
        self.conditions = conditions

        self.then_expr = then_expr
        if self.then_expr is None:
            self.then_expr = []

        self.else_expr = else_expr
        if self.else_expr is None:
            self.else_expr = []


class Return(LanguageConstruct):
    def __init__(self, expression=None, **kwargs):
        super(Return, self).__init__(**kwargs)
        self.expression = expression


class Assignment(LanguageConstruct):
    def __init__(self, expression, to, **kwargs):
        super(Assignment, self).__init__(**kwargs)
        self.expression = expression
        self.to = to


class UnaryOperator(LanguageConstruct):
    pass


class BinaryOperator(LanguageConstruct):
    def __init__(self, a, b, **kwargs):
        super(BinaryOperator, self).__init__(**kwargs)
        self.a = a
        self.b = b


class EqualComparisonOperator(BinaryOperator):
    def __init__(self, **kwargs):
        super(EqualComparisonOperator, self).__init__(**kwargs)


class NotEqualComparisonOperator(BinaryOperator):
    def __init__(self, **kwargs):
        super(NotEqualComparisonOperator, self).__init__(**kwargs)


class GreaterThanComparisonOperator(BinaryOperator):
    def __init__(self, **kwargs):
        super(GreaterThanComparisonOperator, self).__init__(**kwargs)


class GreaterThanOrEqualComparisonOperator(BinaryOperator):
    def __init__(self, **kwargs):
        super(GreaterThanOrEqualComparisonOperator, self).__init__(**kwargs)


class LessThanComparisonOperator(BinaryOperator):
    def __init__(self, **kwargs):
        super(LessThanComparisonOperator, self).__init__(**kwargs)


class LessThanOrEqualComparisonOperator(BinaryOperator):
    def __init__(self, **kwargs):
        super(LessThanOrEqualComparisonOperator, self).__init__(**kwargs)


class Enumeration(LanguageConstruct):
    def __init__(self, name, definitions, type=None, visibility=VisibilityPublic, **kwargs):
        super(Enumeration, self).__init__(**kwargs)
        self.name = name
        self.definitions = definitions
        self.type = type
        self.visibility = visibility


class EnumerationDefinition(LanguageConstruct):
    def __init__(self, name, value=None, **kwargs):
        super(EnumerationDefinition, self).__init__(**kwargs)
        self.name = name
        self.value = value


class Comment(LanguageConstruct):
    def __init__(self, content, **kwargs):
        super(Comment, self).__init__(**kwargs)
        self.content = content
