package designPatternsNew.creational.factory;

/**
 * Created by aditya.dalal on 19/01/17.
 */
public class Client {

    public static void main(String[] args) {
        AutomobileFactory factory = new AutomobileFactory();

        Automobile twoWheeler = factory.getAutomobile(AutomobileType.TWO_WHEELER);
        System.out.println(twoWheeler.getMake());

        Automobile fourWheeler = factory.getAutomobile(AutomobileType.FOUR_WHEELER);
        System.out.println(fourWheeler.getMake());
    }
}
