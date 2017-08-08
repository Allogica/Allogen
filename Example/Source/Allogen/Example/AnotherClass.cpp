//
// Created by Rogiel Sulzbach on 7/11/17.
//

#include "AnotherClass.hpp"

Allogen::Example::AnotherClass::AnotherClass(const std::string& name) : name(name) {}

const std::string& Allogen::Example::AnotherClass::getName() const {
	return name;
}

void Allogen::Example::AnotherClass::setName(const std::string& name) {
	AnotherClass::name = name;
}

