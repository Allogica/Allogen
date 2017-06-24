
class LangNode(object):
    def __getattr__(self,name):
        #self.extra['abc'] can be accessed via self.abc
        if name in self.extra:
            return self.extra[name]
        return None

class Class(LangNode):

    def __init__(self, name, members, **kwargs):
        self.name = name
        self.members = members
        self.extra = kwargs

class TemplateSpecializationClass(Class):
    def __init__(self, template, specialization, **kargs):
        super(TemplateSpecializationClass, self).__init__(**kargs)
        self.template = template
        self.specialization = specialization

class Field(LangNode):

    def __init__(self, name, type, **kwargs):
        self.name = name
        self.type = type
        self.extra = kwargs

MethodVisibilityPublic = 'public'
MethodVisibilityPrivate = 'private'
MethodVisibilityProtected = 'protected'

class Method(LangNode):

    def __init__(self, name, ret, args=list(), body=None, virtual = False, \
                 visibility = MethodVisibilityPublic, **kwargs):
        self.name = name
        self.ret = ret
        self.args = args
        self.body = body
        self.virtual = virtual
        self.visibility = visibility
        self.extra = kwargs

class TemplateMethod(Method):
    def __init__(self, template, **kargs):
        super(TemplateMethod, self).__init__(**kargs)
        self.template = template

class Constructor(LangNode):
    def __init__(self, name, args=list(), body=None, visibility=MethodVisibilityPublic, **kargs):
        self.name = name
        self.args = args
        self.body = body
        self.visibility = visibility
        self.extra = kargs

class Destructor(LangNode):
    def __init__(self, name, body=None, virtual=False, visibility=MethodVisibilityPublic, **kargs):
        self.name = name
        self.body = body
        self.visibility = visibility
        self.virtual = virtual
        self.extra = kargs


class Argument(LangNode):

    def __init__(self, name, type, const=False, reference=False, **kwargs):
        self.name = name
        self.type = type
        self.const = const
        self.reference = reference
        self.extra = kwargs

class Alias(LangNode):
    def __init__(self, name, to, **kargs):
        self.name = name
        self.to = to
        self.extra = kargs


class Namespace(LangNode):
    def __init__(self, name, content, **kargs):
        self.name = name
        self.content = content
        self.extra = kargs


class Raw(LangNode):
    def __init__(self, content, **kargs):
        self.content = content
        self.extra = kargs
