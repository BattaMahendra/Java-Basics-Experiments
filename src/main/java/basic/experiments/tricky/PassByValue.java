package basic.experiments.tricky;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
* This is an example to illustrate the pass by value in java
* */
class PassByValue {
    // swap() doesn't swap i and j
    public static void swap(Integer i, Integer j)
    {
        Integer temp = new Integer(i);
        i = j;
        j = temp;
    }

    private static void addNames(List<String> list){
        list = new ArrayList<>();
        list.add("modified");
    }
    public static void main(String[] args)
    {
        //experimenting with Integer
        Integer i = new Integer(10);
        Integer j = new Integer(20);
        swap(i, j);
        System.out.println(" i = " + i + " , j = " + j);

        //experimenting with list
        List<String> names = new ArrayList<>();
        names.add("Helloo");
        addNames(names);
        System.out.println(names);

        //Experimenting with ojects
        Student s = new Student();
        s.setId(1);
        s.setName("Viswa");
        System.out.println("Before modification : "+ s);

        updateStudent(s);

        System.out.println("After modification : "+ s);
        System.out.println("In the main method and hashcode is :"+ s.hashCode());

    }

    private static void updateStudent(Student s) {
        s.setName("Viswa Modified");
        System.out.println("In the update method and hashcode is :"+ s.hashCode());
        s = new Student();
        s.setName("Mahi");
        System.out.println("In the update method and hashcode is :"+ s.hashCode());
    }
}

@Data
class Student{
    int id;
    String name;
}

