from codegen.Language import *
class CppCodegen(Language):
    builtin_types = {
        '_string': 'std::string',
        'uint64': 'uint64_t'
    }

    def gen(self, node):
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

    def remap_type(self, t):
        if t in self.builtin_types:
            return self.builtin_types[t]
        return t

    def gen_docstring(self, node):
        doc = ""
        if node.documentation is not None:
            doc += "/**\n"
            doc += " * " + node.documentation + "\n"

            if node.args is not None and len(node.args) > 0:
                doc += " * \n"

                for arg in node.args:
                    if arg.documentation is not None:
                        doc += " * @param " + arg.name + " " + arg.documentation + "\n"

            if node.ret_documentation is not None:
                doc += " * \n"
                doc += " * @return " + node.ret_documentation + "\n"

            doc += " */\n"
        return doc

    def gen_class(self, cls):
        cls.__last_vis_scope = 'private'

        str = (
            self.gen_docstring(cls) +
            "class " + cls.name
        )

        return str + self.gen_class_body(cls)

    def gen_class_body(self, cls):
        str = ""
        if len(cls.parents):
            str += " : " + (",\n".join(map((lambda x: "public " + x), cls.parents)))

        str += (
            "{\npublic:\n" +
            ('\n'.join(map(self.gen, cls.members))) +
            "\n};\n"
        )

        return str

    def gen_template_spec_class(self, cls):
        cls.__last_vis_scope = 'private'

        str = (
            self.gen_docstring(cls) +
            'template<' + cls.template + '>' + '\n' +
            "class " + cls.name + cls.specialization
        )

        return str + self.gen_class_body(cls);

    def gen_member_var(self, member):
        var = (
            self.gen_docstring(member) +
            self.remap_type(member.type) + " " + member.name
        )
        if member.default:
            var += " = " + member.default
        return var + ";"

    def gen_member_func(self, member):
        method = ""
        if member.cppOnly:
            method = "// " + member.cppOnly + "\n"

        method += self.gen_docstring(member)

        if member.virtual:
            method += "virtual "
        if member.static:
            method += "static "
        if member.inline:
            method += "inline "

        method += (
            self.remap_type(member.ret) + " " + member.name + '(' +
            (', '.join(map(self.gen, member.args)))
            + ')'
        )

        if member.final:
            method += " final"
        if member.override:
            method += " override"

        if member.body is not None:
            method = method + (
                ' { ' + member.body + ' }'
            )
        elif member.trivial is True:
            method = method + ' = default;'
        elif member.abstract is True:
            method = method + ' = 0;'
        else:
            method += ";"
        return method

    def gen_member_func_template(self, member):
        return (
            member.template + "\n" +
            self.gen_member_func(member)
        )

    def gen_constructor(self, const):
        method = ""

        method += self.gen_docstring(const)

        if const.inline:
            method += "inline "

        method += (
            const.name + '(' +
            (', '.join(map(self.gen, const.args)))
            + ')'
        )

        if const.body is not None:
            if isinstance(const, Constructor):
                method += ' : '
            method += const.body
        elif const.trivial is True:
            method = method + ' = default;'
        else:
            method += ";"
        return method

    def gen_destructor(self, dest):
        method = ""

        method += self.gen_docstring(dest)

        if dest.inline:
            method += "inline "
        if dest.virtual:
            method += "virtual "

        method += (
            '~' + dest.name + '()'
        )

        if dest.body is not None:
            method += dest.body
        elif dest.trivial is True:
            method = method + ' = default;'
        else:
            method += ";"
        return method

    def gen_argument(self, arg):
        out = (
            self.remap_type(arg.type) + " " + arg.name
        )

        if arg.default:
            out += " = " + arg.default
        return out

    def gen_alias(self, alias):
        return (
            self.gen_docstring(alias) +
            "using " + alias.name + " = " + alias.to + ";\n"
        )

    def gen_namespace(self, namespace):
        ns_new_line = '\n'
        if len(namespace.content) == 1 and isinstance(namespace.content[0], Namespace):
            ns_new_line = ''

        return (
            "namespace " + namespace.name + " { " + ns_new_line +
            (''.join(map(self.gen, namespace.content))) +
            ns_new_line + "}"
        )
