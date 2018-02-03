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
     * Calls the C++ ExampleClass() native method
     */
    public class ExampleClass {
        /**
         * A numeric value that represents the pointer used to access the wrapped object.
         *
         * This value should not be changed by the user and is automatically initialized by the _init
         * or when used as a return value from another method.
         */
        internal IntPtr Pointer;

        public int aInteger {
        get => GetInteger();
        set => SetInteger(value);
        }

        public ExampleClass(IntPtr pointer) {
            Pointer = pointer;
        }

        /**
         * Calls the C++ () native method
         */
        public ExampleClass() {
            Pointer = AllogenPInvoke.Constructor();
        }

        /**
         * Calls the C++ (uint32_t) native method
         *
         * @param initialValue the initialValue parameter
         */
        public ExampleClass(int initialValue) {
            Pointer = AllogenPInvoke.Constructor(initialValue);
        } 
        /**
         * This method deletes the wrapped C++ object. This method should
         * not be called directly by the user, but must be called by the GC.
         *
         * Note that since Java does not require the GC to call finalize() at all
         * it is recommended to not wrap any RAII objects that could lock or unlock
         * resources that are system wide.
         */
        ~ExampleClass() {
            AllogenPInvoke.Destructor(Pointer);
        }

        /**
         * Calls the C++ setInteger(uint32_t) native method
         *
         * @param aInteger the aInteger parameter
         */
        public void SetInteger(int aInteger) {

            AllogenPInvoke.SetInteger(Pointer, aInteger);
        }


        /**
         * Calls the C++ getInteger() native method
         */
        public int GetInteger() {
            return AllogenPInvoke.GetInteger(Pointer);
        }


        /**
         * Calls the C++ copy() native method
         */
        public ExampleClass Copy() {
            return new ExampleClass(AllogenPInvoke.Copy(Pointer));
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void AsyncTaskCallback();
        /**
         * Calls the C++ doAsync(std::function<void()> ) native method
         *
         * @param callback the callback parameter
         */
        public void DoAsync(AsyncTaskCallback callback) {

            AllogenPInvoke.DoAsync(Pointer, callback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate int AsyncTaskCallback2(short a, short b);
        /**
         * Calls the C++ anotherCallback(std::function<uint32_t(uint16_t, uint16_t)> ) native method
         *
         * @param callback the callback parameter
         */
        public int AnotherCallback(AsyncTaskCallback2 callback) {

            return AllogenPInvoke.AnotherCallback(Pointer, callback);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate int AsyncTaskCallback3(short a, short b);
        /**
         * Calls the C++ virtualCallback(std::function<uint32_t(uint16_t, uint16_t)> , uint16_t, uint16_t) native method
         *
         * @param callback the callback parameter
         * @param a the a parameter
         * @param b the b parameter
         */
        public int VirtualCallback(AsyncTaskCallback3 callback, short a, short b) {

            return AllogenPInvoke.VirtualCallback(Pointer, callback, a, b);
        }


        /**
         * Calls the C++ testingIfs(uint16_t) native method
         *
         * @param a the a parameter
         */
        public int TestingIfs(short a) {

            return AllogenPInvoke.TestingIfs(Pointer, a);
        }


        /**
         * Calls the C++ sayHello(std::string) native method
         *
         * @param name the name parameter
         */
        public void SayHello(string name) {

            AllogenPInvoke.SayHello(Pointer, name);
        }


        /**
         * Calls the C++ createAnother(std::string) native method
         *
         * @param name the name parameter
         */
        public AnotherClass CreateAnother(string name) {

            return new AnotherClass(AllogenPInvoke.CreateAnother(Pointer, name));
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void CreateAnotherAsyncCallback(AnotherClass another);
        /**
         * Calls the C++ createAnotherAsync(std::string, std::function<void(Allogen::Example::AnotherClass)> ) native method
         *
         * @param name the name parameter
         * @param callback the callback parameter
         */
        public void CreateAnotherAsync(string name, CreateAnotherAsyncCallback callback) {

            AllogenPInvoke.CreateAnotherAsync(Pointer, name, callback);
        }


        /**
         * Calls the C++ printAnother(Allogen::Example::AnotherClass) native method
         *
         * @param another the another parameter
         */
        public void PrintAnother(AnotherClass another) {

            AllogenPInvoke.PrintAnother(Pointer, another.Pointer);
        }


        [UnmanagedFunctionPointer(CallingConvention.StdCall,
            CharSet=CharSet.Ansi)]
        public delegate void PrintAnotherAsyncCallback();
        /**
         * Calls the C++ printAnotherAsync(Allogen::Example::AnotherClass, std::function<void()> ) native method
         *
         * @param another the another parameter
         * @param callback the callback parameter
         */
        public void PrintAnotherAsync(AnotherClass another, PrintAnotherAsyncCallback callback) {

            AllogenPInvoke.PrintAnotherAsync(Pointer, another.Pointer, callback);
        }


        /**
         * Calls the C++ getStaticInt() native method
         */
        public static int GetStaticInt() {
            return AllogenPInvoke.GetStaticInt();
        }


        /**
         * Calls the C++ shared() native method
         */
        public static ExampleClass Shared() {
            return new ExampleClass(AllogenPInvoke.Shared());
        }


        private struct AllogenPInvoke {
            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_Constructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern IntPtr Constructor();

            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_Constructor_initialValue",
                CallingConvention = CallingConvention.StdCall)]
            public static extern IntPtr Constructor(int initialValue); 
            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_Destructor",
                CallingConvention = CallingConvention.StdCall)]
            public static extern void Destructor(IntPtr pointer);

            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_setInteger",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void SetInteger(
                IntPtr pointer, 
                int aInteger
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_getInteger",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern int GetInteger(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_copy",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern IntPtr Copy(
                IntPtr pointer
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_doAsync",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void DoAsync(
                IntPtr pointer, 
                AsyncTaskCallback callback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_anotherCallback",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern int AnotherCallback(
                IntPtr pointer, 
                AsyncTaskCallback2 callback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_virtualCallback",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern int VirtualCallback(
                IntPtr pointer, 
                AsyncTaskCallback3 callback, short a, short b
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_testingIfs",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern int TestingIfs(
                IntPtr pointer, 
                short a
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_sayHello",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void SayHello(
                IntPtr pointer, 
                string name
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_createAnother",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern IntPtr CreateAnother(
                IntPtr pointer, 
                string name
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_createAnotherAsync",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void CreateAnotherAsync(
                IntPtr pointer, 
                string name, CreateAnotherAsyncCallback callback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_printAnother",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void PrintAnother(
                IntPtr pointer, 
                IntPtr another
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_printAnotherAsync",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern void PrintAnotherAsync(
                IntPtr pointer, 
                IntPtr another, PrintAnotherAsyncCallback callback
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_getStaticInt",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern int GetStaticInt(
            );


            [DllImport("Allogen.Example.Bridge.CSharp",
                EntryPoint = "Allogen_Example_ExampleClass_shared",
                CallingConvention = CallingConvention.StdCall,
                CharSet=CharSet.Ansi)]
            public static extern IntPtr Shared(
            );

        }
    }
}