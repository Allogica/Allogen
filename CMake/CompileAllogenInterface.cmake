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
find_package(PythonInterp 3.5)

if (NOT ALLOGEN_COMPILER)
    find_file(ALLOGEN_COMPILER allogenc
            HINTS ${ALLOGEN_ROOT}/bin
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
    set(oneValueArgs LANGUAGE TARGET_DIR BRIDGE_DIR)
    set(multiValueArgs IDL INCLUDE_DIRS)
    cmake_parse_arguments(IFT "${options}" "${oneValueArgs}" "${multiValueArgs}" ${ARGN})
    
    if (NOT PYTHONINTERP_FOUND OR NOT ALLOGEN_COMPILER)
        return()
    endif ()
    
    set(INCLUDE_LIST)
    foreach(${dir} ${IFT_INCLUDE_DIRS})
        list(APPEND -I${dir})
    endforeach()
    
    add_custom_target(${target_name} SOURCES ${IFT_IDL}
            DEPENDS ${IFT_IDL}
            COMMAND ${PYTHON_EXECUTABLE} ${ALLOGEN_COMPILER}
                --target ${IFT_LANGUAGE}
                --target-dir ${IFT_TARGET_DIR}
                --bridge-dir ${IFT_BRIDGE_DIR}
                ${INCLUDE_LIST}
                ${IFT_IDL}
            COMMENT "Compiling Allogen interface files..."
    )

endfunction()