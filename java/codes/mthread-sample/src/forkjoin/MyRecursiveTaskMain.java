package forkjoin;

import java.util.concurrent.ForkJoinPool;

public class MyRecursiveTaskMain {
    public static void main(String[] args ) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(24);
        long mergedResult = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("mergedResult = " + mergedResult);
    }
}
