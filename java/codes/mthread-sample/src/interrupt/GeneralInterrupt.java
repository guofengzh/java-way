package interrupt;

import java.util.Random;

public class GeneralInterrupt implements Runnable {
    public void run() {
        try {
            System.out.println("in run() - about to work()");
            work();
            System.out.println("in run() - back from  work()");
        }
        catch (InterruptedException x) {
            System.out.println("in run() - interrupted in work()");
            return;
        }
        System.out.println("in run() - leaving normally");
    }

    private void work() throws InterruptedException {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("C isInterrupted()=" + Thread.currentThread().isInterrupted());
                break;
            }
            new Random().nextDouble() ;
            //Thread.sleep(2000);  // Simulating long running task
        }
    }
}