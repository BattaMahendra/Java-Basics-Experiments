package exceptions.code;

public class Tricky2 {

    // exception in static block
    static {
        System.out.println("We are in static block");
        if(true)
            throw new RuntimeException("custome Excption");
    }

    public static void main(String[] args) {
        System.out.println("We are in main method");
    }
}

/*
* We can throw exceptions in static block
* - If not handled then class is not loaded and as a result main method is not executed*/
