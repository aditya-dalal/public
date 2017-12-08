package designPatternsNew.creational.builderComplex;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class Client {

    public static void main(String[] args) {
        Meal vegMeal = MealBuilder.addVegMeal();
        System.out.println(vegMeal.toString());
        System.out.println("Total cost: " + vegMeal.cost());

        Meal nonVegMeal = MealBuilder.addNonVegMeal();
        System.out.println(nonVegMeal.toString());
        System.out.println("Total cost: " + nonVegMeal.cost());
    }
}
