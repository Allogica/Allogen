//
// Created by Rogiel Sulzbach on 2/1/18.
//

#include "DataTypes.hpp"

#include <iostream>

namespace Allogen { namespace Example {

    DataTypes::DataTypes() = default;
    DataTypes::~DataTypes() = default;

    std::string DataTypes::getString() {
        return "Hello from C++ world";
    }

    void DataTypes::setString(std::string str) {
        std::cout << "[C++] setString(" << str << ")" << std::endl;
    }

    std::experimental::optional<DummyClass> DataTypes::getEmptyOptional() {
        return {};
    }

    std::experimental::optional<DummyClass> DataTypes::getOptionalWithValue() {
        return DummyClass();
    }

    void DataTypes::setOptional(std::experimental::optional<DummyClass> opt) {

    }

    std::shared_ptr<DummyClass> DataTypes::getSharedPtr() {
        return std::make_shared<DummyClass>();
    }

    void DataTypes::setSharedPtr(std::shared_ptr<DummyClass> ptr) {

    }

    std::vector<std::string> DataTypes::getVector() {
        return {
                "String1", "String2",
                "String3", "String4",
        };
    }

    void DataTypes::setVector(std::vector<std::string> vec) {
        for(auto entry : vec) {
            std::cout << entry << std::endl;
        }
    }

    std::map<std::string, std::string> DataTypes::getMap() {
        return {
                {"Name", "Allogen"},
                {"Language", "Java and C++"}
        };
    }

    void DataTypes::setMap(std::map<std::string, std::string> map) {

    }

    std::vector<unsigned char> DataTypes::getBuffer() {
        std::vector<unsigned char> buffer;
        buffer.resize(256);
        for(int i = 0; i<256; i++) {
            buffer[i] = (unsigned char) i;
        }
        return buffer;
    }

    void DataTypes::setBuffer(std::vector<unsigned char> buffer) {

    }

    std::chrono::system_clock::time_point DataTypes::getDate() {
        return std::chrono::system_clock::now() - std::chrono::hours(1);
    }

    void DataTypes::setDate(std::chrono::system_clock::time_point date) {
        std::cout << "[C++] setDate(" << date.time_since_epoch().count() << ")" << std::endl;
    }

    void DataTypes::doAsyncWithString(std::function<void(std::string)> theCallback) {
        theCallback(getString());
    }

    void DataTypes::doAsyncWithOptional(std::function<void(std::experimental::optional<uint32_t>,
                                                           std::experimental::optional<std::string>)> theCallback) {
        theCallback({}, getString());
        theCallback({34}, {});
    }

    void DataTypes::doAsyncWithVector(std::function<void(std::vector<std::string>)> theCallback) {
        theCallback(getVector());
    }

    void DataTypes::doAsyncWithMap(std::function<void(std::map<std::string, std::string>)> theCallback) {
        theCallback(getMap());
    }

    void DataTypes::doAsyncWithBuffer(std::function<void(std::vector<unsigned char>)> theCallback) {
        theCallback(getBuffer());
    }

    void DataTypes::doAsyncWithDate(std::function<void(std::chrono::system_clock::time_point)> theCallback) {
        theCallback(getDate());
    }

    void DataTypes::doAsyncAndReturnString(std::function<std::string()> theCallback) {
        setString(theCallback());
    }

    void DataTypes::doAsyncAndReturnOptional(std::function<std::experimental::optional<std::string>()> theCallback) {
        theCallback();
    }

    void DataTypes::doAsyncAndReturnVector(std::function<std::vector<std::string>()> theCallback) {
        setVector(theCallback());
    }

    void DataTypes::doAsyncAndReturnMap(std::function<std::map<std::string, std::string>()> theCallback) {
        setMap(theCallback());
    }

    void DataTypes::doAsyncAndReturnBuffer(std::function<std::vector<unsigned char>()> theCallback) {
        setBuffer(theCallback());
    }

    void DataTypes::doAsyncAndReturnDate(std::function<std::chrono::system_clock::time_point()> theCallback) {
        setDate(theCallback());
    }

}}