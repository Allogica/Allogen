namespace Allogen { namespace Example { namespace Inheritance {
    class BaseClass {
        #include "Allogen/Example/Inheritance/Inheritance.hpp"

        string getName();
        void fromNonvirtualBase();

    }

    class SubClass1 extends BaseClass {
        #include "Allogen/Example/Inheritance/Inheritance.hpp"

        constructor();
        void doInSubclass1();
    }

    class SubClass2 extends BaseClass {
        #include "Allogen/Example/Inheritance/Inheritance.hpp"

        constructor();
        void doInSubclass2();
    }

}}}