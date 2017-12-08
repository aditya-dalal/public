package temp.temp;

/**
 * Created by aditya.dalal on 14/03/17.
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton(){}

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void message(int message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}
