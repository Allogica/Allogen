## Allogen - Automatic code generation tools

### How it works
Allogen is mostly automatic once you define a interface file. A interface file declares classes and methods that you wish to export in a target language.

```
namespace Allogen { namespace Example {
    /// A simple test class that shows how Allogen can bridge C++
    /// classes into another target language.
    /// Comments on this file are automatically appended into the generated
    /// code as documentation strings.
    class ExampleClass {
        #include "Allogen/Example/ExampleClass.hpp"

        /// Creates a new ExampleClass object with the default value of 0.
        constructor();

        /// Creates a new ExampleClass with the given value
        constructor(
            /// The initial value to set the integer to
            initialValue: uint32
        ) {
            // Our C++ class does not implement this method. By Using a {} block we
            // can define any code that will be called by the bridge implementation.
            //
            // Note that we must use operator new here, because languages like Java
            // require that objects are allocated on the heap. However, on most
            // cases you can still return by value and the bridge compiler will
            // automatically create copy (or move) the object to a heap allocated
            // instance.
            auto example = new Allogen::Example::ExampleClass();
            example->setInteger(initialValue);
            return example;
        }

        /// Destroys the object
        destructor();

        /// Sets a integer that can later be retrieved
        @Setter(property="aInteger")
        void setInteger(
            /// The integer to be set
            aInteger: uint32
        );

        /// The previously set integer
        @Getter(property="aInteger")
        uint32 getInteger();

        /// Creates a copy of the object
        ExampleClass copy() {
            return Allogen::Example::ExampleClass(*wself);
        }

        /// Performs a async task
        void doAsync(
            /// The callback function
            @Callback(interface="AsyncTaskCallback", method="onCallback")
            callback: lambda<void()>
        );

        /// Executes a callback function returning a integer with two integer arguments
        uint32 anotherCallback(
            /// The callback function
            @Callback(interface="AsyncTaskCallback2", method="onCallback")
            callback: lambda<uint32(
                /// The "a" integer
                a: uint16,

                /// The "b" integer
                b: uint16
            )>
        );

        /// Executes a callback function returning a integer with two integer arguments.
        /// This callback does not have a corresponding implementation in the native C++
        /// ExampleClass class.
        uint32 virtualCallback(
            /// The callback function
            @Callback(interface="AsyncTaskCallback3", method="onCallback")
            callback: lambda<uint32(
                /// The "a" integer
                a: uint16,

                /// The "b" integer
                b: uint16
            )>,

            /// The "a" integer
            a: uint16,

            /// The "b" integer
            b: uint16
        ) {
            return callback(a, b);
        }

        uint32 testingIfs(
            a: uint16
        ) {
            if(a < 10) {
                return uint32_t(10);
            } else {
                return uint32_t(a);
            }
        }

        void sayHello(
            name: string
        );

        AnotherClass createAnother(
            name: string
        );

        void createAnotherAsync(
            name: string,
            @Callback(interface="CreateAnotherAsyncCallback", method="createAnother")
            callback: lambda<void(
                /// The created another object
                another: AnotherClass
            )>
        );

        void printAnother(
            another: AnotherClass
        );

        void printAnotherAsync(
            another: AnotherClass,
            @Callback(interface="PrintAnotherAsyncCallback", method="printAnother")
            callback: lambda<void()>
        );

        static uint32 getStaticInt() {
            return 100;
        }

        static ExampleClass shared() {
            static Allogen::Example::ExampleClass shared;
            return &shared;
        }

    }
}}
```
