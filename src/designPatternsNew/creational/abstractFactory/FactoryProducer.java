package designPatternsNew.creational.abstractFactory;

/**
 * Created by aditya.dalal on 19/01/17.
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(FactoryType type) {
        switch (type) {
            case AUTOMOBILE_FACTORY:
                return new AutomobileFactory();
            case COLOR_FACTORY:
                return new ColorFactory();
            default:
                return null;
        }
    }
}
