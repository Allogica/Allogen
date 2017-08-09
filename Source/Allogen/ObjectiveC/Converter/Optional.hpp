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

#include "Allogen/ObjectiveC/Converter.hpp"
#include <Juice/Utility/Optional.hpp>

namespace Allogen {
	namespace ObjectiveC {
		
		/**
		 * A converter specialization for C++ optional types
		 *
		 * @tparam IntegralType the integral type to be converted
		 */
		template<typename ContainedType>
		struct Converter<std::experimental::optional<ContainedType>> {
			/**
			 * The C++ type this converter is operating on
			 */
			using Type = std::experimental::optional<ContainedType>;

			/**
			 * The JNI type this converter supports
			 */
			using ObjectiveCType = typename Converter<ContainedType>::ObjectiveCType;

			/**
			 * Converts a C++ integer into a ObjectiveC integer
			 *
			 * @param env the JNI environment
			 * @param i the C++ integer
			 *
			 * @return the ObjectiveC integer
			 */
			static ObjectiveCType toObjectiveC(Type object) {
				if(object) {
					return Converter<ContainedType>::toObjectiveC(object.value());
				}
				return nullptr;
			}

			/**
			 * Converts a ObjectiveC integer into a C++ integer
			 *
			 * @param env the JNI environment
			 * @param i the ObjectiveC integer
			 *
			 * @return the C++ integer
			 */
			static Type fromObjectiveC(ObjectiveCType object) {
				if(object) {
					return Converter<ContainedType>::fromObjectiveC(object.value());
				}
				return nullptr;
			}
		};

	}
}
