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

#include <vector>
#include <jni.h>

namespace Allogen {
	namespace JNI {

		/**
		 * A converter specialization that allows convertion between std::vector and Java arrays.
		 *
		 * @tparam ContainedType the C++ object contained inside the vector
		 * @tparam Allocator the vector allocator type
		 */
		template<typename Allocator>
		struct Converter<std::vector<uint8_t, Allocator>> {
			/**
			 * The vector type
			 */
			using Type = std::vector<uint8_t, Allocator>;

			/**
			 * The Java array type
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts a C++ vector into a Java array
			 *
			 * @param env the JNI environment
			 * @param v the C++ vector
			 *
			 * @return the converted Java array
			 */
			static JavaType toJava(JNIEnv* env, Type v) {
				return {env, env->NewDirectByteBuffer(v.data(), v.size())};
			}

			/**
			 * Converts a Java array into a C++ vector
			 *
			 * @param env the JNI environment
			 * @param i the Java array
			 *
			 * @return the converted C++ vector
			 */
			static Type fromJava(JNIEnv* env, JavaType buffer) {
				uint8_t* data = (uint8_t*) env->GetDirectBufferAddress(buffer);
				size_t length = (size_t) env->GetDirectBufferCapacity(buffer);
				return std::vector<uint8_t>(data, data+length);
			}
		};

	}
}
