package designPatternsNew.creational.abstractFactory;


/**
 * Created by aditya.dalal on 19/01/17.
 */
public interface AbstractFactory {

    public Automobile getAutomobile(AutomobileType type);
    public Color getColor(ColorType type);
}
