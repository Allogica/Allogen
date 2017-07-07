//
// Created by Rogiel Sulzbach on 7/6/17.
//

#pragma once

#include <cstdint>

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

	};

}}
