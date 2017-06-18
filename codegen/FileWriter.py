from StreamWriter import *

class FileWriter(StreamWriter):

    def __init__(self,fname):
        self.file = open(fname,'w')

    def raw_write(self,str):
        self.file.write(str)

    def __del__(self):
        self.file.close()
