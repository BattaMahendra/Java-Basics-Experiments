package exceptions.code;

import java.io.IOException;

public class ExceptionPropagation {

    public static void main(String[] args) {

        //for  learning more about propagation: https://www.geeksforgeeks.org/exception-propagation-java/

        //checked exceptions
        try {
            method3();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    private static void method1() throws IOException {
        System.out.println("We are in method 1");
        throw new IOException();
    }
    private static void method2() throws IOException {
        System.out.println("We are in method 2");
        method1();
    }
    private static void method3() throws IOException {
        System.out.println("We are in method 3");
        method2();
    }
}
