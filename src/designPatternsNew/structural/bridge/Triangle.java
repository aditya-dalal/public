package designPatternsNew.structural.bridge;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing triangle with color ");
        color.fillColor();
    }
}
