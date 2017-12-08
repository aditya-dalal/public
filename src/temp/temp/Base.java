package temp.temp;

/**
 * Created by aditya.dalal on 26/03/17.
 */
public class Base {

    String packagePrivateString = "base";

    public static void printStatic() {
        System.out.println("print from static base");
    }

    protected void print() {
        System.out.println("from base");
    }
}
