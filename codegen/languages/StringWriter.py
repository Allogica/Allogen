from StreamWriter import *

class StringWriter(StreamWriter):

    def __init__(self):
        self.buffer = ""

    def raw_write(self,str):
        self.buffer += str
