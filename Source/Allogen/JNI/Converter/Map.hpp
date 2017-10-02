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

#include <map>
#include <jni.h>

namespace Allogen {
	namespace JNI {

		/**
		 * A converter specialization that allows convertion between std::vector and Java arrays.
		 *
		 * @tparam ContainedType the C++ object contained inside the vector
		 * @tparam Allocator the vector allocator type
		 */
		template<typename KeyType, typename ValueType, typename Compare, typename Allocator>
		struct Converter<std::map<KeyType, ValueType, Compare, Allocator>> {
			/**
			 * The vector type
			 */
			using Type = std::map<KeyType, ValueType, Compare, Allocator>;

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
				jclass java_util_HashMap = env->FindClass("java/util/HashMap");
				jmethodID java_util_HashMap_ = env->GetMethodID(java_util_HashMap, "<init>", "(I)V");
				jmethodID java_util_HashMap_put = env->GetMethodID(java_util_HashMap, "put",
																   "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");

				LocalRef<jobject> result = {env, env->NewObject(java_util_HashMap, java_util_HashMap_, v.size())};
				for(auto& entry : v) {
					LocalRef<jobject> ret = {env, env->CallObjectMethod(
							result, java_util_HashMap_put,
							unwrapReference(Converter<KeyType>::toJava(env, entry.first)),
							unwrapReference(Converter<ValueType>::toJava(env, entry.second))
					)};
				}
				return result;
			}

			/**
			 * Converts a Java array into a C++ vector
			 *
			 * @param env the JNI environment
			 * @param i the Java array
			 *
			 * @return the converted C++ vector
			 */
			static Type fromJava(JNIEnv* env, JavaType map) {
				jclass java_util_Map = env->FindClass("java/util/Map");
				jmethodID java_util_Map_entrySey = env->GetMethodID(java_util_Map, "entrySet", "()Ljava/util/Set;");

				LocalRef<jobject> entrySet = {env, env->CallObjectMethod(map, java_util_Map_entrySey)};

				jclass entrySetClass = env->GetObjectClass(entrySet);
				jmethodID java_util_Set_toArray = env->GetMethodID(entrySetClass, "toArray", "()[Ljava/lang/Object;");

				jclass entryClass = env->FindClass("java/util/Map$Entry");
				jmethodID entryGetKey = env->GetMethodID(entryClass, "getKey", "()Ljava/lang/Object;");
				jmethodID entryGetValue = env->GetMethodID(entryClass, "getValue", "()Ljava/lang/Object;");

				LocalRef<jobjectArray> entries = {env, (jobjectArray) env->CallObjectMethod(entrySet,
																							java_util_Set_toArray)};
				jsize size = env->GetArrayLength(entries);

				Type objects;
				for(jsize i = 0; i < size; i++) {
					LocalRef<jobject> entry = {env, env->GetObjectArrayElement(entries, i)};

					typename Converter<KeyType>::JavaType key = {
							env, reinterpret_cast<typename Converter<KeyType>::JavaType::RefType>(env->CallObjectMethod(
									entry, entryGetKey))
					};
					typename Converter<ValueType>::JavaType value = {
							env, reinterpret_cast<typename Converter<ValueType>::JavaType::RefType>(env->CallObjectMethod(
									entry, entryGetValue))
					};

					objects.insert(std::make_pair(
							Converter<KeyType>::fromJava(env, key),
							Converter<ValueType>::fromJava(env, value)
					));
				}

				return objects;
			}
		};

	}
}
