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
import java.util.Map;
import java.util.stream.Collectors;

public class PropertiesPass implements CompilerPass<Class, Class> {

    @Override
    public Class pass(Compiler compiler, CompilerContext context, Class clazz) {
        for (final Method method : clazz.getMethods()) {
            handleMethod(context, clazz, method);
        }

        clazz.getProperties().forEach((key, value) -> {
            // properties must have getters
            if (value.getGetter() == null) {
                clazz.getProperties().remove(key);
            }
        });

        return clazz;
    }

    private void handleMethod(CompilerContext context, Class clazz, Method method) {
        final Map<String, Property> properties = clazz.getProperties();

        final IDLAnnotation getter = method.getIdlMethod().getAnnotation("Getter");
        if (getter != null) {
            final String name = getter.getProperty("property");
            if (!properties.containsKey(name)) {
                properties.put(name, new Property(name));
            }
            final Property property = properties.get(name);
            property.setGetter(method);
        }

        final IDLAnnotation setter = method.getIdlMethod().getAnnotation("Setter");
        if (setter != null) {
            final String name = setter.getProperty("property");
            if (!properties.containsKey(name)) {
                properties.put(name, new Property(name));
            }
            final Property property = properties.get(name);
            property.setSetter(method);
        }
    }

}
