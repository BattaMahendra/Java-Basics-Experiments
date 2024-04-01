package multi_threading;


public class DaemonThreadTest {
    public static void main(String[] args) {
        CustomThread t1 = new CustomThread();
        t1.setName("t1");
        CustomThread t2 = new CustomThread();
        t2.setName("t2");
        CustomThread t3 = new CustomThread();
        t3.setName("t3");

        // creating a daemon thread
        t1.setDaemon(true);
        // now t1 is deamon thread
        t1.start();
        t2.start();
        t3.start();
    }
}
 class CustomThread extends Thread {

    /*
    * In Java, daemon threads are low-priority threads that run in the background to perform tasks
    * such as garbage collection or provide services to user threads.
    *  The life of a daemon thread depends on the mercy of user threads,
    *  meaning that when all user threads finish their execution,
    * the Java Virtual Machine (JVM) automatically terminates the daemon thread.

To put it simply, daemon threads serve user threads by handling background tasks and
*  have no role other than supporting the main execution.*/

    public void run() {
        System.out.println("Current thread is "
                + Thread.currentThread().getName()+
                " at exact time "+ System.currentTimeMillis());
        System.out.println("Current thread is "
                + Thread.currentThread().getName()+
                "  Daemon thread ? : "+Thread.currentThread().isDaemon());

    }


}


