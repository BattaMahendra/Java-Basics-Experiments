package multi_threading;

import static java.lang.Thread.sleep;

public class CustomRunnable  implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            try {
                sleep(500);
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
