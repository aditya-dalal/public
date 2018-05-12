package designPatternsNew.creational.factoryWithRegistration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.dalal on 09/03/18.
 */
public class HondaCarFactory {

    private static Map<CarType, HondaCar> cars = new HashMap<>();

    public static void addCar(CarType type, HondaCar car) {
        cars.put(type, car);
    }

    public static HondaCar createCar(CarType type) {
        return cars.get(type).createCar();
    }
}
