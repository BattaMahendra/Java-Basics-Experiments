package oops.inheritance;

/*
* Talking about Multiple inheritance is
* when a child class is inherits the properties from more than one parents and
* the methods for the parents are same (Method name and parameters are exactly the same)
* then child gets confused about which method will be called.
*  This problem in Java is called the Diamond problem.*/

/*
* Here we are achieving multiple inheritance in java using interfaces.
* If we try to achieve multiple inheritance using java classes then it leads to
* Diamond problem which is serious issue */
public class Liger  implements  Lion,Tiger{

    /*
    * This is a same abstract method which is present in both parent classes.
    * The child class can just override it and can give its own implementation as below.*/
    @Override
    public void habitat() {
        System.out.println("Liger lives in the zoo");
    }
    /*
    * Here we have eat() method as default in both interfaces.
    * When overriding we can specifically call any default method from both
    * parent classes using super keyword which solves the diamond problem */

    @Override
    public void eat() {
        Lion.super.eat();
        Tiger.super.eat();
        System.out.println("Liger eats the food in the zoo");
    }


}
