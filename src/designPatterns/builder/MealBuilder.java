package designPatterns.builder;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal("Veg Meal");
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal("Non Veg Meal");
        meal.addItem(new NonVegBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
