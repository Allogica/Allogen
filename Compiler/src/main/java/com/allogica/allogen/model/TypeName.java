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

import com.allogica.allogen.Scope;
import com.allogica.allogen.idl.model.IDLTypeName;
import com.allogica.allogen.types.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeName extends ModelObject {

    private String name;
    private String[] namespace;
    private Scope scope;

    private List<TypeName> templateArguments = new ArrayList<>();

    private IDLTypeName idlTypeName;
    private transient Type resolvedType;

    public TypeName(String name) {
        this(name, new String[]{});
    }

    public TypeName(String name, List<TypeName> templateArguments, String[] namespace) {
        this.name = name;
        this.namespace = namespace;
        this.templateArguments = templateArguments;
    }

    public TypeName(String name, String... namespace) {
        this.name = name;
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNamespace() {
        return namespace;
    }

    public void setNamespace(String[] namespace) {
        this.namespace = namespace;
    }

    public boolean hasResolvedType() {
        return resolvedType != null;
    }

    public Type getResolvedType() {
        return resolvedType;
    }

    public TypeName setResolvedType(Type resolvedType) {
        this.resolvedType = resolvedType;
        return this;
    }

    public List<TypeName> getTemplateArguments() {
        return templateArguments;
    }

    public TypeName setTemplateArguments(List<TypeName> templateArguments) {
        this.templateArguments = templateArguments;
        return this;
    }

    public Scope getScope() {
        return scope;
    }

    public TypeName setScope(Scope scope) {
        this.scope = scope;
        return this;
    }

    public IDLTypeName getIdlTypeName() {
        return idlTypeName;
    }

    public TypeName setIdlTypeName(IDLTypeName idlTypeName) {
        this.idlTypeName = idlTypeName;
        return this;
    }

    @Override
    public String toString() {
        return String.join("::", namespace) + "::" + name;
    }
}
