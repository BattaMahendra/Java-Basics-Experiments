package multi_threading;


import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

public class ThreadCreation {
    public static void main(String[] args) {
        First first1 = new First();
        first1.run();
        Second second = new Second();
        second.run();

    }
}


class First extends Thread{
    private static final Logger LOGGER = Logger.getLogger("Logging");
    public void run(){
        System.out.println("I am in the run method from the "+this.getClass());
    }
}

class  Second implements Runnable{



    @Override
    public void run() {
        System.out.println("I am in the run method from the "+this.getClass());
    }
}
