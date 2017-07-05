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

class Context:
    classes = {}
    interfaces = {}
    namespaces = {}

    def __init__(self):
        pass

    def add_class(self, object):
        pass

    def get_namespace(self, name):
        pass

    def get_named(self, name):
        if name in self.classes: return self.classes[name]
        if name in self.interfaces: return self.interfaces[name]
        if name in self.namespaces: return self.namespaces[name]
        return None

    def resolve(self, fully_qualified_name):
        pass


class WrapperNamespace:
    def __init__(self, name, content):
        pass


class WrapperClass:
    constructors = []
    destructor = None
    methods = []

    def __init__(self, name, constructors=None, destructor=None, methods=None, namespace=None):
        self.name = name
        if constructors is not None: self.constructors = constructors
        self.destructor = destructor
        if methods is not None: self.members = methods
        self.namespace = namespace

    def create_target(self):
        pass

    def create_bridge(self):
        pass


class WrapperInterface:
    def __init__(self):
        pass

    def create_target(self):
        pass

    def create_bridge(self):
        pass


class WrapperConstructor:
    def __init__(self):
        pass


class WrapperDestructor:
    def __init__(self):
        pass


class WrapperMethod:
    def __init__(self):
        pass


class WrapperMethodArgument:
    def __init__(self):
        pass


class WrapperAnnotation:
    def __init__(self, name, params):
        pass
