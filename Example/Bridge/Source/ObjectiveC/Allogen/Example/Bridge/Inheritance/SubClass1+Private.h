/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#include <Allogen/ObjectiveC.hpp>

#import "Allogen/ASubClass1.h"

#import "Allogen/Example/Bridge/Inheritance/BaseClass+Private.h"
#import "Allogen/ABaseClass.h"


#include "Allogen/Example/Inheritance/Inheritance.hpp"


ALLOGEN_BRIDGED_CLASS(Allogen::Example::Inheritance::SubClass1, ASubClass1)

@interface ASubClass1()
-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>*)cppObject;
-(std::shared_ptr<Allogen::Example::Inheritance::SubClass1>*)toCppObject;
@end