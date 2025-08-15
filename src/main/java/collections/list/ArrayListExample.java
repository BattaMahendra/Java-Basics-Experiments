package collections.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

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

    public static void addElements(ArrayList arr,int size){

        for(int i = 0; i <size; i++){
            arr.add(i);
        }

    }

    public static void main(String[] args) {
        ArrayListExample obj = new ArrayListExample();
        obj.instaintiaion();

        //thread-safe variant of array list --> CopyOnWriteArrayList

        CopyOnWriteArrayList<String> synchronisedList = new CopyOnWriteArrayList<>();
        synchronisedList.add("Hello");
        synchronisedList.add("hi");

        /*
        * Here we are modifying the copyOnWriteArrayList while iterating and as you can observe
        * it doesn't throw concurrentModificationException. If its a plain arraylist then it would throw the exception*/
        for(int i =0; i < synchronisedList.size(); i++){

            synchronisedList.add("Hey");
            System.out.println(synchronisedList.get(i));
        }




    }
}
