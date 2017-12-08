package designPatternsNew.creational.abstractFactory;

/**
 * Created by aditya.dalal on 19/01/17.
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory automobileFactory = FactoryProducer.getFactory(FactoryType.AUTOMOBILE_FACTORY);
        Automobile twoWheeler = automobileFactory.getAutomobile(AutomobileType.TWO_WHEELER);
        System.out.println(twoWheeler.getMake());

        AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryType.COLOR_FACTORY);
        Color red = colorFactory.getColor(ColorType.RED);
        System.out.println(red.getColor());
    }
}
