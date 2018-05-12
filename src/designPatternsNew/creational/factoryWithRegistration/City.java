package designPatternsNew.creational.factoryWithRegistration;

/**
 * Created by aditya.dalal on 09/03/18.
 */
public class City implements HondaCar {

    static {
        HondaCarFactory.addCar(CarType.CITY, new City());
    }

    @Override
    public String getMake() {
        return "City";
    }

    @Override
    public City createCar() {
        return new City();
    }
}
