package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class Client {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.mealDetails();
        System.out.println(vegMeal.price());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        nonVegMeal.mealDetails();
        System.out.println(nonVegMeal.price());

    }
}
