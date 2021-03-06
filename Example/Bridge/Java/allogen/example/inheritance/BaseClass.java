/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

package allogen.example.inheritance;

import java.util.*;
import java.nio.ByteBuffer;

/**
 * Calls the C++ BaseClass() native method
 */
public class BaseClass {
    /**
	 * A numeric value that represents the pointer used to access the wrapped object.
	 *
	 * This value should not be changed by the user and is automatically initialized by the _init
	 * or when used as a return value from another method.
	 */
    protected long pointer;

    protected BaseClass(BaseClass dummy) {
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
     * Calls the C++ fromNonvirtualBase() native method
     */
    public native void fromNonvirtualBase();
}