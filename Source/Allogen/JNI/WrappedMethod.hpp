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

namespace Allogen {
	namespace JNI {

		/**
		 * A undefined template class that represents a wrapped clas method.
		 *
		 * @tparam Class the class whose method is being wrapped
		 * @tparam MethodSignature the method signature being wrapped
		 */
		template<typename Class, typename MethodSignature>
		struct WrappedMethod;

		/**
		 * This class represents a standard method wrapper. This class is
		 * able to automatically convert Java JNI types like jobject, jlong, etc
		 * into a C++ data type.
		 *
		 * New data types can be defined by specializing the Conversion template.
		 *
		 * @tparam Class the wrapped class whose method is being called
		 * @tparam R the C++ method return type
		 * @tparam Args the C++ method argument types
		 */
		template<typename Class, typename R, typename... Args>
		struct WrappedMethod<Class, R(Args...)> {
		public:
			/**
			 * Calls a wrapped C++ function from Java code
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the JNI environment
			 * @param jthis the "this" Java object calling the wrapped method
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the JNI arguments of the method call
			 *
			 * @return the already java-converted object returned by the C++ method
			 */
			template<typename Executor>
			static inline typename Converter<R>::JavaType call(JNIEnv* env, jobject jthis, Executor&& executor,
															   typename Converter<Args>::JavaType... args) {
				return Converter<R>::toJava(
						env,
						executor(
								Converter<Class*>::fromJava(env, jthis),
								Converter<Args>::fromJava(
										env, std::move(args)
								)...
						)
				);
			}
		};

		/**
		 * A WrappedMethod method specialization for <tt>void</tt> return types.
		 *
		 * @tparam Class the wrapped class whose method is being called
		 * @tparam Args the C++ method argument types
		 */
		template<typename Class, typename... Args>
		struct WrappedMethod<Class, void(Args...)> {
		public:
			/**
			 * Calls a wrapped C++ function from Java code.
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the JNI environment
			 * @param jthis the "this" Java object calling the wrapped method
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the JNI arguments of the method call
			 */
			template<typename Executor>
			static inline void call(JNIEnv* env, jobject jthis, Executor&& executor,
									typename Converter<Args>::JavaType... args) {
				return executor(
						Converter<Class*>::fromJava(env, jthis),
						Converter<Args>::fromJava(
								env, std::move(args)
						)...

				);
			}
		};

		/**
		 * A WrappedMethod specialization for class constructors.
		 *
		 * This class automatically sets the Java class "pointer" property
		 * to the newly allocated object.
		 *
		 * @tparam R the return type
		 * @tparam Args the contructor argument types
		 */
		template<typename R, typename... Args>
		struct WrappedMethod<void, R(Args...)> {
		public:
			/**
			 * Calls a wrapped C++ function from Java code
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the JNI environment
			 * @param jthis the "this" Java object calling the wrapped method
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the JNI arguments of the method call
			 *
			 * @return the already java-converted object returned by the C++ method
			 */
			template<typename Executor>
			static inline jlong call(JNIEnv* env, jobject jthis, Executor&& executor,
									 typename Converter<Args>::JavaType& ... args) {
				return reinterpret_cast<jlong>(
						executor(Converter<Args>::fromJava(env, args)...)
				);
			}
		};

		/**
		 * A template variable that indicates the Java fully qualified
		 * class name for the <tt>T</tt> C++ type
		 *
		 * @tparam T the C++ typename
		 */
		template<typename T>
		constexpr const char JAVA_CLASS_NAME[1024] = {0};

		/**
		 * A Conversion implementation for classes bridged between C++ and Java.
		 *
		 * This implementation deals with functions that return or use the object
		 * by value.
		 *
		 * @tparam T the bridged class type
		 */
		template<typename T>
		struct BridgeConversion {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = jobject;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T object) {
				return BridgeConversion<T*>::toJava(env, new T(std::move(object)));
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static T fromJava(JNIEnv* env, JavaType jthis) {
				return *(BridgeConversion<T*>::fromJava(env, jthis));
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and Java.
		 *
		 * This implementation deals with functions that return or use the object
		 * by a pointer.
		 *
		 * @tparam T the bridged class type
		 */
		template<typename T>
		struct BridgeConversion<T*> {
			/**
			 * The C++ type being converted
			 */
			using Type = T*;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = jobject;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T* object) {
				jclass c = env->FindClass(JAVA_CLASS_NAME<T>);
				jobject jobject = env->AllocObject(c);

				jfieldID field = env->GetFieldID(c, "pointer", "J");
				jlong longPtr = env->GetLongField(jobject, field);
				env->SetLongField(jobject, field, reinterpret_cast<jlong>(object));

				return jobject;
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static T* fromJava(JNIEnv* env, JavaType jthis) {
				jclass view = env->GetObjectClass(jthis);
				jfieldID field = env->GetFieldID(view, "pointer", "J");
				jlong longPtr = env->GetLongField(jthis, field);
				return reinterpret_cast<T*>(longPtr);
			}

		};

		/**
		 * A Conversion implementation for classes bridged between C++ and Java.
		 *
		 * This implementation deals with functions that return or use the object
		 * by a reference.
		 *
		 * @tparam T the bridged class type
		 */
		template<typename T>
		struct BridgeConversion<T&> {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = jobject;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T& object) {
				return BridgeConversion<T*>::toJava(env, new T(object));
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static T& fromJava(JNIEnv* env, JavaType jthis) {
				return *(BridgeConversion<T*>::fromJava(env, jthis));
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and Java.
		 *
		 * This implementation deals with functions that return or use the object
		 * by a const reference.
		 *
		 * @tparam T the bridged class type
		 */
		template<typename T>
		struct BridgeConversion<const T&> {
			/**
			 * The C++ type being converted
			 */
			using Type = const T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = jobject;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T& object) {
				return BridgeConversion<T*>::toJava(env, new T(object));
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromJava(JNIEnv* env, JavaType jthis) {
				return *(BridgeConversion<T*>::fromJava(env, jthis));
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and Java.
		 *
		 * This implementation deals with functions that return or use the object
		 * by a universal reference.
		 *
		 * @tparam T the bridged class type
		 */
		template<typename T>
		struct BridgeConversion<T&&> {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = jobject;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T&& object) {
				return BridgeConversion<T*>::toJava(env, new T(std::move(object)));
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromJava(JNIEnv* env, JavaType jthis) {
				return *(BridgeConversion<T*>::fromJava(env, jthis));
			}
		};

#define ALLOGEN_BRIDGED_CLASS_CONVERTER(ClassName, JavaClassName)                                                      \
template<> constexpr const char ::Allogen::JNI::JAVA_CLASS_NAME<ClassName>[] = JavaClassName;                          \
template<> struct ::Allogen::JNI::Converter<ClassName>   : public ::Allogen::JNI::BridgeConversion<ClassName>   {};    \
template<> struct ::Allogen::JNI::Converter<ClassName*>  : public ::Allogen::JNI::BridgeConversion<ClassName*>  {};    \
template<> struct ::Allogen::JNI::Converter<ClassName&>  : public ::Allogen::JNI::BridgeConversion<ClassName&>  {};    \
template<> struct ::Allogen::JNI::Converter<ClassName&&> : public ::Allogen::JNI::BridgeConversion<ClassName&&> {};    \

	}
}
