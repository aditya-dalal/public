package designPatternsNew.creational.builderComplex;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "Paneer Burger";
    }

    @Override
    public int price() {
        return 10;
    }
}
