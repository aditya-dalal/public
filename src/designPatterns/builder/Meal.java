package designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 04/11/15.
 */
public class Meal {

    private String mealName;
    private List<Item> items = new ArrayList<>();

    public Meal(String mealName) {
        this.mealName = mealName;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Float price() {
        Float price = 0.00F;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }

    public void mealDetails() {
        System.out.println(mealName);
        for (Item item : items) {
            System.out.print("Item: " + item.getName());
            System.out.print(", Packing: " + item.getPacking().getPack());
            System.out.println(", Price: " + item.getPrice());
        }
    }
}
