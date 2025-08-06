package oops.abstraction.learning_abstraction;

public class AppleKeyboard extends  KeyBoard{
    @Override
    public Character pressAlphabetCharacters(Character c) {

        if((c >=65 && c <91)||( c>=97 && c <= 123)){
            System.out.println(c);
            return c;
        }
        System.out.println("The input is not a alphabet character");
        return null;
    }

    @Override
    public void multimediaKeys(Object functionKey) {

        if(String.valueOf(functionKey).equals("F10")
             || String.valueOf(functionKey).equals("F11")
             || String.valueOf(functionKey).equals("F12")){

            System.out.println("Change in volume of the system");

        }else if(String.valueOf(functionKey).startsWith("F")){

            System.out.println("Enabling function mode multimedia key");
            // further specific implementation if required

        }else{

            System.out.println("Invalid input");
        }
    }

//    public Character pressNumericValues(Character c){
//        System.out.println(" Apple keyborad specific method");
//        return c;
//    }
}
