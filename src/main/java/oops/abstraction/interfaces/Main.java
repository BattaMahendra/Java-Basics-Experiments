package oops.abstraction.interfaces;

interface Logger {

    //this below statement is compiled as
    // public static final
    String loggerStarted = "STARTED";

    /*
    * */
    // Default method that uses private method
    default void logInfo(String message) {

        log("INFO", message);
    }

    // Default method that uses private method
    default  void logError(String message) {

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


    /*
    * Static methods can't be overridden
    * They are Interface level methods which can be used by anyone by using Interface name
    * We don't need to implement Interface to use static methods
    * */
    public static void printFooter(){
        print("ended");
    }

    //private static methods - used to maintain reoccurring functionality of static methods
    private static void print(String term){
        System.out.println("\nLogger functionality: "+ term);
    }

    /* the below is not allowed as equals(Object o):boolean method belongs to Object class and
     they are not allowed to be overridden. */
//    default  boolean equals(Object o){
//        return true;
//    }



}

public class Main {
    public static void main(String[] args) {

        Logger.printHeader();
        Logger logger = new Logger() {}; // Anonymous class - not overriding anything as we don't have abstract methods
        logger.logInfo("System is starting"); // Output: [INFO]: System is starting
        logger.logError("An error occurred"); // Output: [ERROR]: An error occurred

        Logger.printFooter(); // for using static methods in interfaces we don't need to create objects

        //default methods can also be called as




        //anonymous inner class with overridden default methods - optional
        Logger logger1 = new Logger() {

            @Override
            public void logInfo(String message) {
                System.out.println("Overridden default methods");
                System.out.println("[INFO]: " + message);
            }

            // you can also choose not to override like object logger declared above
            @Override
            public void logError(String message) {
                System.out.println("[ERROR]: " + message);
            }
        };



    }
}
