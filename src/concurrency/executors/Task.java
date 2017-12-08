package concurrency.executors;


/**
 * Created by aditya.dalal on 07/03/17.
 */
public class Task implements Runnable {

    private String message;

    public Task(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
