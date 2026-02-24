package interview_q;


/*
*
* This is a circular dependency problem how do you solve it ?
* --> I just used null to just compile it. But actual solution is to use setter injection
* */
public class CircularDependency {

    public static void main(String[] args) {
        A a = new A(new B( new A(null)));
    }
}

class A {

    B b;
    public A(B b){
        this.b = b;
    }
}

class B {
    A a;
    public B(A a){
        this.a = a;
    }

}
