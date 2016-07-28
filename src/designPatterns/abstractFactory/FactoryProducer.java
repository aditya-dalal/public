package designPatterns.abstractFactory;

/**
 * Created by aditya.dalal on 02/11/15.
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String type) {
        if(type.equalsIgnoreCase("Automobile"))
            return new AutomobileFactory();
        else if(type.equalsIgnoreCase("Color"))
            return new ColorFactory();
        return null;
    }
}
