package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing getPacking() {
        return new Bottle();
    }

    @Override
    public abstract Float getPrice();
}
