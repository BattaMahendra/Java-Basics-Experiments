package oops.polymorphism.code;

public class Test {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.moving();
        System.out.println(v.vehicleType);
        v = new Bike();
        v.moving();
        //data members can't be overrided they will follow the reference object
        System.out.println(v.vehicleType);
        // with v reference you can't access child data members only methods have that special type of polumorphism
        // if you want to call child data members with parent reference then it is not possible , it is possible for methods only
        //to solve this you need to use downcasting

        // this is called downcasting
         Bike bike = (Bike) v;

        System.out.println(v.vehicleType);
        System.out.println(bike.vehicleType);

        //unlike data members we don't need downcasting to call child methods.
        ((Bike) v).run();

        // down casting problems

        //Bike b = new Vehicle(); // results in compilation error

        //Bike b = (Bike) new Vehicle(); // results in run time error as class cast exception

        // proper way to downcast a object is

        Vehicle v1 = new Vehicle();
        Bike b = (Bike) v1;

        // along with above approach we can also leverage instanceOf operator
        // please refere : https://www.javatpoint.com/downcasting-with-instanceof-operator


    }
}
