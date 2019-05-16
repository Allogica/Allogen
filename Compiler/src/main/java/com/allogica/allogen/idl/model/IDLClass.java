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
import java.util.List;

public class IDLClass extends IDLWrappedObject {

    private IDLNamespace parent;

    private String name;
    private List<IDLMember> members = new ArrayList<>();
    private List<IDLInclude> includes = new ArrayList<>();

    private IDLTypeName parentClass;

    private boolean isAbstract = false;
    private boolean isStatic = false;

    public IDLClass(String name, List<IDLMember> members, List<IDLInclude> includes) {
        super(null);

        this.name = name;
        this.members = members;
        this.includes = includes;

        for (IDLMember member : members) {
            member.setParent(this);
        }
    }

    public IDLClass(IDLParser.ClassdefinitionContext ctx) {
        super(ctx.annotation());

        this.name = ctx.classname().Identifier().getText();

        for (final IDLParser.ConstructordefinitionContext constructor : ctx.classbody().constructordefinition()) {
            this.members.add(new IDLConstructor(constructor));
        }

        if(ctx.classbody().destructordefinition() != null) {
            this.members.add(new IDLDestructor(ctx.classbody().destructordefinition()));
        }

        for (final IDLParser.MethoddefinitionContext method : ctx.classbody().methoddefinition()) {
            this.members.add(new IDLMethod(method));
        }

        for (final IDLParser.IncludedefinitionContext include : ctx.classbody().includedefinition()) {
            this.includes.add(new IDLInclude(include));
        }

        if(ctx.Static() != null) {
            this.isStatic = true;
        }
        if(ctx.classextends() != null) {
            this.parentClass = new IDLTypeName(ctx.classextends().typename());
        }
        if(ctx.Abstract() != null) {
            this.isAbstract = true;
        }
    }

    public IDLClass(String name, List<IDLMember> members) {
        this(name, members, new ArrayList<>());
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

    public List<IDLMember> getMembers() {
        return members;
    }

    public void setMembers(List<IDLMember> members) {
        this.members = members;
    }

    public List<IDLInclude> getIncludes() {
        return includes;
    }

    public void setIncludes(List<IDLInclude> includes) {
        this.includes = includes;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public IDLClass setStatic(boolean aStatic) {
        isStatic = aStatic;
        return this;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public IDLClass setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
        return this;
    }

    public IDLTypeName getParentClass() {
        return parentClass;
    }

    public IDLClass setParentClassName(IDLTypeName parentClass) {
        this.parentClass = parentClass;
        return this;
    }
}
