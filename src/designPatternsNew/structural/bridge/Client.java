package designPatternsNew.structural.bridge;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Client {
    public static void main(String[] args) {
        Shape redSquare = new Square(new Red());
        redSquare.draw();

        Shape blueTriangle = new Triangle(new Blue());
        blueTriangle.draw();
    }
}
