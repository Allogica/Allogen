/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 * 
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

package allogen.example;

/**
 * A simple test class that shows how Allogen can bridge C++
 * classes into another target language.
 * Comments on this file are automatically appended into the generated
 * code as documentation strings.
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
	 * Creates a new ExampleClass object with the default value of 0.
	 */
	public ExampleClass() {
		pointer = this._init();
	}

	/**
	 * Creates a new ExampleClass with the given value
	 * 
	 * @param initialValue The initial value to set the integer to
	 */
	public ExampleClass(int initialValue) {
		pointer = this._init(initialValue);
	}

	/**
	 * This method performs the object creation. This method should only be called
	 * from the object constructor.
	 * 
	 * @param initialValue The initial value to set the integer to
	 */
	private native long _init(int initialValue);

	/**
	 * This method performs the object creation. This method should only be called
	 * from the object constructor.
	 */
	private native long _init();

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
	 * Sets a integer that can later be retrieved
	 * 
	 * @param aInteger The integer to be set
	 */
	public native void setInteger(int aInteger);

	/**
	 * The previously set integer
	 */
	public native int getInteger();

	/**
	 * Creates a copy of the object
	 */
	public native ExampleClass copy();

	/**
	 * Performs a async task
	 * 
	 * @param callback The callback function
	 */
	public native void doAsync(AsyncTaskCallback callback);

	/**
	 * Executes a callback function returning a integer with two integer arguments
	 * 
	 * @param callback The callback function
	 */
	public native int anotherCallback(AsyncTaskCallback2 callback);

	/**
	 * Executes a callback function returning a integer with two integer arguments.
	 * This callback does not have a corresponding implementation in the native C++
	 * ExampleClass class.
	 * 
	 * @param callback The callback function
	 * @param a The "a" integer
	 * @param b The "b" integer
	 */
	public native int virtualCallback(AsyncTaskCallback2 callback, int a, int b);

	/**
	 * 
	 * 
	 * @param name 
	 */
	public native void sayHello(String name);

	/**
	 * 
	 * 
	 * @param name 
	 */
	public native AnotherClass createAnother(String name);

	/**
	 * 
	 * 
	 * @param name 
	 * @param callback 
	 */
	public native void createAnotherAsync(String name, CreateAnotherAsyncCallback callback);

	/**
	 * 
	 * 
	 * @param another 
	 */
	public native void printAnother(AnotherClass another);

	/**
	 * 
	 * 
	 * @param another 
	 * @param callback 
	 */
	public native void printAnotherAsync(AnotherClass another, PrintAnotherAsyncCallback callback);

}
