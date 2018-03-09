//
// Created by Rogiel Sulzbach on 2/1/18.
//

#pragma once

#include <string>
#include <experimental/optional>
#include <memory>
#include <vector>
#include <map>
#include <chrono>

namespace Allogen { namespace Example {

    class DummyClass;

    class DataTypes {
    public:
        DataTypes();
        ~DataTypes();

    public:
        std::string getString();
        void setString(std::string str);

        std::experimental::optional<DummyClass> getEmptyOptional();
        std::experimental::optional<DummyClass> getOptionalWithValue();
        void setOptional(std::experimental::optional<DummyClass> opt);

        std::shared_ptr<DummyClass> getSharedPtr();
        void setSharedPtr(std::shared_ptr<DummyClass> ptr);

        std::vector<std::string> getVector();
        void setVector(std::vector<std::string> vec);

        std::map<std::string, std::string> getMap();
        void setMap(std::map<std::string, std::string> map);

        std::vector<unsigned char> getBuffer();
        void setBuffer(std::vector<unsigned char> buffer);

        std::chrono::system_clock::time_point getDate();
        void setDate(std::chrono::system_clock::time_point date);

        void doAsyncWithString(std::function<void(std::string)> theCallback);
        void doAsyncWithOptional(std::function<void(std::experimental::optional<uint32_t>,
                                                    std::experimental::optional<std::string>)> theCallback);
        void doAsyncWithVector(std::function<void(std::vector<std::string>)> theCallback);
        void doAsyncWithMap(std::function<void(std::map<std::string, std::string>)> theCallback);
        void doAsyncWithBuffer(std::function<void(std::vector<unsigned char>)> theCallback);
        void doAsyncWithDate(std::function<void(std::chrono::system_clock::time_point)> theCallback);

        void doAsyncAndReturnString(std::function<std::string()> theCallback);
        void doAsyncAndReturnOptional(std::function<std::experimental::optional<std::string>()> theCallback);
        void doAsyncAndReturnVector(std::function<std::vector<std::string>()> theCallback);
        void doAsyncAndReturnMap(std::function<std::map<std::string, std::string>()> theCallback);
        void doAsyncAndReturnBuffer(std::function<std::vector<unsigned char>()> theCallback);
        void doAsyncAndReturnDate(std::function<std::chrono::system_clock::time_point()> theCallback);
    };

    class DummyClass {

    };

}}
