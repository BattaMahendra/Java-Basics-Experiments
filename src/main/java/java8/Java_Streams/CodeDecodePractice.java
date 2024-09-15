package java8.Java_Streams;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeDecodePractice {

    public static List<Employee> employeeList = Employee.employeeList;

    public static void main(String[] args) {

        /*
        * Partitioning - returns a map with Boolean
        * */
        partitioning();

        /*
        * counting() - return a long variable containing size of given collection
        * */
        counting();

        /*
        * IntSummaryStatistics/DoubleSummaryStatistics - gives various operations like max, min, avg on a collection of integers
        *  */
        doubleSummaryStatistics();

    }

    private static void doubleSummaryStatistics() {
        System.out.println("\n=========================== doubleSummaryStatistics ================");
        DoubleSummaryStatistics salaryStatistics =
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getEmp_salary));
        System.out.println(salaryStatistics);
    }

    private static void counting() {
        System.out.println("\n=========================== counting ================");
        //count employees based on gender
        employeeList.stream().collect(Collectors.groupingBy(
                Employee::getEmp_gender,
                Collectors.counting()
        )).entrySet().forEach(System.out::println);
    }

    private static void partitioning() {
        System.out.println("\n====================== partitioning =====================");
        //partition employees based on salary below 15k and above 15k

        Map<Boolean, List<Employee>> partitionedEmp = employeeList.
                                                        stream().
                                                        collect(
                                                                //partitioning employees based on salary of 15k
                                                                Collectors.partitioningBy(emp -> emp.getEmp_salary()>=15000)
                                                        );

        System.out.println(partitionedEmp);
    }
}
