/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/DataTypes.hpp"

using namespace Allogen::JNI;

namespace Allogen { namespace Example {

    extern "C"
    JNIEXPORT jlong JNICALL
    Java_allogen_example_DataTypes__1init(JNIEnv* _env_, jobject _jthis_) {
        return BridgedConstructor<Allogen::Example::DataTypes()>::call(
            _env_, []() {
                return new DataTypes();
            }
        );
    }
    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_finalize(JNIEnv* _env_, jobject _jthis_) {
        BridgedDestructor<DataTypes>::call(
            _env_, _jthis_,
            [](std::shared_ptr<DataTypes> *wself) {
                delete wself;
            }
        );
    }
    extern "C"
    JNIEXPORT jstring JNICALL
    Java_allogen_example_DataTypes_getString(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::string()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getString();
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_setString(JNIEnv* _env_, jobject _jthis_,
            jstring str) {
        return BridgedMethod<DataTypes, void(std::string)>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::string str) {
                return wself->setString(str);
            }, LocalRef<jstring>(_env_, jstring(str), false)
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_DataTypes_getEmptyOptional(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::experimental::optional<Allogen::Example::DummyClass> ()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getEmptyOptional();
            }
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_DataTypes_getOptionalWithValue(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::experimental::optional<Allogen::Example::DummyClass> ()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getOptionalWithValue();
            }
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_DataTypes_getSharedPtr(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::shared_ptr<Allogen::Example::DummyClass> ()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getSharedPtr();
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_setSharedPtr(JNIEnv* _env_, jobject _jthis_,
            jobject ptr) {
        return BridgedMethod<DataTypes, void(std::shared_ptr<Allogen::Example::DummyClass> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::shared_ptr<Allogen::Example::DummyClass>  ptr) {
                return wself->setSharedPtr(ptr);
            }, LocalRef<jobject>(_env_, jobject(ptr), false)
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_DataTypes_getVector(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::vector<std::string> ()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getVector();
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_setVector(JNIEnv* _env_, jobject _jthis_,
            jobject vec) {
        return BridgedMethod<DataTypes, void(std::vector<std::string> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::vector<std::string>  vec) {
                return wself->setVector(vec);
            }, LocalRef<jobject>(_env_, jobject(vec), false)
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_DataTypes_getMap(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::map<std::string, std::string> ()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getMap();
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_setMap(JNIEnv* _env_, jobject _jthis_,
            jobject m) {
        return BridgedMethod<DataTypes, void(std::map<std::string, std::string> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::map<std::string, std::string>  m) {
                return wself->setMap(m);
            }, LocalRef<jobject>(_env_, jobject(m), false)
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_DataTypes_getBuffer(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::vector<uint8_t>()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getBuffer();
            }
        );
    }

    extern "C"
    JNIEXPORT jobject JNICALL
    Java_allogen_example_DataTypes_getDate(JNIEnv* _env_, jobject _jthis_) {
        return BridgedMethod<DataTypes, std::chrono::system_clock::time_point()>::call(
            _env_, _jthis_,
            [](DataTypes *wself) {
                return wself->getDate();
            }
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_setDate(JNIEnv* _env_, jobject _jthis_,
            jobject date) {
        return BridgedMethod<DataTypes, void(std::chrono::system_clock::time_point)>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::chrono::system_clock::time_point date) {
                return wself->setDate(date);
            }, LocalRef<jobject>(_env_, jobject(date), false)
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncWithString(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<void(std::string)> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<void(std::string)>  theCallback) {
                return wself->doAsyncWithString(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "(Ljava/lang/String;)V") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncWithOptional(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )>  theCallback) {
                return wself->doAsyncWithOptional(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "(ILjava/lang/String;)V") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncWithVector(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<void(std::vector<std::string> )> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<void(std::vector<std::string> )>  theCallback) {
                return wself->doAsyncWithVector(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "(Ljava/util/List;)V") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncWithMap(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<void(std::map<std::string, std::string> )> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<void(std::map<std::string, std::string> )>  theCallback) {
                return wself->doAsyncWithMap(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "(Ljava/util/Map;)V") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncWithBuffer(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<void(std::vector<uint8_t>)> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<void(std::vector<uint8_t>)>  theCallback) {
                return wself->doAsyncWithBuffer(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "(Ljava/nio/ByteBuffer;)V") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncWithDate(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<void(std::chrono::system_clock::time_point)> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<void(std::chrono::system_clock::time_point)>  theCallback) {
                return wself->doAsyncWithDate(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "(Ljava/util/Date;)V") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncAndReturnString(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<std::string()> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<std::string()>  theCallback) {
                return wself->doAsyncAndReturnString(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "()Ljava/lang/String;") 
        );
    }

    extern "C"
    JNIEXPORT void JNICALL
    Java_allogen_example_DataTypes_doAsyncAndReturnDate(JNIEnv* _env_, jobject _jthis_,
            jobject theCallback) {
        return BridgedMethod<DataTypes, void(std::function<std::chrono::system_clock::time_point()> )>::call(
            _env_, _jthis_,
            [](DataTypes *wself, std::function<std::chrono::system_clock::time_point()>  theCallback) {
                return wself->doAsyncAndReturnDate(theCallback);
            }, Lambda::make(_env_, {_env_, theCallback, false}, "onTheCallback", "()Ljava/util/Date;") 
        );
    }

}}