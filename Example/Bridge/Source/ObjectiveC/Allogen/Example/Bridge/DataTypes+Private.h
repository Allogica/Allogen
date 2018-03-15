/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#include <Allogen/ObjectiveC.hpp>

#import "Allogen/ADataTypes.h"

#import "Allogen/Example/Bridge/DummyClass+Private.h"
#import "Allogen/ADummyClass.h"


#include "Allogen/Example/DataTypes.hpp"


ALLOGEN_BRIDGED_CLASS(Allogen::Example::DataTypes, ADataTypes)

@interface ADataTypes()
-(id)initWithCppObject:(std::shared_ptr<Allogen::Example::DataTypes>*)cppObject;
-(std::shared_ptr<Allogen::Example::DataTypes>*)toCppObject;
@end