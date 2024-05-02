package oops.abstraction;


/*
* If there is an abstract method in a class, that class must be abstract.
* */
public abstract class Computer implements  IProcessor{

    int RAM;
    int ROM;

    {
        System.out.println(this.getClass().getName());
    }
    Computer (){
        System.out.println("In the constructor of Computer");
    }

    /*Static methods can't be overriden in java*/
    static  void specification(){
        System.out.println("Computer class static method");
    }

    @Override
   public abstract void process();

    void details(){
        System.out.println("This is a basic "+this.getClass().getName());
    }

    public void utilizeCores(){
        System.out.println("Utilizing the cores from Computer");
    }

}
