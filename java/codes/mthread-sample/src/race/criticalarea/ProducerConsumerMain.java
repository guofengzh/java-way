package race.criticalarea;

public class ProducerConsumerMain {
    public static void main(String args[]) {
        CriticalResource criticalResource = new CriticalResource() ;
        Thread taskProducer = new Thread( new Producer(criticalResource)) ;
        Thread taskConsumer = new Thread( new Consumer(criticalResource)) ;

        taskConsumer.start();
        Thread.yield();   // 交出线程控制
        taskProducer.start();
    }
}
