package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class VegBurger extends Burger {

    @Override
    public String getName() {
        return "Veg Burger";
    }

    @Override
    public Float getPrice() {
        return 250.00F;
    }

}
