/*
 * THIS FILE WAS AUTOMATICALLY GENERATED. DO NOT CHANGE IT!
 *
 * This file was generated using the Allogen bridge tool. If
 * you wish to make changes to it, you must edit the original
 * interface declaration file and regenerate the bridge code.
 */

using System;
using System.Runtime.InteropServices;

using Allogen.Example;


namespace Allogen.Example {
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
        protected IntPtr Pointer;

        public AnotherClass(IntPtr pointer) {
            Pointer = pointer;
        }

        /**
         * Calls the C++ (Allogen::Example::AnotherClass, std::string) native method
         *
         * @param parent the parent parameter
         * @param sub the sub parameter
         */
        public AnotherClass([MarshalAs(UnmanagedType. CustomMarshaler, MarshalTypeRef=typeof(AnotherClass.Marshaller))] AnotherClass parent, [MarshalAs(UnmanagedType.BStr)] string sub) {
            Pointer = AllogenPInvoke.Constructor(parent, sub);
        }


        /**
         * Calls the C++ (std::string) native method
         *
         * @param str the str parameter
         */
        public AnotherClass([MarshalAs(UnmanagedType.BStr)] string str) {
            Pointer = AllogenPInvoke.Constructor(str);
        }
         
        /**
         * This method deletes the wrapped C++ object. This method should
         * not be called directly by the user, but must be called by the GC.
         *
         * Note that since Java does not require the GC to call finalize() at all
         * it is recommended to not wrap any RAII objects that could lock or unlock
         * resources that are system wide.
         */
        ~AnotherClass() {
            AllogenPInvoke.Destructor(Pointer);
        }

        /**
         * Calls the C++ getName() native method
         */
        public virtual string GetName() {
            return AllogenPInvoke.GetName(Pointer);
        }


        /**
         * Calls the C++ setName(std::string) native method
         *
         * @param newName the newName parameter
         */
        public virtual void SetName([MarshalAs(UnmanagedType.BStr)] string newName) {

            AllogenPInvoke.SetName(Pointer, newName);
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
                EntryPoint = "Allogen_Example_AnotherClass_Constructor_parent_sub",
                CallingConvention = CallingConvention.StdCall)]
            public static extern IntPtr Constructor([MarshalAs(UnmanagedType. CustomMarshaler, MarshalTypeRef=typeof(AnotherClass.Marshaller))] AnotherClass parent, [MarshalAs(UnmanagedType.BStr)] string sub);


            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_AnotherClass_Constructor_str",
                CallingConvention = CallingConvention.StdCall)]
            public static extern IntPtr Constructor([MarshalAs(UnmanagedType.BStr)] string str);
             
            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_AnotherClass_Destructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern void Destructor(IntPtr pointer);

            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_AnotherClass_getName",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            [return: MarshalAs(UnmanagedType.BStr)]
            public static extern string GetName(
                IntPtr pointer
            );


            [DllImport(LibraryName,
                EntryPoint = "Allogen_Example_AnotherClass_setName",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]

            public static extern void SetName(
                IntPtr pointer, 
                [MarshalAs(UnmanagedType.BStr)] string newName
            );

        }

        public class Marshaller : ICustomMarshaler
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
                return ((AnotherClass) managedObj)?.Pointer ?? IntPtr.Zero;
            }

            public object MarshalNativeToManaged(IntPtr nativeData)
            {
                return nativeData.ToInt64() == 0 ? null : new AnotherClass(nativeData);
            }

            private static readonly Marshaller Shared = new Marshaller();

            public static ICustomMarshaler GetInstance(string cookie)
            {
                return Shared;
            }
        }
    }
}