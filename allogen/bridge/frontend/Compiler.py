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
from allogen.bridge.backend.java.JavaBackend import JavaBackend
from allogen.bridge.backend.objc.ObjectiveCBackend import ObjectiveCBackend
from allogen.bridge.frontend.CompilerContext import CompilerContext
import allogen.bridge.frontend.passes as p
from allogen.bridge.idl.Objects import *

from allogen.bridge.idl.Parser import Parser

class Compiler(object):
    parser = Parser()

    languages = {
        'java': JavaBackend,
        'objc': ObjectiveCBackend
    }

    def __init__(self, passes=None):
        self.passes = passes
        if self.passes is None:
            self.passes = [
                # p.IDLParsingPass.IDLParsingPass(),
                # p.ImportingPass.ImportingPass(),
                p.TypenameMappingPass.TypenameMappingPass(),
                p.CodegenConstructsCreationPass.CodegenConstructsCreationPass(),
                p.BackendVisitorPass.BackendVisitorPass(),
                p.BackendTargetCodegenPass.BackendTargetCodegenPass(),
                p.BackendBridgeCodegenPass.BackendBridgeCodegenPass()
            ]

    def add_compiler_pass(self, compiler_pass: allogen.bridge.frontend.CompilerPass.CompilerPass):
        self.passes.append(compiler_pass)

    def compile_files(self, files, language: str, **kwargs):
        self.context = CompilerContext()
        self.context.__dict__.update(kwargs)

        self.context.idl = IDL()

        for file in files:
            with open(file) as f:
                print("Parsing file", file)
                self.parse_file(f.read())

        self.context.idl_classes = self.context.idl.get_classes()
        self.context.all_classes = dict(self.context.idl_classes)

        self.compile(self.context, language=language)

    def parse_file(self, source: str):
        self.context.idl.merge(self.parser.parse(source))
        pass

    def compile(self, context: CompilerContext, language: str):
        backend_class = self.languages[language.lower()]

        context.backend = backend_class()
        context.backend.context = context
        context.backend.compiler = self

        # register backend types
        context.backend.register_builtins(context, context.builtin_types)

        for compiler_pass in sorted(self.passes, key=lambda p: p.get_order()):
            compiler_pass.context = context
            compiler_pass.compiler = self
            compiler_pass.run(context)

    def synthesize_class(self, clazz: IDLClass):
        clazz.target_object = Class(
            name=clazz.name,
            documentation=clazz.description,
            members=[]
        )

        for constructor in clazz.constructors:
            c = self.synthesize_constructor(constructor)
            constructor.target_object = c
            clazz.target_object.members.append(c)

        c = self.synthesize_destructor(clazz.destructor)
        clazz.destructor.target_object = c
        clazz.target_object.members.append(c)

        for method in clazz.methods:
            m = self.synthesize_generic_method(method)
            method.target_object = m
            clazz.target_object.members.append(m)

    def synthesize_interface(self, clazz: IDLClass):
        clazz.target_object = Class(
            name=clazz.name,
            documentation=clazz.description,
            members=[], abstract=True, interface=True
        )

        for method in clazz.methods:
            m = self.synthesize_generic_method(method)
            method.target_object = m
            clazz.target_object.members.append(m)

    def synthesize_generic_method(self, method):
        if method.__class__ == IDLConstructor:
            return self.synthesize_constructor(method)
        elif method.__class__ == IDLDestructor:
            return self.synthesize_destructor(method)
        elif method.__class__ == IDLMethod:
            return self.synthesize_method(method)

    def synthesize_constructor(self, constructor: IDLConstructor):
        c = Constructor(
            documentation=constructor.description,
            args=list(map(lambda a: self.synthesize_argument(a), constructor.arguments)),
            idl=constructor
        )
        constructor.target_object = c
        return c

    def synthesize_destructor(self, destructor: IDLDestructor):
        d = Destructor(
            documentation=destructor.description,
            args=list(map(lambda a: self.synthesize_argument(a), destructor.arguments)),
            idl=destructor
        )
        destructor.target_object = d
        return d

    def synthesize_typename(self, typename: IDLTypename):
        if isinstance(typename, list):
            return TypeName('void')
        return TypeName(name=typename.linked_type.get_target_name())

    def synthesize_method(self, method: IDLMethod):
        m = Method(
            name=method.name,
            args=list(map(lambda a: self.synthesize_argument(a), method.arguments)),
            ret=self.synthesize_typename(method.ret),
            documentation=method.description,
            idl=method,
            static=method.static
        )
        method.target_object = m
        return m

    def synthesize_argument(self, arg: IDLMethodArgument):
        a = MethodArgument(
            name=arg.name,
            type=self.synthesize_typename(arg.type),
            documentation=arg.description,
            default_value=arg.default_value,
            idl=arg
        )
        arg.target_object = a
        return a
