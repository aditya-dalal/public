package designPatternsNew.behavioural.template;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class WoodenHouse extends HouseTemplate {

    @Override
    protected void buildWindows() {
        System.out.println("Building wooden windows");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building wooden walls");
    }
}
