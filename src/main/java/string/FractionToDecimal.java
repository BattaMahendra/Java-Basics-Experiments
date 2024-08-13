package string;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Determine the sign of the result
        //here we are using XOR operator --> if both num and denom are negative then result should be positive
        /*
        * XOR Operator Logic:
            XOR (Exclusive OR) Truth Table:
            true ^ true = false
            false ^ false = false
            true ^ false = true
            false ^ true = true
        * */
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with absolute values to handle signs
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part of the quotient
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString(); // No fractional part, return the result
        }

        result.append("."); // There is a fractional part

        // Map to store remainder positions and detect repeating cycles
        Map<Long, Integer> remainderMap = new HashMap<>();

        // Perform long division to find the repeating and non-repeating parts
        while (remainder != 0) {
            // If the remainder is already seen, we found a repeating cycle
            if (remainderMap.containsKey(remainder)) {
                int start = remainderMap.get(remainder);
                result.insert(start, "(");
                result.append(")");
                break;
            }

            // Store the remainder with its corresponding index in the result list
            remainderMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
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

/*
*
* ### Problem Statement: Fraction to Recurring Decimal Conversion

**Objective**:
Write a function that takes two integers, `numerator` and `denominator`, and returns their division as a string in decimal format. If the fractional part of the division is repeating, enclose the repeating part in parentheses. The function should handle cases where there is an initial non-repeating part followed by a repeating sequence in the decimal fraction.

**Function Signature**:
```java
public static String fractionToDecimal(int numerator, int denominator)
```

**Input**:
- Two integers, `numerator` and `denominator`, where `denominator` is non-zero. The numerator can be zero or any integer (positive or negative), and the denominator is any non-zero integer (positive or negative).

**Output**:
- A string representing the quotient in decimal form. If there is a repeating part in the decimal, it should be enclosed in parentheses. The output should handle both positive and negative results correctly.

**Example**:

1. **Input**: `numerator = 62`, `denominator = 45`
   - **Output**: `"1.3(7)"`
   - **Explanation**: \( \frac{62}{45} = 1.3777...\) where the decimal `1.3` is the non-repeating part and `7` is the repeating part.

2. **Input**: `numerator = 1`, `denominator = 3`
   - **Output**: `"0.(3)"`
   - **Explanation**: \( \frac{1}{3} = 0.3333...\) where `3` repeats indefinitely.

3. **Input**: `numerator = 1`, `denominator = 6`
   - **Output**: `"0.1(6)"`
   - **Explanation**: \( \frac{1}{6} = 0.1666...\) where `1` is the non-repeating part and `6` is the repeating part.

4. **Input**: `numerator = -50`, `denominator = 22`
   - **Output**: `"-2.27(27)"`
   - **Explanation**: \( \frac{-50}{22} = -2.272727...\) where `2.27` is the non-repeating part and `27` is the repeating part.

5. **Input**: `numerator = 0`, `denominator = 5`
   - **Output**: `"0"`
   - **Explanation**: \( \frac{0}{5} = 0 \) with no repeating part.

**Constraints**:
- You should not use any built-in libraries for floating-point arithmetic that would directly solve the problem (e.g., `BigDecimal` in Java).
- The function should handle cases with both positive and negative numerator and denominator.
- If the result is negative, ensure the negative sign precedes the whole number.

**Notes**:
- Consider edge cases like very large or very small numerators and denominators.
- Pay special attention to cases where the decimal repeats after a few digits.

This problem tests the understanding of long division, handling recurring decimals, and edge cases involving negative numbers and zero.
* */