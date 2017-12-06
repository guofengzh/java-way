package forkjoin;

import java.util.concurrent.ForkJoinPool;

public class MyRecursiveActionMain {
    public static void main(String[] args ) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);
        forkJoinPool.invoke(myRecursiveAction);
    }
}
