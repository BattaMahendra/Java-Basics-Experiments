package AutoBoxing;

import basic.experiments.pojos.Employee;

public class Main{
    public static void main (String[] args) {
        
        //assigning int to Integer Wrapper (AutoBoxing)
    	//when given primitive value for 
    	//range greater than -127 to 128 the Integer  wrapper stores them in different 
    	//references , how ever if the primitive is with in the range of -127 to 128
    	//then they are stored in the same reference
        Integer a = 500;
        Integer b = 500;
        Integer c = 100;
        Integer d = 100;
        // creating a new Integer object 
        // this gives us new refernce every time and observe the patterns carefully
        Integer e = new Integer(500);
        Integer f = new Integer(500);
        Integer a1 = new Integer(50);
        Integer a2 = new Integer(50);
        
        System.out.println("a = "+a+" -->"+Integer.toHexString(System.identityHashCode(a)));
        System.out.println("b = "+b+" -->"+Integer.toHexString(System.identityHashCode(b)));
        System.out.println("c = "+c+" -->"+Integer.toHexString(System.identityHashCode(c)));
        System.out.println("d = "+d+" -->"+Integer.toHexString(System.identityHashCode(d)));
        System.out.println("e = "+e+" -->"+Integer.toHexString(System.identityHashCode(e)));
        System.out.println("f = "+f+" -->"+Integer.toHexString(System.identityHashCode(f)));
        System.out.println("a1 = "+a1+" -->"+Integer.toHexString(System.identityHashCode(a1)));
        System.out.println("a2 = "+a2+" -->"+Integer.toHexString(System.identityHashCode(a2)));
//        
        System.out.println("==================================================");
        
        System.out.println("c==d :"+ (c==d)); //true
        System.out.println("a==b :"+ (a==b)); //true
        System.out.println("e==f :"+ (e==f)); 
        System.out.println("a1==a2 :"+ (a1==a2));

        System.out.println("Testing something");
        System.out.println("===================================");
        Employee emp  = new Employee();
        String empId = "1234567";
        emp.setEmpId(empId);
        empId ="";
        System.out.println(emp);

    }
}
