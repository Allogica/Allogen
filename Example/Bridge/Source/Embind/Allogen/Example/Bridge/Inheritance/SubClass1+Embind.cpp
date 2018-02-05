/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include <emscripten/bind.h>

#include "Allogen/Example/Inheritance/Inheritance.hpp"


using namespace emscripten;

static Allogen::Example::Inheritance::SubClass1* Make_SubClass1_0() {
    return new Allogen::Example::Inheritance::SubClass1();
}

EMSCRIPTEN_BINDINGS(SubClass1) {
    class_<Allogen::Example::Inheritance::SubClass1, base<Allogen::Example::Inheritance::BaseClass>>("SubClass1")
            .smart_ptr<std::shared_ptr<Allogen::Example::Inheritance::SubClass1>>("SubClass1SharedPtr")
            .constructor(&Make_SubClass1_0, allow_raw_pointers()) 
            .function("doInSubclass1", &Allogen::Example::Inheritance::SubClass1::doInSubclass1);
}