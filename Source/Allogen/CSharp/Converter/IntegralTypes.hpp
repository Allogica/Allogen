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

namespace Allogen {
	namespace CSharp {
		
		/**
		 * A converter specialization for C++ integral types
		 *
		 * @tparam IntegralType the integral type to be converted
		 */
		template<typename IntegralType>
		struct Converter<IntegralType, typename std::enable_if<std::is_integral<IntegralType>::value>::type> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = IntegralType;

			/**
			 * The JNI type this converter supports
			 */
			using CSharpType = IntegralType;

			/**
			 * Converts a C++ integer into a CSharp integer
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the CSharp integer
			 */
			static CSharpType toCSharp(Type i) {
				return i;
			}

			/**
			 * Converts a CSharp integer into a C++ integer
			 *
			 * @param env the JNI environment
			 * @param i the CSharp integer
			 *
			 * @return the C++ integer
			 */
			static Type fromCSharp(CSharpType i) {
				return i;
			}
		};

		/**
		 * A converter specialization for float types
		 */
		template<>
		struct Converter<float> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = float;

			/**
			 * The CSharp type this converter supports
			 */
			using CSharpType = float;

			/**
			 * Converts a C++ float into a CSharp float
			 *
			 * @param i the C++ integer
			 *
			 * @return the CSharp integer
			 */
			static CSharpType toCSharp(Type i) { return i; }

			/**
			 * Converts a CSharp float into a C++ float
			 *
			 * @param i the CSharp float
			 *
			 * @return the C++ float
			 */
			static Type fromCSharp(CSharpType i) { return i; }
		};

		/**
		 * A converter specialization for double types
		 */
		template<>
		struct Converter<double> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = double;

			/**
			 * The CSharp type this converter supports
			 */
			using CSharpType = double;

			/**
			 * Converts a C++ double into a CSharp double
			 *
			 * @param i the C++ double
			 *
			 * @return the CSharp double
			 */
			static CSharpType toCSharp(Type i) { return i; }

			/**
			 * Converts a CSharp integer into a C++ double
			 *
			 * @param i the CSharp double
			 *
			 * @return the C++ double
			 */
			static Type fromCSharp(CSharpType i) { return i; }
		};


	}
}
