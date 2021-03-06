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

#pragma once

#if defined _WIN32 || defined __CYGWIN__
 #define ALLOGEN_EXPORT __declspec(dllexport)
#else
 #if __GNUC__ >= 4
  #define ALLOGEN_EXPORT __attribute__ ((visibility ("default")))
 #else
  #define ALLOGEN_EXPORT
 #endif
#endif

#if defined _WIN32 || defined __CYGWIN__
 #define ALLOGEN_CALL __stdcall
#else
 #define ALLOGEN_CALL
#endif

#include "Allogen/CSharp/BridgedClass.hpp"
#include "Allogen/CSharp/BridgedConstructor.hpp"
#include "Allogen/CSharp/BridgedMethod.hpp"

#include "Allogen/CSharp/Converter.hpp"
#include "Allogen/CSharp/Converter/IntegralTypes.hpp"
#include "Allogen/CSharp/Converter/Function.hpp"
#include "Allogen/CSharp/Converter/Optional.hpp"
#include "Allogen/CSharp/Converter/DateTime.hpp"
#include "Allogen/CSharp/Converter/Vector.hpp"
#include "Allogen/CSharp/Converter/Map.hpp"
