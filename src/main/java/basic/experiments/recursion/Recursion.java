package basic.experiments.recursion;

import java.util.Arrays;
import java.util.Scanner;

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

        fibonacciNumbers(100);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the input string");
        String input = scanner.nextLine();

        String reversedString ="";
        int length = input.length()-1;
       // reversedString = checkForPalindrome(length, reversedString, input);
        reversedString=checkForPalindromeUsingRecursion( length, reversedString, input);
        System.out.println(checkPalindromeRecursion2(0,"peep"));




        System.out.println(reversedString.equals(input) ? input+" is palindrome":input+" is not palindrome");

    }

    private static void fibonacciNumbers(int printUpTO) {
        int temporary =1;
        int temp2 =0;
        while (temp2< printUpTO){
            System.out.print(temp2+" ");
            temp2 =temporary + temp2;
            temporary = temp2 - temporary;

        }
        System.out.println("\n");
    }

    public static boolean checkPalindromeRecursion2(int i, String input){
        if(i > input.length()/2) return true;

        if(input.charAt(i) != input.charAt(input.length()-1-i)) return false;

        return checkPalindromeRecursion2(i+1, input);
    }

    public static String checkForPalindromeUsingRecursion(int length, String reversedString, String input){
        if(length == -1) return reversedString;
        reversedString = reversedString + input.substring(length, length +1);
        return checkForPalindromeUsingRecursion(length-1,reversedString,input);
      //  return reversedString;
    }


    private static String checkForPalindrome(int length, String reversedString, String input) {
        while(length > -1){
            reversedString = reversedString + input.substring(length, length +1);
            length--;
        }
        return reversedString;
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
