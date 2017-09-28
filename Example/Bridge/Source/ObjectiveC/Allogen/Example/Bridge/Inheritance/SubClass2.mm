/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import "Allogen/ASubClass2.h"
#import "Allogen/Example/Bridge/Inheritance/SubClass2+Private.h"

using namespace Allogen::ObjectiveC;

@implementation ASubClass2 {
    std::shared_ptr<Allogen::Example::Inheritance::SubClass2>* _cppObject;
}

-(nonnull id)init {
    if(self) {
        BridgedConstructor<Allogen::Example::Inheritance::SubClass2()>::call(
            self,
            []() {
                return new Allogen::Example::Inheritance::SubClass2();
            }
        );
    }
    return self;
}
-(void)dealloc {
    delete _cppObject;
}
-(void)doInSubclass2 {
    return BridgedMethod<Allogen::Example::Inheritance::SubClass2, void()>::call(
        self,
        [](Allogen::Example::Inheritance::SubClass2* wself) {
            return wself->doInSubclass2();
        }
    );
}
-(NSString*)getName {
    return BridgedMethod<Allogen::Example::Inheritance::SubClass2, std::string()>::call(
        self,
        [](Allogen::Example::Inheritance::SubClass2* wself) {
            return wself->getName();
        }
    );
}

-(void)fromNonvirtualBase {
    return BridgedMethod<Allogen::Example::Inheritance::SubClass2, void()>::call(
        self,
        [](Allogen::Example::Inheritance::SubClass2* wself) {
            return wself->fromNonvirtualBase();
        }
    );
}

-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::Inheritance::SubClass2>*)cppObject {
    _cppObject = cppObject;
    return self;
}

-(std::shared_ptr<Allogen::Example::Inheritance::SubClass2>*)toCppObject {
    return _cppObject;
}
@end