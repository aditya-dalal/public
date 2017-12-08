package designPatternsNew.creational.builderComplex;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class MealBuilder {

    public static Meal addVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public static Meal addNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new NonVegBurger());
        meal.addItem(new Coke());
        return meal;
    }
}
