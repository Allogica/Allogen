//
// Created by Rogiel Sulzbach on 7/11/17.
//

#pragma once

#include <string>

namespace Allogen { namespace Example {

	class AnotherClass {
	private:
		std::string name;

	public:
		AnotherClass(const std::string& name);

	public:
		const std::string& getName() const;

		void setName(const std::string& name);

	};

}}