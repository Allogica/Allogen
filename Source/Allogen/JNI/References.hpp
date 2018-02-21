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

namespace Allogen {
	namespace JNI {

		template<typename T>
		class LocalRef;

		template<typename T>
		class GlobalRef;

		template<typename T>
		class LocalRef {
		public:
			using RefType = T;

		public:
			/**
			 * The JNI object
			 */
			T object = nullptr;

			/**
			 * The JNI environment
			 */
			JNIEnv* env = nullptr;

			/**
			 * A boolean flag indicating if the reference is owned
			 */
			bool owned = true;

		public:
			LocalRef();

			LocalRef(std::nullptr_t);

			LocalRef(JNIEnv* env, T object, bool owned = true);

			LocalRef(const GlobalRef<T>& globalReference);

			LocalRef(const LocalRef& other);

			LocalRef& operator=(const LocalRef& other);

			LocalRef(LocalRef&& other);

			LocalRef& operator=(LocalRef&& other);

			~LocalRef();

		public:
			operator bool() const;

			operator T() const;

		public:
			T retain() const;

		};

		template<typename T>
		class GlobalRef {
		public:
			using RefType = T;

		public:
			/**
			 * The JNI reference
			 */
			T object = nullptr;

			/**
			 * The JNI environment
			 */
			JavaVM* vm = nullptr;

		public:
			GlobalRef();

			GlobalRef(std::nullptr_t);

			GlobalRef(JNIEnv* env, T object);

			GlobalRef(const LocalRef<T>& localReference);

			GlobalRef(const GlobalRef& other);

			GlobalRef& operator=(const GlobalRef& other);

			GlobalRef(GlobalRef&& other);

			GlobalRef& operator=(GlobalRef&& other);

			~GlobalRef();

		public:
			operator bool() const;

			operator T() const;

		};

		template<typename T>
		LocalRef<T>::LocalRef() {
			LocalRef::env = nullptr;
			LocalRef::object = nullptr;
		}

		template<typename T>
		LocalRef<T>::LocalRef(std::nullptr_t) {
			LocalRef::env = nullptr;
			LocalRef::object = nullptr;
		}

		template<typename T>
		LocalRef<T>::LocalRef(JNIEnv* env, T object, bool owned) {
			LocalRef::env = env;
			if(object != nullptr) {
				LocalRef::object = object;
			}
			LocalRef::owned = owned;
		}

		template<typename T>
		LocalRef<T>::LocalRef(const GlobalRef<T>& globalReference) {
			int err = globalReference.vm->GetEnv((void**) &env, JNI_VERSION_1_6);
			if(err == JNI_EDETACHED) {
				throw std::runtime_error("Cannot create a new LocalRef with a detached thread");
			}

			object = (T) env->NewLocalRef(reinterpret_cast<jobject>(globalReference.object));
		}

		template<typename T>
		LocalRef<T>::LocalRef(const LocalRef& other) {
			LocalRef::env = other.env;
			if(other.object != nullptr) {
				LocalRef::object = (T) env->NewLocalRef(reinterpret_cast<jobject>(other.object));
			}
		}

		template<typename T>
		LocalRef<T>& LocalRef<T>::operator=(const LocalRef& other) {
			if(owned && LocalRef::object != nullptr) {
				env->DeleteLocalRef(other);
			}

			LocalRef::env = other.env;
			if(other.object != nullptr) {
				LocalRef::object = (T) env->NewLocalRef(reinterpret_cast<jobject>(other.object));
			} else {
				LocalRef::object = nullptr;
			}

			return *this;
		}

		template<typename T>
		LocalRef<T>::LocalRef(LocalRef&& other) {
			std::swap(env, other.env);
			std::swap(object, other.object);
		}

		template<typename T>
		LocalRef<T>& LocalRef<T>::operator=(LocalRef&& other) {
			std::swap(env, other.env);
			std::swap(object, other.object);

			return *this;
		}

		template<typename T>
		LocalRef<T>::~LocalRef() {
			if(owned && object != nullptr && env != nullptr) {
				env->DeleteLocalRef(object);
			}
		}

		template<typename T>
		LocalRef<T>::operator bool() const {
			return object != nullptr;
		}

		template<typename T>
		LocalRef<T>::operator T() const {
			return object;
		}

		template<typename T>
		T LocalRef<T>::retain() const {
			return env->NewLocalRef(object);
		}

		// -------------------------------------------------------------------------------------------------------------

		template<typename T>
		GlobalRef<T>::GlobalRef() {
			GlobalRef::vm = nullptr;
			GlobalRef::object = nullptr;
		}

		template<typename T>
		GlobalRef<T>::GlobalRef(std::nullptr_t) {
			GlobalRef::vm = nullptr;
			GlobalRef::object = nullptr;
		}

		template<typename T>
		GlobalRef<T>::GlobalRef(JNIEnv* env, T object) {
			env->GetJavaVM(&vm);
			GlobalRef::object = (T) env->NewGlobalRef((jobject) object);
		}

		template<typename T>
		GlobalRef<T>::GlobalRef(const LocalRef<T>& localReference) {
			localReference.env->GetJavaVM(&vm);
			if(localReference.object != nullptr) {
				GlobalRef::object = (T) localReference.env->NewGlobalRef(reinterpret_cast<jobject>(localReference.object));
			}
		}

		template<typename T>
		GlobalRef<T>::GlobalRef(const GlobalRef& other) {
			GlobalRef::vm = other.vm;
			if(other.object != nullptr && vm != nullptr) {
				JNIEnv* env;

				bool attached = false;
				int err = vm->GetEnv((void**) &env, JNI_VERSION_1_6);
				if(err == JNI_EDETACHED) {
					err = vm->AttachCurrentThreadAsDaemon(ALLOGEN_JNI_ANDROID_ATTACH_CURRENT_THREAD_WORKAROUND &env, nullptr);
					attached = true;
				}

				GlobalRef::object = (T) env->NewGlobalRef(reinterpret_cast<jobject>(other.object));

				if(attached) {
					vm->DetachCurrentThread();
				}
			}
		}

		template<typename T>
		GlobalRef<T>& GlobalRef<T>::operator=(const GlobalRef& other) {
			if(object != nullptr && vm != nullptr) {
				JNIEnv* env;

				bool attached = false;
				int err = vm->GetEnv((void**) &env, JNI_VERSION_1_6);
				if(err == JNI_EDETACHED) {
					err = vm->AttachCurrentThreadAsDaemon(ALLOGEN_JNI_ANDROID_ATTACH_CURRENT_THREAD_WORKAROUND &env, nullptr);
					attached = true;
				}

				env->DeleteGlobalRef(object);

				if(attached) {
					vm->DetachCurrentThread();
				}
			}
			GlobalRef::vm = other.vm;

			if(other.object != nullptr && vm != nullptr) {
				JNIEnv* env;

				bool attached = false;
				int err = vm->GetEnv((void**) &env, JNI_VERSION_1_6);
				if(err == JNI_EDETACHED) {
					err = vm->AttachCurrentThreadAsDaemon(ALLOGEN_JNI_ANDROID_ATTACH_CURRENT_THREAD_WORKAROUND &env, nullptr);
					attached = true;
				}

				GlobalRef::object = (T) env->NewGlobalRef(reinterpret_cast<jobject>(other.object));

				if(attached) {
					vm->DetachCurrentThread();
				}
			} else {
				GlobalRef::object = nullptr;
			}

			return *this;
		}

		template<typename T>
		GlobalRef<T>::GlobalRef(GlobalRef&& other) {
			std::swap(vm, other.vm);
			std::swap(object, other.object);
		}

		template<typename T>
		GlobalRef<T>& GlobalRef<T>::operator=(GlobalRef&& other) {
			std::swap(vm, other.vm);
			std::swap(object, other.object);

			return *this;
		}

		template<typename T>
		GlobalRef<T>::~GlobalRef() {
			if(object != nullptr && vm != nullptr) {
				JNIEnv* env;

				bool attached = false;
				int err = vm->GetEnv((void**) &env, JNI_VERSION_1_6);
				if(err == JNI_EDETACHED) {
					err = vm->AttachCurrentThreadAsDaemon(ALLOGEN_JNI_ANDROID_ATTACH_CURRENT_THREAD_WORKAROUND &env, nullptr);
					attached = true;
				}

				env->DeleteGlobalRef(object);

				if(attached) {
					vm->DetachCurrentThread();
				}
			}
		}

		template<typename T>
		GlobalRef<T>::operator bool() const {
			return object != nullptr;
		}

		template<typename T>
		GlobalRef<T>::operator T() const {
			return object;
		}

		template<typename T>
		struct UnwrapReference {
			static T unwrap(T t) {
				return t;
			}

			static T takeOwnership(T t) {
				return t;
			}
		};

		template<typename T>
		struct UnwrapReference<LocalRef<T>> {
			static T unwrap(const LocalRef<T>& ref) {
				return ref.object;
			}

			static T takeOwnership(LocalRef<T> ref) {
				ref.owned = false;
				return ref.object;
			}
		};

		template<typename T>
		struct UnwrapReference<GlobalRef<T>> {
			static T unwrap(const GlobalRef<T>& ref) {
				return ref.object;
			}

			static T takeOwnership(GlobalRef<T> ref) {
				return ref.object;
			}
		};

		template<typename T>
		auto unwrapReference(const T& t) {
			return UnwrapReference<typename std::remove_reference<typename std::remove_const<T>::type>::type>::unwrap(t);
		}

		template<typename T>
		auto takeOwnership(T t) {
			return UnwrapReference<typename std::remove_reference<typename std::remove_const<T>::type>::type>::takeOwnership(t);
		}


	}
}


