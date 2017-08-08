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

package com.allogica.allogen.backend.java;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.backend.AbstractCompilerBackend;
import com.allogica.allogen.idl.model.IDLAnnotation;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.*;
import com.allogica.allogen.types.LambdaType;
import com.allogica.allogen.types.PrimitiveType;
import com.allogica.allogen.types.StringType;
import com.allogica.allogen.types.UserDefinedType;
import com.allogica.allogen.util.StringHelper;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaBackend extends AbstractCompilerBackend {

    @Override
    public URL getTargetTemplateURL() {
        return JavaBackend.class.getResource("TargetTemplate.stg");
    }

    @Override
    public String getTargetOutputFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return String.join("/", Arrays.stream(clazz.getNamespaces()).map(
                String::toLowerCase).collect(Collectors.toList())) + "/" + clazz.getAttribute("javaName") + ".java";
    }

    @Override
    public URL getBridgeTemplateURL() {
        return JavaBackend.class.getResource("BridgeTemplate.stg");
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
        clazz.setAttribute("javaPackage", String.join(".", Arrays.stream(clazz.getNamespaces()).map(
                String::toLowerCase).collect(Collectors.toList())));
        clazz.setAttribute("javaName", clazz.getName());
        clazz.setAttribute("jniSignature", clazz.getAttribute("javaName"));

        clazz.setAttribute("javaFullyQualifiedName", clazz.getAttribute("javaPackage") + "." +
                clazz.getAttribute("javaName"));

        clazz.setAttribute("javaClassPath", String.join("/", Arrays.stream(clazz.getNamespaces()).map(
                String::toLowerCase).collect(Collectors.toList())) + "/" + clazz.getAttribute("javaName"));
        clazz.setAttribute("javaSignature", "L" + String.join("/", Arrays.stream(clazz.getNamespaces()).map(
                String::toLowerCase).collect(Collectors.toList())) + "/" + clazz.getAttribute("javaName") + ";");
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method) {
        method.setAttribute("javaName", method.getName());
        method.setAttribute("jniSignature", createJNIMethodMangling(clazz, method));
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method, MethodArgument argument) {
        if (argument.getType().getResolvedType() instanceof LambdaType) {
            createCallbackInterface(method, argument, (LambdaType) argument.getType().getResolvedType());
        }
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor) {
        // create a init stub method
        final Method stubInit = new Method("_init", null, constructor.getArguments());
        stubInit.setAttribute("javaName", "_init");

        constructor.setAttribute("jniSignature", createJNIMethodMangling(clazz, stubInit,
                clazz.getConstructors().size() > 1));
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Destructor destructor) {
        // create a init stub method
        final Method stubInit = new Method("finalize", null, new ArrayList<>());
        stubInit.setAttribute("javaName", "finalize");

        destructor.setAttribute("jniSignature", createJNIMethodMangling(clazz, stubInit, false));
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void createCallbackInterface(Method method, MethodArgument argument, LambdaType lambda) {
        final IDLAnnotation annotation = argument.getIdlMethodArgument().getAnnotation("Callback");

        final String interfaceName;
        final String methodName;
        if (annotation != null) {
            interfaceName = annotation.getProperty("interface");
            methodName = annotation.getProperty("method");
        } else {
            interfaceName = StringHelper.firstToUpper(method.getName()) + StringHelper.firstToUpper(argument.getName());
            methodName = "on" + StringHelper.firstToUpper(argument.getName());
        }

        argument.setAttribute("javaHasLambdaInterface", true);
        argument.setAttribute("javaLambdaInterfaceName", interfaceName);
        argument.setAttribute("javaLambdaMethodName", methodName);

        argument.getType().setAttribute("javaLambdaInterfaceName", interfaceName);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private static final Map<String, String> javaSignatures = new HashMap<>();

    static {
        javaSignatures.put("void", "V");
        javaSignatures.put("bool", "B");

        javaSignatures.put("int8", "B");
        javaSignatures.put("uint8", "B");

        javaSignatures.put("int16", "S");
        javaSignatures.put("uint16", "S");

        javaSignatures.put("int32", "I");
        javaSignatures.put("uint32", "I");

        javaSignatures.put("int64", "J");
        javaSignatures.put("uint64", "J");

        javaSignatures.put("float", "F");
        javaSignatures.put("double", "D");
    }

    private String createJNIMethodMangling(Class clazz, Method method) {
        return createJNIMethodMangling(clazz, method, false);
    }

    private String createJNIMethodMangling(Class clazz, Method method, boolean forceOverload) {
        String packageName = ((String) clazz.getAttribute("javaPackage")).replaceAll("\\.", "_");
        String className = clazz.getAttribute("javaName");
        String methodName = method.getAttribute("javaName");

        methodName = methodName.replaceAll("_", "_1");

        /* if no overloads, java uses a simplified signature */
        if (!clazz.hasOverloadForMethod(method.getName()) && !forceOverload) {
            return packageName + "_" + className + "_" + methodName;
        }

        StringBuilder overloadBuilder = new StringBuilder();
        overloadBuilder.append(packageName).append("_");
        overloadBuilder.append(className).append("_");
        overloadBuilder.append(methodName)
                .append("__");

        for (final MethodArgument argument : method.getArguments()) {
            if (argument.getType().getResolvedType() instanceof UserDefinedType) {
                final String javaName = ((UserDefinedType) argument.getType().getResolvedType()).getUserDefinedClass()
                        .getAttribute("javaFullyQualifiedName");
                final String normalizedJavaName = javaName.replaceAll("\\.", "_");
                overloadBuilder.append("L").append(normalizedJavaName).append("_");
            } else if (argument.getType().getResolvedType() instanceof PrimitiveType) {
                final String typeName = argument.getType().getName();
                if (!javaSignatures.containsKey(typeName)) {
                    throw new RuntimeException(String.format("Java backend does not support '%s'", typeName));
                }
                overloadBuilder.append(javaSignatures.get(typeName));
            } else if (argument.getType().getResolvedType() instanceof StringType) {
                overloadBuilder.append("Ljava_lang_String_2");
            }
        }

        return overloadBuilder.toString();
    }
}
