package designPatternsNew.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 23/01/17.
 */
public class Drawing implements Shape {

    private List<Shape> shapes;

    public Drawing() {
        shapes = new ArrayList<>();
    }

    @Override
    public void draw(String fillColor) {
        for (Shape shape: shapes)
            shape.draw(fillColor);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public void clear() {
        shapes.clear();
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
