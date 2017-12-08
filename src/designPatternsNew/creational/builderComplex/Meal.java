package designPatternsNew.creational.builderComplex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.dalal on 20/01/17.
 */
public class Meal {

    private List<Item> items;

    public Meal() {
        items = new ArrayList<>();
    }

    public int cost() {
        int cost = 0;
        for(Item item: items)
            cost += item.price();
        return cost;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Item item: items)
            str.append("Item: ").append(item.name()).append(", Packing: ").append(item.packing().packing()).append(", Price: ").append(item.price()).append("\n");
        return str.toString();
    }
}
