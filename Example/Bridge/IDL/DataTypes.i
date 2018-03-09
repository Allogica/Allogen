namespace Allogen { namespace Example {
    class DataTypes {
        #include "Allogen/Example/DataTypes.hpp"

        constructor();
        destructor();

        string getString();
        void setString(str: string);

        optional<DummyClass> getEmptyOptional();
        optional<DummyClass> getOptionalWithValue();

        // void setOptional(value: optional<DummyClass>);

        shared_ptr<DummyClass> getSharedPtr();
        void setSharedPtr(ptr: shared_ptr<DummyClass>);

        vector<string> getVector();
        void setVector(vec: vector<string>);

        map<string, string> getMap();
        void setMap(m: map<string, string>);

        buffer getBuffer();
        // void setBuffer(b: buffer);

        date getDate();
        void setDate(date: date);

        void doAsyncWithString(
            theCallback: lambda<void(
                result: string
            )>
        );

        void doAsyncWithOptional(
            theCallback: lambda<void(
                error: optional<uint32>,
                result: optional<string>
            )>
        );

        void doAsyncWithVector(
            theCallback: lambda<void(
                result: vector<string>
            )>
        );

        void doAsyncWithMap(
            theCallback: lambda<void(
                result: map<string, string>
            )>
        );

        void doAsyncWithBuffer(
            theCallback: lambda<void(
                result: buffer
            )>
        );

        void doAsyncWithDate(
            theCallback: lambda<void(
                result: date
            )>
        );

        void doAsyncAndReturnString(
            theCallback: lambda<string()>
        );

/*
        void doAsyncAndReturnOptional(
            theCallback: lambda<optional<string>()>
        );

        void doAsyncAndReturnVector(
            theCallback: lambda<vector<string>()>
        );

        void doAsyncAndReturnMap(
            theCallback: lambda<map<string, string>()>
        );

        void doAsyncAndReturnBuffer(
            theCallback: lambda<buffer()>
        );
*/

        void doAsyncAndReturnDate(
            theCallback: lambda<date()>
        );

    }

    class DummyClass {
        #include "Allogen/Example/DataTypes.hpp"

    }

}}