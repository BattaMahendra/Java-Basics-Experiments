package oops.inner_classes;

import java.util.*;
class OuterClass {
    int instanceVar = 42;
    
    // Non-static Nested Inner class
    class InnerClass {
        void display() {
            System.out.println("Instance variable: " + instanceVar);
        }
    }

    static class InnerStaticClass {
        void display() {
            System.out.println("static variable: ");
        }
    }

    public static void main(String[] args) {
        OuterClass o = new OuterClass();
        InnerClass i = o.new InnerClass();

    }
}

class Main {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        innerObj.display(); // Output: Instance variable: 42

        OuterClass.InnerStaticClass is = new OuterClass.InnerStaticClass();
        OuterClass.InnerClass innerObj2 = outerObj.new InnerClass();
    }
}

