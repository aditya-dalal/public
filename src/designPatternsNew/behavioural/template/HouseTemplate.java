package designPatternsNew.behavioural.template;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public abstract class HouseTemplate {

    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
    }

    protected abstract void buildWindows();

    protected abstract void buildWalls();

    protected void buildPillars() {
        System.out.println("Building pillars");
    }

    private void buildFoundation() {
        System.out.println("Building foundation");
    }
}
