package multi_threading;

public class TestMultiThreading {

    public static void main(String[] args) {

    }

    private static void printThreadState(Thread... t) {
        for (Thread thread : t) {
            System.out.println("Current thread is "
                    + thread.getName() + " and thread state is "
                    + thread.getState());
        }

    }

    private static void startGivenThread(Thread t) {
        System.out.println("Starting the " + t.getName());
        t.start();
    }


    private static void joinGivenThread(Thread t) {
        System.out.println("Joining the " + t.getName());
        try {
            t.join(450);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
