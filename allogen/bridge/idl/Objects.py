class IDL(object):
    def __init__(self, declarations=None, definitions=None, imports=None):
        self.declarations = declarations
        if self.declarations is None:
            self.declarations = []

        self.definitions = definitions
        if self.definitions is None:
            self.definitions = []

        self.imports = imports
        if self.imports is None:
            self.imports = []

    def __str__(self):
        return str(self.__dict__)

    def __repr__(self):
        return str(self.__dict__)

    def add_declaration(self, declaration):
        self.declarations.append(declaration)

    def add_definition(self, definition):
        self.definitions.append(definition)

    def add_import(self, imp):
        self.imports.append(imp)


class IDLObject(object):
    def __init__(self):
        pass

    def __str__(self):
        return str(self.__dict__)

    def __repr__(self):
        return str(self.__dict__)


class IDLAnnotation(IDLObject):
    def __init__(self, name, attributes=None):
        super(IDLAnnotation, self).__init__()
        self.name = name
        self.attributes = attributes
        if self.attributes is None:
            self.attributes = dict()


class IDLAnnotatedObject(IDLObject):
    def __init__(self, annotations=None, **kwargs):
        super(IDLAnnotatedObject, self).__init__(**kwargs)

        self.annotations = annotations
        if self.annotations is None:
            self.annotations = []

    def add_annotation(self, annotation):
        self.annotations.append(annotation)


class IDLImport(IDLObject):
    def __init__(self, path, **kwargs):
        super(IDLImport, self).__init__(**kwargs)
        self.path = path


class IDLInclude(IDLObject):
    def __init__(self, path, **kwargs):
        super(IDLInclude, self).__init__(**kwargs)
        self.path = path


class IDLDefinition(IDLObject):
    def __init__(self, name, value, **kwargs):
        super(IDLDefinition, self).__init__(**kwargs)
        self.name = name
        self.value = value


class IDLNamespace(IDLAnnotatedObject):
    def __init__(self, name, contents, description=None, **kwargs):
        super(IDLNamespace, self).__init__(**kwargs)

        self.name = name
        self.contents = contents
        if self.contents is None:
            self.contents = []

        self.description = description
        self.namespace = None

    def add_declaration(self, member):
        self.contents.append(member)


class IDLTypename(IDLObject):
    def __init__(self, name, optional=False, **kwargs):
        super(IDLTypename, self).__init__(**kwargs)
        self.name = name
        self.optional = optional


class IDLTypeAlias(IDLAnnotatedObject):
    def __init__(self, name, type, **kwargs):
        super(IDLTypeAlias, self).__init__(**kwargs)

        self.name = name
        self.type = type

        self.namespace = None


class IDLClass(IDLAnnotatedObject):
    def __init__(self, name, methods=None, extends=None, implements=None, description=None, **kwargs):
        super(IDLClass, self).__init__(**kwargs)

        self.name = name
        self.methods = methods
        if self.methods is None:
            self.methods = []

        self.extends = extends
        if self.extends is None:
            self.extends = []

        self.implements = implements
        if self.implements is None:
            self.implements = []

        self.description = description
        self.namespace = None

    def add_method(self, method):
        self.methods.append(method)


class IDLMethodArgument(IDLAnnotatedObject):
    def __init__(self, name, type, default_value, description=None, **kwargs):
        super(IDLMethodArgument, self).__init__(**kwargs)

        self.name = name
        self.type = type
        self.default_value = default_value
        self.description = description
        self.method = None


class IDLMethod(IDLAnnotatedObject):
    def __init__(self, name, ret, arguments=None, body=None, description=None, **kwargs):
        super(IDLMethod, self).__init__(**kwargs)
        self.name = name

        self.ret = ret
        if not isinstance(self.ret, IDLTypename) and self.ret is not None:
            raise Exception("IDLMethod return type must be a IDLTypename")

        if self.ret is None:
            self.ret = []

        self.arguments = arguments
        if self.arguments is None:
            self.arguments = []

        self.body = body
        self.description = description

        self.clazz = None

    def add_argument(self, arg):
        self.arguments.append(arg)


class IDLConstructor(IDLMethod):
    def __init__(self, **kwargs):
        super(IDLConstructor, self).__init__(ret=None, **kwargs)


class IDLDestructor(IDLMethod):
    def __init__(self, **kwargs):
        super(IDLDestructor, self).__init__(ret=None, **kwargs)
