from StreamWriter import *
from StringWriter import *

class FileWriter(StreamWriter):

    def __init__(self,fname):
        self.file = open(fname,'w')

    def raw_write(self,str):
        self.file.write(str)

    def __del__(self):
        """
        Close the file in the destructor.
        It is still necessary to check if it does so when the runtime/console
        closes        
        """
        self.file.close()
