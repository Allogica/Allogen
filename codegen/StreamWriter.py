from Language import *
class StreamWriter(Language):
    """Class that writes and idents strings to another stream (file, buffer, etc)"""
    def __init__(self, *args):
        self.ident = 0

    def get_ident(self):
        return "\t" * self.ident

    def raw_write(self,*args):
        buffer = ''
        for i in args:
            buffer += i
        return buffer

    def write(self,o):
        if isinstance(o,str):
            self.raw_write(self.gen_ident(),o)
        else:
            self.write_node(o)

    def push(self):
        self.ident += 1

    def pop(self):
        self.ident -= 1
