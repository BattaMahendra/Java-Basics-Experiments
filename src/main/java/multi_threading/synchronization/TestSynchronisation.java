package multi_threading.synchronization;

import multi_threading.ThreadPriority;

public class TestSynchronisation extends ThreadPriority {

    /*
    * Try using synchronised keyword in the following method signature and
    * see the difference*/
    static  int sum =0;
    int instanceSum =0;
    public static  void nonSynchronisedStaticMethod(int n ){

        for(int i =0; i<=10; i++){
            System.out.println("This thread is "+Thread.currentThread().getName()+" wtih value "+n*i);
            sum = sum+n*i;
        }
        System.out.println(sum);
    }

    public  void methodContainingSynchronizedBlock(){
        synchronized (this) {
            for (int i = 0; i <= 10; i++) {
                System.out.println("This thread is " + Thread.currentThread().getName() + " wtih value " + i);
                instanceSum = instanceSum+i;
            }
        }
    }

    public synchronized void synchronisedInstanceMethod(){
        for(int i=0; i<=10; i++){
            System.out.println("This thread is "+Thread.currentThread().getName()+" wtih value "+i);
            instanceSum = instanceSum+i;
        }

        System.out.println("The total sum by thread: "+Thread.currentThread().getName()+ " is "+instanceSum);
    }

    public static synchronized  void synchronizedStaticMethod(){
        for(int i=0; i<=10; i++){
            System.out.println("This thread is "+Thread.currentThread().getName()+" wtih value "+i);

        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(1);
        t1.setName("1");
        t2.setName("2");

        /*
        * Observe how the value of sum changes if the method is not synchronised*/
        startGivenThread(t1);
        startGivenThread(t2);

        Thread.sleep(4000);
        System.out.println("\n\n===================================");
        //testing instance synchronisation with same and different objects
        //testSync();




    }

    /*
    * Trying to print an instance synchronised method with two different instances
    * i.e we are using two different objects to invoke the synchronisedInstanceMethod method.
    * THen although the method is synchronised, as we are using two different objects as locks
    * two threads are able to access the method at a time.
    * When an instance method is synchronised it is set by a instance lock(monitor)
    * if we try to access the object with two different instances , the synchronisation fails
    *
    * in the thread run methods use same object to invoke the synchronisedInstanceMethod() method
    * then you can see synchronisation works well
    *
    * We also performed this instance synchronisation using synchronised block
    * we used methodContainingSynchronizedBlock() method which uses synchronised(this)  block
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
                obj1.synchronisedInstanceMethod();
               // obj1.methodContainingSynchronizedBlock();
            }
        };

        Thread t4 = new Thread(){
            public void run(){
                System.out.println("======================================");
                /*
                * comment and uncomment one of the below methods based on what you want to test
                * synchronisedInstanceMethod() is a synchronised method
                * methodContainingSynchronizedBlock() is also a instance method with synchronised() block
                * */


                obj1.synchronisedInstanceMethod();
              //  obj2.methodContainingSynchronizedBlock();
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
        TestSynchronisation.nonSynchronisedStaticMethod(n);
    }
}
