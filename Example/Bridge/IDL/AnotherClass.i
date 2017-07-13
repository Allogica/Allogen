
#include "Allogen/Example/AnotherClass.hpp"

namespace Allogen::Example {
    class AnotherClass {
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
}