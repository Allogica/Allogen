/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/ExampleClass.hpp"

using namespace Allogen::CSharp;

namespace Allogen { namespace Example {

    extern "C" ALLOGEN_EXPORT
    std::shared_ptr<Allogen::Example::ExampleClass>* ALLOGEN_CALL
    Allogen_Example_ExampleClass_Constructor() {
        return BridgedConstructor<Allogen::Example::ExampleClass()>::call(
            []() {
                return new ExampleClass();
            }
        );
    }


    extern "C" ALLOGEN_EXPORT
    std::shared_ptr<Allogen::Example::ExampleClass>* ALLOGEN_CALL
    Allogen_Example_ExampleClass_Constructor_initialValue(uint32_t initialValue) {
        return BridgedConstructor<Allogen::Example::ExampleClass(uint32_t)>::call(
            [](uint32_t initialValue) {
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
            }, initialValue
        );
    }

    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_ExampleClass_Destructor(std::shared_ptr<Allogen::Example::ExampleClass>* csthis) {
        BridgedMethod<Allogen::Example::ExampleClass, void()>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself) {
                // delete wself;
            }
        );
    }

    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_ExampleClass_setInteger(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    uint32_t aInteger) {
        return BridgedMethod<Allogen::Example::ExampleClass, void(uint32_t)>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, uint32_t aInteger) {
                return wself->setInteger(aInteger);
            }, aInteger
        );

    }


    extern "C" ALLOGEN_EXPORT
    uint32_t ALLOGEN_CALL
    Allogen_Example_ExampleClass_getInteger(std::shared_ptr<Allogen::Example::ExampleClass>* csthis
    ) {
        return BridgedMethod<Allogen::Example::ExampleClass, uint32_t()>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself) {
                return wself->getInteger();
            }
        );

    }


    extern "C" ALLOGEN_EXPORT
    std::shared_ptr<Allogen::Example::ExampleClass>* ALLOGEN_CALL
    Allogen_Example_ExampleClass_copy(std::shared_ptr<Allogen::Example::ExampleClass>* csthis
    ) {
        return BridgedMethod<Allogen::Example::ExampleClass, Allogen::Example::ExampleClass()>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself) {
                return Allogen::Example::ExampleClass(*wself);
            }
        );

    }


    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_ExampleClass_doAsync(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    void* callback) {
        return BridgedMethod<Allogen::Example::ExampleClass, void(std::function<void()> )>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, std::function<void()>  callback) {
                return wself->doAsync(callback);
            }, callback
        );

    }


    extern "C" ALLOGEN_EXPORT
    uint32_t ALLOGEN_CALL
    Allogen_Example_ExampleClass_anotherCallback(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    void* callback) {
        return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)> )>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, std::function<uint32_t(uint16_t, uint16_t)>  callback) {
                return wself->anotherCallback(callback);
            }, callback
        );

    }


    extern "C" ALLOGEN_EXPORT
    uint32_t ALLOGEN_CALL
    Allogen_Example_ExampleClass_virtualCallback(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    void* callback, uint16_t a, uint16_t b) {
        return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)> , uint16_t, uint16_t)>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, std::function<uint32_t(uint16_t, uint16_t)>  callback, uint16_t a, uint16_t b) {
                return callback(a, b);
            }, callback, a, b
        );

    }


    extern "C" ALLOGEN_EXPORT
    uint32_t ALLOGEN_CALL
    Allogen_Example_ExampleClass_testingIfs(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    uint16_t a) {
        return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(uint16_t)>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, uint16_t a) {
                if(a < 10) {
                return uint32_t(10);
                } else {
                return uint32_t(a);
                }
            }, a
        );

    }


    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_ExampleClass_sayHello(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    const char* name) {
        return BridgedMethod<Allogen::Example::ExampleClass, void(std::string)>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, std::string name) {
                return wself->sayHello(name);
            }, name
        );

    }


    extern "C" ALLOGEN_EXPORT
    std::shared_ptr<Allogen::Example::AnotherClass>* ALLOGEN_CALL
    Allogen_Example_ExampleClass_createAnother(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    const char* name) {
        return BridgedMethod<Allogen::Example::ExampleClass, Allogen::Example::AnotherClass(std::string)>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, std::string name) {
                return wself->createAnother(name);
            }, name
        );

    }


    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_ExampleClass_createAnotherAsync(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    const char* name, void* callback) {
        return BridgedMethod<Allogen::Example::ExampleClass, void(std::string, std::function<void(Allogen::Example::AnotherClass)> )>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, std::string name, std::function<void(Allogen::Example::AnotherClass)>  callback) {
                return wself->createAnotherAsync(name, callback);
            }, name, callback
        );

    }


    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_ExampleClass_printAnother(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    std::shared_ptr<Allogen::Example::AnotherClass>* another) {
        return BridgedMethod<Allogen::Example::ExampleClass, void(Allogen::Example::AnotherClass)>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, Allogen::Example::AnotherClass another) {
                return wself->printAnother(another);
            }, another
        );

    }


    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_ExampleClass_printAnotherAsync(std::shared_ptr<Allogen::Example::ExampleClass>* csthis, 
    std::shared_ptr<Allogen::Example::AnotherClass>* another, void* callback) {
        return BridgedMethod<Allogen::Example::ExampleClass, void(Allogen::Example::AnotherClass, std::function<void()> )>::call(
            csthis,
            [](Allogen::Example::ExampleClass *wself, Allogen::Example::AnotherClass another, std::function<void()>  callback) {
                return wself->printAnotherAsync(another, callback);
            }, another, callback
        );

    }


    extern "C" ALLOGEN_EXPORT
    uint32_t ALLOGEN_CALL
    Allogen_Example_ExampleClass_getStaticInt(
    ) {
        return BridgedMethod<void, uint32_t()>::call(
            []() {
                return 100;
            }
        );
    }


    extern "C" ALLOGEN_EXPORT
    std::shared_ptr<Allogen::Example::ExampleClass>* ALLOGEN_CALL
    Allogen_Example_ExampleClass_shared(
    ) {
        return BridgedMethod<void, Allogen::Example::ExampleClass()>::call(
            []() {
                static Allogen::Example::ExampleClass shared;
                return &shared;
            }
        );
    }


}}