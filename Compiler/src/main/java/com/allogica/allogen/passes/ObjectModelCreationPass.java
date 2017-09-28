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

package com.allogica.allogen.passes;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.Scope;
import com.allogica.allogen.idl.model.*;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.*;
import com.allogica.allogen.types.UserDefinedType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectModelCreationPass implements CompilerPass<IDLClass, Class> {

    @Override
    public Class pass(Compiler compiler, CompilerContext context, IDLClass clazz) {
        Class o = new Class(
                clazz,
                clazz.getName(),
                new ArrayList<>()
        )
                .setStatic(clazz.isStatic())
                .setAbstract(clazz.isAbstract());

        if (clazz.getParentClass() != null) {
            o.setParent(handleTypeName(context, clazz, clazz.getParentClass()));
        }

        for (final IDLMember member : clazz.getMembers()) {
            if (member instanceof IDLConstructor) {
                o.getConstructors().add(handleConstructor(context, clazz, (IDLConstructor) member));
            } else if (member instanceof IDLDestructor) {
                o.setDestructor(handleDestructor(context, clazz, (IDLDestructor) member));
            } else if (member instanceof IDLMethod) {
                o.getMethods().add(handleMethod(context, clazz, (IDLMethod) member));
            }
        }

        // create a implicit destructor if the class is non-static method
        if (o.getDestructor() == null && !o.isStatic()) {
            o.setDestructor(new Destructor(null));
        }

        List<String> ns = clazz.getParent().getNamespaceChain();
        o.setNamespaces(ns.toArray(new String[ns.size()]));

        // register the class with the compiler context
        final UserDefinedType userDefinedType = compiler.getBackend().createUserDefinedType(compiler, context, o);
        context.registerType(userDefinedType, new TypeName(clazz.getName(), o.getNamespaces()));

        return o;
    }

    private Constructor handleConstructor(CompilerContext context, IDLClass clazz, IDLConstructor constructor) {
        return new Constructor(constructor, constructor.getArguments().stream().map((arg) ->
                handleArgument(context, clazz, arg)).collect(Collectors.toList()))
                .setBody(constructor.getBody());
    }

    private Destructor handleDestructor(CompilerContext context, IDLClass clazz, IDLDestructor destructor) {
        return new Destructor(destructor).setBody(destructor.getBody());
    }

    private Method handleMethod(CompilerContext context, IDLClass clazz, IDLMethod method) {
        return new Method(method, method.getName(), handleTypeName(context, clazz, method.getReturnType()),
                method.getArguments().stream().map((arg) -> handleArgument(context, clazz, arg))
                        .collect(Collectors.toList()))
                .setBody(method.getBody())
                .setStatic(method.isStatic());
    }

    private MethodArgument handleArgument(CompilerContext context, IDLClass clazz, IDLMethodArgument argument) {
        return new MethodArgument(argument, argument.getName(), handleTypeName(context, clazz, argument.getType()));
    }

    private TypeName handleTypeName(CompilerContext context, IDLClass clazz, IDLTypeName typeName) {
        return new TypeName(typeName.getName(), typeName.getTemplateArguments().stream().map((arg) ->
                handleTypeName(context, clazz, arg)).collect(Collectors.toList()), typeName.getNamespaces())
                .setScope(new Scope(clazz.getParent()
                        .getNamespaceChain().toArray(new String[clazz.getParent().getNamespaceChain().size()])));
    }

}
