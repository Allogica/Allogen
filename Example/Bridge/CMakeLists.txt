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

include(CompileAllogenInterface)

file(GLOB_RECURSE IDLS ${CMAKE_CURRENT_SOURCE_DIR}/IDL/*.i)
# Conditionally enable the Java bridge based on JNI presence
if(TARGET Allogen.JNI)
    add_allogen_interface(Allogen.Example.Bridge.JNI.Generate
            LANGUAGE        Java
            IDL             ${IDLS}
            
            INCLUDE_DIRS    ${CMAKE_CURRENT_SOURCE_DIR}/IDL
            
            TARGET_DIR      ${CMAKE_CURRENT_SOURCE_DIR}/Java
            BRIDGE_DIR      ${CMAKE_CURRENT_SOURCE_DIR}/Source/JNI
    )
    
    file(GLOB_RECURSE SRCS ${CMAKE_CURRENT_SOURCE_DIR}/Source/JNI/*.cpp)
    add_library(Allogen.Example.Bridge.JNI SHARED ${SRCS})
    target_link_libraries(Allogen.Example.Bridge.JNI
            PUBLIC  Allogen.JNI
            PRIVATE Allogen.Example
    )
    add_dependencies(Allogen.Example.Bridge.JNI Allogen.Example.Bridge.JNI.Generate)
endif()

# Conditionally enable the Java bridge based on JNI presence
if(TARGET Allogen.ObjectiveC)
    add_allogen_interface(Allogen.Example.Bridge.ObjectiveC.Generate
            LANGUAGE        ObjC
            IDL             ${IDLS}
            
            INCLUDE_DIRS    ${CMAKE_CURRENT_SOURCE_DIR}/IDL
            
            TARGET_DIR      ${CMAKE_CURRENT_SOURCE_DIR}/ObjectiveC
            BRIDGE_DIR      ${CMAKE_CURRENT_SOURCE_DIR}/Source/ObjectiveC
    )
    
    file(GLOB_RECURSE SRCS ${CMAKE_CURRENT_SOURCE_DIR}/Source/ObjectiveC/*.mm)
    add_library(Allogen.Example.Bridge.ObjectiveC SHARED ${SRCS})
    target_include_directories(Allogen.Example.Bridge.ObjectiveC
            PUBLIC ${CMAKE_CURRENT_SOURCE_DIR}/Source/ObjectiveC
    )
    target_link_libraries(Allogen.Example.Bridge.ObjectiveC
            PRIVATE  Allogen.ObjectiveC
            PRIVATE Allogen.Example
            PUBLIC "-framework Foundation"
            PUBLIC objc
            PUBLIC -ObjC
    )
    target_compile_options(Allogen.Example.Bridge.ObjectiveC
            PRIVATE "-xobjective-c++"
    )
#    add_dependencies(Allogen.Example.Bridge.ObjectiveC Allogen.Example.Bridge.ObjectiveC.Generate)
    
    add_executable(Allogen.Example.Bridge.ObjectiveC.Test ${CMAKE_CURRENT_SOURCE_DIR}/Test/ObjectiveC/main.m)
    target_link_libraries(Allogen.Example.Bridge.ObjectiveC.Test
            PRIVATE  Allogen.Example.Bridge.ObjectiveC
    )
    target_compile_options(Allogen.Example.Bridge.ObjectiveC.Test
            PRIVATE -ObjC -all_load
    )
endif()
