package oops.inheritance.aggregation;

public class Test {

    public static void main(String[] args) {

        // creating an address object
        Address address = new Address(216,34,"SrinagarColony","Anantapur", 515001);

        // Here we are passing the address from outside and employee object is just using it - AGGREGATION
        // At the same time we are passing health details and tightly coupling it - COMPOSITION
        Employee employee = new Employee(1234, "Mahi", address, "B +ve", "+ve");

        /*
        * Now Employee HAS A Address
        *
        * Both of them can exist without the other
        * Now if we delete the empoyee object, the address object still exist without any problem
        *
        * This is called aggregation (HAS A - Relationship with loose coupling)
        * */

        /*
        * Now Employee HAS A HealthDetails
        *  The Health details object is being created inside the Employee class and
        *  it is closely associated with Employee object
        *
        *  For suppose if we destroy the employee object then the HealthDetails Object inside the employee is
        *  automatically deleted.
        *
        *  They can not live independently.
        *
        *  This is called Composition (HAS A - Relationship with tight coupling)
        *
        * */

    }
}
