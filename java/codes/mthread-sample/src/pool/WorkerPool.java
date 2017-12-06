package pool;

import java.util.concurrent.*;

public class WorkerPool {

    public static void main(String args[]) throws Exception {
        //RejectedExecutionHandler implementation
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        //start the monitoring thread

        WorkerThread worker = new WorkerThread("Work Thread");
        Future<String> future = executorPool.submit(worker);
        String result = future.get() ;

        //shut down the pool
        executorPool.shutdown();
    }
}