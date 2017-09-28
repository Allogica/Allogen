/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

package allogen.example;

import java.util.*;
import java.nio.ByteBuffer;
import allogen.example.AnotherClass;
import allogen.example.ExampleClass;
import allogen.example.ExampleClass;


/**
 * Calls the C++ ExampleClass() native method
 */
public class ExampleClass {
    /**
	 * A numeric value that represents the pointer used to access the wrapped object.
	 *
	 * This value should not be changed by the user and is automatically initialized by the _init
	 * or when used as a return value from another method.
	 */
    private long pointer;

    /**
     * Calls the C++ () native method
     */
    public ExampleClass() {
        pointer = this._init();
    }

    /**
     * This method performs the object creation. This method should only be called
     * from the object constructor.
     *
     * @return a pointer to the C++ native object
     */
    public native long _init();

    /**
     * Calls the C++ (uint32_t) native method
     *
     * @param initialValue the initialValue parameter
     */
    public ExampleClass(int initialValue) {
        pointer = this._init(initialValue);
    }

    /**
     * This method performs the object creation. This method should only be called
     * from the object constructor.
     *
     * @param initialValue the initialValue parameter
     *
     * @return a pointer to the C++ native object
     */
    public native long _init(int initialValue); 
    /**
     * This method deletes the wrapped C++ object. This method should
     * not be called directly by the user, but must be called by the GC.
     *
     * Note that since Java does not require the GC to call finalize() at all
     * it is recommended to not wrap any RAII objects that could lock or unlock
     * resources that are system wide.
     */
    @Override
    protected native void finalize() throws Throwable;

    /**
     * Calls the C++ setInteger(uint32_t) native method
     *
     * @param aInteger the aInteger parameter
     */
    public native void setInteger(int aInteger);


    /**
     * Calls the C++ getInteger() native method
     */
    public native int getInteger();


    /**
     * Calls the C++ copy() native method
     */
    public native ExampleClass copy();

    public interface AsyncTaskCallback {
        void onCallback();
    }
    /**
     * Calls the C++ doAsync(std::function<void()> ) native method
     *
     * @param callback the callback parameter
     */
    public native void doAsync(AsyncTaskCallback callback);

    public interface AsyncTaskCallback2 {
        int onCallback(short a, short b);
    }
    /**
     * Calls the C++ anotherCallback(std::function<uint32_t(uint16_t, uint16_t)> ) native method
     *
     * @param callback the callback parameter
     */
    public native int anotherCallback(AsyncTaskCallback2 callback);

    public interface AsyncTaskCallback3 {
        int onCallback(short a, short b);
    }
    /**
     * Calls the C++ virtualCallback(std::function<uint32_t(uint16_t, uint16_t)> , uint16_t, uint16_t) native method
     *
     * @param callback the callback parameter
     * @param a the a parameter
     * @param b the b parameter
     */
    public native int virtualCallback(AsyncTaskCallback3 callback, short a, short b);


    /**
     * Calls the C++ testingIfs(uint16_t) native method
     *
     * @param a the a parameter
     */
    public native int testingIfs(short a);


    /**
     * Calls the C++ sayHello(std::string) native method
     *
     * @param name the name parameter
     */
    public native void sayHello(String name);


    /**
     * Calls the C++ createAnother(std::string) native method
     *
     * @param name the name parameter
     */
    public native AnotherClass createAnother(String name);

    public interface CreateAnotherAsyncCallback {
        void createAnother(AnotherClass another);
    }
    /**
     * Calls the C++ createAnotherAsync(std::string, std::function<void(Allogen::Example::AnotherClass)> ) native method
     *
     * @param name the name parameter
     * @param callback the callback parameter
     */
    public native void createAnotherAsync(String name, CreateAnotherAsyncCallback callback);


    /**
     * Calls the C++ printAnother(Allogen::Example::AnotherClass) native method
     *
     * @param another the another parameter
     */
    public native void printAnother(AnotherClass another);

    public interface PrintAnotherAsyncCallback {
        void printAnother();
    }
    /**
     * Calls the C++ printAnotherAsync(Allogen::Example::AnotherClass, std::function<void()> ) native method
     *
     * @param another the another parameter
     * @param callback the callback parameter
     */
    public native void printAnotherAsync(AnotherClass another, PrintAnotherAsyncCallback callback);


    /**
     * Calls the C++ getStaticInt() native method
     */
    public native static int getStaticInt();


    /**
     * Calls the C++ shared() native method
     */
    public native static ExampleClass shared();
}