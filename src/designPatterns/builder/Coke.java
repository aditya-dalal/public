package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class Coke extends ColdDrink {

    @Override
    public String getName() {
        return "Coke";
    }

    @Override
    public Float getPrice() {
        return 25.00F;
    }
}
