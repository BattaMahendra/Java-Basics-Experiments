package oops.polymorphism;

class Parent {
    Parent() {
        init();   // calls override if child overrides!
    }

    void init() {
        System.out.println("Parent init");
    }

    void parentInstance1(){

    }
    int p1 = 2;
}

class Child extends Parent {
    int value = 42;

    @Override
    void init() {
        System.out.println("Child init, value = " + value);
    }

    void childInstance1(){

    }

    int c1 = 3;
}

public class Test{

    public static void main(String[] args) {
        Child c = new Child();

        Parent p = new Child();
        p.init();


    }
}
