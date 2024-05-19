package oops.polymorphism.code;

public class Test {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.moving();
        v = new Bike();
        v.moving();
    }
}
