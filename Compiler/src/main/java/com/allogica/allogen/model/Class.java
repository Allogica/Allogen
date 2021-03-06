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
import com.allogica.allogen.types.UserDefinedType;

import java.util.*;

public class Class extends ModelObject {
    private String name;
    private String[] namespaces;

    private TypeName parent;

    private List<Constructor> constructors = new ArrayList<>();
    private Destructor destructor;
    private List<Method> methods = new ArrayList<>();
    private List<InheritedMethod> inheritedMethods = new ArrayList<>();

    private boolean isAbstract = false;
    private boolean isStatic = false;

    private Map<String, Property> properties = new HashMap<>();

    private IDLClass idlClass;
    private transient Set<Type> usedTypes = new TreeSet<>(Type::compare);

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

    public TypeName getParent() {
        return parent;
    }

    public Class getParentClass() {
        if(parent.getResolvedType() == null) {
            return null;
        }
        return ((UserDefinedType) parent.getResolvedType()).getUserDefinedClass();
    }

    public Class setParent(TypeName parent) {
        this.parent = parent;
        return this;
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

    public List<InheritedMethod> getInheritedMethods() {
        return inheritedMethods;
    }

    public Class setInheritedMethods(List<InheritedMethod> inheritedMethods) {
        this.inheritedMethods = inheritedMethods;
        return this;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public Class setStatic(boolean aStatic) {
        isStatic = aStatic;
        return this;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public Class setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
        return this;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    public Class setProperties(Map<String, Property> properties) {
        this.properties = properties;
        return this;
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

    public boolean hasNonStaticMethod() {
        for(final Method method : methods) {
            if(!method.isStatic()) {
                return true;
            }
        }
        return false;
    }

}
