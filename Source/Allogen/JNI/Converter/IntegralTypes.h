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

#include "Allogen/JNI/Converter.h"

namespace Allogen {
	namespace JNI {
		/**
		 * A trait that specifies the C++ integral type and the corresponding JNI type.
		 *
		 * @tparam T the C++ integral type
		 */
		template<typename T>
		struct IntegralConverterTrait;

		/**
		 * A converter specialization for C++ integral types
		 *
		 * @tparam IntegralType the integral type to be converted
		 */
		template<typename IntegralType>
		struct Converter<IntegralType, typename std::enable_if<std::is_integral<IntegralType>::value>::type> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = IntegralType;

			/**
			 * The JNI type this converter supports
			 */
			using JavaType = typename IntegralConverterTrait<IntegralType>::T;

			/**
			 * Converts a C++ integer into a Java integer
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the Java integer
			 */
			static JavaType toJava(JNIEnv* env, Type i) {
				return i;
			}

			/**
			 * Converts a Java integer into a C++ integer
			 *
			 * @param env the JNI environment
			 * @param i the Java integer
			 *
			 * @return the C++ integer
			 */
			static Type fromJava(JNIEnv* env, JavaType i) {
				return i;
			}
		};

		template<>
		struct IntegralConverterTrait<int8_t> {
			using T = jbyte;
		};
		template<>
		struct IntegralConverterTrait<uint8_t> {
			using T = jbyte;
		};

		template<>
		struct IntegralConverterTrait<int16_t> {
			using T = jshort;
		};
		template<>
		struct IntegralConverterTrait<uint16_t> {
			using T = jshort;
		};

		template<>
		struct IntegralConverterTrait<int32_t> {
			using T = jint;
		};
		template<>
		struct IntegralConverterTrait<uint32_t> {
			using T = jint;
		};

		template<>
		struct IntegralConverterTrait<int64_t> {
			using T = jlong;
		};
		template<>
		struct IntegralConverterTrait<uint64_t> {
			using T = jlong;
		};

	}
}
