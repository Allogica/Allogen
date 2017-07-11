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


class Backend(object):
    context = None  # type: allogen.bridge.frontend.CompilerContext.CompilerContext
    compiler = None  # type: allogen.bridge.frontend.Compiler.Compiler

    def register_builtins(self, builtins):
        pass

    def create_target_backend(self):
        raise Exception("create_target_backend not implemented by Backend implementation")

    def create_bridge_backend(self):
        raise Exception("create_bridge_backend not implemented by Backend implementation")

    # visitors
    def namespace(self, namespace):
        pass

    def clazz(self, namespace, clazz):
        pass

    def clazz_post(self, namespace, clazz):
        pass

    def interface(self, namespace, interface):
        pass

    def interface_post(self, namespace, interface):
        pass

    def constructor(self, namespace, clazz, constructor):
        pass

    def constructor_post(self, namespace, clazz, constructor):
        pass

    def destructor(self, namespace, clazz, destructor):
        pass

    def destructor_post(self, namespace, clazz, destructor):
        pass

    def method(self, namespace, clazz, method, constructor=False):
        pass

    def method_post(self, namespace, clazz, method, constructor=False):
        pass

    def argument(self, namespace, clazz, method, argument):
        pass
