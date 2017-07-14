/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#import <Allogen/ObjectiveC.hpp>

#import "AEAnotherClass.h"


#import "Allogen/Example/AnotherClass.hpp"
#import "Allogen/Example/ExampleClass.hpp"

ALLOGEN_BRIDGED_CLASS(Allogen::Example::AnotherClass, AEAnotherClass)

@interface AEAnotherClass(Private)
- (id)initWithCppObject:(Allogen::Example::AnotherClass*)cppObject;
- (Allogen::Example::AnotherClass*)toCppObject;
@end