/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import <Allogen/ObjectiveC.hpp>

#pragma once

#import "AEExampleClass.h"


#import "Allogen/Example/AnotherClass.hpp"
#import "Allogen/Example/ExampleClass.hpp"
#import "AEAnotherClass.h"
#import "AEAnotherClass+Private.h"
#import "AEAnotherClass.h"
#import "AEAnotherClass+Private.h"
#import "AEExampleClass.h"
#import "AEExampleClass+Private.h"

ALLOGEN_BRIDGED_CLASS(Allogen::Example::ExampleClass, "AEExampleClass")


@interface AEExampleClass(Private)
- (id)initWithCppObject:(Allogen::Example::ExampleClass*)cppObject;
- (Allogen::Example::ExampleClass*)toCppObject;
@end