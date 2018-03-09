/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

using System;
using System.Runtime.InteropServices;


namespace Allogen.Example {
    /**
     * Calls the C++ DummyClass() native method
     */
    public class DummyClass {
        /**
         * A numeric value that represents the pointer used to access the wrapped object.
         *
         * This value should not be changed by the user and is automatically initialized by the _init
         * or when used as a return value from another method.
         */
        internal IntPtr Pointer;

        public DummyClass(IntPtr pointer) {
            Pointer = pointer;
        }

        /**
         * This method deletes the wrapped C++ object. This method should
         * not be called directly by the user, but must be called by the GC.
         *
         * Note that since Java does not require the GC to call finalize() at all
         * it is recommended to not wrap any RAII objects that could lock or unlock
         * resources that are system wide.
         */
        ~DummyClass() {
            AllogenPInvoke.Destructor(Pointer);
        }


        private struct AllogenPInvoke {
            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DummyClass_Destructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern void Destructor(IntPtr pointer);

        }
    }
}