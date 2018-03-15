/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import "Allogen/ADummyClass.h"
#import "Allogen/Example/Bridge/DummyClass+Private.h"
using namespace Allogen::ObjectiveC;

@implementation ADummyClass {
    std::shared_ptr<Allogen::Example::DummyClass>* _cppObject;
}

-(void)dealloc {
    delete _cppObject;
}

-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::DummyClass>*)cppObject {
    _cppObject = cppObject;
    return self;
}

-(std::shared_ptr<Allogen::Example::DummyClass>*)toCppObject {
    return _cppObject;
}
@end