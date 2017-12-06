package pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleThreadPool {
    public static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WorkerThread worker = new WorkerThread("Work Thread");
        Future<String> future = executor.submit(worker);
        String result = future.get() ;
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished");
    }
}
