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
import allogen
from allogen.bridge.frontend.CompilerPass import CompilerPass
from allogen.bridge.idl.Parser import Parser

import os


class ImportingPass(CompilerPass):
    """
    Parses all files declared as imported in the source IDL
    """

    def run(self, context: allogen.bridge.frontend.CompilerContext.CompilerContext):
        """:type context allogen.bridge.frontend.CompilerContext.CompilerContext"""

        parser = Parser()
        # parse all imported idls
        context.imports = list(map(
            lambda imported: parser.parse(
                open(os.path.join(os.path.dirname(context.file), imported.path)).read()
            ),
            context.idl.imports
        ))

        context.imported_classes = {}
        for imported in context.imports:
            loaded = imported.get_classes()
            for (k, v) in loaded.iteritems():
                if k in context.imported_classes or k in context.all_classes:
                    raise Exception(k+" class was already imported")
            context.imported_classes.update(loaded)
            context.all_classes.update(loaded)

    def get_order(self):
        return 200