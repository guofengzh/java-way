package race.criticalarea;

import java.util.Random;

public class Consumer implements Runnable {
    private CriticalResource criticalResource ;
    private Random taskTime = new Random() ;

    public Consumer(CriticalResource resource) {
        this.criticalResource = resource ;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(taskTime.nextInt(5 * 1000));

            String s = criticalResource.get() ;

            System.out.println(s) ;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
