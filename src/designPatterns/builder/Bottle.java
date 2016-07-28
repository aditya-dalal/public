package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class Bottle implements Packing {

    @Override
    public String getPack() {
        return "Plastic bottle";
    }
}
