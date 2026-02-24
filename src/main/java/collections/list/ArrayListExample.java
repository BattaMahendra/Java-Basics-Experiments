package collections.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List list1 = Arrays.asList(arr);  // this is also returns ArrayList with fixed size of the given array
       // list1.add(3);  // throws exception at runtime because here list1 is an ArrayList with fixed size of 5. can't add any thing to it.
        //below is possible
        list1.set(0, 0);
        System.out.println(list1);

        System.out.println("\n -----------------------------\n");
        int[] arr2 = {1,2,3,4,5};
        List list2 = Arrays.asList(arr2);
        System.out.println(list2.size());  // very interesting behaviour - cause whole int[] is treated as single element in array list.

        // to avoid above scenarios do this - we will get a standard resizable array
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5})); // we can also do explicitly

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
        threadSafeVariants();

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        arrayList.set(0,2);  // just sets the element at 0 index
        arrayList.add(1, 1000); // adds the element at 1 index and shifts all elements towards right
        System.out.println(arrayList);


        // Array initialization techniques

        //With initial Size
        List<Integer> list = new ArrayList<>(25); // best if we already know the initial size - avoids frequent resizing

        // Using Arrays.asList()
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));

        Integer[] arr = new Integer[]{1,2,4,5,6};
        List<Integer> list2 = new ArrayList<>(Arrays.asList(arr));

        /*
        * Using Collections.addAll()*/
        List<String> list7 = new ArrayList<>();
        Collections.addAll(list7, "A", "B", "C");

        // JAVA 9+. Using List.of()
        List<String> fixed = Arrays.asList("A", "B"); // fixed size!
        fixed.add("C"); // ❌ UnsupportedOperationException

        // so wrap it with ArrayList
        List<String> list3 = new ArrayList<>(List.of("A", "B", "C"));


        //double brace initialization
        List<String> list4 = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }};

        /*
        * The above is not recommended as it is using anonymous class and an instance block.
        *  it creates Extra class file
        * */

        //streams
        List<String> list5 =
                Stream.of("A", "B", "C")
                        .collect(Collectors.toCollection(ArrayList::new));



    }

    private static void threadSafeVariants() {
        CopyOnWriteArrayList<String> copyOnWrteArrayList = new CopyOnWriteArrayList<>();
        copyOnWrteArrayList.add("Hello");
        copyOnWrteArrayList.add("hi");

        List<Integer> l2 = new ArrayList<>(List.of(1,2,3));
        List<Integer> synchronizedList = Collections.synchronizedList(l2);

        /*
        * Here we are modifying the copyOnWriteArrayList while iterating and as you can observe
        * it doesn't throw concurrentModificationException. If its a plain arraylist then it would throw the exception*/
        for(int i =0; i < copyOnWrteArrayList.size(); i++){

//            copyOnWrteArrayList.add("Hey");
            System.out.println(copyOnWrteArrayList.get(i));
        }

        // same with Collections.synchronizedList() also
        for(int i =0; i < synchronizedList.size(); i++){

//            synchronizedList.add(1);
            System.out.println(synchronizedList.get(i));
        }
    }
}
