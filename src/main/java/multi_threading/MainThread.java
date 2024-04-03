package multi_threading;

public class MainThread {

    /*
    * Main thread will be created by JVM at the start of main() method.
    * It is also a user thread
    * All the threads we create manually are spawned from the main thread
    * When all the user threads are completed then JVM terminates the program
    * */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Current thread :"+Thread.currentThread().getName()
                +"\n and its state is "+ Thread.currentThread().getState()
                +" and its priority is "+Thread.currentThread().getPriority());

        customThreadCreation().start();
        //in the above line new thread got created and meanwhile while main thread does its work
        //executing the next flow in the main() method.
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");
        System.out.println("===================");
        System.out.printf(" %s got ended ",Thread.currentThread().getName());

        /*Achieving deadlock situation with main thread
        * Here the main thread is waiting for itself to terminate which
        * makes program to run forever and the deadlock is created*/
        //Thread.currentThread().join();
    }

    private static  Thread customThreadCreation() {
       Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.printf("\n %s got created ",Thread.currentThread().getName());
                    Thread.sleep(2000);
                   // Thread.interrupted();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("\n %s got ended ",Thread.currentThread().getName());
            }
        };

       return t1;
    }
}
