package designPatternsNew.structural.facade.example1;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class ShapeHelper {

    Shape circle;
    Shape square;
    Shape triangle;

    public ShapeHelper() {
        circle = new Circle();
        triangle = new Triangle();
        square = new Square();
    }

    public void drawCricle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawTriangle() {
        triangle.draw();
    }
}
