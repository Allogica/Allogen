IDL Specification
=================

The IDL language is very similar to C++ code but differs slightly in some syntax
to be able to express more cleanly or more details that are required for other
languages.

Classes
-------

Classes are the main structure that must be declared in a IDL file. Differently
from C++, Allogen interfaces do not allow free functions (because languages such
as Java do not support them). A workaround for free functions can be made by
using `static` classes.

A class is declared using the `class` keyword and have a body of zero or more
constructors, a single destructor and zero or more methods.

.. code::
    /// This class does something cool!
    class MyClass {
        /// Creates a new empty `MyClass` object
        constructor()

        /// Destroys the object and release it's resources
        destructor()

        /// Do something cool!
        void doSomethingCool()
    }

Methods
-------

Methods in Allogen IDL files uniquely map a C++ class member function into
a method in the target language.

By default, methods without a body will have a implementation automatically
generated for them. The default implementation assumes the C++ member function
has the same name as the IDL method name and with the same arguments order. For
example, given a method `doSomethingTo` with a single argument named `name` of
type `string`. The two IDL declarations are equivalent.

.. code::
    void doSomethingTo(name: string)

.. code::
    void doSomethingTo(name: string) {
        return wself->doSomething(name);
    }

In the second example, note the use of `wself`, this is similar to a `this`
pointer in C++ that corresponds to a pointer to the native C++ object. This
pointer allows great flexibility when implementing custom bridged methods.

Methods can also have annotations that might change their behaviour. For
example, when compiling a IDL file with a Objective-C target, a annotation
of type `@Getter` will automatically create a `@property` in Objective-C code.

.. code::
    class GetterExample {
        /// Returns the name!
        @Getter(property="name")
        string getName()
    }

Given this snippet above of IDL code, the compiler (when targeting Objective-C),
will generate the following statement:

.. code::
    @interface ADGetterExample

    /** Returns the name! **/
    @property (readonly, getter=getName) NSString* name;

    /** Returns the name! **/
    -(NSString*)getName;

    @end

Given the same IDL input to a target language that does not have the concept of
a property, the annotation is simply ignored.

For a complete list of possible annotations, their behaviours and requirements,
see Method Annotations.

Constructors
------------

Constructors behave very similar to methods, but they **do not** have a `wself`
pointer and must return the constructed object.

.. code::
    class ConstructorExample {
        constructor(name: string, age: uint8) {
            return new ConstructorExample(name, age);
        }
    }

As you can see, `operator new` is used to create this object. Since many
languages require object to be allocated on the heap, Allogen will allocate all
bridged objects on the heap. However, a constructor *can* return a object by
value, but the runtime support library will automatically move or copy that
object into a heap allocated instance.

.. code::
    class ConstructorExample {
        constructor(name: string, age: uint8) {
            return ConstructorExample(name, age); // note the lack of `new`
            // the Allogen support library will automatically create a new
            // instance on the heap, but the bridge author does not need to
            // worry about that.
        }
    }

If no constructor is declared, the compiler will assume this object cannot be
constructed from bridged code and will not issue any constructor (not even a
default/no-argument constructor). This implies that the object can only be
created from native C++ code and returned from a native method.

Destructors
-----------

Destructors are rarely necessary in most cases, but they can be useful when if
the constructor does not actually create the object which means the destructor
also must not destroy the object. In these cases a no-op destructor is very
useful.

If no destructor is declared, the compiler will automatically create one.

Namespaces
----------

Allogen also support namespaces. In fact, namespaces are *required* if they are
used in C++. The namespaces in Allogen must match the namespace structure
in C++ in order for the compiler to be able generate the correct code.

In languages where the concept of namespaces are supported, such as Java (with
packages), the namespace structure is mapped directly into the bridged language.
For example, a C++ namespace `Allogen::Example` will be mapped into
`allogen.example` in Java. The Java backend also supports a prefix package to be
added such that the output can be prefixed which a custom package if required.

Types
-----

Allogen natively supports numeric types such as *fixed size* integers, floats,
doubles, bool, strings, vectors, lists, maps and optionals.

 - *Fixed size* integers: a fixed integer with N bits (where N is 8, 16, 32 or
   64) by using uintN for unsigned types or intN for signed types.
 - float/double
 - bool
 - string: strings are automatically converted back and from the bridged
   language string type. All strings as UTF-8.
 - vector: `std::vector<T>` objects are converted to the standard vector object
   in the bridged language.
 - buffer: buffer types are treated as vector<char> in C++. If the target
   language has the concept of a buffer (such as `ByteBuffer` in Java or
   `NSData` in Objective-C) the type is mapped to it.
 - list: `std::list<T>` objects are converted to the standard list object
   in the bridged language.
 - map: `std::map<K, V>` objects are converted to the standard map object
   in the bridged language.
 - optional: `std::optional<T>` are not supported by all backends. Where
   supported, the bridged language is annotated with a nullability flag (
   such as `_Nullable`/`_Nonnull` in Objective-C).
 - date: maps to a `std::system_clock::time_point` in C++ and the bridged Date
   type supported by the target language. If not supported, maps to a integer
   representing the number of seconds elapsed since Epoch.
 - function: in C++ maps to `std::function` objects, in IDL it is declared using
   the special lambda syntax (`void(arg1: int, arg2: int)`) and in the target
   language is mapped into the supported lambda type. If the target does not
   natively supports lambdas, like Java, it is mapped into a interface/
   abstract class.
