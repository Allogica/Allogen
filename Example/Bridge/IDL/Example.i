
#include "Allogen/Example/ExampleClass.hpp"

namespace Allogen::Example {

    /// A simple test class that shows how Allogen can bridge C++
    /// classes into another target language.
    /// Comments on this file are automatically appended into the generated
    /// code as documentation strings.
    @Copyable
    class ExampleClass {

        /// Creates a new ExampleClass object with the default value of 0.
        constructor();

        /// Creates a new ExampleClass with the given value
        constructor(
            /// The initial value to set the integer to
            initialValue: uint32_t
        ) {
            // Our C++ class does not implement this method. By Using a {} block we
            // can define any code that will be called by the bridge implementation.
            //
            // Note that we must use operator new here, because languages like Java
            // require that objects are allocated on the heap. However, on most
            // cases you can still return by value and the bridge compiler will
            // automatically create copy (or move) the object to a heap allocated
            // instance.
            auto example = new ExampleClass();
            example->setInteger(initialValue);
            return example;
        }

        /// Destroys the object
        destructor();

        /// Sets a integer that can later be retrieved
        void setInteger(
            /// The integer to be set
            aInteger: uint32_t
        );

        /// The previously set integer
        uint32_t getInteger();

        /// Creates a copy of the object
        ExampleClass copy() {
            return ExampleClass(*wself);
        }

        /// Performs a async task
        void doAsync(
            /// The callback function
            @Callback(interface="AsyncTaskCallback", method="onCallback")
            callback: lambda<void()>
        );

        /// Executes a callback function returning a integer with two integer arguments
        uint32_t anotherCallback(
            /// The callback function
            @Callback(interface="AsyncTaskCallback2", method="onCallback")
            callback: lambda<uint32_t(
                /// The "a" integer
                a: uint16_t,

                /// The "b" integer
                b: uint16_t
            )>
        );

        /// Executes a callback function returning a integer with two integer arguments.
        /// This callback does not have a corresponding implementation in the native C++
        /// ExampleClass class.
        uint32_t virtualCallback(
            /// The callback function
            @Callback(interface="AsyncTaskCallback2", method="onCallback")
            callback: lambda<uint32_t(
                /// The "a" integer
                a: uint16_t,

                /// The "b" integer
                b: uint16_t
            )>,

            /// The "a" integer
            a: uint16_t,

            /// The "b" integer
            b: uint16_t
        ) {
            return callback(a, b);
        }

        void sayHello(
            name: string
        );

    }
}