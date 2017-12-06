package race.criticalarea;

import java.util.Date;
import java.util.Random;

public class Producer implements Runnable {
    private CriticalResource criticalResource ;
    private Random taskTime = new Random() ;
    public Producer(CriticalResource resource) {
        this.criticalResource = resource ;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(taskTime.nextInt(5 * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        criticalResource.put(new Date().toString());
    }
}
