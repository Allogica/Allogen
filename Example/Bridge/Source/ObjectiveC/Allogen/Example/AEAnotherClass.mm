/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import <Allogen/ObjectiveC.hpp>

#import "AEAnotherClass.h"
#import "AEAnotherClass+Private.h"

#import "Allogen/Example/AnotherClass.hpp"
#import "Allogen/Example/ExampleClass.hpp"

using namespace Allogen::ObjectiveC;

// Since Objective-C does not allow classes to be nested inside a C++ namespace,
// we emulate the behabviour by importing all parent namespaces.
using namespace Allogen;
using namespace Allogen::Example;

/**
 * 
 */
@implementation AEAnotherClass {
	Allogen::Example::AnotherClass* _cppObject;
}

- (id)initWithParent:(AEAnotherClass*)parent
	        sub:(NSString*)sub {
	if(self) {
        BridgedConstructor<Allogen::Example::AnotherClass(Allogen::Example::AnotherClass, std::string)>::call(self, [](Allogen::Example::AnotherClass parent, std::string sub) {{
            return nullptr;
        }}, parent, sub);
    }
    return self;
}

- (id)initWithStr:(NSString*)str {
	if(self) {
        BridgedConstructor<Allogen::Example::AnotherClass(std::string)>::call(self, [](std::string str) {{
            return nullptr;
        }}, str);
    }
    return self;
}

- (void)dealloc {
	BridgedMethod<Allogen::Example::AnotherClass, void()>::call(self, [](Allogen::Example::AnotherClass *wself) { delete wself; });
	[super dealloc];
	

}

- (NSString*)getName {
	return BridgedMethod<Allogen::Example::AnotherClass, std::string()>::call(self, [](Allogen::Example::AnotherClass* wself) {return wself->getName();});
}

- (void)setName:(NSString*)newName {
	return BridgedMethod<Allogen::Example::AnotherClass, void(std::string)>::call(self, [](Allogen::Example::AnotherClass* wself, std::string newName) {return wself->setName(newName);}, newName);
}

@end
@implementation AEAnotherClass(Private)
- (id)initWithCppObject:(Allogen::Example::AnotherClass*)cppObject {
	_cppObject = cppObject; return self;
}

- (Allogen::Example::AnotherClass*)toCppObject {
	return _cppObject;
}

@end