package basic;

public class ThreadRunExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
        Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
        Thread t3 = new Thread(new HeavyWorkRunnable(), "t3");
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();

        System.out.println("t1 & t2 are dead, exiting main threadm but t3 is still running");
    }
}