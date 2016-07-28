package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class Pepsi extends ColdDrink {

    @Override
    public String getName() {
        return "Pepsi";
    }

    @Override
    public Float getPrice() {
        return 25.00F;
    }
}
