package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public abstract class Burger implements Item{

    @Override
    public Packing getPacking() {
        return new PaperWrapper();
    }

    @Override
    public abstract Float getPrice();
}
