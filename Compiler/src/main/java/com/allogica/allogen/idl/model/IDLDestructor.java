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

public class IDLDestructor extends IDLMember {

    private String body;

    public IDLDestructor(IDLParser.DestructordefinitionContext ctx) {
        super(ctx.annotation());

        if(ctx.methodbody() != null && ctx.methodbody().methodbodycontent() != null) {
            this.body = ctx.methodbody().methodbodycontent().start.getInputStream().getText(new Interval(
                    ctx.methodbody().methodbodycontent().block().start.getStopIndex(),
                    ctx.methodbody().methodbodycontent().block().stop.getStartIndex()
            ));
            this.body = MethodBodyHelper.trimMethodBody(this.body);
        }
    }

    public String getBody() {
        return body;
    }

    public IDLDestructor setBody(String body) {
        this.body = body;
        return this;
    }
}
