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
         * A vector converter trait. This trait maps the C++ type into a JNI type
         * and its corresponding array factory method.
         *
         * @tparam T the vector object type
         */
        template<typename T>
        struct VectorConverterTrait {
            /**
             * The Java array type
             */
            using Array = jobjectArray;

            /**
             * The type of object stored inside the array
             */
            using Contained = jobject;

            /**
             * Makes a Java array.
             *
             * @param env the JNI environment
             * @param clazz the Java class
             * @param size the array size
             *
             * @return the newly created Java array
             */
            static Array makeJavaArray(JNIEnv* env, jclass clazz, size_t size) { return env->NewObjectArray(size, clazz, nullptr); }
        };

        /**
         * A converter specialization that allows convertion between std::vector and Java arrays.
         *
         * @tparam ContainedType the C++ object contained inside the vector
         * @tparam Allocator the vector allocator type
         */
        template<typename ContainedType, typename Allocator>
        struct Converter<std::vector<ContainedType, Allocator>, typename VectorConverterTrait<ContainedType>::Array> {
            /**
             * The vector type
             */
            using Type = std::vector<ContainedType, Allocator>;

            /**
             * The Java array type
             */
            using JavaType = typename VectorConverterTrait<ContainedType>::Array;

            /**
             * A alias to the vector type
             */
            using Vector = Type;

            /**
             * Converts a C++ vector into a Java array
             *
             * @param env the JNI environment
             * @param v the C++ vector
             *
             * @return the converted Java array
             */
            static JavaType toJava(JNIEnv *env, Vector v) {
                JavaType array = VectorConverterTrait<ContainedType>::makeJavaArray(env, v.size());
                if (array == nullptr) {
                    return nullptr; /* out of memory error thrown */
                }
            }

            /**
             * Converts a Java array into a C++ vector
             *
             * @param env the JNI environment
             * @param i the Java array
             *
             * @return the converted C++ vector
             */
            static Type fromJava(JNIEnv *env, JavaType i) {
                return i;
            }
        };

        template<>
        struct VectorConverterTrait<int8_t> {
            using Array = jbyteArray;
            using Contained = jbyte;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewByteArray(size); }
        };
        template<>
        struct VectorConverterTrait<uint8_t> {
            using Array = jbyteArray;
            using Contained = jbyte;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewByteArray(size); }
        };

        template<>
        struct VectorConverterTrait<int16_t> {
            using Array = jshortArray;
            using Contained = jshort;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewShortArray(size); }
        };
        template<>
        struct VectorConverterTrait<uint16_t> {
            using Array = jshortArray;
            using Contained = jshort;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewShortArray(size); }
        };

        template<>
        struct VectorConverterTrait<int32_t> {
            using Array = jintArray;
            using Contained = jint;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewIntArray(size); }
        };
        template<>
        struct VectorConverterTrait<uint32_t> {
            using Array = jintArray;
            using Contained = jint;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewIntArray(size); }
        };

        template<>
        struct VectorConverterTrait<int64_t> {
            using Array = jlongArray;
            using Contained = jlong;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewLongArray(size); }
        };
        template<>
        struct VectorConverterTrait<uint64_t> {
            using Array = jlongArray;
            using Contained = jlong;

            static Array makeJavaArray(JNIEnv* env, size_t size) { return env->NewLongArray(size); }
        };

    }
}
