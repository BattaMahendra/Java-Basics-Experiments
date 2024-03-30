package multi_threading;

import static java.lang.Thread.sleep;

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
        //play with different join timings to see difference
        tesJoin(t1, t2, t3);


    }

    /*
    * java.lang.Thread class provides the join() method which allows
    * one thread to wait until another thread completes its execution.
    * If t is a Thread object whose thread is currently executing,
    * then t.join() will make sure that t is terminated before the next instruction is
    * executed by the program.*/
    private static void tesJoin(Thread t1, Thread t2, Thread t3) {
        startGivenThread(t1);
        printThreadState(t1, t2, t3);
        joinGivenThread(t1);
        printThreadState(t1, t2, t3);
        //start the thread t2 only after join time is completed or t1 is dead
        startGivenThread(t2);
        printThreadState(t1, t2, t3);
        joinGivenThread(t2);
        joinGivenThread(t1);
        printThreadState(t1, t2, t3);
        //start the thread t3 only after join time is completed or t1 and t2 are dead
        startGivenThread(t3);
        printThreadState(t1, t2, t3);

        printThreadState(t1, t2, t3);
        joinGivenThread(t3);
        printThreadState(t1, t2, t3);
    }

    private static void printThreadState(Thread ... t) {
        for (Thread thread: t) {
            System.out.println("Current thread is "
                    + thread.getName() + " and thread state is "
                    + thread.getState());
        }

    }

    private static void startGivenThread(Thread t){
        System.out.println("Starting the "+t.getName());
        t.start();
    }


    private static void joinGivenThread(Thread t){
        System.out.println("Joining the "+t.getName());
        try {
            t.join(450);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Current thread is "
                    + Thread.currentThread().getName()+
                    " at exact time "+ System.currentTimeMillis()
                    +" with loop value "+i);
        }

    }
}
