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
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.ModelObject;
import com.allogica.allogen.util.CompilerObjectModelAdaptor;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;

public class CodegenPass implements CompilerPass<Class, Class> {

    @Override
    public Class pass(Compiler compiler, CompilerContext context, Class clazz) throws IOException {
        /*
         * Generate the target language objects
         */
        final URL targetTemplateURL = compiler.getBackend().getTargetTemplateURL();
        final STGroup targetTemplate = new STGroupFile(targetTemplateURL, "UTF-8", '<', '>');
        targetTemplate.registerModelAdaptor(ModelObject.class, new CompilerObjectModelAdaptor());

        final ST targetClassTemplate = targetTemplate.getInstanceOf("class");
        targetClassTemplate.add("class", clazz);

        final String targetOutputFilename = clazz.getAttribute("targetOutputFile");
        final File targetOutputFile = new File(context.getTargetDir(), targetOutputFilename);

        createParentIfNotExists(targetOutputFile);
        writeFileIfChanged(targetOutputFile, targetClassTemplate.render());

        /*
         * Generate Bridged C++ header objects
         */
        final URL bridgeTemplateURL = compiler.getBackend().getBridgeTemplateURL();
        final STGroup bridgeTemplate = new STGroupFile(bridgeTemplateURL, "UTF-8", '<', '>');
        bridgeTemplate.registerModelAdaptor(ModelObject.class, new CompilerObjectModelAdaptor());

        final ST bridgeHeaderClassTemplate = bridgeTemplate.getInstanceOf("header");
        bridgeHeaderClassTemplate.add("class", clazz);

        final String bridgeHeaderOutputFilename = clazz.getAttribute("bridgeHeaderOutputFile");
        final File bridgeHeaderOutputFile = new File(context.getBridgeDir(), bridgeHeaderOutputFilename);

        createParentIfNotExists(bridgeHeaderOutputFile);
        writeFileIfChanged(bridgeHeaderOutputFile, bridgeHeaderClassTemplate.render());

        /*
         * Generate Bridged C++ implementation objects
         */
        final ST bridgeImplementationClassTemplate = bridgeTemplate.getInstanceOf("implementation");
        bridgeImplementationClassTemplate.add("class", clazz);

        final String bridgeImplementationOutputFilename = clazz.getAttribute("bridgeImplementationOutputFile");
        final File bridgeImplementationOutputFile = new File(context.getBridgeDir(), bridgeImplementationOutputFilename);

        createParentIfNotExists(bridgeImplementationOutputFile);
        writeFileIfChanged(bridgeImplementationOutputFile, bridgeImplementationClassTemplate.render());

        return clazz;
    }

    static private void createParentIfNotExists(File file) {
        final File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
    }

    static private void writeFileIfChanged(File file, String content) throws IOException {
        if (file.exists()) {
            final String originalContent = new String(Files.readAllBytes(file.toPath()));
            if (content.equals(originalContent)) {
                return;
            }
        }

        final FileOutputStream outputStream = new FileOutputStream(file);
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(content);

        outputStreamWriter.flush();
        outputStreamWriter.close();

        outputStream.flush();
        outputStream.close();
    }

}
