package java8.functional_interfaces;

import basic.experiments.populating.pojos.VariablesAndTechniques;
import java8.Java_Streams.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Test {

    static List<Employee> employeeList = Employee.populateEmployee();

    //Function --> takes a input and returns a output
    static Function<List<Employee>, List<String>>
            getNamesOfEmployees =
                                employeeList -> employeeList.stream().map(Employee::getEmp_name).collect(Collectors.toList());

    // takes two intput parameter and returns a output paramter
    static BiFunction<Integer , Integer , Integer> addition = ( i ,j) -> i+j;

    //Consumer --> takes a input param and returns nothing
    static Consumer<List<Employee>> printDepartmentsOfEmployees = employeeList -> employeeList.stream().map(Employee::getEmp_dept).forEach(System.out::println);

    //Predicate --> accepts input and returns boolean
    static Predicate<Employee> checkForFemale = (e) -> e.getEmp_gender().equalsIgnoreCase("Female");

    //Supplier --> accepts nothing but returns something
    Supplier<List<Employee>> getFemaleEmployees = () -> employeeList.stream().filter(checkForFemale).collect(Collectors.toList());

    public static void main(String[] args) {
        System.out.println("================= Functions in action ===================");
        functionIllustration();

        int sum = addition.apply(1,2);

        System.out.println("================= Consumer in action ===================");
        printDepartmentsOfEmployees.accept(employeeList);

        System.out.println("================= Predicate and Supplier in action ===================");
        Test t = new Test();
        t.getFemaleEmployees.get().forEach(System.out::println);
    }

    private static void functionIllustration() {
        //illustrating Function type --> apply method
        getNamesOfEmployees
                .apply(employeeList).forEach(System.out::println);

        // we can use another method called andThen

        Object[] namesArray =  getNamesOfEmployees
               .andThen(List::toArray)   // and then takes another Function as input (List.toArray is predefined type of Functional interface)

               .apply(employeeList);

        System.out.println(Arrays.toString(namesArray));
    }


}
