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

from allogen.bridge.frontend.CompilerPass import CompilerPass
from allogen.bridge.idl.Objects import IDLConstructor, IDLDestructor, IDLMethod
from allogen.codegen.Constructs import *


class CodegenConstructsCreationPass(CompilerPass):
    def __init__(self):
        self.namespace = ''

    def run(self, context):
        for (name, cls) in context.classes.iteritems():
            cls.obj = Class(
                name=cls.name,
                documentation=cls.description,
                members=[]
            )

            for constructor in cls.constructors:
                c = self.map_constructor(constructor)
                constructor.obj = c
                cls.obj.members.append(c)

            c = self.map_destructor(cls.destructor)
            cls.destructor.obj = c
            cls.obj.members.append(c)

            for method in cls.methods:
                m = self.map_generic_method(method)
                method.obj = m
                cls.obj.members.append(m)


    def map_generic_method(self, method):
        if method.__class__ == IDLConstructor:
            return self.map_constructor(method)
        elif method.__class__ == IDLDestructor:
            return self.map_destructor(method)
        elif method.__class__ == IDLMethod:
            return self.map_method(method)

    def map_constructor(self, constructor):
        return Constructor(
            documentation=constructor.description,
            args=map(lambda a: self.map_argument(a), constructor.arguments),
            idl=constructor
        )

    def map_destructor(self, constructor):
        return Destructor(
            documentation=constructor.description,
            args=map(lambda a: self.map_argument(a), constructor.arguments),
            idl=constructor
        )

    def map_typename(self, typename):
        if isinstance(typename, list):
            return TypeName('void')
        return TypeName(name=typename.name)

    def map_method(self, method):
        return Method(
            name=method.name,
            args=map(lambda a: self.map_argument(a), method.arguments),
            ret=self.map_typename(method.ret),
            documentation=method.description,
            idl=method
        )

    def map_argument(self, arg):
        return MethodArgument(
            name=arg.name,
            type=self.map_typename(arg.type),
            documentation=arg.description,
            default_value=arg.default_value,
            idl=arg
        )

    def get_order(self):
        return 400


def split_namespace(ns):
    return ns.split("::")
