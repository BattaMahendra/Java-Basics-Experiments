package basic.experiments.jvm.custom_class_loaders;

public class TestCustomLoader {

    public static void main(String[] args) throws Exception {

        MyCustomClassLoader loader =
                new MyCustomClassLoader("C:\\Users\\batta\\IdeaProjects\\Java-Basics-Experiments");

        // Load class dynamically
        Class<?> helloClass = loader.loadClass("Hello");

        /**
         * ⚠️ Learn about usage of findClass() vs loadClass() methods in custom class loaders
         * */

        // Create object
        Object obj = helloClass.getDeclaredConstructor().newInstance();

        // Call method
        helloClass.getMethod("sayHello").invoke(obj);
    }
}

/*
* There is Hello.java file in C:\Users\batta\IdeaProjects\Java-Basics-Experiments
*
* First you need to compile it  and generate .class file and then only this class loader class works
*
* compiling command:  javac --release 11 Hello.java
 */
