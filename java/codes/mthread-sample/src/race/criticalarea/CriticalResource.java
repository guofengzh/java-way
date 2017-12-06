package race.criticalarea;

import java.util.LinkedList;

public class CriticalResource {
    Object lock = new Object();
    LinkedList<String> criticalList = new LinkedList<String>();

     public void put(String s) {
         synchronized (lock) {
             System.out.println("add") ;
             criticalList.add(s);
             if ( criticalList.size() == 1)
                 System.out.println("notify") ;
                lock.notify();  // send out a signal
         }
     }

    public String get() throws InterruptedException {
        synchronized (lock) {
            if ( criticalList.size() == 0 ) {
                System.out.println("wait") ;
                lock.wait();  // wait for a signal
            }

            System.out.println("get") ;
            String s = criticalList.remove() ;
            return s ;
        }
    }
}
