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
 * Calls the C++ DataTypes() native method
 */
public class DataTypes {
    /**
	 * A numeric value that represents the pointer used to access the wrapped object.
	 *
	 * This value should not be changed by the user and is automatically initialized by the _init
	 * or when used as a return value from another method.
	 */
    protected long pointer;

    /**
     * Calls the C++ () native method
     */
    public DataTypes() {
        pointer = this._init();
    }

    /**
     * This method performs the object creation. This method should only be called
     * from the object constructor.
     *
     * @return a pointer to the C++ native object
     */
    private native long _init(); 
    protected DataTypes(DataTypes dummy) {
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
     * Calls the C++ getString() native method
     */
    public native String getString();


    /**
     * Calls the C++ setString(std::string) native method
     *
     * @param str the str parameter
     */
    public native void setString(String str);


    /**
     * Calls the C++ getEmptyOptional() native method
     */
    public native allogen.example.DummyClass getEmptyOptional();


    /**
     * Calls the C++ getOptionalWithValue() native method
     */
    public native allogen.example.DummyClass getOptionalWithValue();


    /**
     * Calls the C++ getSharedPtr() native method
     */
    public native allogen.example.DummyClass getSharedPtr();


    /**
     * Calls the C++ getVector() native method
     */
    public native List<String> getVector();


    /**
     * Calls the C++ setVector(std::vector<std::string> ) native method
     *
     * @param vec the vec parameter
     */
    public native void setVector(List<String> vec);


    /**
     * Calls the C++ getMap() native method
     */
    public native Map<String, String> getMap();


    /**
     * Calls the C++ getBuffer() native method
     */
    public native ByteBuffer getBuffer();


    /**
     * Calls the C++ getDate() native method
     */
    public native Date getDate();

    public interface DoAsyncWithStringTheCallback {
        void onTheCallback(String result);
    }
    /**
     * Calls the C++ doAsyncWithString(std::function<void(std::string)> ) native method
     *
     * @param theCallback the theCallback parameter
     */
    public native void doAsyncWithString(DoAsyncWithStringTheCallback theCallback);

    public interface DoAsyncWithOptionalTheCallback {
        void onTheCallback(int error, String result);
    }
    /**
     * Calls the C++ doAsyncWithOptional(std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )> ) native method
     *
     * @param theCallback the theCallback parameter
     */
    public native void doAsyncWithOptional(DoAsyncWithOptionalTheCallback theCallback);

    public interface DoAsyncWithVectorTheCallback {
        void onTheCallback(List<String> result);
    }
    /**
     * Calls the C++ doAsyncWithVector(std::function<void(std::vector<std::string> )> ) native method
     *
     * @param theCallback the theCallback parameter
     */
    public native void doAsyncWithVector(DoAsyncWithVectorTheCallback theCallback);

    public interface DoAsyncWithMapTheCallback {
        void onTheCallback(Map<String, String> result);
    }
    /**
     * Calls the C++ doAsyncWithMap(std::function<void(std::map<std::string, std::string> )> ) native method
     *
     * @param theCallback the theCallback parameter
     */
    public native void doAsyncWithMap(DoAsyncWithMapTheCallback theCallback);

    public interface DoAsyncWithBufferTheCallback {
        void onTheCallback(ByteBuffer result);
    }
    /**
     * Calls the C++ doAsyncWithBuffer(std::function<void(std::vector<uint8_t>)> ) native method
     *
     * @param theCallback the theCallback parameter
     */
    public native void doAsyncWithBuffer(DoAsyncWithBufferTheCallback theCallback);

    public interface DoAsyncWithDateTheCallback {
        void onTheCallback(Date result);
    }
    /**
     * Calls the C++ doAsyncWithDate(std::function<void(std::chrono::system_clock::time_point)> ) native method
     *
     * @param theCallback the theCallback parameter
     */
    public native void doAsyncWithDate(DoAsyncWithDateTheCallback theCallback);
}