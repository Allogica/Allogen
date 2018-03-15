/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import "Allogen/ASubClass1.h"
#import "Allogen/Example/Bridge/Inheritance/SubClass1+Private.h"
using namespace Allogen::ObjectiveC;

@implementation ASubClass1 {
    std::shared_ptr<Allogen::Example::Inheritance::SubClass1>* _cppObject;
}

-(nonnull id)init {
    if(self) {
        BridgedConstructor<Allogen::Example::Inheritance::SubClass1()>::call(
            self,
            []() {
                return new Allogen::Example::Inheritance::SubClass1();
            }
        );
    }
    return self;
}
-(void)dealloc {
    delete _cppObject;
}
-(void)doInSubclass1 {
    return BridgedMethod<Allogen::Example::Inheritance::SubClass1, void()>::call(
        self,
        [](Allogen::Example::Inheritance::SubClass1* wself, std::shared_ptr<Allogen::Example::Inheritance::SubClass1> wselfSharedPtr) {
            return wself->doInSubclass1();
        }
    );
}
-(nonnull NSString*)getName {
    return BridgedMethod<Allogen::Example::Inheritance::SubClass1, std::string()>::call(
        self,
        [](Allogen::Example::Inheritance::SubClass1* wself, std::shared_ptr<Allogen::Example::Inheritance::SubClass1> wselfSharedPtr) {
            return wself->getName();
        }
    );
}

-(void)fromNonvirtualBase {
    return BridgedMethod<Allogen::Example::Inheritance::SubClass1, void()>::call(
        self,
        [](Allogen::Example::Inheritance::SubClass1* wself, std::shared_ptr<Allogen::Example::Inheritance::SubClass1> wselfSharedPtr) {
            return wself->fromNonvirtualBase();
        }
    );
}

-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>*)cppObject {
    _cppObject = cppObject;
    return self;
}

-(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>*)toCppObject {
    return _cppObject;
}
@end