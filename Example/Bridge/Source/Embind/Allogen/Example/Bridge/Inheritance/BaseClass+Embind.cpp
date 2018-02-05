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


EMSCRIPTEN_BINDINGS(BaseClass) {
    class_<Allogen::Example::Inheritance::BaseClass>("BaseClass")
            .smart_ptr<std::shared_ptr<Allogen::Example::Inheritance::BaseClass>>("BaseClassSharedPtr")
            .function("getName", &Allogen::Example::Inheritance::BaseClass::getName)
            .function("fromNonvirtualBase", &Allogen::Example::Inheritance::BaseClass::fromNonvirtualBase);
}