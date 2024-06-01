package java8.method_references;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;

@NoArgsConstructor
public class Test {

    String instanceVariable;
    Test(String message){
        this.instanceVariable = message;
    }

    //a static method
    public static void aStaticMethod(){
        System.out.println("I am static method of Test class");
    }

    //a instance method
    public  void anInstanceMethod(){
        System.out.println("I am an instance method of Test class "+ toString());
    }

    @Override
    public String toString() {
        String s = "\nI am overrided toString of Test class";
        return s;
    }

    public static void main(String[] args) {

        IPerformer staticMethodReference = Test::aStaticMethod;
        //the above code is same as
        IPerformer staticWithoutMethodReference = ()->Test.aStaticMethod();
        staticMethodReference.perform();;

        Test obj1 = new Test();
        IPerformer instanceMethodCall = () -> obj1.anInstanceMethod();
        //it can be replaced with method reference
        instanceMethodCall = obj1::anInstanceMethod;
        instanceMethodCall.perform();

        //creating objects using method reference
        IPerformer createObj = ()-> new Test();
        createObj = Test::new;

        System.out.println(createObj);

        //we can also use method reference for predefined libraries in java

        //convert a list of strings into integers in java
        List<String> listOfStringNums = List.of("1" ,"2","3");

        int sum =listOfStringNums
                .stream()
               // .map(s -> Integer.parseInt(s))
                .map(Integer::parseInt)
              //  .reduce(0,(e1,e2)->e1+e2);
                .reduce(0,Integer::sum);
        System.out.println(sum);


    }




}
