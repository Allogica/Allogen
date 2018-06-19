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

#include <memory>
#include <type_traits>

namespace Allogen {
	namespace CSharp {
		
		/**
		 * A Conversion implementation for classes bridged between C++ and CSharp.
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
			using Type = T;

			/**
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = std::shared_ptr<T>*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T object) {
				return BridgeClass<std::shared_ptr<T>>::toCSharp(std::make_shared<T>(std::move(object)));
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param csthis the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static T& fromCSharp(CSharpType csthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromCSharp(csthis));
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and CSharp.
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
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = std::shared_ptr<T>*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T* object) {
				return BridgeClass<std::shared_ptr<T>>::toCSharp(std::shared_ptr<T>(object, [](auto) { /* no-op */ }));
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param csthis the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static T* fromCSharp(CSharpType csthis) {
				return BridgeClass<std::shared_ptr<T>>::fromCSharp(csthis).get();
			}

		};

		/**
		 * A Conversion implementation for classes bridged between C++ and CSharp.
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
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = std::shared_ptr<T>*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T& object) {
				return BridgeClass<T*>::toCSharp(std::make_shared<T>(object));
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param csthis the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static T& fromCSharp(CSharpType csthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromCSharp(csthis).get());
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and CSharp.
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
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = std::shared_ptr<T>*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T& object) {
				return BridgeClass<std::shared_ptr<T>>::toCSharp(std::make_shared<T>(object));
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param csthis the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromCSharp(CSharpType csthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromCSharp(csthis).get());
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and CSharp.
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
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = std::shared_ptr<T>*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(T&& object) {
				return BridgeClass<std::shared_ptr<T>>::toCSharp(std::make_shared<T>(std::move(object)));
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param csthis the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static const T& fromCSharp(CSharpType csthis) {
				return *(BridgeClass<std::shared_ptr<T>>::fromCSharp(csthis));
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and CSharp.
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
			 * The CSharp type this converter converts from/to
			 */
			using CSharpType = std::shared_ptr<T>*;

			/**
			 * Converts from the C++ object to a CSharp object
			 *
			 * @param object the C++ object
			 *
			 * @return the corresponding CSharp type
			 */
			static CSharpType toCSharp(Type object) {
				return new std::shared_ptr<T>(object);
			}

			/**
			 * Converts from the CSharp object to the C++ object
			 *
			 * @param csthis the CSharp object
			 *
			 * @return the corresponding C++ type
			 */
			static Type fromCSharp(CSharpType csthis) {
				if(csthis == nullptr) {
					return nullptr;
				}
				return *csthis;
			}

		};

#define ALLOGEN_BRIDGED_CLASS(ClassName)                                                               					\
template<> struct ::Allogen::CSharp::Converter<ClassName>   : public ::Allogen::CSharp::BridgeClass<ClassName>   {};    \
template<> struct ::Allogen::CSharp::Converter<ClassName*>  : public ::Allogen::CSharp::BridgeClass<ClassName*>  {};    \
template<> struct ::Allogen::CSharp::Converter<ClassName&>  : public ::Allogen::CSharp::BridgeClass<ClassName&>  {};    \
template<> struct ::Allogen::CSharp::Converter<ClassName&&> : public ::Allogen::CSharp::BridgeClass<ClassName&&> {};    \
template<> struct ::Allogen::CSharp::Converter<std::shared_ptr<ClassName>> :                                            \
                public ::Allogen::CSharp::BridgeClass<std::shared_ptr<ClassName>> {};                                   \
template<> struct ::Allogen::CSharp::Converter<std::shared_ptr<ClassName>*> :                                           \
                public ::Allogen::CSharp::BridgeClass<std::shared_ptr<ClassName>*> {};                                  \
template<> struct ::Allogen::CSharp::Converter<std::shared_ptr<ClassName>&> :                                          	\
                public ::Allogen::CSharp::BridgeClass<std::shared_ptr<ClassName>&> {};                                  \
template<> struct ::Allogen::CSharp::Converter<std::shared_ptr<ClassName>&&> :                                          \
                public ::Allogen::CSharp::BridgeClass<std::shared_ptr<ClassName>&&> {};                                 \

	}
}
