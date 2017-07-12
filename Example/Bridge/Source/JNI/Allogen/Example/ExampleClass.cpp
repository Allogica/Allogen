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

	extern "C" JNIEXPORT jint JNICALL Java_allogen_example_ExampleClass_anotherCallback(JNIEnv* _env_, jobject _jthis_, jobject callback) {
		return WrappedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint32_t, uint32_t)>)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, std::function<uint32_t(uint32_t, uint32_t)> callback) {return wself->anotherCallback(callback);}, Lambda::make(_env_, callback, "onCallback", "(II)I"));
	}

	extern "C" JNIEXPORT jint JNICALL Java_allogen_example_ExampleClass_getInteger(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<Allogen::Example::ExampleClass, uint32_t()>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself) {return wself->getInteger();});
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_sayHello(JNIEnv* _env_, jobject _jthis_, jstring name) {
		return WrappedMethod<Allogen::Example::ExampleClass, void(std::string)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, std::string name) {return wself->sayHello(name);}, name);
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_printAnotherAsync(JNIEnv* _env_, jobject _jthis_, jobject another, jobject callback) {
		return WrappedMethod<Allogen::Example::ExampleClass, void(AnotherClass, std::function<void()>)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, AnotherClass another, std::function<void()> callback) {return wself->printAnotherAsync(another, callback);}, another, Lambda::make(_env_, callback, "printAnother", "()V"));
	}

	extern "C" JNIEXPORT jint JNICALL Java_allogen_example_ExampleClass_virtualCallback(JNIEnv* _env_, jobject _jthis_, jobject callback, jint a, jint b) {
		return WrappedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint32_t, uint32_t)>, uint32_t, uint32_t)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, std::function<uint32_t(uint32_t, uint32_t)> callback, uint32_t a, uint32_t b) {{
            return callback(a, b);
        }}, Lambda::make(_env_, callback, "onCallback", "(II)I"), a, b);
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_setInteger(JNIEnv* _env_, jobject _jthis_, jint aInteger) {
		return WrappedMethod<Allogen::Example::ExampleClass, void(uint32_t)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, uint32_t aInteger) {return wself->setInteger(aInteger);}, aInteger);
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_doAsync(JNIEnv* _env_, jobject _jthis_, jobject callback) {
		return WrappedMethod<Allogen::Example::ExampleClass, void(std::function<void()>)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, std::function<void()> callback) {return wself->doAsync(callback);}, Lambda::make(_env_, callback, "onCallback", "()V"));
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_createAnotherAsync(JNIEnv* _env_, jobject _jthis_, jstring name, jobject callback) {
		return WrappedMethod<Allogen::Example::ExampleClass, void(std::string, std::function<void(AnotherClass)>)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, std::string name, std::function<void(AnotherClass)> callback) {return wself->createAnotherAsync(name, callback);}, name, Lambda::make(_env_, callback, "createAnother", "(Lallogen/example/AnotherClass;)V"));
	}

	extern "C" JNIEXPORT jobject JNICALL Java_allogen_example_ExampleClass_createAnother(JNIEnv* _env_, jobject _jthis_, jstring name) {
		return WrappedMethod<Allogen::Example::ExampleClass, AnotherClass(std::string)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, std::string name) {return wself->createAnother(name);}, name);
	}

	extern "C" JNIEXPORT jobject JNICALL Java_allogen_example_ExampleClass_copy(JNIEnv* _env_, jobject _jthis_) {
		return WrappedMethod<Allogen::Example::ExampleClass, ExampleClass()>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself) {{
            return ExampleClass(*wself);
        }});
	}

	extern "C" JNIEXPORT void JNICALL Java_allogen_example_ExampleClass_printAnother(JNIEnv* _env_, jobject _jthis_, jobject another) {
		return WrappedMethod<Allogen::Example::ExampleClass, void(AnotherClass)>::call(_env_, _jthis_, [](Allogen::Example::ExampleClass* wself, AnotherClass another) {return wself->printAnother(another);}, another);
	}
}}