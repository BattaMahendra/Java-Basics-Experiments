package multi_threading;


import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/*
* Threads in java can be created in two ways
*
* 1. by extending Thread class ( you must override run() method otherwise its useless)
* 2. by implementing Runnable interface
*
* */

public class ThreadCreation {
    public static void main(String[] args) throws Exception {
      //  usingOnlyRun();
        First first1 = new First("Thread-1");
        first1.start();
        //we can't use start method twice on same method
        //It gives IllegalThreadStateException
       // first1.start();


        /*
        * When we create thread class using Runnable interface  then
        * we need to use Thread class constructor as shown below */

        Second second = new Second("Thread-2");
        Thread t = new Thread(second);
        t.start();
        first1.join();
        t.join();

        usingOnlyRun();

        // Creating thread using anonymous inner class (Runnable)

        Thread third = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("callable thread created using Runnable anonymous inner class");
            }
        });
        third.start();

        // the above can be reduced to lambda function
        Thread fourth = new Thread(()->{
            System.out.println("Fourth thread created using Runnable anonymous inner class");
        });
        fourth.start();
        // Creating Thread using anonymous inner class (Thread)
        Thread fifth = new Thread(){
            @Override
            public void run(){
                System.out.println("Fifth thread created using Runnable anonymous inner class");
            }
        };
        fifth.start();

        // Using callable - Callable can't be used directly with Thread
        // It has to be used with Executor services
        callable callable = new callable();
        Future<String> f = Executors
                                .newFixedThreadPool(1)
                                        .submit(callable);
        f.get(); // this is a blocking call i.e. blocks all other operations until get() completes

    }

    /*
    * So what is the difference between the start and run method?
    * Main difference is that when program calls start() method a new Thread is created and
    *  code inside run() method is executed in new Thread
    * while if you call run() method directly no new Thread is created and
    * code inside run() will execute on the current Thread.
    *
    *
    * Another difference between start vs run in Java thread is that
    *  you can not call start() method twice on the thread object.
    * once started, the second call of start() will throw IllegalStateException in Java
    * while you can call run() method twice.
     */
    private static void usingOnlyRun() {
        System.out.println("\n Using directly run() method");
        First first1 = new First("Thread-3");
        first1.run();
        Second second = new Second("Thread-4");
        second.run();
        System.out.println("==================================================================================");
    }
}
/*
* Runnable vs Thread
  If your class provides more functionality rather than just running as Thread,
* you should implement Runnable interface to provide a way to run it as Thread.
* If your class only goal is to run as Thread, you can extend Thread class.
* Implementing Runnable is preferred because java supports implementing multiple interfaces.
* If you extend Thread class, you can’t extend any other classes.*/

class First extends Thread{
    private static final Logger LOGGER = Logger.getLogger("Logging");
    private String name;
    First (String s){
        this.name = s;
    }

    /*
    * Here if you don't override run() method
    * then default run method will be created and no use even if you create thread*/
    public void run(){
        System.out.println("I am in the run method from the "+this.name
                +"and thread is "+Thread.currentThread());

    }
}

class  Second implements Runnable{

    private String name;
    Second(String s){
        this.name =s;
    }

    @Override
    public void run() {
        System.out.println("I am in the run method from the "+this.name
                +"and thread is "+Thread.currentThread());

    }
}

/*
* Creation of task using Callable interface ( a functional interface - has one method  public T call() )
* Unlike Runnable it returns the value and also throws checked exceptions
* It can't be used with Thread class but rather should be used with Executor services*/

class callable implements Callable<String> {

    // we need to override the call method of callable interface
    @Override
    public String call() throws Exception {
        return "I am a task from callable";
    }
}


