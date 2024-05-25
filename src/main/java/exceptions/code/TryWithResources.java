package exceptions.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) throws FileNotFoundException {

        InputStream inputStream = TryWithResources.class.getResourceAsStream("/files/File1.txt");

        experiment1(inputStream);

        experiment2(inputStream);

        // for custom connections please refer :https://www.baeldung.com/java-try-with-resources

    }

    private static void experiment2(InputStream inputStream) throws FileNotFoundException {
        // after java 9 we can pass effectively final variables in the try block
        //scanner is a final varible
        // printwriter is a effectively final variable
        // ( Put simply, a variable is effectively final if it doesn’t change after the first assignment, even though it’s not explicitly marked as final.)
        final Scanner scanner = new Scanner(inputStream);
        PrintWriter printWriter = new PrintWriter(new File("C:\\Users\\batta.chowdary\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\File2.txt"));

        try (
                scanner; printWriter

        ) {

            while(scanner.hasNextLine()){
                  System.out.println(scanner.nextLine());
            }


        } catch (Exception ex1) {

            System.out.println("we are catch block");
            System.out.println(ex1.getMessage());

        }
    }

    private static void experiment1(InputStream inputStream) {
        /*
         * We usually use finally block to close the printReaders or Stream readers
         * We also use it close open jdbc connections
         * As we know writing finally and writing to close the already opened connections is verbose
         * In order to avoid that we have try with resources feature from java 7 onwards , here we can
         * declare and initialize the connections in try signature and then they will be auto closed
         * */
        try (
                Scanner scanner = new Scanner(inputStream);
                //we can have multiple connections in the try signature, they should be separated by ;
                PrintWriter printWriter = new PrintWriter(new File("C:\\Users\\batta.chowdary\\IdeaProjects\\Java-Basics-Experiments\\src\\main\\resources\\files\\File2.txt"))
        ) {

            while(scanner.hasNextLine()){
              //  System.out.println(scanner.nextLine());
                printWriter.write(scanner.nextLine()+"\n");
            }


        } catch (FileNotFoundException ex1) {

            System.out.println("we are catch block");
            System.out.println(ex1.getMessage());

        }
        // by the end of execution the connections of scanner and writer are automatically closed
        //we can still have finally block if you wish
    }
}
