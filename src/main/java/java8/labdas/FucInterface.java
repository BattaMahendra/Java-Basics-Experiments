package java8.labdas;

@FunctionalInterface
public interface FucInterface {


    // a functional interface should have only one abstract method
    void singleAbstractMethod();

    // A functional interface can have all the Object class methods
    boolean equals(Object o);
    int hashCode();
    String toString();



    // a functional interface can have n number of default and static methods
    default void aDefaultMethod(){
        //implementation
    }

    static void aStaticMethod(){
        //implementation
    }

}
