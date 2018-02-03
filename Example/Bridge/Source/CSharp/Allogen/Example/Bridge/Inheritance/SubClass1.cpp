/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/Inheritance/SubClass1.hpp"

using namespace Allogen::CSharp;

namespace Allogen { namespace Example { namespace Inheritance {

    extern "C" std::shared_ptr<Allogen::Example::Inheritance::SubClass1>*
    Allogen_Example_Inheritance_SubClass1_Constructor() {
        return BridgedConstructor<Allogen::Example::Inheritance::SubClass1()>::call(
            []() {
                return new SubClass1();
            }
        );
    }
    extern "C" void
    Allogen_Example_Inheritance_SubClass1_Destructor(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>* csthis) {
        BridgedMethod<Allogen::Example::Inheritance::SubClass1, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass1 *wself) {
                delete wself;
            }
        );
    }
    extern "C" void
    Allogen_Example_Inheritance_SubClass1_doInSubclass1(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>* csthis) {
        return BridgedMethod<Allogen::Example::Inheritance::SubClass1, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass1 *wself) {
                return wself->doInSubclass1();
            }
        );

    }

    extern "C" const char*
    Allogen_Example_Inheritance_SubClass1_getName(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>* csthis) {
        return BridgedMethod<Allogen::Example::Inheritance::SubClass1, std::string()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass1 *wself) {
                return wself->getName();
            }
        );

    }


    extern "C" void
    Allogen_Example_Inheritance_SubClass1_fromNonvirtualBase(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>* csthis) {
        return BridgedMethod<Allogen::Example::Inheritance::SubClass1, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass1 *wself) {
                return wself->fromNonvirtualBase();
            }
        );

    }


}}}