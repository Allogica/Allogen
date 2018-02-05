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

static Allogen::Example::Inheritance::SubClass2* Make_SubClass2_0() {
    return new Allogen::Example::Inheritance::SubClass2();
}

EMSCRIPTEN_BINDINGS(SubClass2) {
    class_<Allogen::Example::Inheritance::SubClass2, base<Allogen::Example::Inheritance::BaseClass>>("SubClass2")
            .smart_ptr<std::shared_ptr<Allogen::Example::Inheritance::SubClass2>>("SubClass2SharedPtr")
            .constructor(&Make_SubClass2_0, allow_raw_pointers()) 
            .function("doInSubclass2", &Allogen::Example::Inheritance::SubClass2::doInSubclass2);
}