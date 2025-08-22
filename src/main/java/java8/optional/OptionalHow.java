package java8.optional;

import basic.experiments.pojos.Address;
import java8.Java_Streams.Employee;

import java.util.List;
import java.util.Optional;

public class OptionalHow {

    public static void main(String[] args) {

        creatingOptionalAndBasicUsage();

        List<Employee> employeeList = Employee.populateEmployee();

        Employee employee = employeeList.get(1);
        Optional<Employee> employeeOptional = Optional.ofNullable(employee);

        variousMethodsInOptional(employeeOptional, employeeList);
    }

    private static void variousMethodsInOptional(Optional<Employee> employeeOptional, List<Employee> employeeList) {
        //isPresent() --> returns true or false just like a null check
        if(employeeOptional.isPresent()){
            System.out.println(employeeOptional.get().getEmp_name());
        }
        //the above can be rewritten as using ifPresent(Consumer)
        employeeOptional.ifPresent(value -> System.out.println(value.getEmp_name()));
        //Java 9 introduced ifPresentOrElse(Consumer,runnable)
        employeeOptional.ifPresentOrElse(System.out::println, ()-> System.out.println("No employee found"));

        //map(function) --> returns an optional value if present , executes orElse if not.
        employeeOptional.map(Employee::getEmp_salary).orElse(0.0);

        //chaining
        //finding employee salary who is male and age above 21
        employeeList.stream().findAny()
                //findAny() in stream usually return optional
                .filter( employee1 -> employee1.getEmp_gender().equals("M"))
                .filter(emp -> emp.getEmp_age()>21)
                .map(employee1 -> employee1.getEmp_salary())
                .map(salary -> salary%100)
                .orElse(0.0);
    }


    private static void creatingOptionalAndBasicUsage() {
        // Creating an empty optional
        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        // we can wrap an object with Optional.of() if the value is present
        String name = "Mahendra";
        Optional nameOptional = Optional.of(name);
        System.out.println(nameOptional);

        //if the original value is null then wrapping with of() throws NPE
        name = null;
        //Optional.of(name);

        //In such ambiguous cases when you don't know original has null or not
        // it is safer to use Optional.ofNullable() which means it might contain null or non null
        Optional<String> mayBeName = Optional.ofNullable(name);
        System.out.println(mayBeName);

        /*.get() method returns value if present , if not then throws no such element exception
        So don't ever use get() until you are sure it is bad practise*/
        //mayBeName.get();

        /*How to avoid it
        * use orElse() to return a default value if its not present*/
        int length = mayBeName.map(String::length)
                              .orElse(0);
        System.out.println(length);

        //ifPresent(Consumer) --> executes consumer if value is present , if not doesn't do anything
        mayBeName.ifPresent(System.out::println);
    }
}
