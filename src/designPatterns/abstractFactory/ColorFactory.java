package designPatterns.abstractFactory;

/**
 * Created by aditya.dalal on 02/11/15.
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        if(color == null || color.equals(""))
            return null;
        else if(color.equalsIgnoreCase("Red"))
            return new Red();
        else if(color.equalsIgnoreCase("Blue"))
            return new Blue();
        return null;
    }

    @Override
    public Automobile getAutomobile(String type) {
        return null;
    }
}
