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

package com.allogica.allogen.types;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.Scope;
import com.allogica.allogen.idl.model.IDLTypeName;
import com.allogica.allogen.model.TypeName;
import com.allogica.allogen.util.TypeUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MapType extends AbstractType {

    private TypeName keyType;
    private TypeName valueType;
    
    private Scope scope;

    public MapType(final TypeName typeName) {
        scope = typeName.getScope();
        keyType = typeName.getTemplateArguments().get(0).setScope(scope);
        valueType = typeName.getTemplateArguments().get(1).setScope(scope);
    }

    @Override
    public void link(Compiler<?, ?> compiler, CompilerContext compilerContext) {
        keyType.setResolvedType(compilerContext.resolve(keyType, scope));
        if (keyType.getResolvedType() == null) {
            throw new RuntimeException(String.format("Type '%s' not found in scope '%s'",
                    keyType, scope));
        }
        keyType.getResolvedType().link(compiler, compilerContext);

        valueType.setResolvedType(compilerContext.resolve(valueType, scope));
        if (valueType.getResolvedType() == null) {
            throw new RuntimeException(String.format("Type '%s' not found in scope '%s'",
                    valueType, scope));
        }
        valueType.getResolvedType().link(compiler, compilerContext);
    }

    @Override
    public String getTemplateName() {
        return "mapType";
    }

    @Override
    public List<Type> getDependantTypes() {
        List<Type> types = TypeUtils.getAllDependantTypes(keyType.getResolvedType());
        types.addAll(TypeUtils.getAllDependantTypes(valueType.getResolvedType()));
        return types;
    }

    public TypeName getKeyType() {
        return keyType;
    }

    public MapType setKeyType(TypeName keyType) {
        this.keyType = keyType;
        return this;
    }

    public TypeName getValueType() {
        return valueType;
    }

    public MapType setValueType(TypeName valueType) {
        this.valueType = valueType;
        return this;
    }

    public Scope getScope() {
        return scope;
    }

    public MapType setScope(Scope scope) {
        this.scope = scope;
        return this;
    }
}
