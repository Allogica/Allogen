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

package com.allogica.allogen.model;

import com.allogica.allogen.idl.model.IDLMethod;

import java.util.List;

public class Method extends ModelObject {
    private String name;
    private TypeName returnType;
    private List<MethodArgument> arguments;

    private boolean isStatic;
    private String body;

    private IDLMethod idlMethod;

    public Method(String name, TypeName returnType, List<MethodArgument> arguments) {
        this.name = name;
        this.returnType = returnType;
        this.arguments = arguments;
    }

    public Method(IDLMethod idlMethod, String name, TypeName returnType, List<MethodArgument> arguments) {
        this.name = name;
        this.returnType = returnType;
        this.arguments = arguments;
        this.idlMethod = idlMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeName getReturnType() {
        return returnType;
    }

    public Method setReturnType(TypeName returnType) {
        this.returnType = returnType;
        return this;
    }

    public List<MethodArgument> getArguments() {
        return arguments;
    }

    public void setArguments(List<MethodArgument> arguments) {
        this.arguments = arguments;
    }

    public void addArgumentAfter(MethodArgument argument, MethodArgument newArgument) {
        arguments.add(arguments.indexOf(argument) + 1, newArgument);
    }

    public String getBody() {
        return body;
    }

    public Method setBody(String body) {
        this.body = body;
        return this;
    }

    public IDLMethod getIdlMethod() {
        return idlMethod;
    }

    public Method setIdlMethod(IDLMethod idlMethod) {
        this.idlMethod = idlMethod;
        return this;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public Method setStatic(boolean aStatic) {
        isStatic = aStatic;
        return this;
    }
}
