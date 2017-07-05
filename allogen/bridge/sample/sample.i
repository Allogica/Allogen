import "FileProvider.i"

def cppexport "JUICE_EXPORT"
def objcnullable true

@Java(package="com.allogica.allogen.tests")
@ObjectiveC(prefix="AGT")
namespace Allogen::Tests {

    class Test1 {
        constructor(a: int = 10) {
            return new Test1(a);
        }

        destructor() {
            delete self;
        }

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
        @Async
        @Export(export=true)
        Provider::OpenFileProviderOperation::Promise? open(
            path: FilePath
        );
    }

    class Test2 extends Test1 implements FileProvider {
        void call2(p1: string, p2: int?)
    }

}