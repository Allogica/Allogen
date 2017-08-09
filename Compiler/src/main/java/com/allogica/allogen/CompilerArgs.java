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

package com.allogica.allogen;

import com.allogica.allogen.util.FileConverter;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CompilerArgs {

    @Parameter(names = {"--target"}, required = true, description = "The target language to generate binding to")
    String target = null;

    @Parameter(names = {"--target-dir"}, required = true, description = "The directory to generate bindings to", converter = FileConverter.class)
    File targetDir = null;

    @Parameter(names = {"--bridge-dir"}, required = true, description = "The directory to generate bridge implementation files to", converter = FileConverter.class)
    File bridgeDir = null;

    @Parameter(names = {"--base-bridge-namespace"}, required = false, description = "The root namespaced directory to be used when generating bridged files")
    String baseNamespace = "";

    @Parameter(names = {"--import"}, required = false, description = "Imports a module")
    List<File> imports = new ArrayList<>();

    @Parameter(names = {"--module"}, required = false, description = "The file to export the module name")
    File moduleFile = null;

    @Parameter(required = true, listConverter = FileConverter.class)
    List<File> idlFiles = new ArrayList<>();

}
