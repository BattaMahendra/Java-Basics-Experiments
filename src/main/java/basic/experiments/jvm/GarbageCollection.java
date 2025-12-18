package basic.experiments.jvm;

import lombok.ToString;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;


/*Also read
*
* https://www.geeksforgeeks.org/island-of-isolation-in-java/*/
public class GarbageCollection {


    static {
        Employee e1  = new Employee("static block", 7);
    }

    public static  Employee e1;


    public static void main(String[] args) throws InterruptedException {
        System.out.println("===========================================================");
        testingFinalizeMethod();
        Thread.sleep(1000);
        System.out.println("===========================================================");
        eligibleObjectsForGC();
        Thread.sleep(1000);
        System.out.println("=============================  GC  ==============================");
        System.gc();
        System.out.println("===========================================================");

        Thread.sleep(1000);
        //strong reference
        Integer i = new Integer(1);
        /**
         * 1. Object is collected by GC if no strong references exist, even if weak references exist.
         * 2. Common use: caches (like WeakHashMap).*/
        WeakReference<Integer> w = new WeakReference<>(1);

        /*  1. Similar to weak references, but GC keeps them longer.
            2. Objects are cleared only when JVM really needs memory.
            3. Best for caching memory-sensitive objects.
            */
        SoftReference<Integer> s = new SoftReference<>(1);

        System.out.println("\n BEFORE GC ");
        System.out.println(i);
        System.out.println(w.get());
        System.out.println(s.get());

        System.gc();

        System.out.println("\n AFTER GC ");
        System.out.println(i);
        System.out.println(w.get());
        System.out.println(s.get());


        // with Hashmaps

        System.out.println("\n\n====================== MAPS ===========================");
        withMaps();


    }

    private static void withMaps() {
        Employee strongEmployee = new Employee("Strong" , 40);


        //adding into Hashmap
        Map <Employee, Integer> map = new HashMap<>();
        map.put(strongEmployee, 1);
        map.put(new Employee("No reference", 25), 3);  // although the key has no strong reference still it is not eligible for GC as it is in map

        strongEmployee = null; // removing reference of strong employee

        // ideally the strongEmployee should have been eligible for GC
        // but it won't because it is contained in HashMap
        // you can observe below object will be eligible for GC

        new Employee("Idle" , 40);   // eligible for GC cause no strong reference and no entry in hashmap.
        System.gc();


        Employee weakEmployee = new Employee("weak" , 30);


        WeakReference<Employee> weakReference = new WeakReference<>(weakEmployee);

        WeakHashMap<WeakReference<Employee>, String> weakHashMap = new WeakHashMap<>();

        weakHashMap.put(weakReference, "Putting a weak employee reference");

        weakEmployee = null;  // it is immediately eligible for GC

        // the below is also immediately eligible for GC
        WeakReference<Employee> weakReference2 = new WeakReference<>(new Employee("weak - no reference", 45));
        System.gc();

        Employee softEmployee = new Employee("Soft" , 30);
        SoftReference<Employee> softReference = new SoftReference<>(softEmployee);
        softEmployee = null;  // not immediately eligible for GC. GC only sweeps it if JVM absolutely needs some memory

        // the below object is not immediately eligible for GC.
        SoftReference<Employee> softReference2 =new SoftReference<Employee>(new Employee("soft - no reference", 57));
        System.gc();

    }

    private static void eligibleObjectsForGC() {
        //unreferenced object
        new Employee("unreferenced", 24);


        e1 =  new Employee("Vishwa", 24);
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
           // System.runFinalization();
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
        this.empId = ++nextEmpId;
    }

    /*Custom implementation of finalize method. JVM calls this method before system.gc() is being used
    **/
    protected void finalize()
    {


        System.out.println(this + " object successfully garbage collected "+" done by thread: "+Thread.currentThread().getName());
        --nextEmpId;

    }


}
