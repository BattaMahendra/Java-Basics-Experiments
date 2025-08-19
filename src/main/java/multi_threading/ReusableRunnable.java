package multi_threading;

public class ReusableRunnable implements  Runnable{

    private final ReusableTask task;
    public ReusableRunnable(ReusableTask task){

        this.task = task;
    }



    /**
     * When an object implementing interface Runnable is used
     * to create a thread, starting the thread causes the object's
     * run method to be called in that separately executing
     * thread.
     * 
     * The general contract of the method run is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" is running");
        task.execute();
        System.out.println(Thread.currentThread().getName()+" is finished");
    }
}
