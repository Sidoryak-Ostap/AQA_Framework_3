package task_4.task_a;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
    private CountDownLatch latch;
    private int threadNumber;

    public Worker(CountDownLatch latch, int threadNumber){
        this.latch = latch;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Thread #"+ this.threadNumber + " is doing some work");
        System.out.println("Thread #"+ this.threadNumber + " finished work");
        this.latch.countDown();
    }

}
