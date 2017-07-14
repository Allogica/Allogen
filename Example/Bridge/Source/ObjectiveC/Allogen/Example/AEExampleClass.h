/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#pragma once

#import <Foundation/Foundation.h>

#import "AEAnotherClass.h"
#import "AEAnotherClass.h"
#import "AEAnotherClass.h"
#import "AEExampleClass.h"

/**
 * A simple test class that shows how Allogen can bridge C++
 * classes into another target language.
 * Comments on this file are automatically appended into the generated
 * code as documentation strings.
 */
@interface AEExampleClass : NSObject
@property (nonatomic, getter=getInteger, setter=setInteger:) uint32_t aInteger;

/**
 * Creates a new ExampleClass object with the default value of 0.
 */
- (id)init;

/**
 * Creates a new ExampleClass with the given value
 * 
 * @param initialValue The initial value to set the integer to
 */
- (id)initWithInitialValue:(uint32_t)initialValue;

/**
 * 
 */
- (void)dealloc;

/**
 * Sets a integer that can later be retrieved
 * 
 * @param aInteger The integer to be set
 */
- (void)setInteger:(uint32_t)aInteger;

/**
 * The previously set integer
 */
- (uint32_t)getInteger;

/**
 * Creates a copy of the object
 */
- (AEExampleClass*)copy;

/**
 * Performs a async task
 * 
 * @param callback The callback function
 */
- (void)doAsync:(void(^)())callback;

/**
 * Executes a callback function returning a integer with two integer arguments
 * 
 * @param callback The callback function
 */
- (uint32_t)anotherCallback:(uint32_t(^)(uint16_t, uint16_t))callback;

/**
 * Executes a callback function returning a integer with two integer arguments.
 * This callback does not have a corresponding implementation in the native C++
 * ExampleClass class.
 * 
 * @param callback The callback function
 * @param a The "a" integer
 * @param b The "b" integer
 */
- (uint32_t)virtualCallback:(uint32_t(^)(uint16_t, uint16_t))callback
	                   a:(uint16_t)a
	                   b:(uint16_t)b;

/**
 * 
 * 
 * @param name 
 */
- (void)sayHello:(NSString*)name;

/**
 * 
 * 
 * @param name 
 */
- (AEAnotherClass*)createAnother:(NSString*)name;

/**
 * 
 * 
 * @param name 
 * @param callback 
 */
- (void)createAnotherAsync:(NSString*)name
	                      callback:(void(^)(AEAnotherClass*))callback;

/**
 * 
 * 
 * @param another 
 */
- (void)printAnother:(AEAnotherClass*)another;

/**
 * 
 * 
 * @param another 
 * @param callback 
 */
- (void)printAnotherAsync:(AEAnotherClass*)another
	                     callback:(void(^)())callback;

/**
 * 
 */
+ (uint32_t)getStaticInt;

/**
 * 
 */
+ (AEExampleClass*)shared;

@end
