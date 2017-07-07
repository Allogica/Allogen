import "FileProvider.i"

def cppexport "JUICE_EXPORT"
def objcnullable true

@Java(package="com.allogica.allogen.tests")
@ObjectiveC(prefix="AGT")
namespace Allogen::Tests {

    /// The Test1 class bridge interface
    class Test1 {
        /// Creates a new Test1 object
        constructor(
            /// The objects "a" parameter
            a: int = 10
        ) {
            return new Test1(a);
        }

        /// Destroys the object.
        destructor() {
            delete self;
        }

        /// Executes a remote operation call
        void call() {
            if(true) {
                return 10;
            }
            while(true) doIt();
        }
    }

    /// Hello
    /// Again. Testing
    class FileManager {
        /// Opens a file.
        @Async
        @Export(export=true)
        Provider::OpenFileProviderOperation::Promise? open(
            /// The path of the file to be opened
            path: FilePath
        );
    }

    /// The Test2 class bridge interface
    class Test2 extends Test1 implements FileProvider {
        /// Calls a function!
        void call2(
            /// The functions p1 parameter
            p1: string,

            /// The functions p2 parameter
            p2: uint8_t?
        )
    }

}