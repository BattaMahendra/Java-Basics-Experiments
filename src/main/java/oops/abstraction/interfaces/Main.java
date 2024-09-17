package oops.abstraction.interfaces;

interface Logger {

    //this below statement is compiled as
    // public static final
    String loggerStarted = "STARTED";

    // Default method that uses private method
    default void logInfo(String message) {

        log("INFO", message);
    }

    // Default method that uses private method
    default void logError(String message) {

        log("ERROR", message);
    }

    // Private method in interface (used by default methods)
    private void log(String level, String message) {

        System.out.println("[" + level + "]: " + message);
    }

    //static methods - used for utility functions
    public static void printHeader(){

        //static method is using private static methods
        //private default methods are not allowed here
        print("Started\n");
    }

    public static void printFooter(){
        print("ended");
    }

    //private static methods - used to maintain reoccurring functionality of static methods
    private static void print(String term){
        System.out.println("\nLogger functionality: "+ term);
    }
}

public class Main {
    public static void main(String[] args) {

        Logger.printHeader();
        Logger logger = new Logger() {}; // Anonymous class
        logger.logInfo("System is starting"); // Output: [INFO]: System is starting
        logger.logError("An error occurred"); // Output: [ERROR]: An error occurred
        Logger.printFooter();

    }
}
