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

        //generateClassNotFoundException();

        generateNoClassDefFoundError();


    }

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

