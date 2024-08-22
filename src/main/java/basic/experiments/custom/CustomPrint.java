package basic.experiments.custom;

import basic.experiments.pojos.Employee;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CustomPrint {

    private static OutputStream out = System.out;

    public static  void print(Object o)  {
        String printing = String.valueOf(o);
        try {
            out.write(printing.getBytes());
            out.flush(); // Ensure all data is sent to the output
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public static void main(String[] args) {

        CustomPrint.print(new Employee() );
        System.out.println(new Employee());

    }
}
