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

from allogen.bridge.frontend.CompilerContext import CompilerContext
import passes as p
from bridge.idl.Parser import Parser


class Compiler(object):
    def __init__(self, passes=None):
        self.passes = passes
        if self.passes is None:
            self.passes = [
                p.IDLParsingPass.IDLParsingPass(),
                p.ImportingPass.ImportingPass(),
                p.TypenameMappingPass.TypenameMappingPass(),
                p.CodegenConstructsCreationPass.CodegenConstructsCreationPass(),
                p.BackendTargetCodegenPass.BackendTargetCodegenPass(),
                p.BackendBridgeCodegenPass.BackendBridgeCodegenPass()
            ]

    def add_compiler_pass(self, compiler_pass):
        self.passes.append(compiler_pass)

    def compile_file(self, file, **kwargs):
        with open(file) as f:
            return self.compile_source(f.read(), file=file, **kwargs)

    def compile_source(self, source, **kwargs):
        context = CompilerContext()
        context.__dict__.update(kwargs)

        context.source = source

        for compiler_pass in sorted(self.passes, key=lambda p: p.get_order()):
            compiler_pass.run(context)

    def list_products(self, file):
        source = None
        with open(file) as f:
            source = f.read()

        parser = Parser()
        parsed = parser.parse(source)

        return map(lambda c: c.name, parsed.get_classes())
