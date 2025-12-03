package oops.abstraction;

import lombok.NoArgsConstructor;

/*
* If you are extending an abstract class that has an abstract method,
*  you must either provide the implementation of the method or make this class abstract.*/
@NoArgsConstructor
public class Laptop extends  Computer{
    /**
     *
     */

    Laptop(int ram , int rom){
        super();
        this.RAM = ram;
        this.ROM = rom;
    }
    @Override
   public void process() {
        System.out.println(" Being processed by Laptop");
    }

    /**
     *
     */


    @Override
    public void details(){
        System.out.println("this is overrided method from "+this.getClass());
    }


}
