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

#include <jni.h>
#include <string>

#include <Allogen/JNI/References.hpp>

namespace Allogen {
	namespace JNI {

		/**
		 * The converter template class is responsible for converting to and from
		 * Java JNI types and C++ types.
		 *
		 * A user can specialize the template to add custom conversion for a
		 * type not supported by the Allogen runtime support library.
		 *
		 * A converter must implement 2 static member functions and 1 type alias.
		 *
		 *  - static void toJava(JNIEnv *env, T object);
		 *    Must convert a C++ object into a Java object.
		 *
		 *  - static T fromJava(JNIEnv *env, jobject object);
		 *    Must convert a Java object into a C++ object
		 *
		 *  - JavaType type alias
		 *    Must define the object type used by the JNI library.
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
			using JavaType = void;

			/**
			 * Performs a <tt>void</tt> conversion.
			 *
			 * @param env the JNI environment
			 */
			static void toJava(JNIEnv* env) {}

			/**
			 * Performs a <tt>void</tt> conversion.
			 *
			 * @param env the JNI environment
			 */
			static void fromJava(JNIEnv* env) {}

		};

		/**
		 * A converter specialization for string types
		 */
		template<>
		struct Converter<std::string> {
			/**
			 * The Java string type
			 */
			using JavaType = LocalRef<jstring>;

			/**
			 * Creates a Java string from a C++ string
			 *
			 * @param env the JNI environment
			 * @param string the C++ string
			 *
			 * @return the newly created Java string or NULL if
			 * no memory could be allocated
			 */
			static LocalRef<jstring> toJava(JNIEnv* env, const std::string& string) {
				return {env, env->NewStringUTF(string.c_str()), false};
			}

			/**
			 * Creates a C++ string from a Java string
			 *
			 * @param env the JNI environment
			 * @param string the Java string
			 *
			 * @return the C++ string created from the Java string contents
			 */
			static std::string fromJava(JNIEnv* env, LocalRef<jstring> string) {
				const char* inCStr = env->GetStringUTFChars(string.object, nullptr);
				if(NULL == inCStr) return NULL;

				std::string str = inCStr; // TODO maybe we should check for exceptions here
				env->ReleaseStringUTFChars(string.object, inCStr);  // release resources

				return str;
			}
		};

	}
}

