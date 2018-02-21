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

#include "Allogen/JNI/Converter.hpp"
#include <chrono>

namespace Allogen {
	namespace JNI {
		
		/**
		 * A converter specialization for C++ duration types
		 *
		 * @tparam IntegralType the integral type to be converted
		 */
		template<typename Representation, typename Period>
		struct Converter<std::chrono::duration<Representation, Period>> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = std::chrono::duration<Representation, Period>;

			/**
			 * The JNI type this converter supports
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts a C++ data into a Java data
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the Java integer
			 */
			static JavaType toJava(JNIEnv* env, Type object) {
				LocalRef<jclass> java_util_Date = {env, env->FindClass("java/util/Date")};
				jmethodID java_util_Date_ = env->GetMethodID(java_util_Date, "<init>", "(L)V");

				auto millis = std::chrono::duration_cast<std::chrono::milliseconds>(object);
				return {env, env->NewObject(java_util_Date, java_util_Date_, millis.count())};
			}

			/**
			 * Converts a Java data into a C++ data
			 *
			 * @param env the JNI environment
			 * @param i the Java integer
			 *
			 * @return the C++ integer
			 */
			static Type fromJava(JNIEnv* env, JavaType date) {
				LocalRef<jclass> java_util_Date = {env, env->FindClass("java/util/Date")};
				jmethodID java_util_Date_getTime = env->GetMethodID(java_util_Date, "getTime", "()L");

				auto millis = std::chrono::milliseconds(env->CallLongMethod(date, java_util_Date_getTime));
				return std::chrono::duration_cast<Type>(millis);
			}
		};

		/**
		 * A converter specialization for C++ time_point types
		 *
		 * @tparam IntegralType the integral type to be converted
		 */
		template<typename Clock, typename Duration>
		struct Converter<std::chrono::time_point<Clock, Duration>> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = std::chrono::time_point<Clock, Duration>;

			/**
			 * The JNI type this converter supports
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts a C++ integer into a Java integer
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the Java integer
			 */
			static JavaType toJava(JNIEnv* env, Type object) {
				return Converter<Duration>::toJava(env, object.time_since_epoch());
			}

			/**
			 * Converts a Java integer into a C++ integer
			 *
			 * @param env the JNI environment
			 * @param i the Java integer
			 *
			 * @return the C++ integer
			 */
			static Type fromJava(JNIEnv* env, JavaType date) {
				return Converter<Duration>::fromJava(env, date);
			}
		};

	}
}
