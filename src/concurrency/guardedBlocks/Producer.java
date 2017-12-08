package concurrency.guardedBlocks;


import java.util.Random;

/**
 * Created by aditya.dalal on 07/03/17.
 */
public class Producer implements Runnable{

    Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    String[] messages = {"m1", "m2", "m3", "m4", "m5", "done"};

    public void run() {
        Random random = new Random();
        for (String message: messages) {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drop.put(message);
        }
    }
}
