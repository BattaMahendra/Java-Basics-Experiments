package oops.inheritance;

public interface Lion {
    void habitat();

    public default void eat(){
        System.out.println("Lion Hunts and eats in the Savannah!");
    }
}
