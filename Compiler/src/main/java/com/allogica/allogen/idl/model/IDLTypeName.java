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
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class IDLTypeName extends IDLObject {

    private String[] namespaces = new String[]{};
    private String name;
    private List<IDLTypeName> templateArguments = new ArrayList<>();

    public IDLTypeName(String name) {
        this.name = name;
    }

    public IDLTypeName(String name, List<IDLTypeName> templateArguments) {
        this.name = name;
        this.templateArguments = templateArguments;
    }

    public IDLTypeName(IDLParser.TypenameContext ctx) {
        if (ctx.regulartypename() != null) {
            final List<TerminalNode> identifiers = ctx.regulartypename().Identifier();

            this.name = identifiers.get(identifiers.size() - 1).getText(); // the last identifier is the class name
            if(identifiers.size() >= 2) {
                this.namespaces = new String[identifiers.size() - 1];
                for (int i = 0; i < identifiers.size() - 1; i++) {
                    this.namespaces[i] = identifiers.get(i).getText();
                }
            }

            if (ctx.typenametemplateargs() != null) {
                for (IDLParser.TypenameContext targ : ctx.typenametemplateargs().typename()) {
                    this.templateArguments.add(new IDLTypeName(targ));
                }
            }
        } else if (ctx.lambdatype() != null) {
            this.name = ctx.lambdatype().getText();
        }
    }

    public IDLTypeName(IDLParser.RegulartypenameContext ctx) {
        final List<TerminalNode> identifiers = ctx.Identifier();

        this.name = identifiers.get(identifiers.size() - 1).getText(); // the last identifier is the class name
        if(identifiers.size() >= 2) {
            this.namespaces = new String[identifiers.size() - 1];
            for (int i = 0; i < identifiers.size() - 1; i++) {
                this.namespaces[i] = identifiers.get(i).getText();
            }
        }
    }

    public String[] getNamespaces() {
        return namespaces;
    }

    public IDLTypeName setNamespaces(String[] namespaces) {
        this.namespaces = namespaces;
        return this;
    }

    public String getName() {
        return name;
    }

    public IDLTypeName setName(String name) {
        this.name = name;
        return this;
    }

    public List<IDLTypeName> getTemplateArguments() {
        return templateArguments;
    }

    public IDLTypeName setTemplateArguments(List<IDLTypeName> templateArguments) {
        this.templateArguments = templateArguments;
        return this;
    }
}
