package designPatternsNew.creational.builderComplex;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
