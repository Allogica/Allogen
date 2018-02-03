/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#include "Allogen/Example/Bridge/DataTypes.hpp"

using namespace Allogen::CSharp;

namespace Allogen { namespace Example {

    extern "C" std::shared_ptr<Allogen::Example::DataTypes>*
    Allogen_Example_DataTypes_Constructor() {
        return BridgedConstructor<Allogen::Example::DataTypes()>::call(
            []() {
                return new DataTypes();
            }
        );
    }
    extern "C" void
    Allogen_Example_DataTypes_Destructor(std::shared_ptr<Allogen::Example::DataTypes>* csthis) {
        BridgedMethod<Allogen::Example::DataTypes, void()>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself) {
                delete wself;
            }
        );
    }
    extern "C" const char*
    Allogen_Example_DataTypes_getString(std::shared_ptr<Allogen::Example::DataTypes>* csthis) {
        return BridgedMethod<Allogen::Example::DataTypes, std::string()>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself) {
                return wself->getString();
            }
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_setString(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    const char* str) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::string)>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::string str) {
                return wself->setString(str);
            }, str
        );

    }


    extern "C" std::shared_ptr<Allogen::Example::DummyClass>*
    Allogen_Example_DataTypes_getEmptyOptional(std::shared_ptr<Allogen::Example::DataTypes>* csthis) {
        return BridgedMethod<Allogen::Example::DataTypes, std::experimental::optional<Allogen::Example::DummyClass> ()>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself) {
                return wself->getEmptyOptional();
            }
        );

    }


    extern "C" std::shared_ptr<Allogen::Example::DummyClass>*
    Allogen_Example_DataTypes_getOptionalWithValue(std::shared_ptr<Allogen::Example::DataTypes>* csthis) {
        return BridgedMethod<Allogen::Example::DataTypes, std::experimental::optional<Allogen::Example::DummyClass> ()>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself) {
                return wself->getOptionalWithValue();
            }
        );

    }


    extern "C" std::shared_ptr<Allogen::Example::DummyClass>*
    Allogen_Example_DataTypes_getSharedPtr(std::shared_ptr<Allogen::Example::DataTypes>* csthis) {
        return BridgedMethod<Allogen::Example::DataTypes, std::shared_ptr<Allogen::Example::DummyClass> ()>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself) {
                return wself->getSharedPtr();
            }
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_setSharedPtr(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    std::shared_ptr<Allogen::Example::DummyClass>* ptr) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::shared_ptr<Allogen::Example::DummyClass> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::shared_ptr<Allogen::Example::DummyClass>  ptr) {
                return wself->setSharedPtr(ptr);
            }, ptr
        );

    }










    extern "C" void
    Allogen_Example_DataTypes_getBuffer(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    const unsigned char** csretValue, uint64_t* csretSize
    ) {
        auto ret = BridgedMethod<Allogen::Example::DataTypes, std::vector<uint8_t>()>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself) {
                return wself->getBuffer();
            }
        );
        *csretValue = ret.first;*csretSize = ret.second;

    }


    extern "C" long
    Allogen_Example_DataTypes_getDate(std::shared_ptr<Allogen::Example::DataTypes>* csthis) {
        return BridgedMethod<Allogen::Example::DataTypes, std::chrono::system_clock::time_point()>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself) {
                return wself->getDate();
            }
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_setDate(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    long date) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::chrono::system_clock::time_point)>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::chrono::system_clock::time_point date) {
                return wself->setDate(date);
            }, date
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncWithString(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::string)> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<void(std::string)>  theCallback) {
                return wself->doAsyncWithString(theCallback);
            }, theCallback
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncWithOptional(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )>  theCallback) {
                return wself->doAsyncWithOptional(theCallback);
            }, theCallback
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncWithVector(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::vector<std::string> )> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<void(std::vector<std::string> )>  theCallback) {
                return wself->doAsyncWithVector(theCallback);
            }, theCallback
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncWithMap(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::map<std::string, std::string> )> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<void(std::map<std::string, std::string> )>  theCallback) {
                return wself->doAsyncWithMap(theCallback);
            }, theCallback
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncWithBuffer(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::vector<uint8_t>)> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<void(std::vector<uint8_t>)>  theCallback) {
                return wself->doAsyncWithBuffer(theCallback);
            }, theCallback
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncWithDate(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::chrono::system_clock::time_point)> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<void(std::chrono::system_clock::time_point)>  theCallback) {
                return wself->doAsyncWithDate(theCallback);
            }, theCallback
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncAndReturnString(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<std::string()> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<std::string()>  theCallback) {
                return wself->doAsyncAndReturnString(theCallback);
            }, theCallback
        );

    }


    extern "C" void
    Allogen_Example_DataTypes_doAsyncAndReturnDate(std::shared_ptr<Allogen::Example::DataTypes>* csthis,
    void* theCallback) {
        return BridgedMethod<Allogen::Example::DataTypes, void(std::function<std::chrono::system_clock::time_point()> )>::call(
            csthis,
            [](Allogen::Example::DataTypes *wself, std::function<std::chrono::system_clock::time_point()>  theCallback) {
                return wself->doAsyncAndReturnDate(theCallback);
            }, theCallback
        );

    }


}}