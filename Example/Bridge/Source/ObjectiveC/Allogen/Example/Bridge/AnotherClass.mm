/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import "Allogen/Example/Bridge/AnotherClass+Private.h"
#import "Allogen/Example/AAnotherClass.h"

using namespace Allogen::ObjectiveC;

@implementation AAnotherClass {
    Allogen::Example::AnotherClass* _cppObject;
}

-(id)initWithParent:(AAnotherClass*)parent sub:(NSString*)sub {
    if(self) {
        BridgedConstructor<Allogen::Example::AnotherClass(Allogen::Example::AnotherClass, std::string)>::call(
            self,
            [](Allogen::Example::AnotherClass parent, std::string sub) {
                return nullptr;
            }, parent, sub
        );
    }
    return self;
}

-(id)initWithStr:(NSString*)str {
    if(self) {
        BridgedConstructor<Allogen::Example::AnotherClass(std::string)>::call(
            self,
            [](std::string str) {
                return nullptr;
            }, str
        );
    }
    return self;
}
-(void)dealloc {
    BridgedMethod<Allogen::Example::AnotherClass, void()>::call(
        self,
        [](Allogen::Example::AnotherClass* wself) {
            delete wself;
        }
    );
    [super dealloc];
}
-(NSString*)getName {
    return BridgedMethod<Allogen::Example::AnotherClass, std::string()>::call(
        self,
        [](Allogen::Example::AnotherClass* wself) {
            return wself->getName();
        }
    );
}

-(void)setName:(NSString*)newName {
    return BridgedMethod<Allogen::Example::AnotherClass, void(std::string)>::call(
        self,
        [](Allogen::Example::AnotherClass* wself, std::string newName) {
            return wself->setName(newName);
        }, newName
    );
}

-(id)initWithCppObject:(Allogen::Example::AnotherClass*)cppObject {
    _cppObject = cppObject;
    return self;
}

-(Allogen::Example::AnotherClass*)toCppObject {
    return _cppObject;
}
@end