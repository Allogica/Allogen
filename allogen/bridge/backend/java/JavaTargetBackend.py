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
from allogen.codegen.Constructs import Raw, Constructor, MethodArgument, TypeName, Field, Method, VisibilityPublic, \
    VisibilityPrivate, Destructor, VisibilityProtected, Namespace, Comment
from allogen.codegen.FileSourceCodeWriter import FileSourceCodeWriter
from allogen.codegen.StreamSourceCodeWriter import StreamSourceCodeWriter
from allogen.codegen.languages.JavaLanguage import JavaLanguageSourceGenerator

import sys, os
import copy

from string import Template


class JavaTargetBackend(TargetBackend):
    def full_pass(self, context):
        # Java does not require any special full pass stage
        pass

    def handle_class(self, context, cls):
        # we need a way to store the object pointer in Java, we create a dummy "pointer" field
        # on the class. This type has a 64 bit integer type which is large enough for almost all
        # platforms
        cls.obj.members.insert(0, Field(
            name='pointer', type='long', visibility=VisibilityPrivate,
            documentation='A numeric value that represents the pointer used to access the wrapped object.\n\n'
                          'This value should not be changed by the user and is automatically initialized by the _init\n'
                          'or when used as a return value from another method.'
        ))

        # we cant implement a Java constructor in JNI code, so we first "translate"
        # the constructor call into a "_init" function.

        initializers = []
        native_init_template = Template("pointer = this._init(${args});")
        last_constructor = None
        for constructor in cls.obj.members:
            if constructor.__class__ == Constructor:
                last_constructor = constructor
                constructor.body = [
                    Raw(native_init_template.substitute({
                        'args': ", ".join(map(lambda a: a.name, constructor.args))
                    }))]

                # synthesize the _init method
                initializers.append(
                    Method(
                        name="_init", args=constructor.args, visibility=VisibilityPrivate,
                        ret='long', native=True,
                        documentation='This method performs the object creation. This method should only be called\n'
                                      'from the object constructor.'
                    )
                )

        if last_constructor:
            for ini in initializers:
                cls.obj.members.insert(cls.obj.members.index(last_constructor)+1, ini)

        for method in cls.obj.members:
            if method.__class__ == Method:
                idl_method = cls.get_method(method.name)
                if not idl_method:
                    continue
                method.native = True
            elif method.__class__ == Destructor:
                method.native = True
                method.visibility = VisibilityProtected
                method.documentation = 'This method deletes the wrapped C++ object. This method should\n' \
                                       'not be called directly by the user, but must be called by the GC.\n\n' \
                                       'Note that since Java does not require the GC to call finalize() at all\n' \
                                       'it is recommended to not wrap any RAII objects that could lock or unlock\n' \
                                       'resources that are system wide.'

    def codegen(self, context, cls):
        path = os.path.join(context.target_out_dir, reduce(lambda o, ns: os.path.join(ns.lower(), o), reversed(cls.namespaces), cls.obj.name+'.java'))

        if not os.path.exists(os.path.dirname(path)):
            os.makedirs(os.path.dirname(path))

        package = reduce(lambda o, ns: Namespace(name=ns, content=[o]), reversed(cls.namespaces), cls.obj)

        # package = Namespace('allogen', content=[Namespace('tests', content=[cls.obj])])

        generator = JavaLanguageSourceGenerator()
        stream = FileSourceCodeWriter(path, generator=generator)

        stream(Comment(content=codegen_notice, multiline=True), stream.nl, stream.nl)
        stream(package)
