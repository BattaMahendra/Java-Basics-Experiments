package oops.abstraction;

import java.io.Serializable;

/*
* Interfaces can extend multiple interfaces*/
public interface IProcessor extends Serializable , Cloneable {

    /*Compiler by default convert below line into public abstract void process();*/
    void process();

    default void utilizeCores(){
        System.out.println("Utilizing the cores from IProcessor");
    }

}
