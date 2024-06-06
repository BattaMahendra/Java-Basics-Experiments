package experiment;

import basic.experiments.pojos.Employee;

public class Test {
    public static void main(String[] args) {
        Integer i =1;
        Integer j= 1;
        if(i==j) System.out.println("true");
        else System.out.println("false");

        Employee emp1 = new Employee();
        emp1.setFirstName("Pavan");

        Employee emp2 = new Employee();
        emp2 .setFirstName(emp1.getFirstName());
        System.out.println("before assigning "+ emp2);

        emp1.setFirstName("Mahendra");

        System.out.println(emp1+"\n"+emp2);
    }
}
