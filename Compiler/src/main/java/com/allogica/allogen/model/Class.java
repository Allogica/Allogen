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
import com.allogica.allogen.idl.model.IDLClass;
import com.allogica.allogen.types.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Class extends ModelObject {
    private String name;
    private String[] namespaces;

    private List<Constructor> constructors = new ArrayList<>();
    private Destructor destructor;
    private List<Method> methods = new ArrayList<>();

    private IDLClass idlClass;
    private Set<Type> usedTypes = new HashSet<>();

    public Class(String name, List<Method> methods) {
        this.name = name;
        this.methods = methods;
    }

    public Class(IDLClass idlClass, String name, List<Method> methods) {
        this.name = name;
        this.methods = methods;
        this.idlClass = idlClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNamespaces() {
        return namespaces;
    }

    public Scope getScope() {
        return new Scope(namespaces);
    }

    public void setNamespaces(String[] namespaces) {
        this.namespaces = namespaces;
    }

    public List<Constructor> getConstructors() {
        return constructors;
    }

    public Class setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
        return this;
    }

    public Destructor getDestructor() {
        return destructor;
    }

    public Class setDestructor(Destructor destructor) {
        this.destructor = destructor;
        return this;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public String getFullyQualifiedName() {
        return String.join("::", namespaces) + "::" + name;
    }

    public IDLClass getIdlClass() {
        return idlClass;
    }

    public Class setIdlClass(IDLClass idlClass) {
        this.idlClass = idlClass;
        return this;
    }

    public Set<Type> getUsedTypes() {
        return usedTypes;
    }

    public Class setUsedTypes(Set<Type> usedTypes) {
        this.usedTypes = usedTypes;
        return this;
    }

    public Class addUsedType(Type usedType) {
        this.usedTypes.add(usedType);
        return this;
    }

    public boolean hasOverloadForMethod(String name) {
        boolean found = false;
        for(final Method method : methods) {
            if(method.getName().equals(name)) {
                if(!found) {
                    found = true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
