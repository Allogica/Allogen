/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include <emscripten/bind.h>

#include "Allogen/Example/ExampleClass.hpp"


using namespace emscripten;

static Allogen::Example::ExampleClass* Make_ExampleClass_0() {
    return new Allogen::Example::ExampleClass();
}

static Allogen::Example::ExampleClass* Make_ExampleClass_1(uint32_t initialValue) {
    // Our C++ class does not implement this method. By Using a {} block we
    // can define any code that will be called by the bridge implementation.
    //
    // Note that we must use operator new here, because languages like Java
    // require that objects are allocated on the heap. However, on most
    // cases you can still return by value and the bridge compiler will
    // automatically create copy (or move) the object to a heap allocated
    // instance.
    auto example = new Allogen::Example::ExampleClass();
    example->setInteger(initialValue);
    return example;
}

EMSCRIPTEN_BINDINGS(ExampleClass) {
    class_<Allogen::Example::ExampleClass>("ExampleClass")
            .smart_ptr<std::shared_ptr<Allogen::Example::ExampleClass>>("ExampleClassSharedPtr")
            .property("aInteger", &Allogen::Example::ExampleClass::getInteger, &Allogen::Example::ExampleClass::setInteger)
            .constructor(&Make_ExampleClass_0, allow_raw_pointers())
            .constructor(&Make_ExampleClass_1, allow_raw_pointers()) 
            .function("setInteger", &Allogen::Example::ExampleClass::setInteger)
            .function("getInteger", &Allogen::Example::ExampleClass::getInteger)
            .function("copy", select_overload<Allogen::Example::ExampleClass(Allogen::Example::ExampleClass&)>([](Allogen::Example::ExampleClass& _allogenSelf) -> Allogen::Example::ExampleClass {
            auto* wself = &_allogenSelf;
            return Allogen::Example::ExampleClass(*wself);
            }))
            .function("doAsync", &Allogen::Example::ExampleClass::doAsync)
            .function("anotherCallback", &Allogen::Example::ExampleClass::anotherCallback)
            .function("virtualCallback", select_overload<uint32_t(Allogen::Example::ExampleClass&, emscripten::val , uint16_t, uint16_t)>([](Allogen::Example::ExampleClass& _allogenSelf, emscripten::val  callback, uint16_t a, uint16_t b) -> uint32_t {
            auto* wself = &_allogenSelf;
            return callback(a, b);
            }))
            .function("testingIfs", select_overload<uint32_t(Allogen::Example::ExampleClass&, uint16_t)>([](Allogen::Example::ExampleClass& _allogenSelf, uint16_t a) -> uint32_t {
            auto* wself = &_allogenSelf;
            if(a < 10) {
            return uint32_t(10);
            } else {
            return uint32_t(a);
            }
            }))
            .function("sayHello", &Allogen::Example::ExampleClass::sayHello)
            .function("createAnother", &Allogen::Example::ExampleClass::createAnother)
            .function("createAnotherAsync", &Allogen::Example::ExampleClass::createAnotherAsync)
            .function("printAnother", &Allogen::Example::ExampleClass::printAnother)
            .function("printAnotherAsync", &Allogen::Example::ExampleClass::printAnotherAsync)

;
}