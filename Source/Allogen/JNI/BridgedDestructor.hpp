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
#include "Allogen/JNI/CoffeeCatch.hpp"

namespace Allogen {
	namespace JNI {

		/**
		 * This class represents a standard destructor wrapper.
		 *
		 * @tparam Class 	the wrapped class whose destructor is being called
		 */
		template<typename Class>
		struct BridgedDestructor {
		public:
			/**
			 * Calls a wrapped C++ destructor from Java code
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env 		the JNI environment
			 * @param jthis 	the "this" Java object calling the wrapped destructor
			 * @param executor 	the code generated executor used to dispatch the destructor to
			 * 					the C++ object
			 */
			template<typename Executor>
			static inline void call(JNIEnv* env, jobject jthis, Executor&& executor) {
#if defined(ALLOGEN_JNI_USE_COFFEECATCH)
				CoffeeCatchCleaner cleaner;
				if (coffeecatch_inside() ||
					(coffeecatch_setup() == 0
					 && sigsetjmp(*coffeecatch_get_ctx(), 1) == 0)) {
#endif
					jclass view = env->GetObjectClass(jthis);
					jfieldID field = env->GetFieldID(view, "pointer", "J");
					jlong longPtr = env->GetLongField(jthis, field);

					auto ptr = reinterpret_cast<std::shared_ptr<Class>*>(longPtr);
					executor(ptr);
#if defined(ALLOGEN_JNI_USE_COFFEECATCH)
				} else {
					CoffeeCatch::_throw(env);
				}
#endif
			}
		};

	}
}
