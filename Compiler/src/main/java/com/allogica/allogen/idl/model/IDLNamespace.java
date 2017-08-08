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

package com.allogica.allogen.idl.model;

import com.allogica.allogen.idl.grammar.IDLParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IDLNamespace extends IDLWrappedObject {

    private IDLNamespace parent;

    private String name;
    private List<IDLClass> classes;
    private List<IDLNamespace> namespaces;

    public IDLNamespace(String name, List<IDLClass> classes, List<IDLNamespace> namespaces) {
        super(null);

        this.name = name;
        this.classes = classes;
        this.namespaces = namespaces;

        for (IDLClass clazz : classes) {
            clazz.setParent(this);
        }
        for (IDLNamespace namespace : namespaces) {
            namespace.setParent(this);
        }
    }

    public IDLNamespace(List<IDLParser.DeclarationContext> ctx) {
        super(null);

        this.name = null;
        this.classes = new ArrayList<>();
        this.namespaces = new ArrayList<>();

        for (final IDLParser.DeclarationContext declaration : ctx) {
            if (declaration.classdefinition() != null) {
                final IDLClass clazz = new IDLClass(declaration.classdefinition());
                this.classes.add(clazz);
                clazz.setParent(this);
            } else if (declaration.namespacedefinition() != null) {
                final IDLNamespace namespace = new IDLNamespace(declaration.namespacedefinition());
                this.namespaces.add(namespace);
                namespace.setParent(this);
            }
        }
    }

    public IDLNamespace(IDLParser.NamespacedefinitionContext ctx) {
        super(null);

        this.name = ctx.namespacename().Identifier().getText();
        this.classes = new ArrayList<>();
        this.namespaces = new ArrayList<>();

        for (final IDLParser.DeclarationContext declaration : ctx.namespacebody().declarations().declaration()) {
            if (declaration.classdefinition() != null) {
                final IDLClass clazz = new IDLClass(declaration.classdefinition());
                this.classes.add(clazz);
                clazz.setParent(this);
            } else if (declaration.namespacedefinition() != null) {
                final IDLNamespace namespace = new IDLNamespace(declaration.namespacedefinition());
                this.namespaces.add(namespace);
                namespace.setParent(this);
            }
        }
    }

    public IDLNamespace getParent() {
        return parent;
    }

    public void setParent(IDLNamespace parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IDLClass> getClasses() {
        return classes;
    }

    public List<IDLClass> getAllClasses() {
        List<IDLClass> allClasses = new ArrayList<>();
        allClasses.addAll(classes);
        for(final IDLNamespace namespace : namespaces) {
            allClasses.addAll(namespace.getAllClasses());
        }
        return allClasses;
    }

    public IDLClass getClass(String name) {
        for (IDLClass clazz : classes) {
            if (clazz.getName().equals(name)) {
                return clazz;
            }
        }
        return null;
    }

    public void setClasses(List<IDLClass> classes) {
        this.classes = classes;
    }

    public List<IDLNamespace> getNamespaces() {
        return namespaces;
    }

    public IDLNamespace getNamespace(String name) {
        for (IDLNamespace namespace : namespaces) {
            if (namespace.getName().equals(name)) {
                return namespace;
            }
        }
        return null;
    }

    public void setNamespaces(List<IDLNamespace> namespaces) {
        this.namespaces = namespaces;
    }

    public List<String> getNamespaceChain() {
        if (parent != null) {
            List<String> fromParent = parent.getNamespaceChain();
            if (name != null)
                fromParent.add(name);
            return fromParent;
        }

        if (name == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Collections.singletonList(name));
    }

}
