package java8.labdas;

public class Test {

    /*
    * Functional programming enables us to write more clean and maintainable code
    * */

    String instanceVariable = "Test class instance variable";
    static String staticVariable = "Test class static variable";

   static  FucInterface fucInterface1 = new FucInterface() {
        @Override
        public void singleAbstractMethod() {
            System.out.println("performing function using anonymous inner classes");
        }
    };

    //We can avoid above implementation  using Lambdas
    static FucInterface fuc2 = () -> System.out.println("We are using lambdas ");

    // Note that anonymous inner classes can have state (Object) but lambdas can't have that

    static FucInterface fuc3 = new FucInterface() {
        // it can have its own objects state
        //anonymous inner classes can have its own instance variables
        String variable = "instance Variable";
        @Override
        public void singleAbstractMethod() {
            System.out.println(this.variable);
        }
    };

    //we can't do that with lambdas

    //FucInterface fuc4 = () -> System.out.println(this.);

    FucInterface printInstanceVariable = () -> System.out.println(this.instanceVariable);


    public static void main(String[] args) {
        fucInterface1.singleAbstractMethod();

        //using lambdas
        fuc2.singleAbstractMethod();

        //anonymous inner class with a instance variable
        fuc3.singleAbstractMethod();

        //Behaviour of lambdas with local variables , instace variables and static variables

        String local = "local variable";
        FucInterface fuc5 = ()->{
            System.out.println(local);
            //Variable used in lambda expression should be final or effectively final
            // the below line can't be executed
           // local = "local variable modified";
        };

        System.out.println("\n Before changing the instance variable");
        Test t = new Test();
        t.printInstanceVariable.singleAbstractMethod();
        System.out.println(" After changing the instance variable");
        t.instanceVariable = "Test class instance variable modified";
        t.printInstanceVariable.singleAbstractMethod();

        //we can access Object class methods with functional interfaces

        System.out.println( fuc2.hashCode());
        System.out.println( fuc2.toString());






    }
}
