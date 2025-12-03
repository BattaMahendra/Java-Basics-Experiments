package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiThreading {

    public static void main(String[] args) throws InterruptedException {

        /*
        * Here you can check the multithreading compatibilities by commenting each arraylist type*/

        // normal array list
        List<Integer> arr = new ArrayList<>();

        //same above arraylist synchronised
        arr = Collections.synchronizedList(arr);

        // copyOnwriteArrayList which is a synchronised one
       // CopyOnWriteArrayList arr = new CopyOnWriteArrayList<Integer>();

        MyRunnable runnable1 = new MyRunnable(arr,1,1000);
        MyRunnable runnable2 = new MyRunnable(arr,1001,2000);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // here ideal size should be 2000
        System.out.println(arr.size());


    }
}

class MyRunnable implements Runnable{

    private List<Integer> arrayList;
    int start;
    int end;

    public MyRunnable(List<Integer> arrayList, int start, int end) {
        this.arrayList = arrayList;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        addElements(this.arrayList,this.start,this.end);

    }

    public static void addElements(List<Integer> arr, int start, int end){

        for(int i = start; i <=end; i++){
            arr.add(i);
        }

    }
}
