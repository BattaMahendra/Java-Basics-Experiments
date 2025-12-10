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

        System.out.println("==================== Chaining =========================");
        //chaining  ==> in optional chaining , you don't need to do explicit null checks - internally it does for you. ==> just concentrate on logic.
        //finding employee salary who is male and age above 21
        employeeList.stream().findAny()
                //findAny() in stream usually return optional
                // the below filter(), map() belong to Optional class and not the stream one.
                .filter( employee1 -> employee1.getEmp_gender().equals("Male"))
                .filter(emp -> emp.getEmp_age()>21)
                .map(employee1 -> employee1.getEmp_salary())
                .map(salary -> {System.out.println(salary); return salary;})
                .orElse(0.0);

        System.out.println("=============== Without Optional ================");

        // rewriting above without using optional

                Employee foundEmployee = null;

                // Step 1: mimic findAny()
                for (Employee employee : employeeList) {
                    foundEmployee = employee;
                    break; // pick any one element
                }

                if (foundEmployee != null) {

                    // Step 2: first filter
                    if ("Male".equals(foundEmployee.getEmp_gender())) {

                        // Step 3: second filter
                        if (foundEmployee.getEmp_age() > 21) {

                            // Step 4: map to salary
                            Double salary = foundEmployee.getEmp_salary();

                            // Step 5: side effect
                            System.out.println(salary);

                        }
                    }
                }
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
        // it is safer to use Optional.ofNullable() which means it might contain null or non-null
        Optional<String> mayBeName = Optional.ofNullable(name);
        System.out.println(mayBeName);

        //very bad practice - how can optional itself be null - optional should be used as wrapper class
        Optional<String> opt = null; // ❌ pointless and wrong

        /*.get() method returns value if present , if not then throws no such element exception
        So don't ever use get() until you are sure. It is bad practise*/
        //mayBeName.get();

        /*How to avoid it
        * use orElse() to return a default value if its not present*/
        int length = mayBeName.map(String::length)
                              .orElse(0);
        System.out.println(length);

        //traditional approach with Optional - isPresent():boolean
        if(mayBeName.isPresent()){
            System.out.println(mayBeName.get());
        }else{
            System.out.println("mayBeName is empty");
        }

        // functional approach which combines optional and java-8
        //ifPresent(Consumer) --> executes consumer if value is present , if not doesn't do anything
        mayBeName.ifPresent(System.out::println);
    }
}
