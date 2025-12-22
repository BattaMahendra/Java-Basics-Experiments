package basic.experiments.jvm;

public class LazyLoading {

    public static void main(String[] args) {
        System.out.println("Main");
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


