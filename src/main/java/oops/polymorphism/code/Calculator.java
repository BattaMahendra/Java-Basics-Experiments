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

    //comment out this method and check for the ambiguity

    private static void add(int a, int b) {
        System.out.println(a + b);
    }
    private static void add(int a, long c) {
        System.out.println(" we are in overloaded method of int and long");
        System.out.println(a + c);
    }
    private static void add(long  a, int c) {
        System.out.println(" we are in overloaded method of long and int");
        System.out.println(a + c);
    }
    private static void add(int a, short b) {
        System.out.println(" we are in overloaded method of int and short");
        System.out.println(a + b);
    }

    private static void add(byte a, short b) {
        System.out.println(" we are in overloaded method of byte and short");
        System.out.println(a + b);
    }

    //byte --> short --> int --> long --> float --> double
    //One type is not de-promoted implicitly for example double cannot be depromoted to any type implicitly.

    //even we can overload main method
    public static void main(String[] args,int i) {

        System.out.println("we are in overloaded java main method: "+i);

    }
}
