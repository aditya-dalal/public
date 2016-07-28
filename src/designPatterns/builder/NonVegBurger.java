package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class NonVegBurger extends Burger {

    @Override
    public String getName() {
        return "Non Veg Burger";
    }

    @Override
    public Float getPrice() {
        return 275.00F;
    }
}
