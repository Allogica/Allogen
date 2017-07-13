/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

package allogen.example;

/**
 * 
 */
public class AnotherClass {
	/**
	 * A numeric value that represents the pointer used to access the wrapped object.
	 * 
	 * This value should not be changed by the user and is automatically initialized by the _init
	 * or when used as a return value from another method.
	 */
	private long pointer;

	/**
	 * 
	 * 
	 * @param parent 
	 * @param sub 
	 */
	public AnotherClass(AnotherClass parent, String sub) {
		pointer = this._init(parent, sub);
	}

	/**
	 * 
	 * 
	 * @param str 
	 */
	public AnotherClass(String str) {
		pointer = this._init(str);
	}

	/**
	 * This method performs the object creation. This method should only be called
	 * from the object constructor.
	 * 
	 * @param str 
	 */
	private native long _init(String str);

	/**
	 * This method performs the object creation. This method should only be called
	 * from the object constructor.
	 * 
	 * @param parent 
	 * @param sub 
	 */
	private native long _init(AnotherClass parent, String sub);

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
	 * 
	 */
	public native String getName();

	/**
	 * 
	 * 
	 * @param newName 
	 */
	public native void setName(String newName);

}
