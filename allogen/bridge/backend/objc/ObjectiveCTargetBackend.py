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

from allogen.bridge.backend.TargetBackend import TargetBackend
from allogen.bridge.frontend.CompilerContext import CompilerContext
from allogen.bridge.idl.Objects import IDLClass
from allogen.codegen.Constructs import Raw, Constructor, MethodArgument, TypeName
from allogen.codegen.FileSourceCodeWriter import FileSourceCodeWriter
from allogen.codegen.StreamSourceCodeWriter import StreamSourceCodeWriter
from allogen.codegen.languages.ObjectiveCLanguage import ObjectiveCInterfaceLanguageSourceGenerator, \
    ObjectiveCImplementationLanguageSourceGenerator

import sys, os


class ObjectiveCTargetBackend(TargetBackend):
    def full_pass(self, context: CompilerContext):
        # Objective-C does not require any special full pass stage
        pass

    def handle_class(self, context: CompilerContext, cls: IDLClass):
        cls.target_object.name = "AD" + cls.target_object.name
        # cls.target_object.body = cls.idl.body

        for method in cls.target_object.members:
            idl_method = cls.idl.get_method(method.name)
            if not idl_method:
                continue

            method.body = [Raw(idl_method.body)]

        # add the conversion constructor
        cls.target_object.members += [
            Constructor(args=[
                MethodArgument(name="cppObject", type=TypeName(name=cls.cpp_namespace+'::'+cls.idl.name, pointer=True))
            ])
        ]

    def codegen(self, context: CompilerContext, cls: IDLClass):
        path = os.path.join(context.out_dir, cls.target_object.name)

        generator = ObjectiveCInterfaceLanguageSourceGenerator()
        stream = FileSourceCodeWriter(path + '.h', generator=generator)
        stream(cls.target_object)

        generator = ObjectiveCImplementationLanguageSourceGenerator()
        stream = FileSourceCodeWriter(path + '.mm', generator=generator)
        stream(cls.target_object)
