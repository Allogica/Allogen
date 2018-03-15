/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

using System;
using System.Runtime.InteropServices;

using Allogen.Example.Inheritance;


namespace Allogen.Example.Inheritance {
    /**
     * Calls the C++ SubClass2() native method
     */
    public class SubClass2 : Allogen.Example.Inheritance.BaseClass {
        public SubClass2(IntPtr pointer) : base(pointer) {
            Pointer = pointer;
        }

        /**
         * Calls the C++ () native method
         */
        public SubClass2() : base(IntPtr.Zero) {
            Pointer = AllogenPInvoke.Constructor();
        }
         
        /**
         * This method deletes the wrapped C++ object. This method should
         * not be called directly by the user, but must be called by the GC.
         *
         * Note that since Java does not require the GC to call finalize() at all
         * it is recommended to not wrap any RAII objects that could lock or unlock
         * resources that are system wide.
         */
        ~SubClass2() {
            AllogenPInvoke.Destructor(Pointer);
        }

        /**
         * Calls the C++ doInSubclass2() native method
         */
        public virtual void DoInSubclass2() {
            AllogenPInvoke.DoInSubclass2(Pointer);
        }

        /**
         * Calls the C++ getName() native method
         */
        public override string GetName() {
            return AllogenPInvoke.GetName(Pointer);
        }


        /**
         * Calls the C++ fromNonvirtualBase() native method
         */
        public override void FromNonvirtualBase() {
            AllogenPInvoke.FromNonvirtualBase(Pointer);
        }


        private struct AllogenPInvoke {
            /// 
            /// The native Interop library name
            /// 
            #if DEBUG
            private const string LibraryName = "d.dll";
            #else
            private const string LibraryName = ".dll";
            #endif

            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_Inheritance_SubClass2_Constructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern IntPtr Constructor();
             
            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_Inheritance_SubClass2_Destructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern void Destructor(IntPtr pointer);

            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_Inheritance_SubClass2_doInSubclass2",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]

            public static extern void DoInSubclass2(
                IntPtr pointer
            );

            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_Inheritance_SubClass2_getName",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            [return: MarshalAs(UnmanagedType.BStr)]
            public static extern string GetName(
                IntPtr pointer
            );


            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_Inheritance_SubClass2_fromNonvirtualBase",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]

            public static extern void FromNonvirtualBase(
                IntPtr pointer
            );

        }

        public new class Marshaller : ICustomMarshaler
        {
            public void CleanUpManagedData(object managedObj)
            {

            }

            public void CleanUpNativeData(IntPtr nativeData)
            {

            }

            public int GetNativeDataSize()
            {
                return IntPtr.Size;
            }

            public IntPtr MarshalManagedToNative(object managedObj)
            {
                return ((SubClass2) managedObj)?.Pointer ?? IntPtr.Zero;
            }

            public object MarshalNativeToManaged(IntPtr nativeData)
            {
                return nativeData.ToInt64() == 0 ? null : new SubClass2(nativeData);
            }

            private static readonly Marshaller Shared = new Marshaller();

            public static ICustomMarshaler GetInstance(string cookie)
            {
                return Shared;
            }
        }
    }
}