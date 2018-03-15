/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import "Allogen/AExampleClass.h"
#import "Allogen/Example/Bridge/ExampleClass+Private.h"
using namespace Allogen::ObjectiveC;

@implementation AExampleClass {
    std::shared_ptr<Allogen::Example::ExampleClass>* _cppObject;
}

-(nonnull id)init {
    if(self) {
        BridgedConstructor<Allogen::Example::ExampleClass()>::call(
            self,
            []() {
                return new Allogen::Example::ExampleClass();
            }
        );
    }
    return self;
}

-(nonnull id)initWithInitialValue:(uint32_t)initialValue {
    if(self) {
        BridgedConstructor<Allogen::Example::ExampleClass(uint32_t)>::call(
            self,
            [](uint32_t initialValue) {
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
            }, initialValue
        );
    }
    return self;
}
-(void)dealloc {
    delete _cppObject;
}
-(void)setInteger:(uint32_t)aInteger {
    return BridgedMethod<Allogen::Example::ExampleClass, void(uint32_t)>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, uint32_t aInteger) {
            return wself->setInteger(aInteger);
        }, aInteger
    );
}

-(uint32_t)getInteger {
    return BridgedMethod<Allogen::Example::ExampleClass, uint32_t()>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr) {
            return wself->getInteger();
        }
    );
}

-(nonnull AExampleClass*)copy {
    return BridgedMethod<Allogen::Example::ExampleClass, Allogen::Example::ExampleClass()>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr) {
            return Allogen::Example::ExampleClass(*wself);
        }
    );
}

-(void)doAsync:(void(^ _Nonnull)())callback {
    return BridgedMethod<Allogen::Example::ExampleClass, void(std::function<void()> )>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, std::function<void()>  callback) {
            return wself->doAsync(callback);
        }, callback
    );
}

-(uint32_t)anotherCallback:(uint32_t(^ _Nonnull)(uint16_t a, uint16_t b))callback {
    return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)> )>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, std::function<uint32_t(uint16_t, uint16_t)>  callback) {
            return wself->anotherCallback(callback);
        }, callback
    );
}

-(uint32_t)virtualCallback:(uint32_t(^ _Nonnull)(uint16_t a, uint16_t b))callback a:(uint16_t)a b:(uint16_t)b {
    return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)> , uint16_t, uint16_t)>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, std::function<uint32_t(uint16_t, uint16_t)>  callback, uint16_t a, uint16_t b) {
            return callback(a, b);
        }, callback, a, b
    );
}

-(uint32_t)testingIfs:(uint16_t)a {
    return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(uint16_t)>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, uint16_t a) {
            if(a < 10) {
            return uint32_t(10);
            } else {
            return uint32_t(a);
            }
        }, a
    );
}

-(void)sayHello:(nonnull NSString*)name {
    return BridgedMethod<Allogen::Example::ExampleClass, void(std::string)>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, std::string name) {
            return wself->sayHello(name);
        }, name
    );
}

-(nonnull AAnotherClass*)createAnother:(nonnull NSString*)name {
    return BridgedMethod<Allogen::Example::ExampleClass, Allogen::Example::AnotherClass(std::string)>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, std::string name) {
            return wself->createAnother(name);
        }, name
    );
}

-(void)createAnotherAsync:(nonnull NSString*)name callback:(void(^ _Nonnull)(AAnotherClass* _Nonnull another))callback {
    return BridgedMethod<Allogen::Example::ExampleClass, void(std::string, std::function<void(Allogen::Example::AnotherClass)> )>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, std::string name, std::function<void(Allogen::Example::AnotherClass)>  callback) {
            return wself->createAnotherAsync(name, callback);
        }, name, callback
    );
}

-(void)printAnother:(nonnull AAnotherClass*)another {
    return BridgedMethod<Allogen::Example::ExampleClass, void(Allogen::Example::AnotherClass)>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, Allogen::Example::AnotherClass another) {
            return wself->printAnother(another);
        }, another
    );
}

-(void)printAnotherAsync:(nonnull AAnotherClass*)another callback:(void(^ _Nonnull)())callback {
    return BridgedMethod<Allogen::Example::ExampleClass, void(Allogen::Example::AnotherClass, std::function<void()> )>::call(
        self,
        [](Allogen::Example::ExampleClass* wself, std::shared_ptr<Allogen::Example::ExampleClass> wselfSharedPtr, Allogen::Example::AnotherClass another, std::function<void()>  callback) {
            return wself->printAnotherAsync(another, callback);
        }, another, callback
    );
}

+(uint32_t)getStaticInt {
    return BridgedMethod<void, uint32_t()>::call(
        []() {
            return 100;
        }
    );
}

+(nonnull AExampleClass*)shared {
    return BridgedMethod<void, Allogen::Example::ExampleClass()>::call(
        []() {
            static Allogen::Example::ExampleClass shared;
            return &shared;
        }
    );
}

-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::ExampleClass>*)cppObject {
    _cppObject = cppObject;
    return self;
}

-(std::shared_ptr<Allogen::Example::ExampleClass>*)toCppObject {
    return _cppObject;
}
@end