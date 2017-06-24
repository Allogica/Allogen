from Constructors import *
from codegen.languages.CppCodegen import *
from codegen.languages.JavaCodegen import * #To be implemented

class Language(object):

    def write_node(self,node):
        if isinstance(node, TemplateSpecializationClass):
            return self.gen_template_spec_class(node)
        elif isinstance(node, Class):
            return self.gen_class(node)
        elif isinstance(node, Field):
            return self.gen_member_var(node)
        elif isinstance(node, TemplateMethod):
            return self.gen_member_func_template(node)
        elif isinstance(node, Method):
            return self.gen_member_func(node)
        elif isinstance(node, Constructor):
            return self.gen_constructor(node)
        elif isinstance(node, Destructor):
            return self.gen_destructor(node)
        elif isinstance(node, Argument):
            return self.gen_argument(node)
        elif isinstance(node, Alias):
            return self.gen_alias(node)
        elif isinstance(node, Namespace):
            return self.gen_namespace(node)
        elif isinstance(node, Raw):
            return node.content
        else:
            raise Exception("Unknown LangNode type")
