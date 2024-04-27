package basic.experiments.jvm;

import lombok.ToString;


/*Also read
*
* https://www.geeksforgeeks.org/island-of-isolation-in-java/*/
public class GarbageCollection {

    public static void main(String[] args) {
        testingFinalizeMethod();
        eligibleObjectsForGC();
        System.gc();



    }

    private static void eligibleObjectsForGC() {
        //unreferenced object
        new Employee("unreferenced", 24);


        Employee e1 =  new Employee("Vishwa", 24);
        Employee e2 =  new Employee("Other Referenced", 24);

        //other referenced objects - now e2 is also referenced to e1
        //but original e1 becomes unreferenced , so it is eligible for gc
        e2 = e1;

        //null referenced objects
        e2 = null;

        // objects created inside method
        method();


    }

    //method to demonstrate that objects created inside method are eligible for gc
    // once the method call is over
    private static void method() {
        Employee e4 =  new Employee("Inside Method", 24);
    }

    private static void testingFinalizeMethod() {
        Employee employee1 = new Employee("1", 24);
        System.out.println(employee1);
        Employee employee2 = new Employee("Ajay", 24);
        System.out.println(employee2);
        Employee employee3 = new Employee("2", 24);
        System.out.println(employee3);
        {
            // It is sub block to keep
            // all those interns.
            Employee X = new Employee("GFG4", 23);
            Employee Y = new Employee("GFG5", 21);
            X = Y = null;
            System.gc();
            System.runFinalization();
        }

        Employee employee4 = new Employee("3", 24);
        System.out.println(employee4);
    }
}

@ToString
class Employee{
    public  int empId;

    public String name;
    public int age;

    public static int nextEmpId = 1;

    public Employee(String name, int age){
        this.age = age;
        this.name = name;
        this.empId = nextEmpId++;
    }

    /*Custom implementation of finalize method. JVM calls this method before system.gc() is being used
    **/
    protected void finalize()
    {


        System.out.println(this + " object successfully garbage collected");
        --nextEmpId;

    }


}
