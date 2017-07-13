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
	extern "C" JNIEXPORT jlong Java_allogen_example_AnotherClass__1init__Lallogen_example_AnotherClass_2__Ljava_lang_String_3(JNIEnv* _env_, jobject _jthis_, jobject parent, jstring sub) {
		return BridgedConstructor<Allogen::Example::AnotherClass(Allogen::Example::AnotherClass, std::string)>::call(_env_, [](Allogen::Example::AnotherClass parent, std::string sub) {{
            return nullptr;
        }}, parent, sub);
	}

	extern "C" JNIEXPORT jlong Java_allogen_example_AnotherClass__1init__Ljava_lang_String_2(JNIEnv* _env_, jobject _jthis_, jstring str) {
		return BridgedConstructor<Allogen::Example::AnotherClass(std::string)>::call(_env_, [](std::string str) {{
            return nullptr;
        }}, str);
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_AnotherClass_finalize(JNIEnv* _env_, jobject _jthis_) {
		return BridgedMethod<Allogen::Example::AnotherClass, void()>::call(_env_, _jthis_, [](Allogen::Example::AnotherClass *wself) { delete wself; });
	}

	extern "C" JNIEXPORT jstring JNICALL Java_allogen_example_AnotherClass_getName(JNIEnv* _env_, jobject _jthis_) {
		return BridgedMethod<Allogen::Example::AnotherClass, std::string()>::call(_env_, _jthis_, [](Allogen::Example::AnotherClass* wself) {return wself->getName();});
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_AnotherClass_setName(JNIEnv* _env_, jobject _jthis_, jstring newName) {
		return BridgedMethod<Allogen::Example::AnotherClass, void(std::string)>::call(_env_, _jthis_, [](Allogen::Example::AnotherClass* wself, std::string newName) {return wself->setName(newName);}, newName);
	}
}}