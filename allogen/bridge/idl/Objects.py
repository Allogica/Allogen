import allogen
from allogen.codegen.Constructs import *

class IDL(object):
    declarations = None  # type: list(IDLClass|IDLNamespace)
    definitions = None  # type: list(IDLDefinition)
    imports = None  # type: list(IDLImport)
    includes = None  # type: list(IDLInclude)

    def __init__(self, declarations=None, definitions=None, imports=None, includes=None):
        self.declarations = declarations
        if self.declarations is None:
            self.declarations = []

        self.definitions = definitions
        if self.definitions is None:
            self.definitions = []

        self.imports = imports
        if self.imports is None:
            self.imports = []

        self.includes = includes
        if self.includes is None:
            self.includes = []

    def __str__(self):
        return str(self.__dict__)

    def __repr__(self):
        return str(self.__dict__)

    def __copy__(self):
        newone = type(self)(**self.__dict__)
        newone.__dict__.update(self.__dict__)
        return newone

    def __deepcopy__(self, memo):
        from copy import deepcopy
        newone = type(self)(**self.__dict__)
        newone.__dict__.update(deepcopy(self.__dict__))
        return newone

    def add_declaration(self, declaration):
        self.declarations.append(declaration)

    def add_definition(self, definition):
        self.definitions.append(definition)

    def add_import(self, imp):
        self.imports.append(imp)

    def get_classes(self):
        classes = {}
        for decl in self.declarations:
            classes.update(decl.get_classes())
        return classes

    def merge(self, other):
        self.declarations += other.declarations
        self.definitions += other.definitions
        self.imports += other.imports
        self.includes += other.includes


class IDLObject(object):
    def __init__(self):
        pass

    def __str__(self):
        return str(self.__dict__)

    def __repr__(self):
        return str(self.__dict__)

    def __copy__(self):
        newone = type(self)(**self.__dict__)
        newone.__dict__.update(self.__dict__)
        return newone

    def __deepcopy__(self, memo):
        from copy import deepcopy
        newone = type(self)(**self.__dict__)
        newone.__dict__.update(deepcopy(self.__dict__))
        return newone

    def get_classes(self):
        return {}


class IDLAnnotation(IDLObject):
    name = None  # type: str
    attributes = None  # type: dict(str, str)

    def __init__(self, name, attributes=None):
        super(IDLAnnotation, self).__init__()
        self.name = name
        self.attributes = attributes
        if self.attributes is None:
            self.attributes = dict()


class IDLAnnotatedObject(IDLObject):
    annotations = None  # type: IDLAnnotation

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
    def __init__(self, path, angled=False, **kwargs):
        super(IDLInclude, self).__init__(**kwargs)
        self.path = path
        self.angled = angled


class IDLDefinition(IDLObject):
    def __init__(self, name, value, **kwargs):
        super(IDLDefinition, self).__init__(**kwargs)
        self.name = name
        self.value = value


class IDLNamespace(IDLAnnotatedObject):
    target_object = None  # type: Namespace

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

    def get_classes(self):
        classes = {}
        for content in self.contents:
            classes.update(content.get_classes())
        return classes


class IDLTypename(IDLObject):
    linked_type = None  # type: allogen.bridge.frontend.CompilerType.CompilerType

    def __init__(self, name, optional=False, template_arguments=None, **kwargs):
        super(IDLTypename, self).__init__(**kwargs)
        self.name = name
        self.optional = optional

        self.template_arguments = template_arguments
        if self.template_arguments is None:
            self.template_arguments = []

        self.linked_type = None


class IDLTypeAlias(IDLAnnotatedObject):
    def __init__(self, name, type, **kwargs):
        super(IDLTypeAlias, self).__init__(**kwargs)

        self.name = name
        self.type = type

        self.namespace = None


class IDLInterface(IDLAnnotatedObject):
    target_object = None  # type: Class
    methods_dict = None  # type: dict(str, IDLMethod)

    def __init__(self, name, methods=None, description=None, **kwargs):
        super(IDLInterface, self).__init__(**kwargs)

        self.name = name

        self.methods_dict = methods
        if self.methods_dict is None:
            self.methods_dict = {}
        elif isinstance(self.methods_dict, list):
            self.methods_dict = {}
            self.add_methods(methods)

        self.description = description

    def __getattr__(self, item):
        if item == 'methods':
            return sorted({x for v in self.methods_dict.values() for x in v})

    def add_method(self, method):
        if method.name not in self.methods_dict:
            self.methods_dict[method.name] = []
        self.methods_dict[method.name].append(method)

    def add_methods(self, methods):
        for method in methods:
            self.add_method(method)


class IDLClass(IDLAnnotatedObject):
    target_object = None  # type: Class
    constructors = None  # type: list(Constructor)
    destructor = None  # type: Destructor
    # methods = None  # type: list(Method)
    extends = None  # type: list(str)
    implements = None  # type: list(str)

    def __init__(self, name, constructors=None, destructor=None, methods=None, extends=None, implements=None,
                 description=None, **kwargs):
        super(IDLClass, self).__init__(**kwargs)

        self.name = name

        self.constructors = constructors
        if self.constructors is None:
            self.constructors = []

        self.destructor = destructor

        self.methods_dict = methods
        if self.methods_dict is None:
            self.methods_dict = {}

        self.extends = extends
        if self.extends is None:
            self.extends = []

        self.implements = implements
        if self.implements is None:
            self.implements = []

        self.description = description
        self.namespace = None

    def __getattr__(self, item):
        if item == 'methods':
            return [x for v in self.methods_dict.values() for x in v]

    def add_method(self, method):
        if method.name not in self.methods_dict:
            self.methods_dict[method.name] = []
        self.methods_dict[method.name].append(method)

    def get_method(self, name: str):
        return next((m for m in self.methods if m.name == name), None)

    def get_classes(self):
        return {
            self.name: self
        }


class IDLMethodArgument(IDLAnnotatedObject):
    target_object = None  # type: MethodArgument
    type = None  # type: TypeName

    def __init__(self, name, type, default_value, description=None, **kwargs):
        super(IDLMethodArgument, self).__init__(**kwargs)

        self.name = name
        self.type = type
        self.default_value = default_value
        self.description = description
        self.method = None


class IDLMethod(IDLAnnotatedObject):
    target_object = None  # type: Method
    ret = None  # type: TypeName
    arguments = None  # type: IDLMethodArgument

    def __init__(self, name, ret, arguments=None, body=None, description=None, **kwargs):
        super(IDLMethod, self).__init__(**kwargs)
        self.name = name

        self.ret = ret
        if not isinstance(self.ret, IDLTypename) and self.ret is not None:
            raise Exception("IDLMethod return type must be a IDLTypename")

        if self.ret is None:
            self.ret = IDLTypename(name='void')

        self.arguments = arguments
        if self.arguments is None:
            self.arguments = []

        self.body = body
        self.description = description

        self.clazz = None

    def add_argument(self, arg):
        self.arguments.append(arg)


class IDLConstructor(IDLMethod):
    target_object = None  # type: Constructor

    def __init__(self, **kwargs):
        super(IDLConstructor, self).__init__(ret=None, **kwargs)


class IDLDestructor(IDLMethod):
    target_object = None  # type: Destructor

    def __init__(self, **kwargs):
        super(IDLDestructor, self).__init__(ret=None, **kwargs)
