/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

#import <Foundation/Foundation.h>

@class ADummyClass;


/**
 * Calls the C++ DataTypes() native method
 */
@interface ADataTypes : NSObject

/**
 * Calls the C++ () native method
 */
-(nonnull id)init; 
/**
 * Calls the C++ () native method
 */
-(void)dealloc;

/**
 * Calls the C++ getString() native method
 */
-(nonnull NSString*)getString;

/**
 * Calls the C++ setString(std::string) native method
 *
 * @param str the str parameter
 */
-(void)setString:(nonnull NSString*)str;

/**
 * Calls the C++ getEmptyOptional() native method
 */
-(nullable ADummyClass*)getEmptyOptional;

/**
 * Calls the C++ getOptionalWithValue() native method
 */
-(nullable ADummyClass*)getOptionalWithValue;

/**
 * Calls the C++ getSharedPtr() native method
 */
-(nonnull ADummyClass*)getSharedPtr;

/**
 * Calls the C++ setSharedPtr(std::shared_ptr<Allogen::Example::DummyClass> ) native method
 *
 * @param ptr the ptr parameter
 */
-(void)setSharedPtr:(nonnull ADummyClass*)ptr;

/**
 * Calls the C++ getVector() native method
 */
-(nonnull NSArray<NSString*>*)getVector;

/**
 * Calls the C++ setVector(std::vector<std::string> ) native method
 *
 * @param vec the vec parameter
 */
-(void)setVector:(nonnull NSArray<NSString*>*)vec;

/**
 * Calls the C++ getMap() native method
 */
-(nonnull NSDictionary<NSString*, NSString*>*)getMap;

/**
 * Calls the C++ setMap(std::map<std::string, std::string> ) native method
 *
 * @param m the m parameter
 */
-(void)setMap:(nonnull NSDictionary<NSString*, NSString*>*)m;

/**
 * Calls the C++ getBuffer() native method
 */
-(nonnull NSData*)getBuffer;

/**
 * Calls the C++ getDate() native method
 */
-(nonnull NSDate*)getDate;

/**
 * Calls the C++ setDate(std::chrono::system_clock::time_point) native method
 *
 * @param date the date parameter
 */
-(void)setDate:(nonnull NSDate*)date;

/**
 * Calls the C++ doAsyncWithString(std::function<void(std::string)> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncWithString:(void(^ _Nonnull)(NSString* _Nonnull result))theCallback;

/**
 * Calls the C++ doAsyncWithOptional(std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncWithOptional:(void(^ _Nonnull)(uint32_t error, NSString* _Nullable result))theCallback;

/**
 * Calls the C++ doAsyncWithVector(std::function<void(std::vector<std::string> )> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncWithVector:(void(^ _Nonnull)(NSArray<NSString*>* _Nonnull result))theCallback;

/**
 * Calls the C++ doAsyncWithMap(std::function<void(std::map<std::string, std::string> )> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncWithMap:(void(^ _Nonnull)(NSDictionary<NSString*, NSString*>* _Nonnull result))theCallback;

/**
 * Calls the C++ doAsyncWithBuffer(std::function<void(std::vector<uint8_t>)> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncWithBuffer:(void(^ _Nonnull)(NSData* _Nonnull result))theCallback;

/**
 * Calls the C++ doAsyncWithDate(std::function<void(std::chrono::system_clock::time_point)> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncWithDate:(void(^ _Nonnull)(NSDate* _Nonnull result))theCallback;

/**
 * Calls the C++ doAsyncAndReturnString(std::function<std::string()> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncAndReturnString:(NSString*(^ _Nonnull)())theCallback;

/**
 * Calls the C++ doAsyncAndReturnDate(std::function<std::chrono::system_clock::time_point()> ) native method
 *
 * @param theCallback the theCallback parameter
 */
-(void)doAsyncAndReturnDate:(NSDate*(^ _Nonnull)())theCallback;

@end