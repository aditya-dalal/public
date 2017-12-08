package concurrency.guardedBlocks;

/**
 * Created by aditya.dalal on 07/03/17.
 */
public class Client {

    public static void main(String[] args) {
        Drop drop = new Drop();

        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
