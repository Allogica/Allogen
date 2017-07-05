# Copyright (c) 2017, Allogica
#
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without modification,
# are permitted provided that the following conditions are met:
#
#     * Redistributions of source code must retain the above copyright notice,
#       this list of conditions and the following disclaimer.
#     * Redistributions in binary form must reproduce the above copyright notice,
#       this list of conditions and the following disclaimer in the documentation
#       and/or other materials provided with the distribution.
#     * Neither the name of Allogen nor the names of its contributors
#       may be used to endorse or promote products derived from this software
#       without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
# A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
# EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
# PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
# PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
# NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

from LanguageSourceGenerator import *


class SourceCodeWriter(object):
    """Class that writes and idents strings to another stream (file, buffer, etc)"""

    class TabHint:
        pass

    class NewLineHint:
        pass

    class IndentedBlockHint:
        def __init__(self, *args):
            self.args = list(args)

    class DeindentedBlockHint:
        def __init__(self, *args):
            self.args = list(args)

    class JoinedHint:
        def __init__(self, glue, args):
            self.glue = glue
            self.args = args

    def __init__(self, generator, *args):
        self.indent = 0
        self.generator = generator
        # Still has to be implemented using 'inspect' to trace inner frames
        # Not difficult, thou
        self.traceback = None

        self.nl = self.NewLineHint()
        self.tab = self.TabHint()

        self.new_line_char = '\n'
        self.tab_char = '\t'

    def raw_write(self, *args):
        return False

    def write(self, o):
        if o is None:
            return False

        elif isinstance(o, tuple) and (len(o) == 2 or len(o) == 3):
            if o[0] and o[0] is not None:
                return self.write(o[1])
            elif len(o) == 3:
                return self.write(o[2])
            return False

        elif isinstance(o, self.TabHint):
            self.raw_write(self.tab_char * self.indent)
            return False

        elif isinstance(o, self.NewLineHint):
            self.raw_write(self.new_line_char)
            return False

        elif isinstance(o, self.IndentedBlockHint):
            self.push()
            ret = self.write(o.args)
            self.pop()
            return ret

        elif isinstance(o, self.DeindentedBlockHint):
            self.pop()
            ret = self.write(o.args)
            self.push()
            return ret

        elif isinstance(o, self.JoinedHint):
            if o.args is None:
                return False

            ret = False
            for obj in o.args[:-1]:
                if self.write(obj):
                    self.write(o.glue)
                    if ret is False:
                        ret = True
            if len(o.args) != 0:
                return self.write(o.args[-1])

            return ret

        elif o == self.push:
            self.push()
            return False

        elif o == self.pop:
            self.pop()
            return False

        elif isinstance(o, list):
            ret = False
            for element in o:
                ret1 = self.write(element)
                if ret is False:
                    ret = ret1
            return ret

        elif callable(o):
            return o()

        elif isinstance(o, LanguageConstruct):
            return self.generator.codegen(self, o)

        else:
            return self.raw_write(str(o))

    def __call__(self, *args):
        for element in args:
            self.write(element)

    def indented(self, *args):
        return self.IndentedBlockHint(*args)

    def deindented(self, *args):
        return self.DeindentedBlockHint(*args)

    def joined(self, glue, args):
        return self.JoinedHint(glue, args)

    def push(self):
        self.indent += 1

    def pop(self):
        self.indent -= 1

    def __del__(self):
        if self.indent != 0:
            print("Stream purged at the {} th indentation level".format(self.indent))
