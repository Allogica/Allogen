class CodegenStream(object):

    def __init__(self, *args):
        pass

    def write(self):
        pass

    def push(self):
        pass

    def pop(self):
        pass

    def undo(self):
        pass

    def printStack(self):
        pass

    def __str__(self):
        print ('Hello World')

    def __del__(self):
        lastStream = self.write() 
