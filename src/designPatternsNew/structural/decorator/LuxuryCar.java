package designPatternsNew.structural.decorator;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    public void assemble() {
        car.assemble();
        System.out.println("Adding luxury parts");
    }
}
