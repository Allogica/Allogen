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
import com.allogica.allogen.backend.csharp.CSharpBackend;
import com.allogica.allogen.backend.java.JavaBackend;
import com.allogica.allogen.backend.objectivec.ObjectiveCBackend;
import com.allogica.allogen.idl.ParsedIDL;
import com.allogica.allogen.idl.Parser;
import com.allogica.allogen.idl.model.IDLClass;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.modules.Module;
import com.allogica.allogen.passes.*;
import com.beust.jcommander.JCommander;

import java.io.*;
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
        System.out.println("Module: " + args.moduleFile);
        System.out.println("Imports: " + args.imports);

        CompilerBackend backend;
        switch (args.target.toLowerCase()) {
            case "objectivec":
            case "objc":
                backend = new ObjectiveCBackend();
                break;

            case "java":
                backend = new JavaBackend();
                break;

            case "cs":
            case "csharp":
                backend = new CSharpBackend();
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

                new PropertiesPass(),

                new PreBackendPass(),
                new BackendPass(),
                new PostBackendPass(),

                new CodegenPass()
        );

        // import modules!
        for (final File moduleName : args.imports) {
            System.out.println("Importing module " + moduleName);

            final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(moduleName));
            final Module module = (Module) ois.readObject();
            compiler.importModule(module);
        }

        List<IDLClass> classes = new ArrayList<>();
        Parser parser = new Parser();
        for (final File idlFile : args.idlFiles) {
            ParsedIDL idl = parser.parse(new FileInputStream(idlFile));
            classes.addAll(idl.getGlobalNamespace().getAllClasses());
        }
        final List<Class> compiledClasses = compiler.compile(classes);

        // Write the module file!
        if (args.moduleFile != null) {
            final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(args.moduleFile));
            oos.writeObject(
                    new Module(compiledClasses)
            );
        }
    }

}
