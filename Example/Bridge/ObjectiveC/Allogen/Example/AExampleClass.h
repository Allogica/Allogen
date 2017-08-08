/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import <Foundation/Foundation.h>

#import "Allogen/Example/AAnotherClass.h"
#import "Allogen/Example/AExampleClass.h"


/**
 * Calls the C++ ExampleClass() native method
 */
@interface AExampleClass : NSObject

@property (nonatomic, assign, getter=getInteger) uint32_t aInteger;
/**
 * Calls the C++ () native method
 */
-(id)init;

/**
 * Calls the C++ (uint32_t) native method
 *
 * @param initialValue the initialValue parameter
 */
-(id)initWithInitialValue:(uint32_t)initialValue; 
/**
 * Calls the C++ () native method
 */
-(void)dealloc;

/**
 * Calls the C++ setInteger(uint32_t) native method
 *
 * @param aInteger the aInteger parameter
 */
-(void)setInteger:(uint32_t)aInteger;

/**
 * Calls the C++ getInteger() native method
 */
-(uint32_t)getInteger;

/**
 * Calls the C++ copy() native method
 */
-(AExampleClass*)copy;

/**
 * Calls the C++ doAsync(std::function<void()> ) native method
 *
 * @param callback the callback parameter
 */
-(void)doAsync:(void(^)() )callback;

/**
 * Calls the C++ anotherCallback(std::function<uint32_t(uint16_t, uint16_t)> ) native method
 *
 * @param callback the callback parameter
 */
-(uint32_t)anotherCallback:(uint32_t(^)(uint16_t, uint16_t) )callback;

/**
 * Calls the C++ virtualCallback(std::function<uint32_t(uint16_t, uint16_t)> , uint16_t, uint16_t) native method
 *
 * @param callback the callback parameter
 * @param a the a parameter
 * @param b the b parameter
 */
-(uint32_t)virtualCallback:(uint32_t(^)(uint16_t, uint16_t) )callback a:(uint16_t)a b:(uint16_t)b;

/**
 * Calls the C++ testingIfs(uint16_t) native method
 *
 * @param a the a parameter
 */
-(uint32_t)testingIfs:(uint16_t)a;

/**
 * Calls the C++ sayHello(std::string) native method
 *
 * @param name the name parameter
 */
-(void)sayHello:(NSString*)name;

/**
 * Calls the C++ createAnother(std::string) native method
 *
 * @param name the name parameter
 */
-(AAnotherClass*)createAnother:(NSString*)name;

/**
 * Calls the C++ createAnotherAsync(std::string, std::function<void(Allogen::Example::AnotherClass)> ) native method
 *
 * @param name the name parameter
 * @param callback the callback parameter
 */
-(void)createAnotherAsync:(NSString*)name callback:(void(^)(AAnotherClass*) )callback;

/**
 * Calls the C++ printAnother(Allogen::Example::AnotherClass) native method
 *
 * @param another the another parameter
 */
-(void)printAnother:(AAnotherClass*)another;

/**
 * Calls the C++ printAnotherAsync(Allogen::Example::AnotherClass, std::function<void()> ) native method
 *
 * @param another the another parameter
 * @param callback the callback parameter
 */
-(void)printAnotherAsync:(AAnotherClass*)another callback:(void(^)() )callback;

/**
 * Calls the C++ getStaticInt() native method
 */
+(uint32_t)getStaticInt;

/**
 * Calls the C++ shared() native method
 */
+(AExampleClass*)shared;

@end