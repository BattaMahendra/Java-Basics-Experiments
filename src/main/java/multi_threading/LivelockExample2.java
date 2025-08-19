package multi_threading;

class Worker {
    private String name;
    private boolean workDone = false;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isWorkDone() {
        return workDone;
    }

    public void setWorkDone(boolean workDone) {
        this.workDone = workDone;
    }
}

public class LivelockExample2 {

    public static void main(String[] args) {
        Worker worker1 = new Worker("Worker-1");
        Worker worker2 = new Worker("Worker-2");

        Thread t1 = new Thread(() -> workTogether(worker1, worker2));
        Thread t2 = new Thread(() -> workTogether(worker2, worker1));

        t1.start();
        t2.start();
    }

    public static void workTogether(Worker self, Worker other) {
        while (!self.isWorkDone()) {
            if (!other.isWorkDone()) {
                System.out.println(self.getName() + " says: You go ahead...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                continue; // gives chance to the other worker
            }

            System.out.println(self.getName() + " is doing work!");
            self.setWorkDone(true);
        }
    }
}
