package designPatternsNew.structural.bridge;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Red implements Color {

    @Override
    public void fillColor() {
        System.out.println("red");
    }
}
