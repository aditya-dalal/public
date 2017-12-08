package designPatternsNew.structural.facade.example1;


/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}
