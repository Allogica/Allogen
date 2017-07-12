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


class BackendVisitorPass(CompilerPass):
    def run(self, context: allogen.bridge.frontend.CompilerContext.CompilerContext):
        """:type context allogen.bridge.frontend.CompilerContext.CompilerContext"""
        backend = context.backend

        namespace = None

        for clazz in context.classes.values():
            backend.clazz_pre(namespace, clazz)

        for clazz in context.classes.values():
            backend.clazz(namespace, clazz)

            for constructor in clazz.constructors:
                backend.constructor(namespace, clazz, constructor)
                for argument in constructor.arguments:
                    backend.argument(namespace, clazz, constructor, argument)
                backend.constructor_post(namespace, clazz, constructor)

            backend.destructor(namespace, clazz, clazz.destructor)
            for argument in clazz.destructor.arguments:
                backend.argument(namespace, clazz, clazz.destructor, argument)
            backend.destructor_post(namespace, clazz, clazz.destructor)

            for method in clazz.methods:
                backend.method(namespace, clazz, method)
                for argument in method.arguments:
                    backend.argument(namespace, clazz, method, argument)
                backend.method_post(namespace, clazz, method)

            backend.clazz_post(namespace, clazz)

        for interface in context.interfaces.values():
            backend.interface(namespace, interface)
            for method in interface.methods:
                backend.method(namespace, interface, method)
                for argument in method.arguments:
                    backend.argument(namespace, interface, method, argument)
                backend.method_post(namespace, interface, method)
            backend.interface_post(namespace, interface)

    def get_order(self):
        return 500
