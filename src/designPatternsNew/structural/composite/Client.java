package designPatternsNew.structural.composite;

/**
 * Created by aditya.dalal on 23/01/17.
 */
public class Client {

    public static void main(String[] args) {
        Shape tri1 = new Triangle();
        Shape tri2 = new Triangle();
        Shape cir1 = new Circle();
        Shape cir2 = new Circle();

        Drawing drawing = new Drawing();
        drawing.addShape(tri1);
        drawing.addShape(cir2);
        drawing.draw("Red");

        drawing.clear();
        drawing.addShape(tri2);
        drawing.addShape(cir1);
        drawing.addShape(tri1);
        drawing.draw("Green");

    }
}
