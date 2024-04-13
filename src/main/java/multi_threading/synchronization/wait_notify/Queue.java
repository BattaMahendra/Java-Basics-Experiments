package multi_threading.synchronization.wait_notify;

public class Queue {
    private String message;

    private String lock ="lock";

    private String checkCondition="0";
    public  void send(String messageToBeSent){
        synchronized (lock) {
            while (checkCondition.equals("1")) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            this.message = messageToBeSent;
            System.out.println("message :" + this.message + " was sent by "
                    + Thread.currentThread().getName());
            this.checkCondition = "1";
            lock.notifyAll();

        }

    }

    public  String receive(){
        synchronized(lock) {
            while (checkCondition.equals("0")) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


            String receivedMessage = this.message;
            System.out.println("message :" + this.message + " was received by "
                    + Thread.currentThread().getName());
            lock.notifyAll();
            this.checkCondition = "0";
            return receivedMessage;
        }
    }

}
