package designPatternsNew.creational.builderComplex;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class NonVegBurger extends Burger {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public int price() {
        return 20;
    }

}
