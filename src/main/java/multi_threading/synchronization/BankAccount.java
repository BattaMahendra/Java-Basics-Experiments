package multi_threading.synchronization;

/*
* This example can be used to understand both Synchronization and Race condition*/
public class BankAccount {

    private  int balance;



    public BankAccount(int balance) {
        this.balance = balance;
    }

    /*
    * Try using synchronized and notice the difference*/

    public synchronized int withdrawBalance(int amount)  {

        if(balance >= amount){
            //simulating delay
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //withdrawing balance
            balance = balance -amount;
            System.out.println(Thread.currentThread().getName()+" Withdraw successful: "+
                    amount+" remaining balance: "+balance);

        }else{
            System.out.println(Thread.currentThread().getName()+" Not enough balance to withdraw: "+ balance);
        }
        return balance;
    }

    public int getBalance() {
        return balance;
    }
}

class Test{
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        System.out.println("\nAvailable Balance in bank acccount: "+ bankAccount.getBalance());

        // creating threads using Thread class and lambda of runnable
        Thread thread1 = new Thread(()->{
            bankAccount.withdrawBalance(1000);
        });
        Thread thread2 = new Thread(()->{
            bankAccount.withdrawBalance(1000);
        });
        Thread thread3 = new Thread(()->{
            bankAccount.withdrawBalance(1000);
        });

        // Creating a task using runnable interface
        Runnable r = ()->{bankAccount.withdrawBalance(1000);};
        //Using above runnable to create threads
        Thread thread4 = new Thread(r,"t4");
        Thread thread5 = new Thread(r,"t5");

        thread1.setName("t1");
        thread2.setName("t2");
        thread3.setName("t3");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
