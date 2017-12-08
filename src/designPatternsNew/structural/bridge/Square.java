package designPatternsNew.structural.bridge;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing square with color ");
        color.fillColor();
    }
}
