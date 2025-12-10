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

    //static inner classes
    static class InnerStaticClass {
        void display() {
            System.out.println("static variable: ");
        }
    }

    static void aStaticMethod(){

        // any static or instance method can have local inner classes - it shouldn't be static in any case
        //it is accessible only inside this method
        class localInnerClass{
            int id;
        }

        localInnerClass l = new localInnerClass();
        l.id = 9;
    }

    //anonymous inner class
    //can't have constructor - but can have state and multiple extra methods if we want
    //can have static and state variables
    //can't have static variables and methods - but can have static final variables (constants)
    AnAbstractClass anonymousInnerClass = new AnAbstractClass(2) {

        static final String roll="";   //only constants are supposed to be there
        String name;  // can have its own variables
        @Override
        void print() {
            //logic
        }

        @Override
        void write() {
            //logic
        }

        //can have its own methods
        void printAgain(){

        }
    };


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

abstract class AnAbstractClass{
    private int id;
    abstract void print();
    abstract void write();
    AnAbstractClass(int id){
        this.id = id;
    }
}

