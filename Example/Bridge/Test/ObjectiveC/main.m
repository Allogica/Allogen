#import <Allogen/AExampleClass.h>
#import <Allogen/AExampleClass.h>
#import <Allogen/ABaseClass.h>
#import <Allogen/ASubClass1.h>
#import <Allogen/ASubClass2.h>

int main(int argc, const char** argv) {
    AExampleClass* exampleClass = [[AExampleClass alloc] init];
    NSLog(@"%@", exampleClass);

    NSLog(@"%i", [exampleClass getInteger]);

    [exampleClass setInteger: 100];
    NSLog(@"%i", [exampleClass getInteger]);


    AExampleClass* n = [[AExampleClass alloc] initWithInitialValue: 200];
    {
        AExampleClass* shared1 = [AExampleClass shared];
        [shared1 setInteger: 123];

        AExampleClass* shared2 = [AExampleClass shared];
        NSLog(@"%i", [shared2 getInteger]);

        [shared2 setInteger: 124];
        NSLog(@"%i", [shared1 getInteger]);
    }

    NSLog(@"%i", [AExampleClass getStaticInt]);

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
    AExampleClass* copy = [n copy];
    [copy setInteger: 300];

    NSLog(@"Original: %i", [n getInteger]);
    NSLog(@"Copy: %i", [copy getInteger]);

    AAnotherClass* anotherClass = [n createAnother: @"Testing"];
    [n printAnother: anotherClass];

    [n createAnotherAsync: @"Testing2" callback: ^(AAnotherClass* another) {
        NSLog(@"%@", [another getName]);
        [n printAnotherAsync: another callback: ^() {
            NSLog(@"Printing complete");
        }];
    }];

    ABaseClass* b = [[ASubClass1 alloc] init];
    NSLog(@"Name: %@", [b getName]);
    [b fromNonvirtualBase];

    ASubClass1* sb1 = b;
    [sb1 fromNonvirtualBase];

    b = [[ASubClass2 alloc] init];
    NSLog(@"Name: %@", [b getName]);
    [b fromNonvirtualBase];

    ASubClass1* sb2 = b;
    [sb2 fromNonvirtualBase];
}