package basic.experiments.recursion;

public class Recursion {

    public static void main(String[] args) {
        /*
        *
        * You can provide arguments in the run configuration of the program
        * JVM will load whatever u provide into args
        *
        * while compiling without IDE you can give arguments in the command line interface also
        * eg: javac Recursion.java
            java Recursion 1 2 3 "Testing the main method"*/
        for(String eachArgument : args){
            System.out.println(eachArgument);
        }
        //main(args);
    }
}
