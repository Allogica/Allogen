/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/Inheritance/BaseClass.hpp"

using namespace Allogen::CSharp;

namespace Allogen { namespace Example { namespace Inheritance {

    extern "C" void
    Allogen_Example_Inheritance_BaseClass_Destructor(std::shared_ptr<Allogen::Example::Inheritance::BaseClass>* csthis) {
        BridgedMethod<Allogen::Example::Inheritance::BaseClass, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::BaseClass *wself) {
                delete wself;
            }
        );
    }
    extern "C" const char*
    Allogen_Example_Inheritance_BaseClass_getName(std::shared_ptr<Allogen::Example::Inheritance::BaseClass>* csthis) {
        return BridgedMethod<Allogen::Example::Inheritance::BaseClass, std::string()>::call(
            csthis,
            [](Allogen::Example::Inheritance::BaseClass *wself) {
                return wself->getName();
            }
        );

    }


    extern "C" void
    Allogen_Example_Inheritance_BaseClass_fromNonvirtualBase(std::shared_ptr<Allogen::Example::Inheritance::BaseClass>* csthis) {
        return BridgedMethod<Allogen::Example::Inheritance::BaseClass, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::BaseClass *wself) {
                return wself->fromNonvirtualBase();
            }
        );

    }


}}}