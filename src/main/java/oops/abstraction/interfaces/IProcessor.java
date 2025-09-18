package oops.abstraction.interfaces;

/*
* The interface in Java is a mechanism to achieve abstraction.
*  It is used to achieve abstraction and multiple inheritance in Java.
*
* Main uses of interface
* 1.It is used to achieve abstraction.
2.By interface, we can support the functionality of multiple inheritance.
3.It can be used to achieve loose coupling.
* */
public interface IProcessor {



  void process();

  void setCores(int cores);

  /*
  * Default methods are introduced to solve backward compatibility in Interfaces
  * Purpose: to allow interfaces to evolve without breaking existing implementations.
  *
  * 1. They can be overridden by child classes or interfaces.
  * 2. They are instance methods with a body.
  * */
   default void getDescription(){

     System.out.println("This is the processor interface");
  }

  /*
  * Static methods are Interface level methods which can be used as utility methods
  *
  * 1. They can't be overridden
  * 2. They can be directly accessed with Interface name */
  static void productionDetails(){
    System.out.println(" This design belongs to Intel company");
  }

  // we can have private methods also in interfaces which acts as supporting methods for default and static methods


}
