package multi_threading.synchronization.wait_notify;

public class WaitAndNotifyTest {

    public static void main(String[] args) {

        DisplayNumbers object = new DisplayNumbers();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    object.printEvenNumbers(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    object.printOddNumbers(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        t1.start();
        t2.start();


    }


}

class DisplayNumbers{

    int counter =0;
    public void printOddNumbers(int num) throws InterruptedException {

        synchronized (this){
            while(counter<=num){
                if(counter%2!=0){
                    System.out.println(counter+" ");
                   notify();

                }
                counter++;

                wait();
            }
        }


    }

    public void printEvenNumbers(int num) throws InterruptedException {

        synchronized (this){
            while(counter<=num){
                if(counter % 2 == 0){
                    System.out.println(counter+" ");


                    notify();
                }
                counter++;
                wait();
            }
        }


    }
}
