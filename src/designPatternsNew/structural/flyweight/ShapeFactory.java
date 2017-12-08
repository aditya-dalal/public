package designPatternsNew.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.dalal on 24/01/17.
 */
public class ShapeFactory {

    private static Map<ShapeType, Shape> shapes = new HashMap<>();

    public Shape getShape(ShapeType shapeType) {
        if(shapes.get(shapeType) != null)
            return shapes.get(shapeType);
        else {
            Shape shape = getNewShape(shapeType);
            shapes.put(shapeType, shape);
            return shape;
        }
    }

    private Shape getNewShape(ShapeType shapeType) {
        switch (shapeType) {
            case LINE_FILL:
                return new Line();
            case OVAL_FILL:
                return new Oval(true);
            case OVAL_NO_FILL:
                return new Oval(false);
            default:
                return null;
        }
    }

    public enum ShapeType {
        LINE_FILL, OVAL_NO_FILL, OVAL_FILL
    }
}
