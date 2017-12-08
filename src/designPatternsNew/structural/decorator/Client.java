package designPatternsNew.structural.decorator;

/**
 * Created by aditya.dalal on 26/02/17.
 */
public class Client {

    public static void main(String[] args) {
        Car basic = new BasicCar();
        Car sports = new SportsCar(new BasicCar());
        Car sportsLuxury = new LuxuryCar(new SportsCar(new BasicCar()));

        basic.assemble();
        System.out.println("##########");
        sports.assemble();
        System.out.println("##########");
        sportsLuxury.assemble();
    }
}
