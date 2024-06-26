package basic.experiments.mathematics;

import java.util.ArrayList;
import java.util.List;
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


        allFactorsOfGivenNumber(n);

        isPrime(n);

        System.out.println("GCD operation");
        System.out.println(" please give first number");
        Integer first = s.nextInt();
        System.out.println(" please give second number");
        Integer second = s.nextInt();

         checkGCD(first , second);

        findGCDUsingEquilateralAlgorithm(first, second);


    }

    private static void findGCDUsingEquilateralAlgorithm(Integer first, Integer second) {
        while ( first > 0 && second > 0){
            if(first > second) first = first % second;
            else second = second % first;
        }
        if(first == 0) System.out.println("GCD is "+ second);
        else System.out.println("GCD is "+ first);
    }

    // check this video https://www.youtube.com/watch?v=1xNbjMdbjug
    // you can find equilateral algorithm to find GCD/HCF of given numbers
    // that is much faster and more efficient
    private static int checkGCD(int first , int second) {


        for(int i=Math.min(first , second); i>=1; i--){

            if(first % i == 0 && second % i ==0){
                System.out.println("GCD of "+first + " and "+ second+" is "+i);
                return i;
            }

        }
        return 0;
    }

    private static void isPrime(Integer n) {
        int factorsSize = allFactorsOfGivenNumber(n).size();
        if(n ==1) System.out.println("1 is a prime number");
        else if(factorsSize == 2) System.out.println(n + " is a prime number");
        else System.out.println(n+" is not a prime number");
    }

    private static List<Integer> allFactorsOfGivenNumber(Integer n) {
        int squareRoot = (int) Math.sqrt(n);
        List<Integer> factorsList = new ArrayList<>();
        //iterating only upto square root of given number to reduce time complexity
        for(int i=1; i<=squareRoot; i++){
            if(n %i == 0){
                factorsList.add(i);
                //If a number is a perfect square root then making sure that
                // same factor is not being added into list again as it is already added in above line
                if(n /i != i){
                    factorsList.add(n /i);
                }
            }
        }
        System.out.println(factorsList);
        return factorsList;
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
