package inheritance;

public interface Tiger {

    void habitat();

    public default void eat(){
        System.out.println("Tiger Hunts and eats in the jungle");
    }
}
