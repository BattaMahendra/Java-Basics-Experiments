package oops.abstraction.learning_abstraction;

public abstract class KeyBoard implements  IKeyboard{

    //this is a abstract method
    public abstract Character pressAlphabetCharacters(Character c);

    //concrete method
    public Character pressNumericValues(Character c){
        if(c >=48 && c <58){
            System.out.println(c);
            return c;
        }
        System.out.println("The input is not a numerical character");
        return null;
    }
}
