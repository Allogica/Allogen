namespace Allogen { namespace Example {
    class AnotherClass {
        #include "Allogen/Example/AnotherClass.hpp"

        constructor(
            parent: AnotherClass,
            sub: string
        ) {
            return nullptr;
        }
        constructor(
            str: string
        ) {
            return nullptr;
        }
        destructor();

        string getName();
        void setName(newName: string);

    }
}}