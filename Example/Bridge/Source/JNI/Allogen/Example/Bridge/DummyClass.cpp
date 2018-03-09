/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/DummyClass.hpp"

using namespace Allogen::JNI;

namespace Allogen { namespace Example {

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DummyClass_finalize(JNIEnv* _env_, jobject _jthis_) {
        BridgedDestructor<DummyClass>::call(
            _env_, _jthis_,
            [](std::shared_ptr<DummyClass> *wself) {
                delete wself;
            }
        );
    }

}}