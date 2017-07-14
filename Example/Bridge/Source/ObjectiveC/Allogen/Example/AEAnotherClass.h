/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#import <Foundation/Foundation.h>


/**
 * 
 */
@interface AEAnotherClass : NSObject
/**
 * 
 * 
 * @param parent 
 * @param sub 
 */
- (id)initWithParent:(AEAnotherClass*)parent
	        sub:(NSString*)sub;

/**
 * 
 * 
 * @param str 
 */
- (id)initWithStr:(NSString*)str;

/**
 * 
 */
- (void)dealloc;

/**
 * 
 */
- (NSString*)getName;

/**
 * 
 * 
 * @param newName 
 */
- (void)setName:(NSString*)newName;

@end
