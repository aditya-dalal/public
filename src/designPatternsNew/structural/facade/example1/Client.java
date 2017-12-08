package designPatternsNew.structural.facade.example1;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Client {

    public static void main(String[] args) {
        ShapeHelper shapeHelper = new ShapeHelper();
        shapeHelper.drawCricle();
        shapeHelper.drawSquare();
        shapeHelper.drawTriangle();
    }

}
