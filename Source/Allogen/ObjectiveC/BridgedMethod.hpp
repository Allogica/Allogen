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
	namespace ObjectiveC {

		/**
		 * A undefined template class that represents a wrapped clas method.
		 *
		 * @tparam Class the class whose method is being wrapped
		 * @tparam MethodSignature the method signature being wrapped
		 */
		template<typename Class, typename MethodSignature>
		struct BridgedMethod;

		/**
		 * This class represents a standard method wrapper. This class is
		 * able to automatically convert ObjectiveC ObjectiveC types like jobject, jlong, etc
		 * into a C++ data type.
		 *
		 * New data types can be defined by specializing the Conversion template.
		 *
		 * @tparam Class the wrapped class whose method is being called
		 * @tparam R the C++ method return type
		 * @tparam Args the C++ method argument types
		 */
		template<typename Class, typename R, typename... Args>
		struct BridgedMethod<Class, R(Args...)> {
		public:
			/**
			 * Calls a wrapped C++ function from ObjectiveC code
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the ObjectiveC environment
			 * @param jthis the "this" ObjectiveC object calling the wrapped method
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the ObjectiveC arguments of the method call
			 *
			 * @return the already ObjectiveC-converted object returned by the C++ method
			 */
			template<typename ObjCT, typename Executor>
			static inline typename Converter<R>::ObjectiveCType call(ObjCT* objcSelf, Executor&& executor,
															   typename Converter<Args>::ObjectiveCType... args) {
				@autoreleasepool {
					return Converter<decltype(executor(std::declval<Class*>(), std::declval<std::shared_ptr<Class>>(), std::declval<Args>()...))>::toObjectiveC(
							executor(
									Converter<Class*>::fromObjectiveC(objcSelf),
									Converter<std::shared_ptr<Class>>::fromObjectiveC(objcSelf),
									Converter<Args>::fromObjectiveC(
											std::move(args)
									)...
							)
					);
                }
			}

			/**
			 * Calls a wrapped C++ static function from ObjectiveC code
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the ObjectiveC environment
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the ObjectiveC arguments of the method call
			 *
			 * @return the already ObjectiveC-converted object returned by the C++ method
			 */
			template<typename Executor>
			static inline typename Converter<R>::ObjectiveCType call(Executor&& executor,
															   typename Converter<Args>::ObjectiveCType... args) {
				@autoreleasepool {
					return Converter<decltype(executor(std::declval<Args>()...))>::toObjectiveC(
							executor(
									Converter<Args>::fromObjectiveC(
											std::move(args)
									)...
							)
					);
				}
			}
		};

		/**
		 * A WrappedMethod method specialization for <tt>void</tt> return types.
		 *
		 * @tparam Class the wrapped class whose method is being called
		 * @tparam Args the C++ method argument types
		 */
		template<typename Class, typename... Args>
		struct BridgedMethod<Class, void(Args...)> {
		public:
			/**
			 * Calls a wrapped C++ function from ObjectiveC code.
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the ObjectiveC environment
			 * @param jthis the "this" ObjectiveC object calling the wrapped method
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the ObjectiveC arguments of the method call
			 */
			template<typename ObjCT, typename Executor>
			static inline void call(ObjCT* objcSelf, Executor&& executor,
			                        typename Converter<Args>::ObjectiveCType... args) {
				@autoreleasepool {
						executor(
								Converter<Class*>::fromObjectiveC(objcSelf),
								Converter<std::shared_ptr<Class>>::fromObjectiveC(objcSelf),
								Converter<Args>::fromObjectiveC(
										std::move(args)
								)...

						);
				}
			}

			/**
			 * Calls a wrapped C++ static function from ObjectiveC code.
			 *
			 * @tparam Executor the executor type
			 *
			 * @param env the ObjectiveC environment
			 * @param executor the code generated executor used to dispatch the method to the C++ object
			 * @param args the ObjectiveC arguments of the method call
			 */
			template<typename Executor>
			static inline void call(Executor&& executor,
			                        typename Converter<Args>::ObjectiveCType... args) {
				@autoreleasepool {
					executor(
							Converter<Args>::fromObjectiveC(
									std::move(args)
							)...

					);
				}
			}
		};
	}
}
