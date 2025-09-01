package basic.experiments.jvm;

/*
* This is an example to illustrate ClassNotFound Exception and  NoClassDefFound error
*
* As the name suggests,
* ClassNotFoundException is an exception while NoClassDefFoundError is an error.
*
* ClassNotFoundException occurs when classpath does not get updated with required JAR files while error occurs
*  when the required class definition is not present at runtime.
* */

//please refer the link to understand more : https://www.geeksforgeeks.org/classnotfoundexception-vs-noclassdeffounderror-java/
public class ClassLoader {

    public static void main(String[] args) {

        generateClassNotFoundException();

        generateNoClassDefFoundError();


    }

    /*ClassDef*/
    private static void generateNoClassDefFoundError() {
        ClassWithInitErrors test;
        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t);
        }
        System.out.println("=================================");
        test = new ClassWithInitErrors();
        System.out.println(test);
    }

    private static void generateClassNotFoundException() {
        try {

            Class.forName("Mahendra"); // Mahendra class does not exist in the classpath
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class ClassWithInitErrors{
    static int value = 1/0;
}

/*
* Stack overflow means exactly that: a stack overflows. Usually there's a one stack in the program that contains local-scope variables and addresses where to return when execution of a routine ends.
* That stack tends to be a fixed memory range somewhere in the memory, therefore it's limited how much it can contain values.
   If the stack is empty you can't pop, if you do you'll get stack underflow error.
   If the stack is full you can't push, if you do you'll get stack overflow error.

So stack overflow appears where you allocate too much into the stack. For instance, in the mentioned recursion.
* */

