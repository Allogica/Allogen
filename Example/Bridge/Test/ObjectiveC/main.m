#import <Allogen/Example/AEExampleClass.h>

int main(int argc, const char** argv) {
    /*
    AEExampleClass* exampleClass = [[AEExampleClass alloc] init];
    NSLog(@"%@", exampleClass);

    NSLog(@"%i", [exampleClass getInteger]);

    [exampleClass setInteger: 100];
    NSLog(@"%i", [exampleClass getInteger]);*/


    AEExampleClass* n = [[AEExampleClass alloc] initWithInitialValue: 200];

    {
        AEExampleClass* shared1 = [AEExampleClass shared];
        [shared1 setInteger: 123];

        AEExampleClass* shared2 = [AEExampleClass shared];
        NSLog(@"%i", [shared2 getInteger]);

        [shared2 setInteger: 124];
        NSLog(@"%i", [shared1 getInteger]);
    }

    NSLog(@"%i", [AEExampleClass getStaticInt]);

    [n sayHello: @"Allogen Bridge"];

    [n doAsync: ^() {
        NSLog(@"Done async!!!!");
    }];

    uint32_t r = [n anotherCallback: ^uint32_t (uint16_t a, uint16_t b) {
        return a + b;
    }];
    NSLog(@"%i", r);

    r = [n virtualCallback: ^uint32_t (uint16_t a, uint16_t b) {
        return a + b;
    } a: 100 b: 200];
    NSLog(@"%i", r);

    NSLog(@"Newly constructed");
    NSLog(@"%i", [n getInteger]);

    NSLog(@"Setting to 10000...");
    [n setInteger: 10000];
    NSLog(@"%i", [n getInteger]);

    NSLog(@"Setting to 200...");
    n.aInteger = 200;
    NSLog(@"%i", n.aInteger);

    NSLog(@"Setting copy to 300...");
    AEExampleClass* copy = [n copy];
    [copy setInteger: 300];

    NSLog(@"Original: %i", [n getInteger]);
    NSLog(@"Copy: %i", [copy getInteger]);

    AEAnotherClass* anotherClass = [n createAnother: @"Testing"];
    [n printAnother: anotherClass];

    [n createAnotherAsync: @"Testing2" callback: ^(AEAnotherClass* another) {
        NSLog(@"%@", [another getName]);
        [n printAnotherAsync: another callback: ^() {
            NSLog(@"Printing complete");
        }];
    }];

}