package temp.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aditya.dalal on 25/02/17.
 */
public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            Message message = new Message();
            executorService.submit(message);
        }
        executorService.shutdown();

        Base b = new SubClass();
        SubClass s = new SubClass();
    }

}
