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
 * Calls the C++ SubClass2() native method
 */
public class SubClass2 extends allogen.example.inheritance.BaseClass {
    /**
     * Calls the C++ () native method
     */
    public SubClass2() {
        super((allogen.example.inheritance.BaseClass) null);
        pointer = this._init();
    }

    /**
     * This method performs the object creation. This method should only be called
     * from the object constructor.
     *
     * @return a pointer to the C++ native object
     */
    private native long _init(); 
    protected SubClass2(SubClass2 dummy) {
        // DO NOT USE THIS CONSTRUCTOR! THIS IS FOR INTERNAL USE ONLY!!!
        super((allogen.example.inheritance.BaseClass) null);
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
     * Calls the C++ doInSubclass2() native method
     */
    public native void doInSubclass2();
    /**
     * Calls the C++ getName() native method
     */
    @Override
    public native String getName();


    /**
     * Calls the C++ fromNonvirtualBase() native method
     */
    @Override
    public native void fromNonvirtualBase();
}