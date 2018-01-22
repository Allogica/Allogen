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

import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.TypeName;
import com.allogica.allogen.types.Type;
import com.allogica.allogen.types.TypeFactory;

import java.io.File;
import java.util.*;

public class CompilerContext {

    private NamespaceContext globalNamespace = new NamespaceContext(null);

    private File targetDir;
    private File bridgeDir;
    private String[] basePath;

    public CompilerContext(File targetDir, File bridgeDir, String[] basePath) {
        this.targetDir = targetDir;
        this.bridgeDir = bridgeDir;
        this.basePath = basePath;
    }

    private class TypeContext {
        Type type;
        TypeFactory factory;

        TypeContext(Type type) {
            this.type = type;
        }

        TypeContext(TypeFactory factory) {
            this.factory = factory;
        }
    }

    private class NamespaceContext {
        private String name;

        private Map<String, NamespaceContext> namespaces = new HashMap<>();
        private Map<String, TypeContext> types = new HashMap<>();

        public NamespaceContext(String name) {
            this.name = name;
        }

        NamespaceContext getChildNamespace(String name) {
            if (namespaces.containsKey(name)) {
                return namespaces.get(name);
            }
            return null;
        }

        NamespaceContext addNamespace(String name) {
            if (types.containsKey(name) || namespaces.containsKey(name)) {
                throw new RuntimeException("Name " + name + " is already used.");
            }
            NamespaceContext ns = new NamespaceContext(name);
            namespaces.put(name, ns);
            return ns;
        }

        void addType(String name, Type type) {
            if (types.containsKey(name) || namespaces.containsKey(name)) {
                throw new RuntimeException("Name "+name+" is already used.");
            }
            types.put(name, new TypeContext(type));
        }

        void addTypeFactory(String name, TypeFactory typeFactory) {
            if (types.containsKey(name) || namespaces.containsKey(name)) {
                throw new RuntimeException("Name "+name+" is already used.");
            }
            types.put(name, new TypeContext(typeFactory));
        }

        Type resolve(TypeName typeName) {
            if (typeName.getNamespace().length == 0) {
                final TypeContext context = types.get(typeName.getName());
                if (context == null) {
                    return null;
                }

                if (context.type != null) {
                    return context.type;
                }
                return context.factory.createType(typeName);
            }

            if (!namespaces.containsKey(typeName.getNamespace()[0])) {
                return null;
            }

            List<String> l = new ArrayList<>(Arrays.asList(typeName.getNamespace()));
            l.remove(0);

            return namespaces.get(typeName.getNamespace()[0]).resolve(
                    new TypeName(typeName.getName(), typeName.getTemplateArguments(),
                            l.toArray(new String[l.size()]))
            );
        }

    }

    public Type resolve(TypeName typeName) {
        return globalNamespace.resolve(typeName);
    }

    public Type resolve(TypeName typeName, Scope scope) {
        NamespaceContext ns = globalNamespace;
        for (String namespace : scope.getNamespace()) {
            final Type resolved = ns.resolve(typeName);
            if (resolved != null) {
                return resolved;
            }

            ns = ns.getChildNamespace(namespace);
            if (ns == null) {
                return null;
            }
        }

        return ns.resolve(typeName);
    }

    public void registerType(Type type, TypeName typeName) {
        System.out.println("Registering " + typeName.getName());

        NamespaceContext ns = globalNamespace;
        for (String namespace : typeName.getNamespace()) {
            NamespaceContext nextNs = ns.getChildNamespace(namespace);
            if (nextNs == null) {
                nextNs = ns.addNamespace(namespace);
            }
            ns = nextNs;
        }
        ns.addType(typeName.getName(), type);
    }

    public void registerTypeFactory(TypeFactory typeFactory, TypeName typeName) {
        NamespaceContext ns = globalNamespace;
        for (String namespace : typeName.getNamespace()) {
            NamespaceContext nextNs = ns.getChildNamespace(namespace);
            if (nextNs == null) {
                nextNs = ns.addNamespace(namespace);
            }
            ns = nextNs;
        }
        ns.addTypeFactory(typeName.getName(), typeFactory);
    }

    public String getBridgePath(String[] namespacesArray, String className) {
        if (basePath.length == 0) {
            return String.join("/", namespacesArray) + "/" + className;
        }

        List<String> namespaces = new ArrayList<>(Arrays.asList(namespacesArray));
        namespaces.add(className);

        for (String aBasePath : basePath) {
            if (!aBasePath.equals(namespaces.get(0))) {
                break;
            }
            namespaces.remove(0);
        }

        return String.join("/", basePath) + "/" + String.join("/", namespaces);
    }

    public String[] getBasePath() {
        return basePath;
    }

    public File getTargetDir() {
        return targetDir;
    }

    public File getBridgeDir() {
        return bridgeDir;
    }
}
