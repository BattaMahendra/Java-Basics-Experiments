package oops.polymorphism.code;

public class Vehicle {


    public void moving(){
        System.out.println("Vehicle is moving");
    }

    //static methods can't be overriden because they belong to class not object.
    //static belongs to class area where as object belongs to heap area.
    public static void create(){
        System.out.println("creating vehicle");
    }
}
class Bike extends Vehicle{

    @Override
    public void moving(){
        System.out.println("Bike is running on two wheels");
    }
    public static void create(){
        System.out.println("Bike is created");
    }
}
class Boat extends Vehicle{

    @Override
    public void moving(){
        System.out.println("Boat is running on propellers");
    }
    public static void create(){
        System.out.println("Boat is created");
    }
}
