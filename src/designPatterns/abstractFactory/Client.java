package designPatterns.abstractFactory;

/**
 * Created by aditya.dalal on 02/11/15.
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory automobileFactory = FactoryProducer.getFactory("Automobile");
        Automobile twoWheeler = automobileFactory.getAutomobile("TwoWheeler");
        twoWheeler.getBrand();

        AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
        Color red = colorFactory.getColor("Blue");
        red.getColor();
    }
}
