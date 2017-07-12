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
from allogen.bridge.backend.objc.ObjectiveCTargetBackend import ObjectiveCTargetBackend
from allogen.bridge.backend.java.JavaTargetBackend import JavaTargetBackend
from allogen.bridge.frontend.CompilerPass import CompilerPass


class BackendTargetCodegenPass(CompilerPass):
    def run(self, context: allogen.bridge.frontend.CompilerContext.CompilerContext):
        """:type context allogen.bridge.frontend.CompilerContext.CompilerContext"""
        target_backend = context.backend.create_target_backend()

        target_backend.full_pass(context)
        for clazz in context.classes.values():
            target_backend.handle_class(context, clazz)
        for interface in context.interfaces.values():
            target_backend.handle_interface(context, interface)

        for clazz in list(context.classes.values()) + list(context.interfaces.values()):
            print("Codegen for backend target class", clazz.name)
            target_backend.codegen(context, clazz)

    def get_order(self):
        return 1000
