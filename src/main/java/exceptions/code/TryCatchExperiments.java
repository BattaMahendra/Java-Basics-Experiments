package exceptions.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TryCatchExperiments {

    public static void main(String[] args)  {
        aStaticMethod();

        multipleExcepitonsInSameCatchBlock(args);

        tryWithoutCatchBlock();

    }

    /*
    * We can have try block wihtout catch block
    * */


    private static void tryWithoutCatchBlock() {
        try {
            System.out.println("Inside try block");
            int result = 10 / 0; // This will cause an ArithmeticException
        } finally {
            System.out.println("Inside finally block");
        }
    }

    /*
    * using pipe " | " operator we can catch multiple exceptions in same catch block.
    *
    * Used when you want same catching logic for different kind of exceptions
    * */
    private static void multipleExcepitonsInSameCatchBlock(String[] args) {
        try {
            System.out.println("Inside try block");
            if (args.length > 0) {
                int result = 10 / 0; // This will cause an ArithmeticException
            } else {
                int[] numbers = new int[2];
                numbers[3] = 5; // This will cause an ArrayIndexOutOfBoundsException
            }
            //here you will be using single variable for all exceptions
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            System.out.println("Inside finally block");
        }
    }

    static void aStaticMethod(){

        TryCatchExperiments tryCatchExperiments = new TryCatchExperiments();
        try {
            tryCatchExperiments.readFromFile();
        }catch (IOException ex2 ){
            System.out.println("caught in caller method");
        }
        catch (Exception ex2 ){
            System.out.println("caught in caller method");
        }
        catch (Error error ){
            System.out.println("caught in caller method");
        }
    }

    private  void readFromFile() throws IOException {
        try {
            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("file/File1.txt").toURI());

            Stream<String> lines = Files.lines(path);
            String data = lines.collect(Collectors.joining("\n"));
            System.out.println(data);
            lines.close();
        }
//        catch ( NullPointerException ex){              // a try block can have multiple catch blocks
//            System.out.println("we are in firt catch block");
//            System.out.println(ex);
//            throw new IOException();
//        }
        catch ( Exception ex){
            System.out.println("we are in second catch block");
            System.out.println(ex);
           // throw new IOException();
            throw new Error();

        }
        finally {           // a try block should have only one finally block
            //The finally block will not be executed if the program exits (either by calling System.exit() or
            // by causing a fatal error that causes the process to abort).
            System.out.println(" I am in the finally block");
        }
    }
}
