package designPatternsNew.creational.abstractFactory;

/**
 * Created by aditya.dalal on 19/01/17.
 */
public class ColorFactory implements AbstractFactory{

    @Override
    public Color getColor(ColorType type) {
        switch (type) {
            case RED:
                return new Red();
            case BLUE:
                return new Blue();
            default:
                return null;
        }
    }

    @Override
    public Automobile getAutomobile(AutomobileType type) {
        return null;
    }
}
