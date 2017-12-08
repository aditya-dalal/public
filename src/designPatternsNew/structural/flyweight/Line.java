package designPatternsNew.structural.flyweight;

/**
 * Created by aditya.dalal on 24/01/17.
 */
public class Line implements Shape {

    @Override
    public void draw(int x, int y, int x1, int y1, String fillColor) {
        System.out.println("Drawing line from (" + x + ", " + y + ") to (" + x1 + ", " + y1 + ") with color: " + fillColor);
    }
}
