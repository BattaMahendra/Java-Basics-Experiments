package multi_threading.synchronization;

import multi_threading.CustomRunnable;
import multi_threading.TestMultiThreading;

public class TestSynchronisation extends TestMultiThreading {

    /*
    * Try using synchronised keyword in the following method signature and
    * see the difference*/
    public static  void printNumbers(int n ){
        for(int i =0; i<=10; i++){
            System.out.println("This thread is "+Thread.currentThread().getName()+" wtih value "+n*i);
        }
    }

    public  void printNames2(){
        synchronized (this) {
            for (int i = 0; i <= 10; i++) {
                System.out.println("This thread is " + Thread.currentThread().getName() + " wtih value " + i);

            }
        }
    }

    public synchronized void printNames(){
        for(int i=0; i<=10; i++){
            System.out.println("This thread is "+Thread.currentThread().getName()+" wtih value "+i);

        }
    }

    public static synchronized  void print(){
        for(int i=0; i<=10; i++){
            System.out.println("This thread is "+Thread.currentThread().getName()+" wtih value "+i);

        }

    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread(1);
//        MyThread t2 = new MyThread(10);
//
//        startGivenThread(t1);
//        startGivenThread(t2);

        //testing instance synchronisation with same and different objects
        testSync();




    }

    /*
    * Trying to print an instance synchronised method with two different instances
    * i.e we are using two different objects to invoke the printNames method.
    * THen although the method is synchronised, as we are using two different objects
    * two threads are able to access the method at a time.
    * When an instance method is synchronised it is set by a instnce lock(monitor)
    * if we try to access the object with two different instances , the synchronisation fails
    *
    * in the thread run methods use same object to invoke the printNames() method
    * then you can see synchronisation works well
    *
    * We also performed this instance synchronisation using synchronised block
    * we used printNames2() method which uses synchronised(this)  block
    * the results are similar to above experiment only
    * */
    private static void testSync() {
        TestSynchronisation obj1= new TestSynchronisation();
        TestSynchronisation obj2= new TestSynchronisation();
        Thread t3 = new Thread(){
            public void run(){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("======================================");
              //  obj1.printNames();
                obj1.printNames2();
            }
        };

        Thread t4 = new Thread(){
            public void run(){
                System.out.println("======================================");
                /*
                * comment and uncomment one of the below methods based on what you want to test
                * printNames() is a synchronised method
                * printNames2() is also a instance method with synchronised() block
                * */

               // obj2.printNames();
                obj2.printNames2();
            }
        };

        startGivenThread(t3);
        startGivenThread(t4);
    }
}

class MyThread extends Thread{
    int n;

    public MyThread(int n){
        this.n =n;
    }

    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TestSynchronisation.printNumbers(n);
    }
}
