package concurrency.guardedBlocks;

import java.util.Random;

/**
 * Created by aditya.dalal on 07/03/17.
 */
public class Consumer implements Runnable{

    Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        System.out.println(drop);
        for (String message = drop.take(); !message.equalsIgnoreCase("done"); message = drop.take()) {
            System.out.println(message);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
