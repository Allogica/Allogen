//
// Created by Rogiel Sulzbach on 7/6/17.
//

#include "ExampleClass.hpp"

#include <iostream>

namespace Allogen { namespace Example {

	ExampleClass::ExampleClass() {}

	ExampleClass::~ExampleClass() {
		std::cout << "[C++] ExampleClass is being deleted!" << std::endl;
	}

	void ExampleClass::setInteger(uint32_t a) {
		integer = a;
	}

	uint32_t ExampleClass::getInteger() const {
		return integer;
	}

	void ExampleClass::doAsync(std::function<void()> async) {
		async();
	}

	uint32_t ExampleClass::anotherCallback(std::function<uint32_t(uint16_t, uint16_t)> callback) {
		return callback(20, 30);
	}

	ExampleClass* ExampleClass::getSelf() {
		return this;
	}

	void ExampleClass::sayHello(const std::string& name) {
		std::cout << "Hello " << name << std::endl;
	}

}}