package designPatternsNew.behavioural.template;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class GlassHouse extends HouseTemplate {
    @Override
    protected void buildWindows() {
        System.out.println("Building glass windows");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building glass walls");
    }
}
