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

#include "BridgedClass.hpp"

namespace Allogen {
	namespace ObjectiveC {

		/**
		 * A template class that represents a bridged constructor.
		 *
		 * @tparam Class the class whose method is being wrapped
		 * @tparam MethodSignature the method signature being wrapped
		 */
		template<typename MethodSignature>
		struct BridgedConstructor;

		/**
		 * A BridgedConstructor specialization for class constructors.
		 *
		 * This class automatically sets the ObjectiveC class "pointer" property
		 * to the newly allocated object.
		 *
		 * @tparam R the return type
		 * @tparam Args the contructor argument types
		 */
		template<typename R, typename... Args>
		struct BridgedConstructor<R(Args...)> {
		public:
			/**
			 * Calls a wrapped C++ function from ObjectiveC code
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the ObjectiveC environment
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the ObjectiveC arguments of the method call
			 *
			 * @return the already ObjectiveC-converted object returned by the C++ method
			 */
			template<typename ObjCT, typename Executor>
			static inline id call(ObjCT* wself, Executor&& executor,
									 typename Converter<Args>::ObjectiveCType... args) {
				@autoreleasepool {
						return [wself initWithCppObject: new std::shared_ptr<R>(executor(Converter<Args>::fromObjectiveC(args)...))];
				}
			}
		};

	}
}
