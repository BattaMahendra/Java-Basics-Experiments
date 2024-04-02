package multi_threading;

import static java.lang.Thread.sleep;

public class CustomRunnable  implements  Runnable{

    /*
    Using the Thread class we create the threads
    * This is the place where we assign the work to thread
    In the run method we assign the work for thread*/
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
        System.out.println("Finished working with the thread : "+Thread.currentThread().getName()+
                " at exact time "+ System.currentTimeMillis());
    }
}
