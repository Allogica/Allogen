/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/AnotherClass.hpp"

using namespace Allogen::CSharp;

namespace Allogen { namespace Example {

    extern "C" std::shared_ptr<Allogen::Example::AnotherClass>*
    Allogen_Example_AnotherClass_Constructor_parent_sub(std::shared_ptr<Allogen::Example::AnotherClass>* parent, const char* sub) {
        return BridgedConstructor<Allogen::Example::AnotherClass(Allogen::Example::AnotherClass, std::string)>::call(
            [](Allogen::Example::AnotherClass parent, std::string sub) {
                return nullptr;
            }, parent, sub
        );
    }

    extern "C" std::shared_ptr<Allogen::Example::AnotherClass>*
    Allogen_Example_AnotherClass_Constructor_str(const char* str) {
        return BridgedConstructor<Allogen::Example::AnotherClass(std::string)>::call(
            [](std::string str) {
                return nullptr;
            }, str
        );
    }
    extern "C" void
    Allogen_Example_AnotherClass_Destructor(std::shared_ptr<Allogen::Example::AnotherClass>* csthis) {
        BridgedMethod<Allogen::Example::AnotherClass, void()>::call(
            csthis,
            [](Allogen::Example::AnotherClass *wself) {
                delete wself;
            }
        );
    }
    extern "C" const char*
    Allogen_Example_AnotherClass_getName(std::shared_ptr<Allogen::Example::AnotherClass>* csthis) {
        return BridgedMethod<Allogen::Example::AnotherClass, std::string()>::call(
            csthis,
            [](Allogen::Example::AnotherClass *wself) {
                return wself->getName();
            }
        );

    }


    extern "C" void
    Allogen_Example_AnotherClass_setName(std::shared_ptr<Allogen::Example::AnotherClass>* csthis,
    const char* newName) {
        return BridgedMethod<Allogen::Example::AnotherClass, void(std::string)>::call(
            csthis,
            [](Allogen::Example::AnotherClass *wself, std::string newName) {
                return wself->setName(newName);
            }, newName
        );

    }


}}