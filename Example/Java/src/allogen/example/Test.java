package allogen.example;

import java.io.File;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExampleClass n = new ExampleClass(200);

        {
            ExampleClass shared1 = ExampleClass.shared();
            shared1.setInteger(123);

            ExampleClass shared2 = ExampleClass.shared();
            System.out.println(shared2.getInteger());

            shared2.setInteger(124);
            System.out.println(shared1.getInteger());
        }

        System.out.println(ExampleClass.getStaticInt());

        n.sayHello("Allogen Bridge");

        n.doAsync(() -> {
            System.out.println("Done async!!!!");
        });

        int r = n.anotherCallback((short a, short b) -> a + b);
        System.out.println(r);

        r = n.virtualCallback((short a, short b) -> a + b, (short) 100, (short) 200);
        System.out.println(r);

        System.out.println("Newly constructed");
        System.out.println(n.getInteger());

        System.out.println("Setting to 10000...");
        n.setInteger(10000);
        System.out.println(n.getInteger());

        System.out.println("Setting to 200...");
        n.setInteger(200);
        System.out.println(n.getInteger());

        System.out.println("Setting copy to 300...");
        ExampleClass copy = n.copy();
        copy.setInteger(300);

        System.out.println("Original: " + n.getInteger());
        System.out.println("Copy: " + copy.getInteger());

        AnotherClass anotherClass = n.createAnother("Testing");
        n.printAnother(anotherClass);
        n.printAnotherAsync(anotherClass, () -> {
            System.out.println("Printed async!!!");
        });


        ExampleClass finalN = n;
        n.createAnotherAsync("Testing2", (AnotherClass another) -> {
            System.out.println("Received a async another: " + another.getName());
            finalN.printAnotherAsync(another, () -> {
                System.out.println("Printing complete");
            });
        });

        n = null;
        copy = null;

        // When calling GC, it should automatically call the C++ destructor!
        System.gc();
    }

    static {
        File file = new File("../../cmake-build-debug/Example/Bridge/libAllogen.Example.Bridge.JNI.dylib");
        System.load(file.getAbsolutePath());
    }
}
