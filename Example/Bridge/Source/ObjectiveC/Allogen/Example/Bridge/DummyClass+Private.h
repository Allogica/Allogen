/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#include <Allogen/ObjectiveC.hpp>

#import "Allogen/ADummyClass.h"


#include "Allogen/Example/DataTypes.hpp"


ALLOGEN_BRIDGED_CLASS(Allogen::Example::DummyClass, ADummyClass)

@interface ADummyClass()
-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::DummyClass>*)cppObject;
-(std::shared_ptr<Allogen::Example::DummyClass>*)toCppObject;
@end