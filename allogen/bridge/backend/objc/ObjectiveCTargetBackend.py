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
from allogen.bridge.backend.Constants import codegen_notice
from allogen.bridge.backend.TargetBackend import TargetBackend
from allogen.bridge.frontend.CompilerContext import CompilerContext
from allogen.bridge.idl.Objects import IDLClass
from allogen.codegen.Constructs import Raw, Constructor, MethodArgument, TypeName, Import, Comment
from allogen.codegen.FileSourceCodeWriter import FileSourceCodeWriter
from allogen.codegen.StreamSourceCodeWriter import StreamSourceCodeWriter
from allogen.codegen.languages.ObjectiveCLanguage import ObjectiveCInterfaceLanguageSourceGenerator, \
    ObjectiveCImplementationLanguageSourceGenerator

import sys, os


class ObjectiveCTargetBackend(TargetBackend):
    def full_pass(self, context: CompilerContext):
        # Objective-C does not require any special full pass stage
        pass

    def handle_class(self, context: CompilerContext, clazz: IDLClass):
        pass

    def codegen(self, context: CompilerContext, clazz: IDLClass):
        header_path = os.path.join(context.bridge_out_dir, clazz.objc_header_file_location)
        dirname = os.path.dirname(header_path)

        if not os.path.exists(dirname):
            os.makedirs(dirname)

        generator = ObjectiveCInterfaceLanguageSourceGenerator()

        with open(header_path, 'w') as f:
            writer = StreamSourceCodeWriter(stream=f, generator=generator)

            writer(Comment(codegen_notice, multiline=True), writer.nl, writer.nl)
            writer('#pragma once', writer.nl, writer.nl)
            writer(Import('Foundation/Foundation.h', quoted=False), writer.nl)

            writer(
                map(
                    lambda x: Import(x.objc_name + '.h', quoted=True),
                    filter(lambda x: isinstance(x, IDLClass), clazz.types_used)
                )
            )
            writer(writer.nl)

            writer(clazz.target_object)

        private_header_path = os.path.join(context.bridge_out_dir, clazz.objc_private_header_file_location)
        with open(private_header_path, 'w') as f:
            writer = StreamSourceCodeWriter(stream=f, generator=generator)

            writer(Comment(codegen_notice, multiline=True), writer.nl, writer.nl)
            writer('#pragma once', writer.nl, writer.nl)

            writer(Import('Allogen/ObjectiveC.hpp', quoted=False), writer.nl)
            writer(Import(clazz.objc_name + '.h', quoted=True))
            writer(writer.nl)

            writer(writer.nl)
            writer(map(lambda x: Import(x.path, quoted=True), context.idl.includes))

            writer(
                map(
                    lambda x: [
                        Import(x.objc_name + '.h', quoted=True),
                        Import(x.objc_name + '+Private.h', quoted=True)
                    ],
                    filter(lambda x: isinstance(x, IDLClass), clazz.types_used)
                ),
                writer.nl
            )

            writer('ALLOGEN_BRIDGED_CLASS(' + clazz.fully_qualified_name + ', ' + clazz.objc_name + ')', writer.nl, writer.nl)

            writer(clazz.private_object)
