package allogen.example;

import java.io.File;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ExampleClass n = new ExampleClass(200);

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
