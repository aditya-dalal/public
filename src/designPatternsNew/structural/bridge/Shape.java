package designPatternsNew.structural.bridge;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
