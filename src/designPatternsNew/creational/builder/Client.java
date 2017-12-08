package designPatternsNew.creational.builder;

/**
 * Created by aditya.dalal on 19/01/17.
 */
public class Client {

    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("16", "4").setGraphicCardEnabled(false).build();
        System.out.println(computer.toString());
    }
}
