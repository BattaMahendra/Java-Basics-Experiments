package basic.experiments.recursion;

import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {

        //main(args);
        int counter = 0;

        print(counter);

        printNamesForNTimes(1, 5);
        //print numbers from n to 1 using recursion
        int n =6;
        reversePrinting(n);

        printDigits(1234567);
        System.out.println( "Sum for given number is "+ sumOfNumbersToN(10));
        System.out.println( "Factorial for given number is "+findFactorial(5));

        int[] array = {1,2,3,4,5};
        reverseAnArray(array);
        System.out.println(Arrays.toString(array));
        reverseArrayUsingRecursion(array, 0);
        System.out.println(Arrays.toString(array));

    }

    public static int[] reverseArrayUsingRecursion(int[] givenArray , int n){
        if(n >= givenArray.length/2) return givenArray;

        int temp = givenArray[givenArray.length-1-n];
        givenArray[givenArray.length-1-n] = givenArray[n];
        givenArray[n]=temp;
        reverseArrayUsingRecursion(givenArray,n+1);

        return givenArray;

    }

    public static int[] reverseAnArray(int[] givenArray){
        int n = givenArray.length;
        for(int i =0; i<n/2; i++){
            int temp = givenArray[n-1-i];
            givenArray[n-1-i] = givenArray[i];
            givenArray[i]=temp;
        }
        System.out.println(Arrays.toString(givenArray));
        return givenArray;
    }

    public static long findFactorial(int n){
        if(n == 0) return 1;
        return n*findFactorial(n-1);

    }
    public static int sumOfNumbersToN(int n){
        if(n == 0) return 0;
        return n+sumOfNumbersToN(n-1);

    }

    private static void reversePrinting(int n) {
        if(n ==0) return;
        System.out.print(n +" ");
       reversePrinting(n-1);
    }

    public static void printDigits(int n){
        if(n==0) return;

         printDigits(n/10);
        System.out.println(n%10);
    }

    private static void printNamesForNTimes(int intialValue, int numberOfTimes) {
        if(intialValue > numberOfTimes) return;
        System.out.println("Mahendra");
        printNamesForNTimes(intialValue+1, numberOfTimes);
    }

    private static void print(int counter) {
        if(counter == 3)  return;
        System.out.println(counter);
        counter++;
        print(counter);
    }
}
