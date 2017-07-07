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

}}