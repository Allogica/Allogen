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

/**
 * Calls the C++ AnotherClass() native method
 */
public class AnotherClass {
    /**
	 * A numeric value that represents the pointer used to access the wrapped object.
	 *
	 * This value should not be changed by the user and is automatically initialized by the _init
	 * or when used as a return value from another method.
	 */
    protected long pointer;

    /**
     * Calls the C++ (Allogen::Example::AnotherClass, std::string) native method
     *
     * @param parent the parent parameter
     * @param sub the sub parameter
     */
    public AnotherClass(allogen.example.AnotherClass parent, String sub) {
        pointer = this._init(parent, sub);
    }

    /**
     * This method performs the object creation. This method should only be called
     * from the object constructor.
     *
     * @param parent the parent parameter
     * @param sub the sub parameter
     *
     * @return a pointer to the C++ native object
     */
    private native long _init(allogen.example.AnotherClass parent, String sub);

    /**
     * Calls the C++ (std::string) native method
     *
     * @param str the str parameter
     */
    public AnotherClass(String str) {
        pointer = this._init(str);
    }

    /**
     * This method performs the object creation. This method should only be called
     * from the object constructor.
     *
     * @param str the str parameter
     *
     * @return a pointer to the C++ native object
     */
    private native long _init(String str); 
    protected AnotherClass(AnotherClass dummy) {
        // DO NOT USE THIS CONSTRUCTOR! THIS IS FOR INTERNAL USE ONLY!!!
    }
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
     * Calls the C++ getName() native method
     */
    public native String getName();


    /**
     * Calls the C++ setName(std::string) native method
     *
     * @param newName the newName parameter
     */
    public native void setName(String newName);
}