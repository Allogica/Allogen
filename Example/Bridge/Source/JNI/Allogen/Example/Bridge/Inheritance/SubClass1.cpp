/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/Inheritance/SubClass1.hpp"

using namespace Allogen::JNI;

namespace Allogen { namespace Example { namespace Inheritance {

    JNIEXPORT void JNICALL
    Java_allogen_example_inheritance_SubClass1_finalize(JNIEnv* _env_, jobject _jthis_) {
        BridgedMethod<SubClass1, void()>::call(
            _env_, _jthis_,
            [](SubClass1 *wself) {
                delete wself;
            }
        );
    }
    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_inheritance_SubClass1_doInSubclass1(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<SubClass1, void()>::call(
            _env_, _jthis_,
            [](SubClass1 *wself) {
                return wself->doInSubclass1();
            }
        );
    }
    extern "C"
    JNIEXPORT jstring JNICALL
    Java_allogen_example_inheritance_BaseClass_getName(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<SubClass1, std::string()>::call(
            _env_, _jthis_,
            [](SubClass1 *wself) {
                return wself->getName();
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_inheritance_BaseClass_fromNonvirtualBase(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<SubClass1, void()>::call(
            _env_, _jthis_,
            [](SubClass1 *wself) {
                return wself->fromNonvirtualBase();
            }
        );
    }

}}}