/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import <Foundation/Foundation.h>

#import "Allogen/Example/AAnotherClass.h"


/**
 * Calls the C++ AnotherClass() native method
 */
@interface AAnotherClass : NSObject

/**
 * Calls the C++ (Allogen::Example::AnotherClass, std::string) native method
 *
 * @param parent the parent parameter
 * @param sub the sub parameter
 */
-(id)initWithParent:(AAnotherClass*)parent sub:(NSString*)sub;

/**
 * Calls the C++ (std::string) native method
 *
 * @param str the str parameter
 */
-(id)initWithStr:(NSString*)str; 
/**
 * Calls the C++ () native method
 */
-(void)dealloc;

/**
 * Calls the C++ getName() native method
 */
-(NSString*)getName;

/**
 * Calls the C++ setName(std::string) native method
 *
 * @param newName the newName parameter
 */
-(void)setName:(NSString*)newName;

@end