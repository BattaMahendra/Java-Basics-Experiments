package oops.abstraction;

import oops.abstraction.learning_abstraction.AppleKeyboard;
import oops.abstraction.learning_abstraction.IKeyboard;
import oops.abstraction.learning_abstraction.KeyBoard;

public class Test {

    public static void main(String[] args) {
        /*This is one of benefits of abstraction , User can provide any subclass of Computer
        * class and the lap reference accepts it.*/
        Computer lap = new Laptop();
        lap.process();
        lap.details();
        lap.utilizeCores();
        Laptop.specification();
        System.out.println("====================================");
        Laptop lap2 = new Laptop(10,100);

        KeyBoard keyBoard = new AppleKeyboard();

        keyBoard.pressAlphabetCharacters('u');
        keyBoard.multimediaKeys("F10");
        keyBoard.pressNumericValues('8');



    }
}
