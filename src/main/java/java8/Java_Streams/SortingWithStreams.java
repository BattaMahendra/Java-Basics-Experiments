package java8.Java_Streams;

import basic.experiments.pojos.Emp;
import basic.experiments.pojos.Employee;
import basic.experiments.populating.pojos.Employees;
import basic.experiments.populating.pojos.VariablesAndTechniques;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortingWithStreams {

    public static List<Emp> employees = Employees.employeeList;
    static Comparator<Emp> advancedNameComparator = (emp1 , emp2) -> emp1.getLastName().compareTo(emp2.getLastName());


    public static void sorting(){
        System.out.println("\n===================================================\n");
        employees.stream().limit(15).forEach(System.out::println);

        System.out.println("\n sorting employees");
        //sort based on salary
         employees.stream()
                 //sorting using comparator
                 .sorted(Comparator.comparing(Emp::getSalary).reversed().thenComparing(Emp::getRating))
                 //sorting  using lambda technique
                 .sorted((emp1 , emp2) -> emp1.getFirstName().compareTo(emp2.getFirstName()))
                 //sorting with predefined comparators
                 .sorted(advancedNameComparator)
                 . forEach(System.out::println);

        System.out.println("\n===================================================\n");

        Stream.of(11,2,3,4,5,6,7,8,9,10).skip(2).sorted().forEach(System.out::print);


    }

    public static void main(String[] args) throws IOException {

        Employees employees1 = new Employees();
        employees = employees1.populateEmployees().subList(0,10);
        sorting();

    }
}
