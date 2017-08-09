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
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.TypeName;
import com.allogica.allogen.modules.Module;
import com.allogica.allogen.passes.CompilerPass;
import com.allogica.allogen.types.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compiler<Input, Output> {

    private CompilerContext context;
    private CompilerBackend backend;

    private List<CompilerPass<?, ?>> passes = new ArrayList<>();

    public Compiler(CompilerContext context, CompilerBackend backend, CompilerPass<?, ?>... passes) {
        this.context = context;
        this.backend = backend;

        this.addPasses(passes);

        context.registerType(new PrimitiveType(), new TypeName("void"));
        context.registerType(new PrimitiveType(), new TypeName("bool"));
        context.registerType(new PrimitiveType(), new TypeName("uint8"));
        context.registerType(new PrimitiveType(), new TypeName("int8"));
        context.registerType(new PrimitiveType(), new TypeName("uint16"));
        context.registerType(new PrimitiveType(), new TypeName("int16"));
        context.registerType(new PrimitiveType(), new TypeName("uint32"));
        context.registerType(new PrimitiveType(), new TypeName("int32"));
        context.registerType(new PrimitiveType(), new TypeName("uint64"));
        context.registerType(new PrimitiveType(), new TypeName("int64"));

        context.registerTypeFactory(LambdaType::new, new TypeName("lambda"));
        context.registerTypeFactory(OptionalType::new, new TypeName("optional"));
        context.registerTypeFactory(SharedPtrType::new, new TypeName("shared_ptr"));
        context.registerType(new StringType(), new TypeName("string"));

        this.backend.registerTypes(this, this.context);
    }

    public void addPass(CompilerPass<?, ?> pass) {
        passes.add(pass);
    }

    public void addPasses(CompilerPass<?, ?>... passes) {
        this.passes.addAll(Arrays.asList(passes));
    }

    public void importModule(Module module) {
        for(final Class clazz : module.getExportedClasses()) {
            // register the class with the compiler context
            final UserDefinedType userDefinedType = getBackend().createUserDefinedType(this, context, clazz);
            context.registerType(userDefinedType, new TypeName(clazz.getName(), clazz.getNamespaces()));
        }
    }

    public List<Output> compile(List<Input> inputs) throws IOException {
        List<Object> output = (List<Object>) inputs;
        for (CompilerPass pass : passes) {
            output = handlePass(pass, output);
        }
        return (List<Output>) output;
    }

    private List<Object> handlePass(CompilerPass pass, List<Object> inputs) throws IOException {
        List<Object> objects = new ArrayList<>();
        for (Object clazz : inputs) {
            objects.add(pass.pass(this, context, clazz));
        }
        return objects;
    }

    public CompilerContext getContext() {
        return context;
    }

    public CompilerBackend getBackend() {
        return backend;
    }

}
