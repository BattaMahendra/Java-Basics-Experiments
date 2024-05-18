package Java_Streams;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreamProblems {

    public static List<Employee>  employeeList = Employee.employeeList;
    public static void main(String[] args) {

       // How many male and female employees are there in the organization?
        countByGender();
       // Print the name of all departments in the organization.
        employeeList.stream().map(emp -> emp.getEmp_dept()).distinct().forEach(System.out::println);

       // What is the average age of male and female employees?
        genderBasedAgeAverage();

       //Get the details of highest paid employee in the organization.
        highestPaidEmployee();

       //Who has the most working experience in the organization?  (given only date of joining)

       Employee experiencedEmployee = employeeList.stream().
                                            collect(Collectors.minBy(Comparator.comparing(Employee::getEmp_doj))).orElse(null);
        System.out.println("Details of most experienced Employee: "+experiencedEmployee);

        // Get the details of youngest male employee in the each department.
        deptWiseSorting();

        //What is the average salary and total salary of the whole organization?
        statistics();

        // Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
        partitionByAge25();

        //find 3 highest salaries
        highestSalariedEmployeesLimit3();

        // Reverse each word of a string using Java 8 streams?
        String s = " My name is Mahendra and I am practising java 8 streams";
        String output =
                Arrays.stream(s.split(" "))
                                    .map(eachWord -> new StringBuilder(eachWord).reverse())
                                    .collect(Collectors.joining(" "));
        System.out.println(output);

        //reverse a sentence
        String output2 =
                Arrays.stream(s.split(" ")).
                        reduce("", (growingSentence, eachWord) ->eachWord+" "+growingSentence );
        System.out.println(output2);

        //method:2
        // Reverse the order of words using a Stream
        StringJoiner joiner = new StringJoiner(" ");
        Stream.of(s.split(" "))
                .reduce((first, second) -> second + " " + first)
                .ifPresent(joiner::add);
        System.out.println(joiner);



    }

    private static void highestSalariedEmployeesLimit3() {
        List<Employee> highestSalaryEmployees =
                employeeList.stream()
                        .sorted(Comparator.comparingDouble(Employee::getEmp_salary).reversed())
                        .limit(3)
                        .collect(Collectors.toList());
        // if you want find only second highest then use skip(1) method.
        System.out.println("\n\n"+highestSalaryEmployees);
    }

    private static void partitionByAge25() {
        Map<String, List<Employee>> empPartitionByAge25 =
                employeeList
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                     emp -> emp.getEmp_age() <25 ? "Younger than 25":"Older than 25",
                                        HashMap::new,
                                        Collectors.mapping(
                                                e -> e,
                                                Collectors.toList()
                                        )
                                )
                        );

        empPartitionByAge25.entrySet().forEach(entry -> {
            System.out.println("\n");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        });
    }

    private static void statistics() {
        DoubleSummaryStatistics summaryStatistics =
                employeeList.stream().
                        collect(Collectors.summarizingDouble(Employee::getEmp_salary)
                        );
        System.out.println("Organisational avg salary: "+summaryStatistics.getAverage());
        System.out.println("Organisational total salary: "+summaryStatistics.getSum());
        System.out.println("Organisational max salary: "+summaryStatistics.getMax());
    }

    private static void deptWiseSorting() {
        Map<String, Optional<Employee>> youngMaleEmpDeptWise = employeeList.stream()
                                                    .filter(emp -> emp.getEmp_gender().equalsIgnoreCase("male"))
                                                    .collect(
                                                            Collectors.groupingBy(
                                                                    Employee::getEmp_dept, Collectors.minBy(Comparator.comparing(Employee::getEmp_age))
                                                            ));
        System.out.println("Details of youngest male employees deptwise "+youngMaleEmpDeptWise);

        //get the details of youngest male employees in each department

        Map<String, List<Employee>> deptWiseEmpList = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getEmp_age))
                .collect(Collectors.groupingBy(
                        Employee::getEmp_dept ,
                        Collectors.collectingAndThen(
                                       Collectors.toList(),
                                            employeeList -> {
                                            employeeList.sort(Comparator.comparing(Employee::getEmp_name).reversed());
                                            return employeeList;
                                            })

                               ));

        deptWiseEmpList.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("=======================");
        });
    }

    private static void highestPaidEmployee() {
        Employee highestSalaryEmployee = employeeList.stream().
                sorted(Comparator.comparing(Employee::getEmp_salary).reversed()).
                findFirst().orElse(null);
        //other way to find
        highestSalaryEmployee = employeeList.stream().
                                                collect(Collectors.maxBy(Comparator.comparing(Employee::getEmp_salary))).orElse(null);
        System.out.println(highestSalaryEmployee);
    }

    private static void genderBasedAgeAverage() {
        Map<String, Double> averageAgeBasedOnGender =   employeeList.stream()
                                                                    .collect(
                                                                            Collectors.groupingBy(
                                                                                    Employee::getEmp_gender,
                                                                                    Collectors.averagingDouble(Employee::getEmp_age)));
        System.out.println(averageAgeBasedOnGender);
    }

    private static void countByGender() {
        Map<String, Long> employeesGroupedByGender = employeeList.stream().collect(Collectors.groupingBy(Employee::getEmp_gender,Collectors.counting()));
        System.out.println(employeesGroupedByGender);
    }
}
