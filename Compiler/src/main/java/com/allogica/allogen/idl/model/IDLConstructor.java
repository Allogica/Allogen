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
import com.allogica.allogen.util.MethodBodyHelper;
import org.antlr.v4.runtime.misc.Interval;

import java.util.ArrayList;
import java.util.List;

public class IDLConstructor extends IDLMember {

    private List<IDLMethodArgument> arguments = new ArrayList<>();
    private String body;

    public IDLConstructor(List<IDLMethodArgument> arguments) {
        super(null);
        this.arguments = arguments;
    }

    public IDLConstructor() {
        this(new ArrayList<>());
    }

    public IDLConstructor(IDLParser.ConstructordefinitionContext ctx) {
        super(ctx.annotation());

        if (ctx.methodarguments() != null && ctx.methodarguments().methodargument() != null) {
            for (final IDLParser.MethodargumentContext argument : ctx.methodarguments().methodargument()) {
                this.arguments.add(new IDLMethodArgument(argument));
            }
        }

        if (ctx.methodbody() != null && ctx.methodbody().methodbodycontent() != null) {
            this.body = ctx.methodbody().methodbodycontent().start.getInputStream().getText(new Interval(
                    ctx.methodbody().methodbodycontent().block().start.getStopIndex(),
                    ctx.methodbody().methodbodycontent().block().stop.getStartIndex()
            ));
            this.body = MethodBodyHelper.trimMethodBody(this.body);
        }
    }

    public List<IDLMethodArgument> getArguments() {
        return arguments;
    }

    public void setArguments(List<IDLMethodArgument> arguments) {
        this.arguments = arguments;
    }

    public String getBody() {
        return body;
    }

    public IDLConstructor setBody(String body) {
        this.body = body;
        return this;
    }
}
