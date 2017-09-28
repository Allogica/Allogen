//
// Created by Rogiel Sulzbach on 9/28/17.
//

#ifndef ALLOGEN_BASECLASS_HPP
#define ALLOGEN_BASECLASS_HPP

#include <string>

namespace Allogen { namespace Example { namespace Inheritance {

	class BaseClass {
	public:
		virtual std::string getName() = 0;
		void fromNonvirtualBase();

	};

	class SubClass1 : public BaseClass {
	public:
		std::string getName() override;
		void doInSubclass1();
	};

	class SubClass2 : public BaseClass {
	public:
		std::string getName() override;
		void doInSubclass2();

	};

}}}

#endif //ALLOGEN_BASECLASS_HPP
