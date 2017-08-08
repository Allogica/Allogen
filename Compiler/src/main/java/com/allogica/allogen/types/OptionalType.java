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

package com.allogica.allogen.types;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.idl.grammar.IDLLexer;
import com.allogica.allogen.idl.grammar.IDLParser;
import com.allogica.allogen.model.TypeName;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class OptionalType extends AbstractType {

    private TypeName containedType;

    public OptionalType(final TypeName typeName) {
        IDLLexer lexer = new IDLLexer(CharStreams.fromString(typeName.getTemplateArguments().get(0).getName()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IDLParser parser = new IDLParser(tokens);
        ParseTree tree = parser.typename();

        IDLParser.TypenameContext ctx = (IDLParser.TypenameContext) tree.getPayload();
        containedType = new TypeName(ctx.regulartypename().getText());
    }

    @Override
    public void link(Compiler<?, ?> compiler, CompilerContext compilerContext) {
        containedType.setResolvedType(compilerContext.resolve(containedType));
        containedType.getResolvedType().link(compiler, compilerContext);
    }

    @Override
    public String getTemplateName() {
        return "optionalType";
    }

}
