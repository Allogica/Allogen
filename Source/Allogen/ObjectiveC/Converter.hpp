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
	namespace ObjectiveC {

		/**
		 * The converter template class is responsible for converting to and from
		 * ObjectiveC ObjectiveC types and C++ types.
		 *
		 * A user can specialize the template to add custom conversion for a
		 * type not supported by the Allogen runtime support library.
		 *
		 * A converter must implement 2 static member functions and 1 type alias.
		 *
		 *  - static void toObjectiveC(ObjectiveCEnv *env, T object);
		 *    Must convert a C++ object into a ObjectiveC object.
		 *
		 *  - static T fromObjectiveC(ObjectiveCEnv *env, jobject object);
		 *    Must convert a ObjectiveC object into a C++ object
		 *
		 *  - ObjectiveCType type alias
		 *    Must define the object type used by the ObjectiveC library.
		 *    Most times <tt>jobject</tt> is desired.
		 *
		 * @tparam T the type to convert
		 */
		template<typename T, typename=void>
		struct Converter;

		/**
		 * A converter specialization for <tt>void</tt> types.
		 */
		template<>
		struct Converter<void> {
			using ObjectiveCType = void;

			/**
			 * Performs a <tt>void</tt> conversion.
			 *
			 * @param env the ObjectiveC environment
			 */
			static void toObjectiveC() {}

			/**
			 * Performs a <tt>void</tt> conversion.
			 *
			 * @param env the ObjectiveC environment
			 */
			static void fromObjectiveC() {}

		};

		/**
		 * A converter specialization for string types
		 */
		template<>
		struct Converter<std::string> {
			/**
			 * The ObjectiveC string type
			 */
			using ObjectiveCType = NSString*;

			/**
			 * Creates a ObjectiveC string from a C++ string
			 *
			 * @param env the ObjectiveC environment
			 * @param string the C++ string
			 *
			 * @return the newly created ObjectiveC string or NULL if
			 * no memory could be allocated
			 */
			static NSString* toObjectiveC(const std::string& string) {
				return [[NSString alloc] initWithUTF8String:string.c_str()];
			}

			/**
			 * Creates a C++ string from a ObjectiveC string
			 *
			 * @param env the ObjectiveC environment
			 * @param string the ObjectiveC string
			 *
			 * @return the C++ string created from the ObjectiveC string contents
			 */
			static std::string fromObjectiveC(NSString* string) {
				return std::string([string UTF8String]);
			}
		};

		/**
		 * A converter specialization for string types
		 */
		template<>
		struct Converter<const char*> {
			/**
			 * The ObjectiveC string type
			 */
			using ObjectiveCType = NSString*;

			/**
			 * Creates a ObjectiveC string from a C++ string
			 *
			 * @param env the ObjectiveC environment
			 * @param string the C string
			 *
			 * @return the newly created ObjectiveC string or NULL if
			 * no memory could be allocated
			 */
			static NSString* toObjectiveC(const char* string) {
				return [NSString stringWithCString:string encoding:[NSString defaultCStringEncoding]];
			}

		};

	}
}

