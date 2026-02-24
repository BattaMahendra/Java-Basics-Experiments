package Immutable.practice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Address a = new Address("ATP", 515001, "srinagar colony");
        Department d = new Department();
        d.setName("IT");
        List<Department> departments = new ArrayList<>();
        departments.add(d);

        List<String> skills = new ArrayList<>();
        skills.add("JAVA");
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Dept", "IT");

        Employee emp = new Employee("Mahendra", skills, metadata, a,departments);

        System.out.println(emp);

        System.out.println("\nAfter modification\n");


        System.out.println(emp.getSkills().hashCode());

        emp.getSkills().add("Kafka");
        System.out.println(emp.getSkills().hashCode());
        emp.getMetadata().put("Roles", "Developer");
        emp.getAddress().setAddress(" Modified");
        emp.getDepartments().add(new Department()); //this works fine

        //now what if original department object is changes
        d.setName("Hey"); // you should make this also should work fine --> make deep copy

        System.out.println(emp);


        //Problems

        /*
        * you should also take care of reflection*/
        Field f = Employee.class.getDeclaredField("name");
        f.setAccessible(true);
        f.set(emp, "Hacked via Reflection");
        System.out.println(emp);
        //solution
        /*
        * Security Manager (pre-Java 17): You could restrict reflective access.
            --> Java 9+ Modules: --illegal-access=deny and strong encapsulation make reflective attacks harder.
            --> Enums: One reason why many immutables (like Singleton) are implemented using enum → they are immune to reflection instantiation         --> .
            --> 👉 Best Practice: For high-security immutables → prefer enum or design so that reflection-based changes don’t impact logical invariants.*/

        //2. Serialization
        /*
        * Serialization or Deserialization also breaks immutability
        * either use readResolve() method or
        * make sure you use readExternal() and writeExternal() objects carefully
        * or Don't extend with serializable  unnecessarily*/

        //3. Clonable
        /*
        * Don’t implement Cloneable in immutable classes (recommended).
           If you must, override clone() to return the same instance:
           * */


        Address ad = new Address("Bengaluru", 560087, "Varthur");
        Address ad2 = ad;
        Department d2 = new Department();
        d.setName("IT");
        List<Department> departmentList = new ArrayList<>();
        departments.add(d2);

        List<String> skills2 = new ArrayList<>();
        skills2.add("JAVA");
        Map<String, String> metadata2 = new HashMap<>();
        metadata2.put("Dept", "IT");
        Employee e2 = new Employee("Ranga", skills2,metadata2,ad2,departmentList);

        ad2.setAddress("Changed");

        System.out.println(e2);

        System.out.println(ad2);



    }
}
