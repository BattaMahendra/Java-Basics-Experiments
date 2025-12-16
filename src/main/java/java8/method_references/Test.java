package java8.method_references;


import basic.experiments.pojos.Employee;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
        staticMethodReference.perform();
        staticWithoutMethodReference.perform();

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


        //object method reference
      Employee employee = new Employee();
      //now if you have a specific object and want to apply method reference
        Supplier<String> getEmployeeName = () -> employee.getFirstName();

        Supplier<String> getEmployeeNameByMethodReference = employee::getFirstName;

        //Sometimes we do this
        Function<String, Integer> f1 = s -> s.length();   // Lambda
        Function<String, Integer> f2 = String::length;    // Method reference
        f2.apply("Mahendra");
        /**
         * Here, String::length doesn’t specify which string.
         * When you call f2.apply("Mahendra"), it runs "Mahendra".length().
         * So the string object ("Mahendra") is the arbitrary object supplied at runtime
         *
         * The above is although instance we have used String (class name) instead of object
         * "Instance method of arbitrary object of a particular type".
         * */

        /**
         *
         * 📜  Method reference is NOT magic. ⁀➴ It’s just a prettier lambda.
         * If a lambda is just:
         *
         * “Take input → call a method with it”
         * then method reference is perfect.
         *
         * ✅ ClassName::methodName  ➤ static method
         * ✅ objectRef::methodName  ➤ instance method
         * ✅ ClassName::new         ➤ constructor
         *
         * 🔴 When You CAN Use Method Reference
         * ✅ When
         * Lambda body has single method call
         * Parameters match automatically
         * No additional logic
         *
         * ❌  method reference won't work for below lambda.
         *      x -> {
         *          System.out.println(x);
         *          return x.length();
         *      }
         *
         *
         *
         * ⚠️⚠️⚠️
         * Method Reference vs Lambda (Quick Decision Rule)
         *
         * 👤 Ask yourself:
         *
         * ⭐⭐⭐⭐⭐ “Is my lambda doing anything other than calling ONE existing method?”
         *
         * ➪ Yes → Lambda
         *
         * ➪ No → Method reference ✅
         *
         * Thank You 😊❣️
         * */


    }




}
