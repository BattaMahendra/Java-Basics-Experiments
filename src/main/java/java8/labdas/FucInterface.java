package java8.labdas;

@FunctionalInterface
public interface FucInterface {

    // read about inheritance in functional interfaces
    /*
    * A functional interface can extend another functional interface as long as the derived interface still has only one abstract method.
    * */



    // a functional interface should have only one abstract method
    void singleAbstractMethod();

    // A functional interface can have all the Object class methods
    boolean equals(Object o);

    int hashCode();

    String toString();


    // a functional interface can have n number of default and static methods
    default void aDefaultMethod() {
        //implementation
    }

    static void aStaticMethod() {
        //implementation
    }

}


//this inheritance is valid as long as SecondFunctionalInterface doesn't have its own method
//it can still override the abstract method in above interface.
@FunctionalInterface
interface  SecondFunctionalInterface extends FucInterface{

}

// this is still valid because the below FI still has only one abstract method
// It is just using its parent abstract method
@FunctionalInterface
interface  ThirdFunctionalInterface extends FucInterface{
    @Override
    void singleAbstractMethod();


}
