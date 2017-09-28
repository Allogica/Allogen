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

package com.allogica.allogen.backend;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.*;
import com.allogica.allogen.types.UserDefinedType;

import java.net.URL;

public interface CompilerBackend {

    void registerTypes(Compiler<?, ?> compiler, CompilerContext compilerContext);
    UserDefinedType createUserDefinedType(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz);

    URL getTargetTemplateURL();
    String getTargetOutputFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz);

    URL getBridgeTemplateURL();
    String getBridgeOutputHeaderFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz);
    String getBridgeOutputImplementationFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Destructor destructor);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Destructor destructor);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Destructor destructor);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor, MethodArgument argument);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor, MethodArgument argument);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor, MethodArgument argument);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method, MethodArgument argument);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method, MethodArgument argument);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method, MethodArgument argument);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, InheritedMethod method);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, InheritedMethod method);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, InheritedMethod method);

    void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, InheritedMethod method, MethodArgument argument);
    void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, InheritedMethod method, MethodArgument argument);
    void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, InheritedMethod method, MethodArgument argument);

}
