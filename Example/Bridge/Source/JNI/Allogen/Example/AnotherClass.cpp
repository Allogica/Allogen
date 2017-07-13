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
	extern "C" JNIEXPORT jlong Java_allogen_example_AnotherClass__1init__Lallogen_example_AnotherClass_2__Ljava_lang_String;_3(JNIEnv* _env_, jobject _jthis_, jobject parent, jstring sub) {
		return WrappedMethod<void, Allogen::Example::AnotherClass(AnotherClass, std::string)>::call(_env_, _jthis_, [](AnotherClass parent, std::string sub) {{
            return nullptr;
        }}, parent, sub);
	}

	extern "C" JNIEXPORT jlong Java_allogen_example_AnotherClass__1init__Ljava_lang_String;_2(JNIEnv* _env_, jobject _jthis_, jstring str) {
		return WrappedMethod<void, Allogen::Example::AnotherClass(std::string)>::call(_env_, _jthis_, [](std::string str) {{
            return nullptr;
        }}, str);
	}

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