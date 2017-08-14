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
#include <string>
#include <objc/objc.h>

namespace Allogen {
	namespace ObjectiveC {

		template<typename T>
		const std::string OBJC_CLASS = {0};

		/**
		 * A Conversion implementation for classes bridged between C++ and ObjectiveC.
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
			 * The ObjectiveC type this converter converts from/to
			 */
			using ObjectiveCType = id;

			/**
			 * Converts from the C++ object to a ObjectiveC object
			 *
			 * @param env the ObjectiveC environment
			 * @param object the C++ object
			 *
			 * @return the corresponding ObjectiveC type
			 */
			static ObjectiveCType toObjectiveC(T object) {
				return BridgeClass<std::shared_ptr<T>>::toObjectiveC(std::make_shared<T>(std::move(object)));
			}

			/**
			 * Converts from the ObjectiveC object to the C++ object
			 *
			 * @param env the ObjectiveC environment
			 * @param wself the ObjectiveC object
			 *
			 * @return the corresponding C++ type
			 */
			static T fromObjectiveC(ObjectiveCType wself) {
				return *(BridgeClass<std::shared_ptr<T>>::fromObjectiveC(wself));
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and ObjectiveC.
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
			 * The ObjectiveC type this converter converts from/to
			 */
			using ObjectiveCType = id;

			/**
			 * Converts from the C++ object to a ObjectiveC object
			 *
			 * @param env the ObjectiveC environment
			 * @param object the C++ object
			 *
			 * @return the corresponding ObjectiveC type
			 */
			static ObjectiveCType toObjectiveC(Type object) {
				return BridgeClass<std::shared_ptr<T>>::toObjectiveC(std::shared_ptr<T>(object, [](auto) { /* no-op */ }));
			}

			/**
			 * Converts from the ObjectiveC object to the C++ object
			 *
			 * @param env the ObjectiveC environment
			 * @param wself the ObjectiveC object
			 *
			 * @return the corresponding C++ type
			 */
			static Type fromObjectiveC(ObjectiveCType wself) {
				auto ptr = BridgeClass<std::shared_ptr<T>>::fromObjectiveC(wself);
				if(ptr == nullptr) {
					return nullptr;
				}
				return ptr.get();
			}

		};

		/**
		 * A Conversion implementation for classes bridged between C++ and ObjectiveC.
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
			 * The ObjectiveC type this converter converts from/to
			 */
			using ObjectiveCType = id;

			/**
			 * Converts from the C++ object to a ObjectiveC object
			 *
			 * @param env the ObjectiveC environment
			 * @param object the C++ object
			 *
			 * @return the corresponding ObjectiveC type
			 */
			static ObjectiveCType toObjectiveC(Type object) {
				return BridgeClass<T*>::toObjectiveC(std::make_shared<T>(object));
			}

			/**
			 * Converts from the ObjectiveC object to the C++ object
			 *
			 * @param env the ObjectiveC environment
			 * @param wself the ObjectiveC object
			 *
			 * @return the corresponding C++ type
			 */
			static Type fromObjectiveC(ObjectiveCType wself) {
				return *(BridgeClass<std::shared_ptr<T>>::fromObjectiveC(wself).get());
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and ObjectiveC.
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
			 * The ObjectiveC type this converter converts from/to
			 */
			using ObjectiveCType = id;

			/**
			 * Converts from the C++ object to a ObjectiveC object
			 *
			 * @param env the ObjectiveC environment
			 * @param object the C++ object
			 *
			 * @return the corresponding ObjectiveC type
			 */
			static ObjectiveCType toObjectiveC(Type object) {
				return BridgeClass<std::shared_ptr<T>>::toObjectiveC(std::make_shared<T>(object));
			}

			/**
			 * Converts from the ObjectiveC object to the C++ object
			 *
			 * @param env the ObjectiveC environment
			 * @param wself the ObjectiveC object
			 *
			 * @return the corresponding C++ type
			 */
			static const Type fromObjectiveC(ObjectiveCType wself) {
				return *(BridgeClass<std::shared_ptr<T>>::fromObjectiveC(wself).get());
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and ObjectiveC.
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
			using Type = T&&;

			/**
			 * The ObjectiveC type this converter converts from/to
			 */
			using ObjectiveCType = id;

			/**
			 * Converts from the C++ object to a ObjectiveC object
			 *
			 * @param env the ObjectiveC environment
			 * @param object the C++ object
			 *
			 * @return the corresponding ObjectiveC type
			 */
			static ObjectiveCType toObjectiveC(Type object) {
				return BridgeClass<std::shared_ptr<T>>::toObjectiveC(std::make_shared<T>(std::move(object)));
			}

			/**
			 * Converts from the ObjectiveC object to the C++ object
			 *
			 * @param env the ObjectiveC environment
			 * @param wself the ObjectiveC object
			 *
			 * @return the corresponding C++ type
			 */
			static const Type fromObjectiveC(ObjectiveCType wself) {
				return *(BridgeClass<std::shared_ptr<T>>::fromObjectiveC(wself));
			}
		};

		/**
		 * A Conversion implementation for classes bridged between C++ and ObjectiveC.
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
			 * The ObjectiveC type this converter converts from/to
			 */
			using ObjectiveCType = id;

			/**
			 * Converts from the C++ object to a ObjectiveC object
			 *
			 * @param env the ObjectiveC environment
			 * @param object the C++ object
			 *
			 * @return the corresponding ObjectiveC type
			 */
			static ObjectiveCType toObjectiveC(Type object) {
				if(object == nullptr) {
					return nullptr;
				}

				auto c = NSClassFromString([NSString stringWithCString:OBJC_CLASS<T>.data()
			encoding:[NSString defaultCStringEncoding]]);
				return [[c alloc] initWithCppObject: new Type(object)];
			}

			/**
			 * Converts from the ObjectiveC object to the C++ object
			 *
			 * @param env the ObjectiveC environment
			 * @param wself the ObjectiveC object
			 *
			 * @return the corresponding C++ type
			 */
			static Type fromObjectiveC(ObjectiveCType wself) {
				if(wself == nullptr) {
					return nullptr;
				}

				return *reinterpret_cast<Type*>([wself performSelector: @selector(toCppObject)]);
			}

		};

#define ALLOGEN_BRIDGED_CLASS(ClassName, ObjectiveCClass)                                                      		\
template<> const std::string Allogen::ObjectiveC::OBJC_CLASS<ClassName> = ::Allogen::ObjectiveC::Converter<std::string>::fromObjectiveC(NSStringFromClass([ObjectiveCClass class]));                       \
template<> struct ::Allogen::ObjectiveC::Converter<ClassName>   : public ::Allogen::ObjectiveC::BridgeClass<ClassName>   {};    	\
template<> struct ::Allogen::ObjectiveC::Converter<ClassName*>  : public ::Allogen::ObjectiveC::BridgeClass<ClassName*>  {};    	\
template<> struct ::Allogen::ObjectiveC::Converter<ClassName&>  : public ::Allogen::ObjectiveC::BridgeClass<ClassName&>  {};    	\
template<> struct ::Allogen::ObjectiveC::Converter<ClassName&&> : public ::Allogen::ObjectiveC::BridgeClass<ClassName&&> {};   	\
template<> struct ::Allogen::ObjectiveC::Converter<std::shared_ptr<ClassName>> : 											\
				public ::Allogen::ObjectiveC::BridgeClass<std::shared_ptr<ClassName>> {};									\
template<> struct ::Allogen::ObjectiveC::Converter<std::shared_ptr<ClassName>*> : 											\
				public ::Allogen::ObjectiveC::BridgeClass<std::shared_ptr<ClassName>*> {};									\
template<> struct ::Allogen::ObjectiveC::Converter<std::shared_ptr<ClassName>&> : 											\
				public ::Allogen::ObjectiveC::BridgeClass<std::shared_ptr<ClassName>&> {};									\
template<> struct ::Allogen::ObjectiveC::Converter<std::shared_ptr<ClassName>&&> : 										\
				public ::Allogen::ObjectiveC::BridgeClass<std::shared_ptr<ClassName>&&> {};								\

	}
}
