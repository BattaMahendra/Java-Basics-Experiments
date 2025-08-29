package Immutable.practice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

   String city;
   int pincode;
   String address;

    public Address(String city, int pincode, String address) {
        this.city = city;
        this.pincode = pincode;
        this.address = address;
    }
}
