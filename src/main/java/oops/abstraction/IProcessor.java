package oops.abstraction;

import java.io.Serializable;

/*
* Interfaces can extend multiple interfaces*/
public interface IProcessor extends Serializable , Cloneable {

    /*Compiler by default convert below line into public abstract void process();*/
    void process();


/*
*  1. Default methods provide a default behavior that can be overridden.
   2. Useful when adding methods to existing interfaces without breaking existing implementations.
   3. They can be overridden, unlike static methods.
* */
    default void utilizeCores(){
        System.out.println("Utilizing the cores from IProcessor");
    }

}
