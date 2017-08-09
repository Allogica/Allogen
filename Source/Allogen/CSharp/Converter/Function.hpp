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

#include "Allogen/CSharp/Converter.hpp"
#include <functional>

namespace Allogen {
	namespace CSharp {

		/**
		 * A converter specialization for C++ integral types
		 *
		 * @tparam IntegralType the integral type to be converted
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
			using CSharpType = typename Converter<R>::CSharpType(^)(typename Converter<Args>::CSharpType...);

			/**
			 * Converts a C++ integer into a CSharp integer
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the CSharp integer
			 */
			static CSharpType toCSharp(Type func) {
				return ^R(Args... args) {
					return Converter<R>::toCSharp(func(
							Converter<Args>::toCSharp(
									std::move<Args>(args)
							)...
					));
				};
			}

			/**
			 * Converts a CSharp integer into a C++ integer
			 *
			 * @param env the JNI environment
			 * @param i the CSharp integer
			 *
			 * @return the C++ integer
			 */
			static Type fromCSharp(CSharpType func) {
				return [func](Args... args) -> R {
					return Converter<R>::fromCSharp(func(
							Converter<Args>::toCSharp(
									std::forward<Args>(args)
							)...
					));
				};
			}
		};

		/**
		 * A converter specialization for C++ integral types
		 *
		 * @tparam IntegralType the integral type to be converted
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
			using CSharpType = typename Converter<void>::CSharpType(^)(typename Converter<Args>::CSharpType...);

			/**
			 * Converts a C++ integer into a CSharp integer
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the CSharp integer
			 */
			static CSharpType toCSharp(Type func) {
				return ^void(Args... args) {
					func(
							Converter<Args>::toCSharp(
									std::move<Args>(args)
							)...
					);
				};
			}

			/**
			 * Converts a CSharp integer into a C++ integer
			 *
			 * @param env the JNI environment
			 * @param i the CSharp integer
			 *
			 * @return the C++ integer
			 */
			static Type fromCSharp(CSharpType func) {
				return [func](Args... args) -> void {
					func(
							Converter<Args>::toCSharp(
									std::forward<Args>(args)
							)...
					);
				};
			}
		};

	}
}
