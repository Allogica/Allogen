/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/DummyClass.hpp"

using namespace Allogen::CSharp;

namespace Allogen { namespace Example {

    extern "C" ALLOGEN_EXPORT
    void ALLOGEN_CALL
    Allogen_Example_DummyClass_Destructor(std::shared_ptr<Allogen::Example::DummyClass>* csthis) {
        BridgedMethod<Allogen::Example::DummyClass, void()>::call(
            csthis,
            [](Allogen::Example::DummyClass *wself) {
                // delete wself;
            }
        );
    }


}}