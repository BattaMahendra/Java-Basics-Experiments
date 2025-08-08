package oops.inheritance.aggregation;

public class Employee {

    private int id;
    private String name;
    private Address address;
    private HealthDetails healthDetails;

    // Here Address entity is being loosely coupled as it is created and passed from outside
    // In the same way health details are being tightly coupled with employee class and health details object being
    // created inside the emplyee class
    public Employee(int id, String name, Address address , String bloodGroup, String testResulsts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.healthDetails = new HealthDetails(bloodGroup,testResulsts);
    }

    private static class HealthDetails{

        private String bloodGroup;
        private String healthTest;

        public HealthDetails(String bloodGroup, String healthTest) {
            this.bloodGroup = bloodGroup;
            this.healthTest = healthTest;
        }
    }
}
