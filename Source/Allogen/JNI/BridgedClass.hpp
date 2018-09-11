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
#include <memory>

namespace Allogen {
	namespace JNI {

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
		struct BridgeClass {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T object) {
				return BridgeClass<std::shared_ptr<T>>::toJava(env, std::make_shared<T>(std::move(object)));
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
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis));
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static T fromJava(JNIEnv* env, jobject jthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis));
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
		struct BridgeClass<T*> {
			/**
			 * The C++ type being converted
			 */
			using Type = T*;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T* object) {
				return BridgeClass<std::shared_ptr<T>>::toJava(env, std::shared_ptr<T>(object, [](auto) { /* no-op */ }));
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
				auto ptr = BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis);
				if(ptr == nullptr) {
					return nullptr;
				}
				return ptr.get();
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static T* fromJava(JNIEnv* env, jobject jthis) {
				auto ptr = BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis);
				if(ptr == nullptr) {
					return nullptr;
				}
				return ptr.get();
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
		struct BridgeClass<T&> {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T& object) {
				return BridgeClass<T*>::toJava(env, std::make_shared<T>(object));
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
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis).get());
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static T& fromJava(JNIEnv* env, jobject jthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis).get());
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
		struct BridgeClass<const T&> {
			/**
			 * The C++ type being converted
			 */
			using Type = const T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T& object) {
				return BridgeClass<std::shared_ptr<T>>::toJava(env, std::make_shared<T>(object));
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
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis).get());
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromJava(JNIEnv* env, jobject jthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis).get());
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
		struct BridgeClass<T&&> {
			/**
			 * The C++ type being converted
			 */
			using Type = T&;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, T&& object) {
				return BridgeClass<std::shared_ptr<T>>::toJava(env, std::make_shared<T>(std::move(object)));
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
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis));
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromJava(JNIEnv* env, jobject jthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromJava(env, jthis));
			}
		};

		inline LocalRef<jclass> getClass(JNIEnv* env, std::string className) {
#if defined(__ANDROID__)
			static jobject gClassLoader;
			static jmethodID gFindClassMethod;
			static bool loaded = false;
			if(!loaded) {
				loaded = true;

				LocalRef<jclass> randomClass = {env, env->FindClass(className.data())};
				LocalRef<jclass> classClass = {env, env->GetObjectClass(randomClass)};

				LocalRef<jclass> classLoaderClass = {env, env->FindClass("java/lang/ClassLoader")};
				jmethodID getClassLoaderMethod = env->GetMethodID(classClass, "getClassLoader",
															 "()Ljava/lang/ClassLoader;");
				gClassLoader = env->NewGlobalRef(
						env->CallObjectMethod(randomClass, getClassLoaderMethod));
				gFindClassMethod = env->GetMethodID(classLoaderClass, "findClass",
													"(Ljava/lang/String;)Ljava/lang/Class;");
			}

			// fixup the class name
			for(char& c : className) {
				if(c == '/') {
					c = '.';
				}
			}

			LocalRef<jstring> jClassName = {env, env->NewStringUTF(className.data())};
			return {env, static_cast<jclass>(env->CallObjectMethod(gClassLoader, gFindClassMethod, unwrapReference(jClassName)))};
#else
			return {env, env->FindClass(className.data())};
#endif
		}

		/**
		 * A Conversion implementation for classes bridged between C++ and Java.
		 *
		 * This implementation deals with functions that return or use the object
		 * by a pointer.
		 *
		 * @tparam T the bridged class type
		 */
		template<typename T>
		struct BridgeClass<std::shared_ptr<T>> {
			/**
			 * The C++ type being converted
			 */
			using Type = std::shared_ptr<T>;

			/**
			 * The Java type this converter converts from/to
			 */
			using JavaType = LocalRef<jobject>;

			/**
			 * Converts from the C++ object to a Java object
			 *
			 * @param env the JNI environment
			 * @param object the C++ object
			 *
			 * @return the corresponding Java type
			 */
			static JavaType toJava(JNIEnv* env, Type object) {
				LocalRef<jclass> c = getClass(env, JAVA_CLASS_NAME<T>);
				jobject jobject = env->AllocObject(c);

				jfieldID field = env->GetFieldID(c, "pointer", "J");
				env->SetLongField(jobject, field, (jlong) new Type(object));

				return {env, jobject};
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static Type fromJava(JNIEnv* env, JavaType jthis) {
				return fromJava(env, jthis.object);
			}

			/**
			 * Converts from the Java object to the C++ object
			 *
			 * @param env the JNI environment
			 * @param jthis the Java object
			 *
			 * @return the corresponding C++ type
			 */
			static Type fromJava(JNIEnv* env, jobject jthis) {
				LocalRef<jclass> view = {env, env->GetObjectClass(jthis)};
				jfieldID field = env->GetFieldID(view, "pointer", "J");
				jlong longPtr = env->GetLongField(jthis, field);
				return *reinterpret_cast<Type*>(longPtr);
			}

		};

#define ALLOGEN_BRIDGED_CLASS(ClassName, JavaClassName)                                                      		\
template<> constexpr const char ::Allogen::JNI::JAVA_CLASS_NAME<ClassName>[] = JavaClassName;                       \
template<> struct Allogen::JNI::Converter<ClassName>   : public ::Allogen::JNI::BridgeClass<ClassName>   {};    	\
template<> struct Allogen::JNI::Converter<ClassName*>  : public ::Allogen::JNI::BridgeClass<ClassName*>  {};    	\
template<> struct Allogen::JNI::Converter<ClassName&>  : public ::Allogen::JNI::BridgeClass<ClassName&>  {};    	\
template<> struct Allogen::JNI::Converter<ClassName&&> : public ::Allogen::JNI::BridgeClass<ClassName&&> {};      	\
template<> struct Allogen::JNI::Converter<std::shared_ptr<ClassName>> : 											\
				public ::Allogen::JNI::BridgeClass<std::shared_ptr<ClassName>> {};									\
template<> struct Allogen::JNI::Converter<std::shared_ptr<ClassName>*> : 											\
				public ::Allogen::JNI::BridgeClass<std::shared_ptr<ClassName>*> {};									\
template<> struct Allogen::JNI::Converter<std::shared_ptr<ClassName>&> : 											\
				public ::Allogen::JNI::BridgeClass<std::shared_ptr<ClassName>&> {};									\
template<> struct Allogen::JNI::Converter<std::shared_ptr<ClassName>&&> : 										    \
				public ::Allogen::JNI::BridgeClass<std::shared_ptr<ClassName>&&> {};								\

	}
}
