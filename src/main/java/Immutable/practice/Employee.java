package Immutable.practice;

import basic.experiments.pojos.Emp;

import java.util.*;
import java.util.stream.Collectors;

/*
* ✅ Rules for creating an Immutable Class

    --> Make class final → prevents subclassing.
    --> Make all fields private and final → cannot be reassigned.
    --> No setters → expose only getters.
    --> Initialize all fields via constructor.
    --> For mutable fields (List, Map, other objects):
    --> Perform deep copy in constructor.
    --> Return defensive copy in getters (not the actual reference).
    --> If holding another object (non-final mutable object) → also deep copy it.
*
* */
public final class Employee {


    private final String name;         // Immutable type
    private final List<String> skills; // Mutable type
    private final Map<String, String> metadata; // Mutable type
    private final Address address;     // Mutable custom object
    private final List<Department> departments;

    public Employee(String name, List<String> skills, Map<String, String> metadata, Address a, List<Department> departments) {
        this.name = name;

        // Defensive copy of mutable collections
        this.skills = new ArrayList<>(skills);
        this.metadata = new HashMap<>(metadata);

        /*
        * we should never do reference assign*/
        // this.skills = skills; //very dangerous as the incoming skills object is from outside and any change to that object will be reflected here

        // Deep copy of mutable object
        this.address = new Address(a.city,a.pincode,a.address);

        //when a collection or object contains mutable field then always do a deep copy
        this.departments = departments.stream().map(dept ->{
            Department d = new Department();
            d.name = dept.name;
            return d;
        }).collect(Collectors.toList());

        //shallow copy
       // this.departments = new ArrayList<>(departments); // this is dangerous
    }

    //avoid setters and only give getters




    public String getName() {
        return name;
    }

    /*Make sure you return a copy of the object rather than returning original reference
    * now every time you access getSkills() you will get new arraylist wrapped with original sills list*/
    public List<String> getSkills() {
        return new ArrayList<>(skills);

       // return Collections.unmodifiableList(skills); // you can use this also instead of above
    }

    public Map<String, String> getMetadata() {
        // Return a copy to avoid external modifications
        return new HashMap<>(metadata);
    }

    public Address getAddress() {
        // Return a copy to avoid external modifications
        return new Address(address.getCity(),address.getPincode(),address.getAddress());
        //so in client code even if client makes changes to new Address object then it can't modify this class address

    }

    public List<Department> getDepartments() {
        return new ArrayList<>(departments);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "  \nname='" + name + '\'' +
                ", \nskills=" + skills +
                ", \nmetadata=" + metadata +
                ", \naddress=" + address +
                ". \ndepartments="+departments+
                '}';
    }

}
