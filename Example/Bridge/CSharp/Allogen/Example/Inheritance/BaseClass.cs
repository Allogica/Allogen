/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

using System;
using System.Runtime.InteropServices;


namespace Allogen.Example.Inheritance {
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
        internal IntPtr Pointer;

        public BaseClass(IntPtr pointer) {
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
        ~BaseClass() {
            AllogenPInvoke.Destructor(Pointer);
        }

        /**
         * Calls the C++ getName() native method
         */
        public virtual string GetName() {
            return AllogenPInvoke.GetName(Pointer);
        }


        /**
         * Calls the C++ fromNonvirtualBase() native method
         */
        public virtual void FromNonvirtualBase() {
            AllogenPInvoke.FromNonvirtualBase(Pointer);
        }


        private struct AllogenPInvoke {
            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_Inheritance_BaseClass_Destructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern void Destructor(IntPtr pointer);

            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_Inheritance_BaseClass_getName",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern string GetName(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_Inheritance_BaseClass_fromNonvirtualBase",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void FromNonvirtualBase(
                IntPtr pointer
            );

        }
    }
}