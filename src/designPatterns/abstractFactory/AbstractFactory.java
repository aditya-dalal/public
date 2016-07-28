package designPatterns.abstractFactory;

/**
 * Created by aditya.dalal on 02/11/15.
 */
public abstract class AbstractFactory {

    abstract Automobile getAutomobile(String type);
    abstract Color getColor(String color);
}
