package multi_threading.synchronization;

import multi_threading.CustomRunnable;
import multi_threading.TestMultiThreading;

public class TestSynchronisation extends TestMultiThreading {

    public static synchronized void printNumbers(int n ){
        for(int i =0; i<=10; i++){
            System.out.println("This thread is "+Thread.currentThread().getName()+" wtih value "+n*i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(10);
        startGivenThread(t1);
        startGivenThread(t2);

    }
}

class MyThread extends Thread{
    int n;

    public MyThread(int n){
        this.n =n;
    }

    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TestSynchronisation.printNumbers(n);
    }
}
