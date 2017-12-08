package temp.temp;

/**
 * Created by aditya.dalal on 14/03/17.
 */
public class Message implements Runnable {

    public void run() {
        Singleton singleton = Singleton.getInstance();
        singleton.message(singleton.hashCode());
    }
}
