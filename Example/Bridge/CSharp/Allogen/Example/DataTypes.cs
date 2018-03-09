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
     * Calls the C++ DataTypes() native method
     */
    public class DataTypes {
        /**
         * A numeric value that represents the pointer used to access the wrapped object.
         *
         * This value should not be changed by the user and is automatically initialized by the _init
         * or when used as a return value from another method.
         */
        internal IntPtr Pointer;

        public DataTypes(IntPtr pointer) {
            Pointer = pointer;
        }

        /**
         * Calls the C++ () native method
         */
        public DataTypes() {
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
        ~DataTypes() {
            AllogenPInvoke.Destructor(Pointer);
        }

        /**
         * Calls the C++ getString() native method
         */
        public string GetString() {
            return AllogenPInvoke.GetString(Pointer);
        }


        /**
         * Calls the C++ setString(std::string) native method
         *
         * @param str the str parameter
         */
        public void SetString(string str) {

            AllogenPInvoke.SetString(Pointer, str);
        }


        /**
         * Calls the C++ getEmptyOptional() native method
         */
        public DummyClass GetEmptyOptional() {
            System.IntPtr ptr = AllogenPInvoke.GetEmptyOptional(Pointer);if(ptr.ToInt64() == 0) return null;return new DummyClass(ptr);
        }


        /**
         * Calls the C++ getOptionalWithValue() native method
         */
        public DummyClass GetOptionalWithValue() {
            System.IntPtr ptr = AllogenPInvoke.GetOptionalWithValue(Pointer);if(ptr.ToInt64() == 0) return null;return new DummyClass(ptr);
        }


        /**
         * Calls the C++ getSharedPtr() native method
         */
        public DummyClass GetSharedPtr() {
            System.IntPtr ptr = AllogenPInvoke.GetSharedPtr(Pointer);if(ptr.ToInt64() == 0) return null;return new DummyClass(ptr);
        }


        /**
         * Calls the C++ setSharedPtr(std::shared_ptr<Allogen::Example::DummyClass> ) native method
         *
         * @param ptr the ptr parameter
         */
        public void SetSharedPtr(DummyClass ptr) {

            AllogenPInvoke.SetSharedPtr(Pointer, (ptr != null ? ptr.Pointer : IntPtr.Zero));
        }










        /**
         * Calls the C++ getBuffer() native method
         */
        public System.IO.MemoryStream GetBuffer() {
            AllogenPInvoke.GetBuffer(Pointer, out var csretValue, out _); return new System.IO.MemoryStream(csretValue);
        }


        /**
         * Calls the C++ getDate() native method
         */
        public System.DateTime GetDate() {
            return DateTime.FromFileTime(AllogenPInvoke.GetDate(Pointer));
        }


        /**
         * Calls the C++ setDate(std::chrono::system_clock::time_point) native method
         *
         * @param date the date parameter
         */
        public void SetDate(System.DateTime date) {

            AllogenPInvoke.SetDate(Pointer, date.ToFileTime());
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void DoAsyncWithStringTheCallback(string result);
        /**
         * Calls the C++ doAsyncWithString(std::function<void(std::string)> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncWithString(DoAsyncWithStringTheCallback theCallback) {

            AllogenPInvoke.DoAsyncWithString(Pointer, theCallback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void DoAsyncWithOptionalTheCallback(int error, string result);
        /**
         * Calls the C++ doAsyncWithOptional(std::function<void(std::experimental::optional<uint32_t> , std::experimental::optional<std::string> )> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncWithOptional(DoAsyncWithOptionalTheCallback theCallback) {

            AllogenPInvoke.DoAsyncWithOptional(Pointer, theCallback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void DoAsyncWithVectorTheCallback(System.Collections.Generic.List<string> result);
        /**
         * Calls the C++ doAsyncWithVector(std::function<void(std::vector<std::string> )> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncWithVector(DoAsyncWithVectorTheCallback theCallback) {

            AllogenPInvoke.DoAsyncWithVector(Pointer, theCallback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void DoAsyncWithMapTheCallback(System.Collections.Generic.Dictionary<string, string> result);
        /**
         * Calls the C++ doAsyncWithMap(std::function<void(std::map<std::string, std::string> )> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncWithMap(DoAsyncWithMapTheCallback theCallback) {

            AllogenPInvoke.DoAsyncWithMap(Pointer, theCallback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void DoAsyncWithBufferTheCallback(System.IO.MemoryStream result);
        /**
         * Calls the C++ doAsyncWithBuffer(std::function<void(std::vector<uint8_t>)> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncWithBuffer(DoAsyncWithBufferTheCallback theCallback) {

            AllogenPInvoke.DoAsyncWithBuffer(Pointer, theCallback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void DoAsyncWithDateTheCallback(System.DateTime result);
        /**
         * Calls the C++ doAsyncWithDate(std::function<void(std::chrono::system_clock::time_point)> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncWithDate(DoAsyncWithDateTheCallback theCallback) {

            AllogenPInvoke.DoAsyncWithDate(Pointer, theCallback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate string DoAsyncAndReturnStringTheCallback();
        /**
         * Calls the C++ doAsyncAndReturnString(std::function<std::string()> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncAndReturnString(DoAsyncAndReturnStringTheCallback theCallback) {

            AllogenPInvoke.DoAsyncAndReturnString(Pointer, theCallback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate System.DateTime DoAsyncAndReturnDateTheCallback();
        /**
         * Calls the C++ doAsyncAndReturnDate(std::function<std::chrono::system_clock::time_point()> ) native method
         *
         * @param theCallback the theCallback parameter
         */
        public void DoAsyncAndReturnDate(DoAsyncAndReturnDateTheCallback theCallback) {

            AllogenPInvoke.DoAsyncAndReturnDate(Pointer, theCallback);
        }


        private struct AllogenPInvoke {
            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_Constructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern IntPtr Constructor(); 
            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_Destructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern void Destructor(IntPtr pointer);

            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_getString",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern string GetString(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_setString",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void SetString(
                IntPtr pointer, 
                string str
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_getEmptyOptional",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern IntPtr GetEmptyOptional(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_getOptionalWithValue",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern IntPtr GetOptionalWithValue(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_getSharedPtr",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern IntPtr GetSharedPtr(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_setSharedPtr",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void SetSharedPtr(
                IntPtr pointer, 
                IntPtr ptr
            );










            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_getBuffer",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void GetBuffer(
                IntPtr pointer, 
                [MarshalAs(UnmanagedType.LPArray, SizeParamIndex=2)] out byte[] csretValue, out long csretSize
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_getDate",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern long GetDate(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_setDate",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void SetDate(
                IntPtr pointer, 
                long date
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncWithString",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncWithString(
                IntPtr pointer, 
                DoAsyncWithStringTheCallback theCallback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncWithOptional",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncWithOptional(
                IntPtr pointer, 
                DoAsyncWithOptionalTheCallback theCallback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncWithVector",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncWithVector(
                IntPtr pointer, 
                DoAsyncWithVectorTheCallback theCallback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncWithMap",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncWithMap(
                IntPtr pointer, 
                DoAsyncWithMapTheCallback theCallback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncWithBuffer",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncWithBuffer(
                IntPtr pointer, 
                DoAsyncWithBufferTheCallback theCallback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncWithDate",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncWithDate(
                IntPtr pointer, 
                DoAsyncWithDateTheCallback theCallback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncAndReturnString",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncAndReturnString(
                IntPtr pointer, 
                DoAsyncAndReturnStringTheCallback theCallback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_DataTypes_doAsyncAndReturnDate",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsyncAndReturnDate(
                IntPtr pointer, 
                DoAsyncAndReturnDateTheCallback theCallback
            );

        }
    }
}