# Copyright (c) 2017, Allogica
#
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without modification,
# are permitted provided that the following conditions are met:
#
#     * Redistributions of source code must retain the above copyright notice,
#       this list of conditions and the following disclaimer.
#     * Redistributions in binary form must reproduce the above copyright notice,
#       this list of conditions and the following disclaimer in the documentation
#       and/or other materials provided with the distribution.
#     * Neither the name of Allogen nor the names of its contributors
#       may be used to endorse or promote products derived from this software
#       without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
# A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
# EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
# PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
# PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
# NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

if (ADD_ALLOGEN_INTERFACE_INCLUDED)
    return()
endif ()
set(ADD_ALLOGEN_INTERFACE_INCLUDED)

include(CMakeParseArguments)

find_package(Java 1.8)
if(NOT Java_FOUND)
    message("Java not found. Allogen compiler will be unavailable.")
endif()

find_package(Maven)
if(NOT Maven_FOUND)
    message("Maven not found. Allogen compiler will be unavailable.")
endif()

if (NOT ALLOGEN_COMPILER)
    find_file(ALLOGEN_COMPILER pom.xml
            HINTS ${ALLOGEN_ROOT}/Compiler
            DOC "The Allogen compiler path"
    )
    if (ALLOGEN_COMPILER)
        message(STATUS "Found the Allogen compiler at ${ALLOGEN_COMPILER}")
    else ()
        message(WARNING "Could not find the Allogen compiler. Try setting ALLOGEN_ROOT variable to the root of the Allogen install.")
    endif ()
endif ()

function(add_allogen_interface target_name)
    set(options)
    set(oneValueArgs LANGUAGE TARGET_DIR BRIDGE_DIR BRIDGE_NAMESPACE MODULE_NAME)
    set(multiValueArgs IDL IMPORT)
    cmake_parse_arguments(IFT "${options}" "${oneValueArgs}" "${multiValueArgs}" ${ARGN})
    
    if (NOT Java_FOUND OR NOT ALLOGEN_COMPILER)
        return()
    endif ()
    
    set(import_args "")
    if(IFT_IMPORT)
        foreach(dir ${IFT_IMPORT})
            set(import_args ${import_args} --import "${dir}")
        endforeach()
    endif()
    
    set(ns_attr "")
    if(IFT_BRIDGE_NAMESPACE)
        set(ns_attr --base-bridge-namespace "${IFT_BRIDGE_NAMESPACE}")
    endif()

    set(module_args "")
    if(IFT_MODULE_NAME)
        set(module_args --module ${IFT_MODULE_NAME})
    endif()

    set(idls)
    foreach(idl ${IFT_IDL})
        string(REPLACE " " "\\ " idl_repl ${idl})
        list(APPEND idls '${idl_repl}')
    endforeach()

    add_custom_target(${target_name} SOURCES ${IFT_IDL}
            DEPENDS ${IFT_IDL}
            COMMAND ${Maven_EXECUTABLE} compile exec:java -f ${ALLOGEN_COMPILER}
            -Dexec.args=\"--target '${IFT_LANGUAGE}' --target-dir '${IFT_TARGET_DIR}' --bridge-dir '${IFT_BRIDGE_DIR}' ${ns_attr} ${module_args} ${import_args} ${idls}\"
            COMMENT "Compiling Allogen interface files..."
    )

endfunction()