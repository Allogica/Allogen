/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "AnotherClass.hpp"

using namespace Allogen::JNI;

namespace Allogen { namespace Example {
	extern "C" JNIEXPORT void JNICALL Java_allogen_example_AnotherClass_finalize(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<Allogen::Example::AnotherClass, void()>::call(_env_, _jthis_, [](Allogen::Example::AnotherClass *wself) { delete wself; });
	}

	extern "C" JNIEXPORT jstring JNICALL Java_allogen_example_AnotherClass_getName(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<Allogen::Example::AnotherClass, std::string()>::call(_env_, _jthis_, [](Allogen::Example::AnotherClass* wself) {return wself->getName();});
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_AnotherClass_setName(JNIEnv* _env_, jobject _jthis_, jstring newName) {
		return WrappedMethod<Allogen::Example::AnotherClass, void(std::string)>::call(_env_, _jthis_, [](Allogen::Example::AnotherClass* wself, std::string newName) {return wself->setName(newName);}, newName);
	}
}}