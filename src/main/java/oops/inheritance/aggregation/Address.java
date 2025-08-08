package oops.inheritance.aggregation;

public class Address {

    private int doorNo;
    private int streetNo;
    private String street;
    private String city;
    private int pincode;

    public Address(int doorNo, int streetNo, String street, String city, int pincode) {
        this.doorNo = doorNo;
        this.streetNo = streetNo;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }
}
