//
// Created by Rogiel Sulzbach on 9/28/17.
//

#include <iostream>
#include "Inheritance.hpp"

namespace Allogen { namespace Example { namespace Inheritance {

	std::string BaseClass::getName() {
		return std::string();
	}

	void BaseClass::fromNonvirtualBase() {
		std::cout << "fromNonvirtualBase: " << getName() << std::endl;
	}

	std::string SubClass1::getName() {
		return "SubClass1";
	}

	void SubClass1::doInSubclass1() {
		std::cout << "doInSubclass1" << std::endl;
	}

	std::string SubClass2::getName() {
		return "SubClass2";
	}

	void SubClass2::doInSubclass2() {
		std::cout << "doInSubclass2" << std::endl;
	}

}}}