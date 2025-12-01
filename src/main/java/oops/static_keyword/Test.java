package oops.static_keyword;

class A {

    int i = 1;

    public static void print(){
        System.out.println("We are in static method of A");
    }
}

class B extends  A{

    int i = 2;

    public static void print(){
        System.out.println("We are in static method of B");
    }
}

class C extends B{

    int i = 3;
    public static void print(){
        System.out.println("We are in static method of C");
    }
}


public  class Test{
    public static void main(String[] args) {

        C c = new C();
        c.print();
        System.out.println(c.i);
        C.print();
        A.print();

        A a = new C();
        a.print();
        System.out.println(a.i);
        B b = new C();
        b.print();
        System.out.println(b.i);
    }
}
