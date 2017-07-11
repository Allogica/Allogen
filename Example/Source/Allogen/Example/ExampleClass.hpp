//
// Created by Rogiel Sulzbach on 7/6/17.
//

#pragma once

#include <cstdint>
#include <functional>

#include "AnotherClass.hpp"

namespace Allogen { namespace Example {

	class ExampleClass {
	private:
		uint32_t integer = 0;

	public:
		ExampleClass();
		~ExampleClass();

	public:
		void setInteger(uint32_t a);
		uint32_t getInteger() const;

	public:
		void doAsync(std::function<void()> async);
		uint32_t anotherCallback(std::function<uint32_t(uint16_t, uint16_t)> callback);

		ExampleClass* getSelf();

		void sayHello(const std::string& name);

		AnotherClass createAnother(const std::string& name);
		void createAnotherAsync(const std::string& name,
								std::function<void(AnotherClass)> callback);

		void printAnother(const AnotherClass& another);

	};

}}
