package designPatternsNew.creational.factoryWithRegistration;

/**
 * Created by aditya.dalal on 09/03/18.
 */
public class Jazz implements HondaCar{
    static {
        HondaCarFactory.addCar(CarType.JAZZ, new Jazz());
    }

    @Override
    public String getMake() {
        return "Jazz";
    }

    @Override
    public Jazz createCar() {
        return new Jazz();
    }
}
