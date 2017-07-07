
#include "Allogen/Example/ExampleClass.hpp"

namespace Allogen::Example {

    /// A simple test class that shows how Allogen can bridge C++
    /// classes into another target language.
    /// Comments on this file are automatically appended into the generated
    /// code as documentation strings.
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

    }

}