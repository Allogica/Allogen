

class LangNode(object):
    def __getattr__(self,name):
        if name in self.extra:
            return self.extra[name]
        return None

class Class(LangNode):

    def __init__(self, name, members, **kwargs):
        self.name = name
        self.members = members
        self.extra = kwargs

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

class Argument(LangNode):

    def __init__(self, name, type, const=False, reference=False, **kwargs):
        self.name = name
        self.type = type
        self.const = const
        self.reference = reference
        self.extra = kwargs
