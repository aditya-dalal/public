package designPatternsNew.creational.factory;

/**
 * Created by aditya.dalal on 19/01/17.
 */
public class AutomobileFactory {

    public Automobile getAutomobile(AutomobileType type) {
        switch (type) {
            case TWO_WHEELER:
                return new TwoWheeler();
            case FOUR_WHEELER:
                return new FourWheeler();
            default:
                return null;
        }
    }
}
