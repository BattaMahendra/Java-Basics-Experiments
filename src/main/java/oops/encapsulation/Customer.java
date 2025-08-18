package oops.encapsulation;

import java.time.LocalDate;

/*
*
*1. Encapsulation is about protecting and controlling access to the internal state of an object.
* In Java, it is achieved through private fields so that they can't be accessed directly.
*
* 2.It groups related data and behavior together into a class. This bundling ensures that the
*  internal state is only manipulated in the context of that class.
*
* 3. It helps in modularity. We can maintain different classes with its own responsibilities
* So ensuring Single responsibility principle in SOLID
*
* V-IMP: Suppose in future if we want to change any functionality the external systems won't affect as we
* are changing only in this class and  will provide same data type to external system
*
*
* Java Reflection is used to break the encapsulation.
* */

//using encapsulation we are binding data (fields) and methods (functionality) into single unit (class)
public class Customer {


    private int id;
    private String name;
    private String address;
    private int age;
    private LocalDate dob;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    /*
    * We can have data validation with encapsulation
    * */
    public void setAge(int age) {

        if(age < 18 ) System.out.println("Please enter valid age");
        else this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }




}
