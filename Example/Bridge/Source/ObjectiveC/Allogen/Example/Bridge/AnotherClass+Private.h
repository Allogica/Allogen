/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#include <Allogen/ObjectiveC.hpp>

#import "Allogen/Example/Bridge/AnotherClass+Private.h"
#import "Allogen/Example/AAnotherClass.h"


#include "Allogen/Example/AnotherClass.hpp"


ALLOGEN_BRIDGED_CLASS(Allogen::Example::AnotherClass, AAnotherClass)

@interface AAnotherClass()
-(id)initWithCppObject:(Allogen::Example::AnotherClass*)cppObject;
-(Allogen::Example::AnotherClass*)toCppObject;
@end