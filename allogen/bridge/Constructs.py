class Context:
    classes = {}
    interfaces = {}
    namespaces = {}

    def __init__(self):
        pass

    def add_class(self, object):
        pass

    def get_namespace(self, name):
        pass

    def get_named(self, name):
        if name in self.classes: return self.classes[name]
        if name in self.interfaces: return self.interfaces[name]
        if name in self.namespaces: return self.namespaces[name]
        return None

    def resolve(self, fully_qualified_name):
        pass


class WrapperNamespace:
    def __init__(self, name, content):
        pass


class WrapperClass:
    constructors = []
    destructor = None
    methods = []

    def __init__(self, name, constructors=None, destructor=None, methods=None, namespace=None):
        self.name = name
        if constructors is not None: self.constructors = constructors
        self.destructor = destructor
        if methods is not None: self.members = methods
        self.namespace = namespace

    def create_target(self):
        pass

    def create_bridge(self):
        pass


class WrapperInterface:
    def __init__(self):
        pass

    def create_target(self):
        pass

    def create_bridge(self):
        pass


class WrapperConstructor:
    def __init__(self):
        pass


class WrapperDestructor:
    def __init__(self):
        pass


class WrapperMethod:
    def __init__(self):
        pass


class WrapperMethodArgument:
    def __init__(self):
        pass


class WrapperAnnotation:
    def __init__(self, name, params):
        pass
