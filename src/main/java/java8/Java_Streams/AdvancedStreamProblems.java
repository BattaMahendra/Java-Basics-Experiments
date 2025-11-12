package java8.Java_Streams;

import java.util.*;
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


        String s = " My name is Mahendra and I am practising java 8 streams";
        //reverse a sentence
        reverseASentence(s);

        // Reverse each word of a string using Java 8 streams?
        everyWordReverseInSentence(s);

        String name = "Manju Angadi";

        System.out.println("\n\n\nInterview Question");
        Stream<String> st = Stream.iterate("", str -> str+"x");
        System.out.println(st.limit(3).map(str -> str+"y"));

        // xyx , yxy , xxy , map will do toString

        Stream<String> pt = Stream.iterate("", str -> str+"x");
        pt.limit(3).map(str -> str+"y").forEach(System.out::println);



    }

    private static void reverseASentence(String s) {
        System.out.println("\n========== Reverse a given sentence=========== \n given sentence:  "+s);
        String output2 =
                Arrays.stream(s.split(" ")).
                        reduce("", (growingSentence, eachWord) ->eachWord+" "+growingSentence );
        System.out.println(" After reversing: "+output2);

        //method:2
        // Reverse the order of words using a Stream
        StringJoiner joiner = new StringJoiner(" ");
        Stream.of(s.split(" "))
                .reduce((first, second) -> second + " " + first)
                .ifPresent(joiner::add);
        System.out.println(joiner);



    }

    private static String everyWordReverseInSentence(String s) {
        System.out.println("\n============= Word Reverse ==========");
        System.out.println("Before reversing\n"+s);
        String output =
                Arrays.stream(s.split(" "))
                                    .map(eachWord -> new StringBuilder(eachWord).reverse())
                                    .collect(Collectors.joining(" "));
        System.out.println("After reversing\n"+output);
        //same as above but using method references
        String y = Arrays.stream(s.split(" "))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .collect(Collectors.joining(" ","[ "," ]"));
        System.out.println(y);
        return s;
    }


    private static void highestSalariedEmployeesLimit3() {
        System.out.println("\n\n Highest Salaried employees");
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
            System.out.println("\n=================== "+entry.getKey()+" ====================");
            entry.getValue().forEach(System.out::println);

        });
    }

    private static void statistics() {
        System.out.println("\n================ Summary statistics ==============================");
        DoubleSummaryStatistics summaryStatistics =
                employeeList.stream().
                        collect(Collectors.summarizingDouble(Employee::getEmp_salary)
                        );
        System.out.println("Organisational avg salary: "+summaryStatistics.getAverage());
        System.out.println("Organisational total salary: "+summaryStatistics.getSum());
        System.out.println("Organisational max salary: "+summaryStatistics.getMax());

        /*Dept wise summary statistics*/

        Map<String, IntSummaryStatistics> deptWiseSalaryStats
                = employeeList.stream().
                     collect(Collectors.groupingBy(Employee::getEmp_dept, Collectors.summarizingInt((e -> {
                         return (int)e.getEmp_salary();
                     }))));

        System.out.println("\n================ Dept wise Summary statistics ==============================\n");
        deptWiseSalaryStats.entrySet().forEach( e -> {
            System.out.println(e.getKey()+" --> "+ e.getValue());
        });
    }

    private static void deptWiseSorting() {

        System.out.println("\n ============================ youngest male employee in each department =========================================");
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
                                            employeeList.sort(Comparator.comparing(Employee::getEmp_age).reversed());
                                            return employeeList;
                                            })

                               ));

        System.out.println("\n======= Printing list of employees(older to younger) department wise ============");
        deptWiseEmpList.entrySet().forEach(entry ->{
            System.out.println("\n============ "+ entry.getKey()+" ==============");
            entry.getValue().forEach(System.out::println);

        });
    }

    private static void highestPaidEmployee() {
        System.out.println("\n==================== Highest salaried Employee ======================");
        Employee highestSalaryEmployee = employeeList.stream().
                sorted(Comparator.comparing(Employee::getEmp_salary).reversed()).
                findFirst().orElse(null);
        //other way to find
        highestSalaryEmployee = employeeList.stream().
                                                collect(Collectors.maxBy(Comparator.comparing(Employee::getEmp_salary))).orElse(null);

        //using max()
        highestSalaryEmployee = employeeList.stream().max(Comparator.comparing(Employee::getEmp_salary)).orElse(null);

        //using max() , custom comparator
        highestSalaryEmployee = employeeList.stream().max((e1,e2) -> (int)e1.getEmp_salary()-(int)e2.getEmp_salary()).orElse(null);

        //lists all salaries from lowest to highest. i.e why we need to use reverse comparator
        employeeList.stream().sorted(Comparator.comparing(Employee::getEmp_salary)).forEach(System.out::println);
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
