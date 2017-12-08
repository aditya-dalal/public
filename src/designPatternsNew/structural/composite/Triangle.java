package designPatternsNew.structural.composite;

/**
 * Created by aditya.dalal on 23/01/17.
 */
public class Triangle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color: " + fillColor);
    }
}
