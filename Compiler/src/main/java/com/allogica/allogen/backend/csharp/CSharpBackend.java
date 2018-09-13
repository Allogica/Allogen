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
 * THIS SOFfTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
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

package com.allogica.allogen.backend.csharp;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.backend.AbstractCompilerBackend;
import com.allogica.allogen.idl.model.IDLAnnotation;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.*;
import com.allogica.allogen.types.*;
import com.allogica.allogen.util.StringHelper;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSharpBackend extends AbstractCompilerBackend {

    private final String pInvokeDll;

    public CSharpBackend(String pInvokeDll) {
        this.pInvokeDll = pInvokeDll;
    }

    @Override
    public URL getTargetTemplateURL() {
        return CSharpBackend.class.getResource("TargetTemplate.stg");
    }

    @Override
    public String getTargetOutputFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return String.join("/", clazz.getNamespaces()) + "/" + clazz.getAttribute("csName") + ".cs";
    }

    @Override
    public URL getBridgeTemplateURL() {
        return CSharpBackend.class.getResource("BridgeTemplate.stg");
    }

    @Override
    public String getBridgeOutputHeaderFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return compilerContext.getBridgePath(clazz.getNamespaces(), clazz.getName()) + ".hpp";
    }

    @Override
    public String getBridgeOutputImplementationFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return compilerContext.getBridgePath(clazz.getNamespaces(), clazz.getName()) + ".cpp";
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        clazz.setAttribute("csNamespace", String.join(".", clazz.getNamespaces()));
        clazz.setAttribute("csName", clazz.getName());

        final String csFullyQualifiedName = clazz.getAttribute("csNamespace") + "." + clazz.getAttribute("csName");
        clazz.setAttribute("csFullyQualifiedName", csFullyQualifiedName);

        clazz.setAttribute("csLibraryName", pInvokeDll);
    }

    @Override
    public void postHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        final Set<String> imports = new HashSet<>();
        for (final Type type : clazz.getUsedTypes()) {
            if (!(type instanceof UserDefinedType)) {
                continue;
            }
            imports.add(((UserDefinedType) type).getUserDefinedClass().getAttribute("csNamespace"));
        }
        clazz.setAttribute("csImports", imports);

        for (final Property property : clazz.getProperties().values()) {
            final String propName = StringHelper.firstToUpper(property.getName());
            property.setAttribute("csName", propName);

            final Method getter = property.getGetter();
            if (getter != null) {
                final String csName = getter.getAttribute("csName");
                if (!csName.equals("ToString")) {
                    getter.setAttribute("csPrivate", true);
                }
                if (csName.equals(propName)) {
                    getter.setAttribute("csName", "_" + csName);
                }
            }
        }
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method) {
        final String csName = StringHelper.firstToUpper(method.getName());

        method.setAttribute("csName", csName);
        method.setAttribute("csVirtual", true);

        String csEntryPoint = String.join("_", clazz.getNamespaces()) + "_" +
                clazz.getName() + "_" + method.getName();
        if (clazz.hasOverloadForMethod(method.getName())) {
            Stream<String> names = method.getArguments().stream().map(MethodArgument::getName);
            csEntryPoint += "_" + String.join("_", names.toArray(String[]::new));
        }
        method.setAttribute("csEntryPoint", csEntryPoint);

        if (method.getReturnType().getName().equals("void")) {
            method.getReturnType().setAttribute("csIsVoid", true);
        }

        if (csName.equals("ToString")) {
            method.setAttribute("csOverride", true);
            method.setAttribute("csVirtual", false);
        }

        if (isIgnoredType(method.getReturnType().getResolvedType(), true)) {
            method.setAttribute("csSkip", true);
            return;
        }

        // Translate a return buffer type into a argument
        if (method.getReturnType().getResolvedType() instanceof BufferType) {
            method.getReturnType().setAttribute("csTranslatedReturnType", true);

//            final MethodArgument arrayArg = new MethodArgument("csretValue", new TypeName("byte[]"));
//            arrayArg.setAttribute("csExternOnly", true);
//            arrayArg.setAttribute("csAttributes", "MarshalAs(UnmanagedType.LPArray, SizeParamIndex=2)");
//
//            final MethodArgument sizeArg = new MethodArgument("csretSize", new TypeName("long"));
//            sizeArg.setAttribute("csExternOnly", true);
//
//            method.getArguments().add(0, sizeArg);
//            method.getArguments().add(0, arrayArg);
        }

        for (MethodArgument argument : method.getArguments()) {
            if (isIgnoredType(argument.getType().getResolvedType(), false) || argument.getType().getResolvedType() instanceof BufferType) {
                method.setAttribute("csSkip", true);
                return;
            }
        }
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, InheritedMethod method) {
        method.setAttribute("csEntryPoint", String.join("_", clazz.getNamespaces()) + "_" +
                clazz.getName() + "_" + method.getName());

        method.setAttribute("csOverride", true);
        method.setAttribute("csVirtual", false);
        method.getMethod().setAttribute("csVirtual", true);
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method, MethodArgument argument) {
        if (argument.getType().getResolvedType() instanceof LambdaType) {
            createDelegate(method, argument, (LambdaType) argument.getType().getResolvedType());
        }
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor) {
        StringBuilder builder = new StringBuilder(String.join("_", clazz.getNamespaces()) + "_" +
                clazz.getName() + "_Constructor");
        for (final MethodArgument argument : constructor.getArguments()) {
            builder.append("_").append(argument.getName());
        }

        constructor.setAttribute("csEntryPoint", builder.toString());

        for (MethodArgument argument : constructor.getArguments()) {
            if (isIgnoredType(argument.getType().getResolvedType(), false) || argument.getType().getResolvedType() instanceof BufferType) {
                constructor.setAttribute("csSkip", true);
                return;
            }
        }
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Destructor destructor) {
        destructor.setAttribute("csEntryPoint", String.join("_", clazz.getNamespaces()) + "_" +
                clazz.getName() + "_Destructor");
    }

    // -----------------------------------------------------------------------------------------------------------------

    private boolean isIgnoredType(Type type, boolean forReturn) {
        if(forReturn) {
            return (type instanceof VectorType || type instanceof MapType);
        } else {
            return (type instanceof MapType);
        }
    }

    private void createDelegate(Method method, MethodArgument argument, LambdaType lambda) {
        final IDLAnnotation annotation = argument.getIdlMethodArgument().getAnnotation("Callback");

        final String interfaceName;
        final String reuse;
        if (annotation != null) {
            interfaceName = annotation.getProperty("interface");
            reuse = annotation.getProperty("reuse");
        } else {
            interfaceName = StringHelper.firstToUpper(method.getName()) + StringHelper.firstToUpper(argument.getName());
            reuse = null;
        }

        argument.setAttribute("csHasDelegate", true);
        argument.setAttribute("csDelegateName", interfaceName);
        argument.setAttribute("csDelegateReuse", reuse != null);

        argument.getType().setAttribute("csDelegateName", interfaceName);
    }

}
