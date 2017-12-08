package designPatternsNew.structural.flyweight;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by aditya.dalal on 24/01/17.
 */
public class Client {

    public static void main(String[] args) {
        List<ShapeFactory.ShapeType> types = Arrays.asList(ShapeFactory.ShapeType.LINE_FILL, ShapeFactory.ShapeType.OVAL_FILL, ShapeFactory.ShapeType.OVAL_NO_FILL);
        List<String> colors = Arrays.asList("Red", "Blue", "Green");

        ShapeFactory factory = new ShapeFactory();
        for (int i = 0; i < 10; i++) {
            Shape shape = factory.getShape(types.get(new Random().nextInt(3)));
            System.out.println(shape);
            shape.draw(getRandomNumber(), getRandomNumber(), getRandomNumber(), getRandomNumber(), colors.get(new Random().nextInt(3)));
        }
    }

    public static int getRandomNumber() {
        return new Random().nextInt(20);
    }
}
