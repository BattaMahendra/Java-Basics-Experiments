package java8.optional;

import basic.experiments.pojos.Address;
import basic.experiments.pojos.Employee;

import java.util.Optional;

public class Why {

    /**
     * Optional is introduced in java 8 to reduce the risk of NPE
     * Optional as a single-value container that either contains a value or doesn't (it is then said to be "empty")
     *
     * In this class we will get to know how it helps dev */

    public static void main(String[] args) {

        Employee employee = new Employee();
        // for example now if we want to check whether employee home district is Anantapur or not
        //traditional nested checks
        System.out.println(traditonalNullChecks(employee));


        // with Optional
        System.out.println(withOptionalCheck(employee));


    }

    /**
     * How does optional solve our problem
     * <p>
     * First of all there is no performance improvement compared to nested conditonal statements
     * rather optional is a bit slower due to wrapping
     * then how does it help us ?
     * <p>
     * Optional is container which might contain value or not
     * So developer is forced to check the conditions
     * With Optional, the compiler/type system forces the caller to handle absence.
     * <p>
     * if a method is returning Optional then dev is enforced by syste to check for null
     * So this reduces the possibility of risk of NPE
     * <p>
     * one more advantage is it comes with functional style approach which combines java 8 stream methods
     *
     * @return
     */

    private static String withOptionalCheck(Employee employee) {
        Optional<Employee> empOpt = Optional.ofNullable(employee);

        return empOpt.map(Employee::getAddress)
                .map(Address::getDistrictName)
                .filter(district -> district.equals("ATP"))
                .orElse("No District");
    }

    /*
* This is a traditional null checks usually with nested conditional statements
* The problem here is developer need to remember the null checks otherwise somewhere it might throw npe
* Sometimes null might occur due not only absence of value but also due to some other problems
* Always remember - Null checks are procedural and can be skipped by mistake.
*
* So dev has to remember and check
* *  */
    private static String traditonalNullChecks(Employee employee) {
        if(employee.getAddress()!=null){
            String district = employee.getAddress().getDistrictName();

            //Easy to forget a null check → risk of NullPointerException.
            if(district!= null && district.equals("ATP")) {
                return district;
            }

        }
        return "NOT FOUND";
    }
}















/**
 * Where should we use Optional and where not?
 * Answer:
 * ✅ Use Optional as return type from repository/service methods when value may not exist.
 * ❌ Avoid in fields (e.g., JPA entities) → complicates serialization.
 * ❌ Avoid in method parameters → unnecessary overhead.
 * ❌ Avoid in collections → better to return empty collection instead of Optional<List<T>>.
 *
 * What are best practices in Optional ?
 *
 * Best practice: use .orElse, .orElseThrow, .ifPresent instead of .get().
 * because .get() is same as null check and can cause problems
 *
 *
 * ✅ Crisp takeaway line for interview:
 * "Optional doesn’t replace null checks for performance.
 * Its real strength is in making the possibility of absence explicit in the type system,
 * forcing safe handling and improving API clarity, while reducing the chances of runtime NullPointerExceptions."
 * */

