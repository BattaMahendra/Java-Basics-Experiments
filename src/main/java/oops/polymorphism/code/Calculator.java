package oops.polymorphism.code;

public class Calculator {

    public static void main(String[] args) {

        int a =1;
        int b = 2;
        add(a, b);
        add(10,11);
        Short s = 10;
        add(10,s);
        add(0,0);

    }

    private static void add(int a, int b) {
        System.out.println(a + b);
    }
    private static void add(int a, short b) {
        System.out.println(" we are in overloaded method of int and short");
        System.out.println(a + b);
    }

    private static void add(byte a, short b) {
        System.out.println(" we are in overloaded method of byte and short");
        System.out.println(a + b);
    }

    //even we can overload main method
    public static void main(String[] args,int i) {

        System.out.println("we are in overloaded java main method: "+i);

    }
}
