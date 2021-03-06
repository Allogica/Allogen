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

package com.allogica.allogen.passes;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.Constructor;
import com.allogica.allogen.model.Method;
import com.allogica.allogen.model.MethodArgument;

public class TypeLinkingPass implements CompilerPass<Class, Class> {

    @Override
    public Class pass(Compiler compiler, CompilerContext context, Class clazz) {
        // now that every type as been loaded or imported, we can link complex types
        // like lambdas

        for (final Method method : clazz.getMethods()) {
            handleMethod(compiler, context, clazz, method);
        }
        for(final Constructor constructor : clazz.getConstructors()) {
            handleConstructor(compiler, context, clazz, constructor);
        }

        return clazz;
    }

    private void handleMethod(Compiler<?, ?> compiler, CompilerContext context, Class clazz, Method method) {
        method.getReturnType().getResolvedType().link(compiler, context);
        clazz.getUsedTypes().addAll(method.getReturnType().getResolvedType().getDependantTypes());

        for (final MethodArgument argument : method.getArguments()) {
            handleArgument(compiler, context, clazz, argument);
        }
    }

    private void handleConstructor(Compiler<?, ?> compiler, CompilerContext context, Class clazz, Constructor constructor) {
        for (final MethodArgument argument : constructor.getArguments()) {
            handleArgument(compiler, context, clazz, argument);
        }
    }

    private void handleArgument(Compiler<?, ?> compiler, CompilerContext context, Class clazz, MethodArgument argument) {
        argument.getType().getResolvedType().link(compiler, context);
        clazz.getUsedTypes().addAll(argument.getType().getResolvedType().getDependantTypes());
    }

}
