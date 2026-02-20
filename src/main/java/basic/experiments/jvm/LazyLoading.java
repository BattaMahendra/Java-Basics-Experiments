package basic.experiments.jvm;

import java.util.List;

public class LazyLoading {

    public static void main(String[] args) {
        System.out.println("Main");

        System.out.println(LazyLoading.class.getClassLoader());  // Prints the Application class loader

        System.out.println(java.sql.Connection.class.getClassLoader());  // Prints Extension/Platform class loader

        System.out.println(String.class.getClassLoader());  // null
        System.out.println(Object.class.getClassLoader());  //null
        System.out.println(List.class.getClassLoader());   //null

        /*
        * The above classes are loaded by bootstrap class loader.
        * Bootstrap class loader is in jvm native code and not represented as java object*/
    }

}


/*
* The below class is never loaded as it is not referenced.
* */
class A {
    static {
        System.out.println("Loaded");
    }
}

/**
 * Java does NOT load all classes at startup.
 *
 * A class is loaded only when needed.
 *
 * Common triggers:
 *      new ClassName()
 *      Calling a static method
 *      Accessing a static variable
 *      Reflection (Class.forName)
 *      Subclass initialization
 *
 * This saves:
 *      Memory
 *      Startup time
 *      Metaspace usage
 *
 * Interview Questions
 * 5️⃣ Why String.class.getClassLoader() is null
 * */


