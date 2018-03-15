/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import "Allogen/ADataTypes.h"
#import "Allogen/Example/Bridge/DataTypes+Private.h"
using namespace Allogen::ObjectiveC;

@implementation ADataTypes {
    std::shared_ptr<Allogen::Example::DataTypes>* _cppObject;
}

-(nonnull id)init {
    if(self) {
        BridgedConstructor<Allogen::Example::DataTypes()>::call(
            self,
            []() {
                return new Allogen::Example::DataTypes();
            }
        );
    }
    return self;
}
-(void)dealloc {
    delete _cppObject;
}
-(nonnull NSString*)getString {
    return BridgedMethod<Allogen::Example::DataTypes, std::string()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getString();
        }
    );
}

-(void)setString:(nonnull NSString*)str {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::string)>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::string str) {
            return wself->setString(str);
        }, str
    );
}

-(nullable ADummyClass*)getEmptyOptional {
    return BridgedMethod<Allogen::Example::DataTypes, std::experimental::optional<Allogen::Example::DummyClass> ()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getEmptyOptional();
        }
    );
}

-(nullable ADummyClass*)getOptionalWithValue {
    return BridgedMethod<Allogen::Example::DataTypes, std::experimental::optional<Allogen::Example::DummyClass> ()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getOptionalWithValue();
        }
    );
}

-(nonnull ADummyClass*)getSharedPtr {
    return BridgedMethod<Allogen::Example::DataTypes, std::shared_ptr<Allogen::Example::DummyClass> ()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getSharedPtr();
        }
    );
}

-(void)setSharedPtr:(nonnull ADummyClass*)ptr {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::shared_ptr<Allogen::Example::DummyClass> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::shared_ptr<Allogen::Example::DummyClass>  ptr) {
            return wself->setSharedPtr(ptr);
        }, ptr
    );
}

-(nonnull NSArray<NSString*>*)getVector {
    return BridgedMethod<Allogen::Example::DataTypes, std::vector<std::string> ()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getVector();
        }
    );
}

-(void)setVector:(nonnull NSArray<NSString*>*)vec {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::vector<std::string> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::vector<std::string>  vec) {
            return wself->setVector(vec);
        }, vec
    );
}

-(nonnull NSDictionary<NSString*, NSString*>*)getMap {
    return BridgedMethod<Allogen::Example::DataTypes, std::map<std::string, std::string> ()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getMap();
        }
    );
}

-(void)setMap:(nonnull NSDictionary<NSString*, NSString*>*)m {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::map<std::string, std::string> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::map<std::string, std::string>  m) {
            return wself->setMap(m);
        }, m
    );
}

-(nonnull NSData*)getBuffer {
    return BridgedMethod<Allogen::Example::DataTypes, std::vector<uint8_t>()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getBuffer();
        }
    );
}

-(nonnull NSDate*)getDate {
    return BridgedMethod<Allogen::Example::DataTypes, std::chrono::system_clock::time_point()>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr) {
            return wself->getDate();
        }
    );
}

-(void)setDate:(nonnull NSDate*)date {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::chrono::system_clock::time_point)>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::chrono::system_clock::time_point date) {
            return wself->setDate(date);
        }, date
    );
}

-(void)doAsyncWithString:(void(^ _Nonnull)(NSString* _Nonnull result))theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::string)> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<void(std::string)>  theCallback) {
            return wself->doAsyncWithString(theCallback);
        }, theCallback
    );
}

-(void)doAsyncWithOptional:(void(^ _Nonnull)(uint32_t error, NSString* _Nullable result))theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )>  theCallback) {
            return wself->doAsyncWithOptional(theCallback);
        }, theCallback
    );
}

-(void)doAsyncWithVector:(void(^ _Nonnull)(NSArray<NSString*>* _Nonnull result))theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::vector<std::string> )> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<void(std::vector<std::string> )>  theCallback) {
            return wself->doAsyncWithVector(theCallback);
        }, theCallback
    );
}

-(void)doAsyncWithMap:(void(^ _Nonnull)(NSDictionary<NSString*, NSString*>* _Nonnull result))theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::map<std::string, std::string> )> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<void(std::map<std::string, std::string> )>  theCallback) {
            return wself->doAsyncWithMap(theCallback);
        }, theCallback
    );
}

-(void)doAsyncWithBuffer:(void(^ _Nonnull)(NSData* _Nonnull result))theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::vector<uint8_t>)> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<void(std::vector<uint8_t>)>  theCallback) {
            return wself->doAsyncWithBuffer(theCallback);
        }, theCallback
    );
}

-(void)doAsyncWithDate:(void(^ _Nonnull)(NSDate* _Nonnull result))theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<void(std::chrono::system_clock::time_point)> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<void(std::chrono::system_clock::time_point)>  theCallback) {
            return wself->doAsyncWithDate(theCallback);
        }, theCallback
    );
}

-(void)doAsyncAndReturnString:(NSString*(^ _Nonnull)())theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<std::string()> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<std::string()>  theCallback) {
            return wself->doAsyncAndReturnString(theCallback);
        }, theCallback
    );
}

-(void)doAsyncAndReturnDate:(NSDate*(^ _Nonnull)())theCallback {
    return BridgedMethod<Allogen::Example::DataTypes, void(std::function<std::chrono::system_clock::time_point()> )>::call(
        self,
        [](Allogen::Example::DataTypes* wself, std::shared_ptr<Allogen::Example::DataTypes> wselfSharedPtr, std::function<std::chrono::system_clock::time_point()>  theCallback) {
            return wself->doAsyncAndReturnDate(theCallback);
        }, theCallback
    );
}

-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::DataTypes>*)cppObject {
    _cppObject = cppObject;
    return self;
}

-(std::shared_ptr<Allogen::Example::DataTypes>*)toCppObject {
    return _cppObject;
}
@end