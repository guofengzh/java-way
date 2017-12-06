package pool;

import java.util.concurrent.Callable;

public class WorkerThread implements Callable<String> {

    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public String call() throws Exception {
        return "WorkerThread Done" ;
    }
}