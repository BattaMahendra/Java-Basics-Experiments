package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FractionToDecimalClone {

    public static String fractionToDecimal(long numerator, long denominator){

        if(numerator == 0 || denominator == 0) return "0";

        StringBuilder result = new StringBuilder();

        if(numerator < 0 || denominator < 0) result.append("-");

        numerator = Math.abs( numerator);
        denominator = Math.abs( denominator);

        long quotient = (numerator/denominator);

        result.append(quotient);
        result.append(".");

        long remainder = (numerator % denominator);
        if (remainder == 0) {
            return result.toString(); // No fractional part, return the result
        }

        Map<Long , Integer> remainderMap = new HashMap<>();

        while(remainder !=0){

            if(remainderMap.containsKey(remainder)){

                int startIndex = remainderMap.get(remainder);
                result.insert(startIndex,"(");
                result.append(")");
                return result.toString();
            }

            remainderMap.put(remainder, result.length());
            remainder = remainder*10;
            result.append(remainder/denominator);
            remainder = remainder % denominator;

            int[] arr = {5,10,12,15,17,20};
            Arrays.stream(arr).filter(i -> i%5 ==0).forEach(System.out::println);
        }




        return "invalid";
    }

    public static void main(String[] args) {


        System.out.println(fractionToDecimal(1, 2));    // Output: "0.5"
        System.out.println(fractionToDecimal(1, 3));    // Output: "0.(3)"
        System.out.println(fractionToDecimal(1, 4));    // Output: "0.25"
        System.out.println(fractionToDecimal(4, 7));    // Output: "0.(571428)"
        System.out.println(fractionToDecimal(-4, 7));   // Output: "-0.(571428)"
        System.out.println(fractionToDecimal(10, 22));  // Output: "0.(45)"
        System.out.println(fractionToDecimal(4, 9));    // Output: "0.(4)"
        System.out.println(fractionToDecimal(62, 45)); // Output: "0.(123)"
        System.out.println(fractionToDecimal(2, 725));


    }
}
