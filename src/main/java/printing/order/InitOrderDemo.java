package printing.order;
class A {
    // ==== STATIC SECTION (A) ====
    static String sa1 = log("A: static var sa1");
    static { log("A: static block 1"); }
    static String sa2 = log("A: static var sa2");
    static { log("A: static block 2"); }

    // ==== INSTANCE SECTION (A) ====
    String ia1 = log("A: instance var ia1");
    { log("A: instance block 1"); }
    String ia2 = log("A: instance var ia2");
    { log("A: instance block 2"); }

    A() {
        log("A: constructor");
    }

    static void staticMethod() {
        log("A: staticMethod()");
    }

    static String log(String msg) {
        System.out.println(msg);
        return msg;
    }

    // just testing inner static classes - they are not triggered until they are referenced
    static class InnerHelper{
         static A instanceOfOuter = new A(); // Bill Pugh singleton method
         void test(){

        }

        static void innerStaticMethod(){

        }
    }
}

class B extends A {
    // ==== STATIC SECTION (B) ====
    static String sb1 = log("B: static var sb1");
    static { log("B: static block 1"); }
    static String sb2 = log("B: static var sb2");
    static { log("B: static block 2"); }

    // ==== INSTANCE SECTION (B) ====
    String ib1 = log("B: instance var ib1");
    { log("B: instance block 1"); }
    String ib2 = log("B: instance var ib2");
    { log("B: instance block 2"); }

    B() {
        // implicit super(); here (calls A())
        log("B: constructor");
    }

    static void staticMethod() {
        log("B: staticMethod()");
    }

    static String log(String msg) {
        System.out.println(msg);
        return msg;
    }
}

class C extends B {
    // ==== STATIC SECTION (C) ====
    static String sc1 = log("C: static var sc1");
    static { log("C: static block 1"); }
    static String sc2 = log("C: static var sc2");
    static { log("C: static block 2"); }

    // ==== INSTANCE SECTION (C) ====
    String ic1 = log("C: instance var ic1");
    { log("C: instance block 1"); }
    String ic2 = log("C: instance var ic2");
    { log("C: instance block 2"); }

    C() {
        // implicit super(); here (calls B())
        log("C: constructor");
    }

    static void staticMethod() {
        log("C: staticMethod()");
    }

    static String log(String msg) {
        System.out.println(msg);
        return msg;
    }
}

public class InitOrderDemo {
    public static void main(String[] args) {
        System.out.println("===== main start =====");

        // Case 1: Only reference, no object creation
        // C cNull = null;

        // Case 2: Access static variable (triggers class initialization of A, B, C)
        // System.out.println("Accessing C.sc1:");
        // System.out.println(C.sc1);

        // Case 3: Call static method (also triggers class initialization)
        // System.out.println("Calling C.staticMethod():");
        // C.staticMethod();

        // Case 4: Create object (triggers class init if not already done, then full constructor chain)
        System.out.println("Creating new C():");
        C c = new C();

        // testing inner static class
        A.InnerHelper i = new A.InnerHelper();
        A.InnerHelper.innerStaticMethod();
        i.innerStaticMethod();
        System.out.println("===== main end =====");


    }
}
