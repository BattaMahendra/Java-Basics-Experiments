package multi_threading;


import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

public class ThreadCreation {
    public static void main(String[] args) {
      //  usingOnlyRun();
        First first1 = new First();
        first1.start();
        //we can't use start method twice on same method
        //It gives IllegalThreadStateException
        first1.start();

        /*
        * When we create thread class using Runnable interface  then
        * we need to use Thread class constructor as shown below */

        Second second = new Second();
        Thread t = new Thread(second);
        t.start();

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
        First first1 = new First();
        first1.run();
        Second second = new Second();
        second.run();
    }
}
/*
* Runnable vs Thread
If your class provides more functionality rather than just running as Thread,
*  you should implement Runnable interface to provide a way to run it as Thread.
*  If your class only goal is to run as Thread, you can extend Thread class.
* Implementing Runnable is preferred because java supports implementing multiple interfaces.
* If you extend Thread class, you can’t extend any other classes.*/

class First extends Thread{
    private static final Logger LOGGER = Logger.getLogger("Logging");
    public void run(){
        System.out.println("I am in the run method from the "+this.getClass()
                +"and thread is "+Thread.currentThread());

    }
}

class  Second implements Runnable{



    @Override
    public void run() {
        System.out.println("I am in the run method from the "+this.getClass()
                +"and thread is "+Thread.currentThread());

    }
}
