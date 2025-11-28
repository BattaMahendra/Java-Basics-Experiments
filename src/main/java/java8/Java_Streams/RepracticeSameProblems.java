package java8.Java_Streams;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepracticeSameProblems {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0,1,1,1,1,7,8,9,5,2,36,4,78,222,24,9,2);

        //sum of numbers in the list
        int s = 0;
        for(int i=0; i<list.size(); i++){
            s+= list.get(i);
        }
        System.out.println(s);

        long s1 = list.stream().collect(Collectors.summingLong(i->i));
        System.out.println(s1);
        s = list.stream().reduce((integer, integer2) -> integer+integer2).get();
        System.out.println(s);
        IntSummaryStatistics iss = list.stream().collect(Collectors.summarizingInt(i -> i));
        System.out.println( iss.getSum());

        //average

        System.out.println(iss.getAverage());
        OptionalDouble avg = list.stream().mapToInt(i -> i).average();
        System.out.println(avg.isPresent() ? avg.getAsDouble():avg);

        int sum = list.stream().reduce( Integer::sum).get();
        int count = (int)list.stream().count();
        float a = sum/count;
        System.out.println("AVG is "+a);

        //numbers starting with 2

        List l = list.stream().map(i -> String.valueOf(i)).filter(i -> i.startsWith("2")).collect(Collectors.toList());
        System.out.println(l);

        //duplicates in the list

       List<Integer> op = list.stream().filter(i -> Collections.frequency(list,i)>1).distinct().collect(Collectors.toList());
        System.out.println(op);

        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(map.get(0));

        list.stream().forEach(i -> map.put(i, map.containsKey(i)?map.get(i)+1:1));
        System.out.println(map);
       op =  map.entrySet().stream().filter(e -> e.getValue()>1).map(Map.Entry::getKey).distinct().collect(Collectors.toList());
        System.out.println(op);

       op=  list.stream().collect(Collectors.groupingBy(i -> i,Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue()>1).map(Map.Entry::getKey).distinct().collect(Collectors.toList());
        System.out.println(op);

        op=    list.stream().filter(i -> list.indexOf(i) != list.lastIndexOf(i)).distinct().collect(Collectors.toList());
        System.out.println(op);

        List<Employee>  el = Employee.employeeList;

        //count by gender
        // ==> map(gender, count of employees)

        Map<String, Long> countByGender = el.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_gender,
                        Collectors.counting()));

        //list of names
        List<String> names = el.stream().map(e -> e.getEmp_name()).collect(Collectors.toList());
        System.out.println(names);

        names = el.stream().collect(Collectors.mapping(e -> e.getEmp_name(), Collectors.toList()));
        System.out.println(names);

        //average age of male and female employees
        Map<String, Double> genderBasedAverageAge = el.stream()
                .collect(Collectors.groupingBy(Employee::getEmp_gender,
                        Collectors.averagingDouble(Employee::getEmp_age)));

        //highest paid employee
        el.stream().map(Employee::getEmp_salary).sorted(Comparator.reverseOrder()).findFirst();

    }
}
