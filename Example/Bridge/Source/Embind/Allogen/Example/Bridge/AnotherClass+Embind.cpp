/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include <emscripten/bind.h>

#include "Allogen/Example/AnotherClass.hpp"


using namespace emscripten;

static Allogen::Example::AnotherClass* Make_AnotherClass_0(Allogen::Example::AnotherClass parent, std::string sub) {
    return nullptr;
}

static Allogen::Example::AnotherClass* Make_AnotherClass_1(std::string str) {
    return nullptr;
}

EMSCRIPTEN_BINDINGS(AnotherClass) {
    class_<Allogen::Example::AnotherClass>("AnotherClass")
            .smart_ptr<std::shared_ptr<Allogen::Example::AnotherClass>>("AnotherClassSharedPtr")
            .constructor(&Make_AnotherClass_0, allow_raw_pointers())
            .constructor(&Make_AnotherClass_1, allow_raw_pointers()) 
            .function("getName", &Allogen::Example::AnotherClass::getName)
            .function("setName", &Allogen::Example::AnotherClass::setName);
}