from Language import *
import inspect

class StreamWriter(Language):
    """Class that writes and idents strings to another stream (file, buffer, etc)"""
    def __init__(self, *args):
        self.ident = 0
        #Still has to be implemented using 'inspect' to trace inner frames
        #Not difficult, thou
        self.traceback = None
    def __str__(self):
        print(args)

    def get_ident(self):
        return "\t" * self.ident

    def raw_write(self,*args):
        buffer = ''
        for i in args:
            buffer += i
        return buffer

    def write(self,o):
        if isinstance(o,str):
            #We always want the raw strings always idented, correct?
            self.push()
            str = self.raw_write(self.gen_ident(),o)
            self.pop()
            return str
        else:
            self.push()
            str = self.write_node(o)
            self.pop()
            return str

    def push(self):
        self.ident += 1

    def pop(self):
        self.ident -= 1

    def __del__(self):
        print("Stream purged at the {} th identation level".format(self.ident))
