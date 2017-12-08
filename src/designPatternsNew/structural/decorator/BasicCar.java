package designPatternsNew.structural.decorator;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembled basic car");
    }
}
