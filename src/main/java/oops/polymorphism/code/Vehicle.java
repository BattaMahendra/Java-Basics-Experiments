package oops.polymorphism.code;

public class Vehicle {

    public String vehicleType ="Vehicle";


    public void moving(){
        System.out.println("Vehicle is moving");
    }

    //static methods can't be overridden because they belong to class not object.
    //static belongs to class area whereas object belongs to heap area.
    public static void create(){
        System.out.println("creating vehicle");
    }
}
class Bike extends Vehicle{

    public String vehicleType ="MotorCycle";

    @Override
    public void moving(){
        System.out.println("Bike is running on two wheels");
    }

    public void run(){
        System.out.println("It runs on land with two wheels");
    }
    public static void create(){
        System.out.println("Bike is created");
    }
}
class Boat extends Vehicle{

    public String vehicleType ="water-boat";

    @Override
    public void moving(){
        System.out.println("Boat is running on propellers");
    }
    public void run(){
        System.out.println("It runs on water with properller");
    }
    public static void create(){
        System.out.println("Boat is created");
    }

}
