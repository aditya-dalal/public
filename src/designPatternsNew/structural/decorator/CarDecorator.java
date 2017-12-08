package designPatternsNew.structural.decorator;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class CarDecorator implements Car {

    Car car;
    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void assemble() {
        car.assemble();
    }
}
