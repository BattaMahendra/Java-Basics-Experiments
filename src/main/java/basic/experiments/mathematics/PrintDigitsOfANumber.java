package basic.experiments.mathematics;

import java.util.Scanner;

public class PrintDigitsOfANumber {

    public static void main(String[] args) {

        System.out.println("Please enter a value");
        Scanner s = new Scanner(System.in);
         Integer n = Integer.valueOf(s.nextLine());

      //  printDigitsOfNumber(n);
      //  printDigitsOfNumberFromLeft(n);
        reverseNumber(n);

        checkPalindrome(n);

        chekIfArmStrongNumber(n);
    }

    private static void chekIfArmStrongNumber(Integer n) {
        int temporary =n;
        int armStrongNumber =0;
        int length = String.valueOf(n).length();
        while(n !=0){
            int remainder = n %10;
            armStrongNumber= (int) (armStrongNumber + Math.pow(remainder,length));
            n=n/10;
        }

        if(armStrongNumber == temporary) System.out.println(temporary+ " is a armstrong number");
        else System.out.println(temporary+" is not a arm strong number");
    }

    private static void checkPalindrome(Integer n) {
        if(n == reverseNumber(n)) System.out.println(n +" is a palindrome number");
        else System.out.println(n + " is not a palindrome number");
    }

    private static int reverseNumber(int n) {
        int reverseNumber = 0;
        while(n >0){
            int remainder = n %10;
            n = n /10;
            reverseNumber = reverseNumber*10 + remainder;
        }
        System.out.println(reverseNumber);
        return reverseNumber;
    }

    public static void printDigitsOfNumberFromLeft(int n){
        int length = String.valueOf(n).length();
        while(length > 0){
            int i = (int) (n / (Math.pow(10, length - 1)));
            System.out.println(i%10);
            length--;
        }

    }
    private static void printDigitsOfNumber(int n) {
        while(n !=0){
            System.out.println(n %10);
            n = n /10;
        }
    }
}
