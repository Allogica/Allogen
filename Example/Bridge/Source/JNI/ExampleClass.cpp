/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "ExampleClass.hpp"

using namespace Allogen::JNI;

namespace Allogen { namespace Example {
	extern "C" JNIEXPORT jlong Java_allogen_example_ExampleClass__1init__(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<void, Allogen::Example::ExampleClass()>::call(_env_, _jthis_, []() {return new Allogen::Example::ExampleClass();});
	}

	extern "C" JNIEXPORT jlong Java_allogen_example_ExampleClass__1init__I(JNIEnv* _env_, jobject _jthis_, jint initialValue) {
		return WrappedMethod<void, Allogen::Example::ExampleClass(uint32_t)>::call(_env_, _jthis_, [](uint32_t initialValue) {{
            // Our C++ class does not implement this method. By Using a {} block we
            // can define any code that will be called by the bridge implementation.
            //
            // Note that we must use operator new here, because languages like Java
            // require that objects are allocated on the heap. However, on most
            // cases you can still return by value and the bridge compiler will
            // automatically create copy (or move) the object to a heap allocated
            // instance.
            auto example = new ExampleClass();
            example->setInteger(initialValue);
            return example;
        }}, initialValue);
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_finalize(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<Allogen::Example::ExampleClass, void()>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass *wself) { delete wself; });
	}

	extern "C" JNIEXPORT jint JNICALL Java_allogen_example_ExampleClass_getInteger(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<Allogen::Example::ExampleClass, uint32_t()>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself) {return wself->getInteger();});
	}

	extern "C" JNIEXPORT jobject JNICALL Java_allogen_example_ExampleClass_copy(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<Allogen::Example::ExampleClass, Allogen::Example::ExampleClass()>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself) {{
            return ExampleClass(*wself);
        }});
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_setInteger(JNIEnv* _env_, jobject _jthis_, jint aInteger) {
		return WrappedMethod<Allogen::Example::ExampleClass, void(uint32_t)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, uint32_t aInteger) {return wself->setInteger(aInteger);}, aInteger);
	}
}}