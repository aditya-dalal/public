package designPatternsNew.creational.factoryWithRegistration;

/**
 * Created by aditya.dalal on 09/03/18.
 */
public class Client {

    static {
        try {
            Class.forName("designPatternsNew.creational.factoryWithRegistration.Jazz");
            Class.forName("designPatternsNew.creational.factoryWithRegistration.City");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HondaCar jazz = HondaCarFactory.createCar(CarType.JAZZ);
        System.out.println(jazz.getMake());
        HondaCar city = HondaCarFactory.createCar(CarType.CITY);
        System.out.println(city.getMake());
    }
}
