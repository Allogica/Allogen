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
#include <functional>

namespace Allogen {
	namespace JNI {

		/**
		 * A helper object that wraps information about a Lambda
		 */
		struct Lambda {
			/**
			 * The Java VM handle
			 */
			JavaVM* vm;

			/**
			 * The lambda target object instance (as a global reference)
			 */
			jobject object;

			/**
			 * The lambda class type
			 */
			jclass clazz;

			/**
			 * The lambda method ID
			 */
			jmethodID method;

			/**
			 * Creates a new empty lambda
			 */
			Lambda() : vm(nullptr),
					   object(nullptr),
					   clazz(nullptr),
					   method(nullptr) {};

			/**
			 * Creates a new lambda object
			 *
			 * @param object the lambda object
			 * @param clazz the lambda class type
			 * @param method the lambda method
			 */
			Lambda(JavaVM* vm, jobject object, jclass clazz, jmethodID method) :
					vm(vm),
					object(object),
					clazz(clazz),
					method(method) {};

			/**
			 * Copies a lambda object
			 *
			 * @param other the lambda object to copy
			 */
			Lambda(const Lambda& other) :
					vm(other.vm),
					object(other.object),
					clazz(other.clazz),
					method(other.method) {
				JNIEnv* env;
				vm->AttachCurrentThreadAsDaemon((void**) &env, nullptr);
				object = env->NewGlobalRef(other.object);
				vm->DetachCurrentThread();
			}

			/**
			 * Moves a lambda object
			 *
			 * @param other the instance to move from
			 */
			Lambda(Lambda&& other) :
					vm(other.vm),
					object(other.object),
					clazz(other.clazz),
					method(other.method) {
				other.vm = nullptr;
				other.object = nullptr;
				other.clazz = nullptr;
				other.method = nullptr;
			}

			/**
			 * Destroys a lambda object
			 */
			~Lambda() {
				if(object != nullptr) {
					JNIEnv* env;
					vm->AttachCurrentThreadAsDaemon((void**) &env, nullptr);
					env->DeleteGlobalRef(object);
					vm->DetachCurrentThread();
				}
			}

			/**
			 * @return the lambda object
			 */
			operator jobject() const { return object; }

			/**
			 * @return the lambda class
			 */
			operator jclass() const { return clazz; }

			/**
			 * @return the lambda method
			 */
			operator jmethodID() const { return method; }

			/**
			 * Makes a new lambda object
			 *
			 * @param env the JNI environment
			 *
			 * @return the newly created lambda object
			 */
			static Lambda make(JNIEnv* env, jobject object, const std::string& methodName,
							   const std::string& signature) {
				if(object == nullptr) {
					return Lambda(nullptr, nullptr, nullptr, nullptr);
				}

				jclass clazz = env->GetObjectClass(object);
				jmethodID method = env->GetMethodID(clazz, methodName.c_str(), signature.c_str());

				if(method == nullptr) {
					throwNoSuchMethodError(env, methodName, signature);
				}

				JavaVM* vm;
				env->GetJavaVM(&vm);

				return Lambda(vm, env->NewGlobalRef(object), clazz, method);
			}

			static jint throwNoSuchMethodError(
					JNIEnv *env, const std::string& methodName,
					const std::string& signature) {
				const char *exClassName = "java/lang/NoSuchMethodError";
				std::string msg = methodName + "." + signature;
				return env->ThrowNew(env->FindClass(exClassName), msg.c_str());
			}
		};

		template<typename R>
		struct FunctionTrait;

		template<>
		struct FunctionTrait<void> {
			template<typename... Args>
			static void javaCall(JNIEnv* env, const Lambda& lambda, Args&& ... args) {
				env->CallVoidMethod(lambda, lambda, args...);
			}
		};

		template<>
		struct FunctionTrait<uint8_t> {
			template<typename... Args>
			static auto javaCall(JNIEnv* env, const Lambda& lambda, Args&& ... args) {
				return env->CallByteMethod(lambda, lambda, args...);
			}
		};

		template<>
		struct FunctionTrait<uint32_t> {
			template<typename... Args>
			static auto javaCall(JNIEnv* env, const Lambda& lambda, Args&& ... args) {
				return env->CallIntMethod(lambda, lambda, args...);
			}
		};

		/**
		 * A converter specialization for C++ std::function types
		 *
		 * @tparam R the function return type
		 * @tparam Args the function argument types
		 */
		template<typename R, typename... Args>
		struct Converter<std::function<R(Args...)>> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = std::function<R(Args...)>;

			/**
			 * The JNI type this converter supports
			 */
			using JavaType = Lambda;

			/**
			 * The function traits type
			 */
			using Traits = FunctionTrait<R>;

			/**
			 * Converts a C++ lambda function into a Java object
			 *
			 * @param env the JNI environment
			 * @param i the C++ function
			 *
			 * @return the Java object
			 */
			static JavaType toJava(JNIEnv* env, Type i) {
				JavaVM* vm;
				env->GetJavaVM(&vm);
				return i;
			}

			/**
			 * Converts a Java object into a C++ lambda function
			 *
			 * @param env the JNI environment
			 * @param object the Java object
			 *
			 * @return the C++ function
			 */
			static Type fromJava(JNIEnv* env, Lambda lambda) {
				return [lambda = std::move(lambda)](Args... args) mutable -> R {
					JNIEnv* env;
					lambda.vm->AttachCurrentThread((void**) &env, nullptr);

//					if(lambda.object == nullptr) {
//						throw std::runtime_error("Invalid Java object handle");
//					}
//					if(lambda.method == nullptr) {
//						throw std::runtime_error("Invalid Java method handle");
//					}

					return Converter<R>::fromJava(
							env, Traits::javaCall(
									env, lambda,
									Converter<Args>::toJava(env, args)...
							)
					);

					// TODO detach thread
				};
			}
		};

		/**
		 * A converter specialization for C++ std::function types returning
		 * a void type
		 *
		 * @tparam IntegralArgsType the function argument types
		 */
		template<typename... Args>
		struct Converter<std::function<void(Args...)>> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = std::function<void(Args...)>;

			/**
			 * The JNI type this converter supports
			 */
			using JavaType = Lambda;

			/**
			 * The function traits type
			 */
			using Traits = FunctionTrait<void>;

			/**
			 * Converts a C++ lambda function into a Java object
			 *
			 * @param env the JNI environment
			 * @param i the C++ function
			 *
			 * @return the Java object
			 */
			static JavaType toJava(JNIEnv* env, Type i) {
				JavaVM* vm;
				env->GetJavaVM(&vm);
				return i;
			}

			/**
			 * Converts a Java object into a C++ lambda function
			 *
			 * @param env the JNI environment
			 * @param object the Java object
			 *
			 * @return the C++ function
			 */
			static Type fromJava(JNIEnv* env, Lambda lambda) {
				return [lambda = std::move(lambda)](Args... args) mutable {
					JNIEnv* env;
					lambda.vm->AttachCurrentThread((void**) &env, nullptr);

//					if(lambda.object == nullptr) {
//						throw std::runtime_error("Invalid Java object handle");
//					}
//					if(lambda.method == nullptr) {
//						throw std::runtime_error("Invalid Java method handle");
//					}

					Traits::javaCall(
							env, lambda,
							Converter<Args>::toJava(env, args)...
					);

					// TODO detach thread
				};
			}
		};


	}
}
