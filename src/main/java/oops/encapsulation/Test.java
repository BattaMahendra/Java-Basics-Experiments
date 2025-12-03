package oops.encapsulation;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Customer customer = new Customer();
        customer.setId(123);
        System.out.println(customer.getId());

        //Using reflection to break
        Field customerIdField = Customer.class.getDeclaredField("id");
        customerIdField.setAccessible(true);

        //reading the field
        int id = (int)customerIdField.get(customer);
        System.out.println("Before changing id: "+id);

        //writing the field
        customerIdField.set(customer,456);
        System.out.println("After changing id: "+customerIdField.get(customer));

        /*
        * In the same way methods and constructors can also be controlled via reflection*/



    }
}
