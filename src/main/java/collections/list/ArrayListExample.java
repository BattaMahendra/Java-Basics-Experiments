package collections.list;

import java.util.*;

public class ArrayListExample {

    void instaintiaion(){
        List list =  new ArrayList();
        list.add(new Exception());
        list.add("Hello");
        list.add(1);
        //array list allows duplicates and null values
        list.add(1);
        list.add(null);
        list.add(null);

        //you can create a array list with initial collection(preferably list)
        List<String> stringList = new ArrayList<>(List.of("hello","Hi"));

        //you can intialize with predefined size
        List<Integer> integerList = new ArrayList<>(7);

        //you can initialize with preexisting arrays
        Integer[] arr = {1,2,3,4,5};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));

        modifyList(arrayList);


    }

    private  void modifyList(ArrayList<Integer> arrayList) {
        Iterator iterator = arrayList.iterator();

        //modifying list while iterating
        while(iterator.hasNext()){

            if( (int)iterator.next() ==2 )
                 iterator.remove();        //doesn't throw concurent modification exception like in for each

          //  arrayList.remove("3");  //throws exception we are modifying without using iterator here
        }
        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        ArrayListExample obj = new ArrayListExample();
        obj.instaintiaion();
    }
}
