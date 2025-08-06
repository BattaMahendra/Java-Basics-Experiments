package oops.inheritance.basic_experiments;

public class Animal {

    public Animal(){
        System.out.println("Animal is being constructed");
    }

    public void lives(){
        System.out.println("Animal lives");
    }

    public void eat(){
        System.out.println("Animal eats");
    }
}

class Dog extends  Animal{

    public Dog(){
        System.out.println("Dog is being constructed");
    }

    @Override
    public void lives(){
        System.out.println("Dog lives");
    }

}

class Puppy extends  Dog{

    public Puppy(){
        System.out.println("Puppy is being constructed");
    }

    @Override
    public void lives(){
        System.out.println("Puppy lives");
    }

}
