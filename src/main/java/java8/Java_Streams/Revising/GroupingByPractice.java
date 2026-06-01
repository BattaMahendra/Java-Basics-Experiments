package java8.Java_Streams.Revising;

import java8.Java_Streams.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByPractice {

    public static List<Employee> employeeList = Employee.employeeList;

    public static void main(String[] args) {

        //Count Frequency of Each Character
        String input = "aabbbcc";
        Map<Character, Long> eachCharByFrequency = input.chars().
                                                            mapToObj(c -> (char)c)
                                                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        // Group Employees by Department and Get Total Salary
        Map<String, Double> deptWiseTotalSalary = employeeList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getEmp_dept,
                        Collectors.summingDouble(Employee::getEmp_salary))
                );

        // Alternative way
        deptWiseTotalSalary= employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getEmp_dept,  //---> Key mapper
                        Employee::getEmp_salary, //---> value mapper
                        (salary1, salary2) -> salary1 + salary2)    // --> value Merger
                );

        System.out.println("\n Dept wise Third highest salary \n");

        //find third highest salaried person dept wise
        Map<String, Employee> deptWiseThirdHighestSalary = new HashMap<>();

                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getEmp_dept)
                        )
                        .entrySet()
                        .stream()
                        .forEach(entry -> {


                                entry.getValue()
                                        .stream()
                                        .sorted(Comparator.comparing(Employee::getEmp_salary).reversed())
                                        .skip(2)
                                        .findFirst()
                                        .ifPresent(employee -> deptWiseThirdHighestSalary.put(entry.getKey(), employee));

                                }
                        );



        Map<String, Double> result =
                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getEmp_dept,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .map(Employee::getEmp_salary)
                                                .sorted(Comparator.reverseOrder())
                                                .skip(2)
                                                .findFirst()
                                                .orElse(null)
                                )
                        ));


  //   The above problem can also be done in this way
        Map<String, Employee> deptWiseThirdHighestSalaryWithDifferentApproach =
        employeeList.stream().collect(Collectors.groupingBy(Employee::getEmp_dept)).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        eachEntry -> {
                            Employee employee = eachEntry.getValue().stream().distinct().sorted(Comparator.comparing(Employee::getEmp_salary).reversed())
                                    .skip(2).findFirst().orElse(null);
                            return employee;
                        }
                ));

        System.out.println(deptWiseThirdHighestSalary);
      //  System.out.println("\n"+deptWiseThirdHighestSalaryWithDifferentApproach);

        // Partitioning by even or odd
        System.out.println("\n Partitioning a list by even or odd \n");
        List<Integer> nums = List.of(1,2,3,4,5,6);
        Map<String, List<Integer>> partitionedNums = nums.stream().collect(Collectors.groupingBy(
                i -> i%2 == 0?"Even":"Odd"
        ));
        System.out.println("\n"+partitionedNums);

        // highest paid employee
        System.out.println("\n Highest paid employee \n");

        Map<String, Optional<Employee>> deptWiseHighestPaidEmployee = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getEmp_dept,
               Collectors.maxBy(Comparator.comparing(Employee::getEmp_salary))
        ));

        // more cleaner approach
        Map<String, Employee> result3 =
                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getEmp_dept,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Employee::getEmp_salary)),
                                        optionalEmp -> optionalEmp.orElse(null)
                                )
                        ));

      //  Group Employees by Department → Then by Salary Range
        System.out.println("\n Group Employees by Department → Then by Salary Range \n");

        Map<String, Map<String, List<Employee>>> deptWiseSalaryRange =
        employeeList
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getEmp_dept,
                        Collectors.groupingBy(emp -> {
                            if(emp.getEmp_salary() < 50000) return "LOW";
                            else if (emp.getEmp_salary() <= 100000) return "MID";
                            else return "HIGH";
                        })
                ));

        //Group Words by First Character → Then Length
        System.out.println("\n Group Words by First Character → Then Length \n");
        List<String> words = List.of("cat", "dog", "elephant", "bat");

        Map<Character, Map<Integer, List<String>>>  groupedWords =
            words.stream()
                .map(String::trim)
                .distinct()
                .collect(Collectors.groupingBy(
                        s -> s.charAt(0),
                        Collectors.groupingBy(String::length))
                );

        //another way for above problem




        // Group employees by Dept and list of their names only
        Map<String, List<String>> deptWiseEmployeeNames =
         employeeList
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getEmp_dept,
                        Collectors.mapping(
                                Employee::getEmp_name,
                                Collectors.toList()))
                );
        // Group by Department → Set of Salaries

        Map<String, Set<Double>> deptWiseSalaries;

        deptWiseSalaries = employeeList
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getEmp_dept,
                        Collectors.mapping( Employee::getEmp_salary, Collectors.toSet()))
                );

        // Group Employees by Department → Top 2 Highest Salaries


        Map<String, List<Employee>> deptWiseTop2HighestSalaries = new HashMap<>();
        employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getEmp_dept))
                .entrySet()
                .stream()
                .forEach(entry -> {
                    deptWiseTop2HighestSalaries.put(entry.getKey(),
                    entry.getValue()
                            .stream()
                            .sorted(Comparator.comparing(Employee::getEmp_salary).reversed())
                            .limit(2)
                            .collect(Collectors.toList())
                    );
                });

        // the above can be rewritten as
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_dept))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                                .stream()
                                .sorted(Comparator.comparing(Employee::getEmp_salary).reversed())
                                .limit(2)
                                .collect(Collectors.toList())
                        )
                );

        // the above can be still reduced as
//        employeeList.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getEmp_dept,
//                        Collectors.collectingAndThen(
//                                Collectors.toList(),
//                                        ( list) -> list.stream()
//                                                            .sorted(Comparator.comparing(Employee::getEmp_salary).reversed())
//                                                            .limit(2))
//                                                            .collect(Collectors.toList())
//                        )
//                );


        // What if we have duplicate salaries i.e salaries are ( 100, 100, 90 , 90, 60, 40, 20)
        // then top 2 highest salaried employees are 4 members

        Map<String, List<Employee>> deptWiseTop2HighestSalariesWithDuplicateSalaries =
                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getEmp_dept,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            // Step 1: find top 2 distinct salaries
                                            List<Double> top2Salaries =
                                                    list.stream()
                                                            .map(Employee::getEmp_salary)
                                                            .distinct()
                                                            .sorted(Comparator.reverseOrder())
                                                            .limit(2)
                                                            .collect(Collectors.toList());

                                            // Step 2: filter employees having those salaries
                                            return list.stream()
                                                    .filter(e -> top2Salaries.contains(e.getEmp_salary()))
                                                    .collect(Collectors.toList());
                                        }
                                )
                        ));



        // Most frequent element in the list
        List<String> words2 = List.of("apple", "banana", "apple", "cherry", "banana", "apple");

       String mostFrequent = words2.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting())
                )
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);




        System.out.println("\n Most frequent element: " + mostFrequent);

    }
}
