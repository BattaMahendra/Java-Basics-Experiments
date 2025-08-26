package multi_threading;

public interface ThreadOperations {

    public  default void printThreadState(Thread... t) {
        for (Thread thread : t) {
            System.out.println("Current thread is "
                    + thread.getName() + " and thread state is "
                    + thread.getState());
        }

    }

    public default void startGivenThread(Thread t) {
        System.out.println("Starting the " + t.getName());
        t.start();
    }


    public  default void  joinGivenThread(Thread t) {
        System.out.println("Joining the " + t.getName());
        try {
            t.join(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  default void  waitGivenThread(Thread t) {
        System.out.println( t.getName() +" entered into waiting state");
        try {
            t.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  default void  notifyGivenThread(Thread t) {
        System.out.println( t.getName() +" is notifying other threads");
        t.notifyAll();
    }

    public static void interruptGivenThread(Thread t){
        System.out.println( " Calling interrupt() method on thread: "+t.getName());
        t.interrupt();
    }

}
