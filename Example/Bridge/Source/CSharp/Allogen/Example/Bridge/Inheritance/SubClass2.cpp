/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/Inheritance/SubClass2.hpp"

using namespace Allogen::CSharp;

namespace Allogen { namespace Example { namespace Inheritance {

    extern "C" ALLOGEN_EXPORT
    std::shared_ptr<Allogen::Example::Inheritance::SubClass2>* ALLOGEN_CALL
    Allogen_Example_Inheritance_SubClass2_Constructor() {
        return BridgedConstructor<Allogen::Example::Inheritance::SubClass2()>::call(
            []() {
                return new SubClass2();
            }
        );
    }

    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_Inheritance_SubClass2_Destructor(std::shared_ptr<Allogen::Example::Inheritance::SubClass2>* csthis) {
        BridgedMethod<Allogen::Example::Inheritance::SubClass2, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass2 *wself) {
                // delete wself;
            }
        );
    }

    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_Inheritance_SubClass2_doInSubclass2(std::shared_ptr<Allogen::Example::Inheritance::SubClass2>* csthis
    ) {
        return BridgedMethod<Allogen::Example::Inheritance::SubClass2, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass2 *wself) {
                return wself->doInSubclass2();
            }
        );

    }

    extern "C" ALLOGEN_EXPORT
    const char* ALLOGEN_CALL
    Allogen_Example_Inheritance_SubClass2_getName(std::shared_ptr<Allogen::Example::Inheritance::SubClass2>* csthis
    ) {
        return BridgedMethod<Allogen::Example::Inheritance::SubClass2, std::string()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass2 *wself) {
                return wself->getName();
            }
        );

    }


    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_Inheritance_SubClass2_fromNonvirtualBase(std::shared_ptr<Allogen::Example::Inheritance::SubClass2>* csthis
    ) {
        return BridgedMethod<Allogen::Example::Inheritance::SubClass2, void()>::call(
            csthis,
            [](Allogen::Example::Inheritance::SubClass2 *wself) {
                return wself->fromNonvirtualBase();
            }
        );

    }


}}}