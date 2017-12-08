package designPatternsNew.behavioural.template;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Client {

    public static void main(String[] args) {
        HouseTemplate woodenHouse = new WoodenHouse();
        HouseTemplate glassHouse = new GlassHouse();
        woodenHouse.buildHouse();
        glassHouse.buildHouse();
    }
}
