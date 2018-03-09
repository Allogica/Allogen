/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/Inheritance/BaseClass.hpp"

using namespace Allogen::JNI;

namespace Allogen { namespace Example { namespace Inheritance {

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_inheritance_BaseClass_finalize(JNIEnv* _env_, jobject _jthis_) {
        BridgedDestructor<BaseClass>::call(
            _env_, _jthis_,
            [](std::shared_ptr<BaseClass> *wself) {
                delete wself;
            }
        );
    }
    extern "C"
    JNIEXPORT jstring JNICALL
    Java_allogen_example_inheritance_BaseClass_getName(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<BaseClass, std::string()>::call(
            _env_, _jthis_,
            [](BaseClass *wself) {
                return wself->getName();
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_inheritance_BaseClass_fromNonvirtualBase(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<BaseClass, void()>::call(
            _env_, _jthis_,
            [](BaseClass *wself) {
                return wself->fromNonvirtualBase();
            }
        );
    }

}}}