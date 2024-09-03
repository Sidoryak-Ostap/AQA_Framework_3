package task_4.task_a;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);

        for(int i = 1; i<4; i++){
            new Thread(new Worker(latch, i)).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Main thread");

    }
}
