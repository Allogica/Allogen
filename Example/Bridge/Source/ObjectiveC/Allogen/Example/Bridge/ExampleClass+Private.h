/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#include <Allogen/ObjectiveC.hpp>

#import "Allogen/AExampleClass.h"

#import "Allogen/Example/Bridge/AnotherClass+Private.h"
#import "Allogen/AAnotherClass.h"
#import "Allogen/Example/Bridge/ExampleClass+Private.h"
#import "Allogen/AExampleClass.h"


#include "Allogen/Example/ExampleClass.hpp"


ALLOGEN_BRIDGED_CLASS(Allogen::Example::ExampleClass, AExampleClass)

@interface AExampleClass()
-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::ExampleClass>*)cppObject;
-(std::shared_ptr<Allogen::Example::ExampleClass>*)toCppObject;
@end