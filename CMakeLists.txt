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

project(Allogen CXX)
cmake_minimum_required(VERSION 3.2)

if(NOT CMAKE_CXX_STANDARD)
    set(CMAKE_CXX_STANDARD 14)
endif()

if(NOT ALLOGEN_ROOT)
    if(EXISTS ${CMAKE_CURRENT_SOURCE_DIR}/bin/allogenc)
        set(ALLOGEN_ROOT ${CMAKE_CURRENT_SOURCE_DIR} CACHE INTERNAL "The root path to the Allogen tool")
    endif()
endif()

list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/CMake)

find_package(JNI)
if(JNI_FOUND)
    add_library(Allogen.JNI INTERFACE)
    target_include_directories(Allogen.JNI
            INTERFACE ${CMAKE_CURRENT_SOURCE_DIR}/Source
            INTERFACE ${JNI_INCLUDE_DIRS}
    )
    target_link_libraries(Allogen.JNI
            INTERFACE ${JNI_LIBRARIES}
    )
endif()

add_library(Allogen.ObjectiveC INTERFACE)
target_include_directories(Allogen.ObjectiveC
        INTERFACE ${CMAKE_CURRENT_SOURCE_DIR}/Source
)

add_library(Allogen.CSharp INTERFACE)
target_include_directories(Allogen.CSharp
        INTERFACE ${CMAKE_CURRENT_SOURCE_DIR}/Source
)

# Enables the Allogen example.
# This is off by default so that the library is easier to integrate
# using a add_directory.
option(ALLOGEN_EXAMPLE "Enables the Allogen example." OFF)

if(ALLOGEN_EXAMPLE)
    add_subdirectory(Example)
endif()