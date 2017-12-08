package concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aditya.dalal on 07/03/17.
 */
public class Client {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 10; i++) {
            Task task = new Task("" + i);
            executorService.execute(task);
        }
        executorService.shutdown();
    }
}
