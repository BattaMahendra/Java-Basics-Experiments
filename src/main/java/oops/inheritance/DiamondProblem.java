package oops.inheritance;

public class DiamondProblem {
    public static void main(String[] args) {
        Liger liger = new Liger();
        liger.eat();
        int a = 010;
        int b = 01;
        int c= a+b;

        System.out.println(a+" + "+b+" = "+c);

        //when we create a child constructor then all the constructors of parents are constructed before it.
        C b1 = new C();
    }
}
class A {
    public A() {
        System.out.println("A");
    }
    public A(String s) {
        System.out.println(s);
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
}

class C extends B {
    public C() {
        System.out.println("C");
    }
}


