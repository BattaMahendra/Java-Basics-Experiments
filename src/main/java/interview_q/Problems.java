package interview_q;

import java.util.Random;

public class Problems {

    public static void main(String[] args) {

        // Generate the 4 digit random otp
        // Using Math.random()
        random4digitOTP();

        // Random library from java
        random4digitOTPUsingRandomClass();

    }

    private static void random4digitOTPUsingRandomClass() {
        Random random = new Random();
        // random.nextInt(int k) generates random numbers from 0 to k-1. k is exclusive
            int otp = 1000 + random.nextInt(9000);
            System.out.println(otp);
    }

    private static void random4digitOTP() {
        // usually Math.random() generates random values from 0.0000.. to o.99999999.....
        // and our 4 digit otp should lie b/w 1000 and 9999
        //so we're multiplying with 9000 leads to max value of 8999.999 which is rounded to 8999
        // and 1000 is added initially to start with 1000
        int otp = 1000 + (int) (Math.random() * 9);

        System.out.println(otp);
    }
}
