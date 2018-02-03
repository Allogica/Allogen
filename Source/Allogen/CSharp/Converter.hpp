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

#include <string>

namespace Allogen {
	namespace CSharp {

		/**
		 * The converter template class is responsible for converting to and from
		 * CSharp CSharp types and C++ types.
		 *
		 * A user can specialize the template to add custom conversion for a
		 * type not supported by the Allogen runtime support library.
		 *
		 * A converter must implement 2 static member functions and 1 type alias.
		 *
		 *  - static void toCSharp(CSharpEnv *env, T object);
		 *    Must convert a C++ object into a CSharp object.
		 *
		 *  - static T fromCSharp(CSharpEnv *env, jobject object);
		 *    Must convert a CSharp object into a C++ object
		 *
		 *  - CSharpType type alias
		 *    Must define the object type used by the CSharp library.
		 *    Most times <tt>jobject</tt> is desired.
		 *
		 * @tparam T the type to convert
		 */
		template<typename T, typename=void>
		struct Converter {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = T*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param env the CSharp environment
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T* object) {
				return new T(*object);
			}

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param env the CSharp environment
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T&& object) {
				return new T(std::move(object));
			}

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param env the CSharp environment
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(const T& object) {
				return new T(object);
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param env the CSharp environment
			 * @param wself the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromCSharp(CSharpType wself) {
				return *wself;
			}
		};

		template<typename T>
		struct Converter<T*> {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = T*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param env the CSharp environment
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T* object) {
				return object;
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param env the CSharp environment
			 * @param wself the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromCSharp(CSharpType wself) {
				return *wself;
			}
		};

		/**
		 * A converter specialization for <tt>void</tt> types.
		 */
		template<>
		struct Converter<void> {
			using CSharpType = void;

			/**
			 * Performs a <tt>void</tt> conversion.
			 *
			 * @param env the CSharp environment
			 */
			static void toCSharp() {}

			/**
			 * Performs a <tt>void</tt> conversion.
			 *
			 * @param env the CSharp environment
			 */
			static void fromCSharp() {}

		};

		/**
		 * A converter specialization for string types
		 */
		template<>
		struct Converter<std::string> {
			/**
			 * The CSharp string type
			 */
			using CSharpType = const char*;

			/**
			 * Creates a CSharp string from a C++ string
			 *
			 * @param env the CSharp environment
			 * @param string the C++ string
			 *
			 * @return the newly created CSharp string or NULL if
			 * no memory could be allocated
			 */
			static char* toCSharp(const std::string& string) {
				auto cstr = new char[string.size() + 1];
				memcpy(cstr, string.c_str(), string.size() + 1);
				return cstr;
			}

			/**
			 * Creates a C++ string from a CSharp string
			 *
			 * @param env the CSharp environment
			 * @param string the CSharp string
			 *
			 * @return the C++ string created from the CSharp string contents
			 */
			static std::string fromCSharp(const char* cstr) {
				return std::string(cstr);
			}
		};

	}
}

