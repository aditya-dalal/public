package designPatterns.factory;

/**
 * Created by aditya.dalal on 02/11/15.
 */
public class Client {
    public static void main(String[] args) {
        AutomobileFactory factory = new AutomobileFactory();

        Automobile twoWheeler = factory.getAutomobile("TwoWheeler");
        twoWheeler.getBrand();

        Automobile fourWheeler = factory.getAutomobile("FourWheeler");
        fourWheeler.getBrand();
    }
}
