package ru.itmo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.itmo.ItemCategory.*;

public class Main {

    public static void main(String[] args) {
	    var item1 = new GenericItem(1, "Item1", 10, null, GENERAL);
	    var item2 = new GenericItem(2, "Item2", 20, null, DRESS);
	    var item3 = new GenericItem(3, "Item3", 30, item2, DRESS);
        var item4 = new FoodItem(4, "food1", 1, null, FOOD, new Date(), (short) 10);
        var item5 = new FoodItem(5, "food2", 2, null, FOOD, new Date(), (short) 20);
        var item6 = new TechnicalItem(6, "tech1", 1, null, PRINT, (short) 10);
        var item7 = new TechnicalItem(7, "tech2", 2, item6, PRINT, (short) 5);

        List<GenericItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.forEach(System.out::println);

        System.out.println("Equals: " + item1.equals(item2));

        var cloned = item4.clone();
        System.out.println("Cloned equals: " + cloned.equals(item4));

        var cloned2 = item1.clone();
        System.out.println("Cloned2 equals: " + cloned2.equals(item1));
    }
}
