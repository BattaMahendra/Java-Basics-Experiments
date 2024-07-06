package experiment;

import basic.experiments.pojos.Employee;

import java.util.HashMap;
import java.util.HashSet;

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

        ShallowDeep obj1 = new ShallowDeep();
        ShallowDeep obj2 = obj1;
        obj1.print();
        obj2.print();
        obj1.name = "Mahendra";
        System.out.println("=========");
        obj1.print();
        obj2.print();

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        // Deep copy

        ShallowDeep obj3 = new ShallowDeep();
        ShallowDeep obj4 = new ShallowDeep();
        obj3.name = "Old";
        obj3.print();
        obj4.name = obj3.name;
        obj3.name = "new";

        obj3.print();
        obj4.print();
        HashSet<String> s = new HashSet<>();
        System.out.println(s.add("Mahendra"));
        System.out.println(s.add("Mahendra"));

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println(hashMap.put(5,1));
        System.out.println(hashMap.put(5,5));
        System.out.println(hashMap.put(5,6));
        try {
            int k = 1 / 0;
        } catch (Exception ex) {
            System.out.println(ex.toString() + "\n next \n");
            System.out.println(ex.getMessage() + "\n next \n");
            ex.printStackTrace();


        }
    }
}
class ShallowDeep{

    public ShallowDeep(){

    }

    public ShallowDeep(String name){
        this.name = name;
    }
    String name;
    public void print(){
        System.out.println(name);
    }
}
