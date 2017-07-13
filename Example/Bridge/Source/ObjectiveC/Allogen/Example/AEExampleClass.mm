/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import <Allogen/ObjectiveC.hpp>

#import "AEExampleClass.h"
#import "AEExampleClass+Private.h"

#import "Allogen/Example/AnotherClass.hpp"
#import "Allogen/Example/ExampleClass.hpp"

using namespace Allogen::ObjectiveC;

// Since Objective-C does not allow classes to be nested inside a C++ namespace,
// we emulate the behabviour by importing all parent namespaces.
using namespace Allogen;
using namespace Allogen::Example;

/**
 * A simple test class that shows how Allogen can bridge C++
 * classes into another target language.
 * Comments on this file are automatically appended into the generated
 * code as documentation strings.
 */
@implementation AEExampleClass {
	Allogen::Example::ExampleClass* _cppObject;
}

- (id)init {
	if(self) {
        BridgedConstructor<Allogen::Example::ExampleClass()>::call(self, []() {return new Allogen::Example::ExampleClass();});
    }
    return self;
}

- (id)initWithInitialValue:(uint32_t)initialValue {
	if(self) {
        BridgedConstructor<Allogen::Example::ExampleClass(uint32_t)>::call(self, [](uint32_t initialValue) {{
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
    return self;
}

- (void)dealloc {
	BridgedMethod<Allogen::Example::ExampleClass, void()>::call(self, [](Allogen::Example::ExampleClass *wself) { delete wself; });
	[super dealloc];
	

}

- (void)setIntegerWithAInteger:(uint32_t)aInteger {
	return BridgedMethod<Allogen::Example::ExampleClass, void(uint32_t)>::call(self, [](Allogen::Example::ExampleClass* wself, uint32_t aInteger) {return wself->setInteger(aInteger);}, aInteger);
}

- (uint32_t)getInteger {
	return BridgedMethod<Allogen::Example::ExampleClass, uint32_t()>::call(self, [](Allogen::Example::ExampleClass* wself) {return wself->getInteger();});
}

- (AEExampleClass*)copy {
	return BridgedMethod<Allogen::Example::ExampleClass, Allogen::Example::ExampleClass()>::call(self, [](Allogen::Example::ExampleClass* wself) {{
            return ExampleClass(*wself);
        }});
}

- (void)doAsyncWithCallback:(void(^)())callback {
	return BridgedMethod<Allogen::Example::ExampleClass, void(std::function<void()>)>::call(self, [](Allogen::Example::ExampleClass* wself, std::function<void()> callback) {return wself->doAsync(callback);}, callback);
}

- (uint32_t)anotherCallbackWithCallback:(uint32_t(^)(uint16_t, uint16_t))callback {
	return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)>)>::call(self, [](Allogen::Example::ExampleClass* wself, std::function<uint32_t(uint16_t, uint16_t)> callback) {return wself->anotherCallback(callback);}, callback);
}

- (uint32_t)virtualCallbackWithCallback:(uint32_t(^)(uint16_t, uint16_t))callback
	                   a:(uint16_t)a
	                   b:(uint16_t)b {
	return BridgedMethod<Allogen::Example::ExampleClass, uint32_t(std::function<uint32_t(uint16_t, uint16_t)>, uint16_t, uint16_t)>::call(self, [](Allogen::Example::ExampleClass* wself, std::function<uint32_t(uint16_t, uint16_t)> callback, uint16_t a, uint16_t b) {{
            return callback(a, b);
        }}, callback, a, b);
}

- (void)sayHelloWithName:(NSString*)name {
	return BridgedMethod<Allogen::Example::ExampleClass, void(std::string)>::call(self, [](Allogen::Example::ExampleClass* wself, std::string name) {return wself->sayHello(name);}, name);
}

- (AEAnotherClass*)createAnotherWithName:(NSString*)name {
	return BridgedMethod<Allogen::Example::ExampleClass, Allogen::Example::AnotherClass(std::string)>::call(self, [](Allogen::Example::ExampleClass* wself, std::string name) {return wself->createAnother(name);}, name);
}

- (void)printAnotherWithAnother:(AEAnotherClass*)another {
	return BridgedMethod<Allogen::Example::ExampleClass, void(Allogen::Example::AnotherClass)>::call(self, [](Allogen::Example::ExampleClass* wself, Allogen::Example::AnotherClass another) {return wself->printAnother(another);}, another);
}

+ (uint32_t)getStaticInt {
	return BridgedMethod<Allogen::Example::ExampleClass, uint32_t()>::call([]() {{
            return 100;
        }});
}

+ (AEExampleClass*)shared {
	return BridgedMethod<Allogen::Example::ExampleClass, Allogen::Example::ExampleClass()>::call([]() {{
            static ExampleClass shared;
            return &shared;
        }});
}

@end
@implementation AEExampleClass(Private)
- (id)initWithCppObject:(Allogen::Example::ExampleClass*)cppObject {
	_cppObject = cppObject; return self;
}

- (Allogen::Example::ExampleClass*)toCppObject {
	return _cppObject;
}

@end