package designPatternsNew.structural.flyweight;

/**
 * Created by aditya.dalal on 24/01/17.
 */
public class Oval implements Shape {

    private boolean fill;

    public Oval(boolean fill) {
        this.fill = fill;
    }

    @Override
    public void draw(int x, int y, int width, int height, String fillColor) {
        if(fill)
            System.out.println("Drawing circle with center (" + x + ", " + y + "), width: " + width + ", height: " + height + ", color: " + fillColor);
        else
            System.out.println("Drawing circle with center (" + x + ", " + y + "), width: " + width + ", height: " + height + ", color: none");
    }
}
