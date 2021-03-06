package designPatterns.factory;

/**
 * Created by aditya.dalal on 02/11/15.
 */
public class AutomobileFactory {

    public Automobile getAutomobile(String type) {
        if(type == null || type.equals(""))
            return null;
        else if(type.equalsIgnoreCase("TwoWheeler"))
            return new TwoWheeler();
        else if(type.equalsIgnoreCase("FourWheeler"))
            return new FourWheeler();
        return null;
    }
}
