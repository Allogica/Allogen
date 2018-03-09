/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/ExampleClass.hpp"

using namespace Allogen::JNI;

namespace Allogen { namespace Example {

    extern "C"
    JNIEXPORT jlong JNICALL
    Java_allogen_example_ExampleClass__1init__(JNIEnv* _env_, jobject _jthis_) {
        return BridgedConstructor<Allogen::Example::ExampleClass()>::call(
            _env_, []() {
                return new ExampleClass();
            }
        );
    }

    extern "C"
    JNIEXPORT jlong JNICALL
    Java_allogen_example_ExampleClass__1init__I(JNIEnv* _env_, jobject _jthis_,
            jint initialValue) {
        return BridgedConstructor<Allogen::Example::ExampleClass(uint32_t)>::call(
            _env_, [](uint32_t initialValue) {
                // Our C++ class does not implement this method. By Using a {} block we
                // can define any code that will be called by the bridge implementation.
                //
                // Note that we must use operator new here, because languages like Java
                // require that objects are allocated on the heap. However, on most
                // cases you can still return by value and the bridge compiler will
                // automatically create copy (or move) the object to a heap allocated
                // instance.
                auto example = new Allogen::Example::ExampleClass();
                example->setInteger(initialValue);
                return example;
            }, jint(initialValue)
        );
    }
    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_ExampleClass_finalize(JNIEnv* _env_, jobject _jthis_) {
        BridgedDestructor<ExampleClass>::call(
            _env_, _jthis_,
            [](std::shared_ptr<ExampleClass> *wself) {
                delete wself;
            }
        );
    }
    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_ExampleClass_setInteger(JNIEnv* _env_, jobject _jthis_,
            jint aInteger) {
        return BridgedMethod<ExampleClass, void(uint32_t)>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, uint32_t aInteger) {
                return wself->setInteger(aInteger);
            }, jint(aInteger)
        );
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_allogen_example_ExampleClass_getInteger(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<ExampleClass, uint32_t()>::call(
            _env_, _jthis_,
            [](ExampleClass *wself) {
                return wself->getInteger();
            }
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_ExampleClass_copy(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<ExampleClass, Allogen::Example::ExampleClass()>::call(
            _env_, _jthis_,
            [](ExampleClass *wself) {
                return Allogen::Example::ExampleClass(*wself);
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_ExampleClass_doAsync(JNIEnv* _env_, jobject _jthis_,
            jobject callback) {
        return BridgedMethod<ExampleClass, void(std::function<void()> )>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, std::function<void()>  callback) {
                return wself->doAsync(callback);
            }, Lambda::make(_env_, {_env_, callback, false}, "onCallback", "()V") 
        );
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_allogen_example_ExampleClass_anotherCallback(JNIEnv* _env_, jobject _jthis_,
            jobject callback) {
        return BridgedMethod<ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)> )>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, std::function<uint32_t(uint16_t, uint16_t)>  callback) {
                return wself->anotherCallback(callback);
            }, Lambda::make(_env_, {_env_, callback, false}, "onCallback", "(SS)I") 
        );
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_allogen_example_ExampleClass_virtualCallback(JNIEnv* _env_, jobject _jthis_,
            jobject callback, jshort a, jshort b) {
        return BridgedMethod<ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)> , uint16_t, uint16_t)>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, std::function<uint32_t(uint16_t, uint16_t)>  callback, uint16_t a, uint16_t b) {
                return callback(a, b);
            }, Lambda::make(_env_, {_env_, callback, false}, "onCallback", "(SS)I") , jshort(a), jshort(b)
        );
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_allogen_example_ExampleClass_testingIfs(JNIEnv* _env_, jobject _jthis_,
            jshort a) {
        return BridgedMethod<ExampleClass, uint32_t(uint16_t)>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, uint16_t a) {
                if(a < 10) {
                return uint32_t(10);
                } else {
                return uint32_t(a);
                }
            }, jshort(a)
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_ExampleClass_sayHello(JNIEnv* _env_, jobject _jthis_,
            jstring name) {
        return BridgedMethod<ExampleClass, void(std::string)>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, std::string name) {
                return wself->sayHello(name);
            }, LocalRef<jstring>(_env_, jstring(name), false)
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_ExampleClass_createAnother(JNIEnv* _env_, jobject _jthis_,
            jstring name) {
        return BridgedMethod<ExampleClass, Allogen::Example::AnotherClass(std::string)>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, std::string name) {
                return wself->createAnother(name);
            }, LocalRef<jstring>(_env_, jstring(name), false)
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_ExampleClass_createAnotherAsync(JNIEnv* _env_, jobject _jthis_,
            jstring name, jobject callback) {
        return BridgedMethod<ExampleClass, void(std::string, std::function<void(Allogen::Example::AnotherClass)> )>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, std::string name, std::function<void(Allogen::Example::AnotherClass)>  callback) {
                return wself->createAnotherAsync(name, callback);
            }, LocalRef<jstring>(_env_, jstring(name), false), Lambda::make(_env_, {_env_, callback, false}, "createAnother", "(Lallogen/example/AnotherClass;)V") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_ExampleClass_printAnother(JNIEnv* _env_, jobject _jthis_,
            jobject another) {
        return BridgedMethod<ExampleClass, void(Allogen::Example::AnotherClass)>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, Allogen::Example::AnotherClass another) {
                return wself->printAnother(another);
            }, LocalRef<jobject>(_env_, jobject(another), false)
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_ExampleClass_printAnotherAsync(JNIEnv* _env_, jobject _jthis_,
            jobject another, jobject callback) {
        return BridgedMethod<ExampleClass, void(Allogen::Example::AnotherClass, std::function<void()> )>::call(
            _env_, _jthis_,
            [](ExampleClass *wself, Allogen::Example::AnotherClass another, std::function<void()>  callback) {
                return wself->printAnotherAsync(another, callback);
            }, LocalRef<jobject>(_env_, jobject(another), false), Lambda::make(_env_, {_env_, callback, false}, "printAnother", "()V") 
        );
    }

    extern "C"
    JNIEXPORT jint JNICALL
    Java_allogen_example_ExampleClass_getStaticInt(JNIEnv* _env_, jclass) {
        return BridgedMethod<void, uint32_t()>::call(
            _env_,
            []() {
                return 100;
            }
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_ExampleClass_shared(JNIEnv* _env_, jclass) {
        return BridgedMethod<void, Allogen::Example::ExampleClass()>::call(
            _env_,
            []() {
                static Allogen::Example::ExampleClass shared;
                return &shared;
            }
        );
    }

}}