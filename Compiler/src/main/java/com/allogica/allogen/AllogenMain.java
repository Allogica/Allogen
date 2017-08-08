/*
 * Copyright (c) 2017, Allogica
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright notice,
 *       this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of Allogen nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.allogica.allogen;

import com.allogica.allogen.backend.CompilerBackend;
import com.allogica.allogen.backend.java.JavaBackend;
import com.allogica.allogen.backend.objectivec.ObjectiveCBackend;
import com.allogica.allogen.idl.ParsedIDL;
import com.allogica.allogen.idl.Parser;
import com.allogica.allogen.idl.model.IDLClass;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.passes.*;
import com.beust.jcommander.JCommander;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class AllogenMain {

    public static void main(String[] argv) throws Exception {
        final CompilerArgs args = new CompilerArgs();

        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(argv);

        System.out.println("Target: " + args.target);
        System.out.println("Target dir: " + args.targetDir);
        System.out.println("Bridge dir: " + args.bridgeDir);
        System.out.println("Parameters: " + args.idlFiles);

        final String input = "namespace Teste {\n" +
                "    class MyClass {\n" +
                "        #include \"Core/MyClass.hpp\"\n" +
                "        constructor();\n" +
                "        constructor(a: int32);\n" +
                "        constructor(name: string);\n" +
                "        constructor(name1: string, name2: string);\n" +
                "        destructor();\n" +
                "        @Callback\n" +
                "        uint32 call(a: int32) { return a; }\n" +
                "        void call2();\n" +
                "        void call2(overload: int32);\n" +
                "        void call2(overload: string);\n" +
                "        void call2(overload: string, overload2: string);\n" +
                "        void call2(a: int32, overload: string, overload2: string);\n" +
                "        int32 call2(a: int32, overload: string, overload2: string, b: int32);\n" +
                "        void doAsync(callback: lambda<void(int32)>);\n" +
                "    };\n" +
                "\n" +
                "    class MyClass2 {\n" +
                "        #include \"Core/MyClass2.hpp\"\n" +
                "        string call();\n" +
                "        MyClass call2();\n" +
                "    };\n" +
                "}";

        CompilerBackend backend;
        switch (args.target.toLowerCase()) {
            case "objectivec":
            case "objc":
                backend = new ObjectiveCBackend();
                break;

            case "java":
                backend = new JavaBackend();
                break;

            default:
                throw new Exception("Unknown backend: " + args.target);

        }

        CompilerContext context = new CompilerContext(
                args.targetDir,
                args.bridgeDir,
                args.baseNamespace.split("::")
        );
        Compiler<IDLClass, Class> compiler = new Compiler<>(
                context, backend,

                /* compiler passes */
                new ObjectModelCreationPass(),
                new TypeResolutionPass(),
                new TypeLinkingPass(),

                new PreBackendPass(),
                new BackendPass(),
                new PostBackendPass(),

                new CodegenPass()
        );

        List<IDLClass> classes = new ArrayList<>();
        Parser parser = new Parser();

        for (final File idlFile : args.idlFiles) {
            ParsedIDL idl = parser.parse(new FileInputStream(idlFile));
            classes.addAll(idl.getGlobalNamespace().getAllClasses());
        }
//        classes.addAll(parser.parse(input).getGlobalNamespace().getAllClasses());

        compiler.compile(classes);

//        for (IDLClass clazz : classes) {
//            Class compiledClass = compiler.compile(clazz);
//        }
    }

}
