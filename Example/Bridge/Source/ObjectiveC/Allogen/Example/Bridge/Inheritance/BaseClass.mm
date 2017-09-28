/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import "Allogen/ABaseClass.h"
#import "Allogen/Example/Bridge/Inheritance/BaseClass+Private.h"

using namespace Allogen::ObjectiveC;

@implementation ABaseClass {
    std::shared_ptr<Allogen::Example::Inheritance::BaseClass>* _cppObject;
}

-(void)dealloc {
    delete _cppObject;
}
-(NSString*)getName {
    return BridgedMethod<Allogen::Example::Inheritance::BaseClass, std::string()>::call(
        self,
        [](Allogen::Example::Inheritance::BaseClass* wself) {
            return wself->getName();
        }
    );
}

-(void)fromNonvirtualBase {
    return BridgedMethod<Allogen::Example::Inheritance::BaseClass, void()>::call(
        self,
        [](Allogen::Example::Inheritance::BaseClass* wself) {
            return wself->fromNonvirtualBase();
        }
    );
}

-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::Inheritance::BaseClass>*)cppObject {
    _cppObject = cppObject;
    return self;
}

-(std::shared_ptr<Allogen::Example::Inheritance::BaseClass>*)toCppObject {
    return _cppObject;
}
@end