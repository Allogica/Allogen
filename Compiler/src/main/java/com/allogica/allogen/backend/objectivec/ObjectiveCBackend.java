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

package com.allogica.allogen.backend.objectivec;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.backend.AbstractCompilerBackend;
import com.allogica.allogen.idl.model.IDLAnnotation;
import com.allogica.allogen.model.*;
import com.allogica.allogen.model.Class;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectiveCBackend extends AbstractCompilerBackend {

    @Override
    public URL getTargetTemplateURL() {
        return ObjectiveCBackend.class.getResource("TargetTemplate.stg");
    }

    private String baseOutputName(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        String ns = null;
        if (clazz.getNamespaces().length > 1) {
            ns = clazz.getNamespaces()[0];
        } else {
            ns = compilerContext.getBasePath()[0];
        }

        return ns + "/" + clazz.getAttribute("objcName");
    }

    @Override
    public String getTargetOutputFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return baseOutputName(compiler, compilerContext, clazz) + ".h";
    }

    @Override
    public URL getBridgeTemplateURL() {
        return ObjectiveCBackend.class.getResource("BridgeTemplate.stg");
    }

/*
    @Override
    public String getBridgeOutputHeaderFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return baseOutputName(compiler, compilerContext, clazz) + "+Private.h";
    }

    @Override
    public String getBridgeOutputImplementationFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return baseOutputName(compiler, compilerContext, clazz) + ".mm";
    }
*/

    @Override
    public String getBridgeOutputHeaderFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return compilerContext.getBridgePath(clazz.getNamespaces(), clazz.getName()) + "+Private.h";
    }

    @Override
    public String getBridgeOutputImplementationFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return compilerContext.getBridgePath(clazz.getNamespaces(), clazz.getName()) + ".mm";
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        final String prefix = getObjectiveCPrefix(clazz);

        clazz.setAttribute("objPrefix", prefix);
        clazz.setAttribute("objcName", prefix + clazz.getName());
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method) {
        method.setAttribute("objcName", method.getName());
    }

    @Override
    public void preHandle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor) {
        constructor.setAttribute("objcName", "init");
        if (constructor.getArguments().size() >= 1) {
            constructor.setAttribute("objcName", "initWith");
        }
    }

    @Override
    public void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method, MethodArgument argument) {
        argument.setAttribute("objSignatureName", argument.getName());
        if (method.getArguments().get(0) == argument) { /* first argument signature name must be capitalized */
            argument.setAttribute("objSignatureName", "");
        }
    }

    @Override
    public void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Constructor constructor, MethodArgument argument) {
        argument.setAttribute("objSignatureName", argument.getName());
        if (constructor.getArguments().get(0) == argument) { /* first argument signature name must be capitalized */
            argument.setAttribute("objSignatureName", Character.toUpperCase(argument.getName().charAt(0)) +
                    argument.getName().substring(1));
        }
    }

    private static String getObjectiveCPrefix(Class clazz) {
        if (clazz.getNamespaces().length == 0) {
            return "";
        }
        return clazz.getNamespaces()[0].chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining());
    }
}
