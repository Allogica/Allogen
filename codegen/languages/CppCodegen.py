class CppCodegen(object):
    builtin_types = {
        '_string': 'std::string',
        'uint64': 'uint64_t'
    }

    def gen(self, node):
        if isinstance(node, Class):
            return self.gen_class(node)
        elif isinstance(node, Field):
            return self.gen_member_var(node)
        elif isinstance(node, Method):
            return self.gen_member_func(node)
        elif isinstance(node, Argument):
            return self.gen_argument(node)
        else:
            raise Exception("Unknown LangNode type")

    def remap_type(self, t):
        if t in self.builtin_types:
            return self.builtin_types[t]
        return t

    def gen_class(self, cls):
        return (
            "class " + cls.name + " {\n" +
            ('\n'.join(map(self.gen, cls.members))) +
            "\n};"
        )

    def gen_member_var(self, member):
        return (
            self.remap_type(member.type) + " " + member.name
        )

    def gen_member_func(self, member):
        method = ""
        if member.cppOnly:
            method = "// " + member.cppOnly + "\n"

        if member.virtual:
            method += "virtual "

        method += (
            self.remap_type(member.ret) + " " + member.name + '(' +
            (', '.join(map(self.gen, member.args)))
            + ')'
        )
        if member.body is not None:
            method = method + (
                ' { ' + member.body + ' }'
            )
        else:
            method += ";"
        return method

    def gen_argument(self, arg):
        return (
            self.remap_type(arg.type) + " " + arg.name
        )
