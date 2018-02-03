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
#include <map>

namespace Allogen {
	namespace CSharp {
		
		/**
		 * A converter specialization for C++ optional types
		 *
		 * @tparam IntegralType the integral type to be converted
		 */
		template<typename Key, typename T, typename Compare, typename Allocator>
		struct Converter<std::map<Key, T, Compare, Allocator>> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = std::map<Key, T, Compare, Allocator>;

			/**
			 * The JNI type this converter supports
			 */
			using CSharpType = std::pair<
					std::pair<
							typename Converter<Key>::CSharpType*,
							typename Converter<T>::CSharpType*
					>,
					uint64_t
			>;

			/**
			 * Converts a C++ integer into a CSharp integer
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the CSharp integer
			 */
			static CSharpType toCSharp(Type map) {
				auto keys = new typename Converter<Key>::CSharpType[map.size()];
				auto values = new typename Converter<T>::CSharpType[map.size()];

				int i = 0;
				for(auto& entry : map) {
					keys[i] = Converter<Key>::toCSharp(entry.first);
					values[i] = Converter<T>::toCSharp(entry.second);
					++i;
				}

				return {
						{keys, values},
						i
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
			static Type fromCSharp(CSharpType object) {
				Type map;
				for(int i = 0; i<object.second; i++) {
					map[
							Converter<Key>::fromCSharp(object.first.first[i])
					] = Converter<T>::fromCSharp(object.first.second[i]);
				}
				return map;
			}
		};

	}
}
