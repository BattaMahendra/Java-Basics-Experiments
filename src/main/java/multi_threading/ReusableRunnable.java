package multi_threading;

public class ReusableRunnable implements  Runnable{

    private final ReusableTask task;
    public ReusableRunnable(ReusableTask task){

        this.task = task;
    }



    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
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
