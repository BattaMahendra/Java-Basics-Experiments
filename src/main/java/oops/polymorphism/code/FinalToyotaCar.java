package oops.polymorphism.code;

/*
* A final class can't be extended by anyother class
* */

import lombok.ToString;

@ToString
public final class FinalToyotaCar {

    //static final variable
    public static final String  company ="Toyota";

    //static uninitialized variable --> it must be initialized in the static block
    public static final String manufacturingUnit;

    static {
        manufacturingUnit = "China";
    }

    //instance final variable --if uninitialized then it must be initialized in constructor

    public final String color;
    public  String customization;

    public final String wheels ="MRF";

    /*
    * Constructor can't be final as it can't be inherited
    * */
    public  FinalToyotaCar(String carColor){
        this.color = carColor;
    }

    //static final method
    //If you make any method as final, you cannot override it.

    public static final void standardModel(){
        System.out.println("Standard model car has been ordered");
    }

    //final method -- it can't be overrided

    public final void customCar(String customization){
        this.customization = customization;
    }

    // we can make main method also final, but it doesn't make any difference as main method is
    //already a static method which can't be overrided.

    public static final void main(String[] args) {

        FinalToyotaCar car1 = new FinalToyotaCar("Orange");

        car1.customCar("custom wheels");

        System.out.println(car1);


    }


}
