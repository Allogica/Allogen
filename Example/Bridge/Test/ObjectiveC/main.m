#import <Allogen/Example/AEExampleClass.h>

int main(int argc, const char** argv) {
    /*
    AEExampleClass* exampleClass = [[AEExampleClass alloc] init];
    NSLog(@"%@", exampleClass);

    NSLog(@"%i", [exampleClass getInteger]);

    [exampleClass setIntegerWithAInteger: 100];
    NSLog(@"%i", [exampleClass getInteger]);*/


    AEExampleClass* n = [[AEExampleClass alloc] initWithInitialValue: 200];

    {
        AEExampleClass* shared1 = [AEExampleClass shared];
        [shared1 setIntegerWithAInteger: 123];

        AEExampleClass* shared2 = [AEExampleClass shared];
        NSLog(@"%i", [shared2 getInteger]);

        [shared2 setIntegerWithAInteger: 124];
        NSLog(@"%i", [shared1 getInteger]);
    }

    NSLog(@"%i", [AEExampleClass getStaticInt]);

    [n sayHelloWithName: @"Allogen Bridge"];

    [n doAsyncWithCallback: ^() {
        NSLog(@"Done async!!!!");
    }];

    uint32_t r = [n anotherCallbackWithCallback: ^uint32_t (uint16_t a, uint16_t b) {
        return a + b;
    }];
    NSLog(@"%i", r);

    r = [n virtualCallbackWithCallback: ^uint32_t (uint16_t a, uint16_t b) {
        return a + b;
    } a: 100 b: 200];
    NSLog(@"%i", r);

    NSLog(@"Newly constructed");
    NSLog(@"%i", [n getInteger]);

    NSLog(@"Setting to 10000...");
    [n setIntegerWithAInteger: 10000];
    NSLog(@"%i", [n getInteger]);

    NSLog(@"Setting to 200...");
    [n setIntegerWithAInteger: 200];
    NSLog(@"%i", [n getInteger]);

    NSLog(@"Setting copy to 300...");
    AEExampleClass* copy = [n copy];
    [copy setIntegerWithAInteger: 300];

    NSLog(@"Original: %i", [n getInteger]);
    NSLog(@"Copy: %i", [copy getInteger]);

    AEAnotherClass* anotherClass = [n createAnotherWithName: @"Testing"];
    [n printAnotherWithAnother: anotherClass];

/*
            AnotherClass anotherClass = n.createAnother("Testing");
            n.printAnother(anotherClass);

            ExampleClass finalN = n;
            n.createAnotherAsync("Testing2", (AnotherClass another) -> {
                System.out.println("Received a async another: " + another.getName());
                finalN.printAnotherAsync(another, () -> {
                    System.out.println("Printing complete");
                });
            });
            */

}