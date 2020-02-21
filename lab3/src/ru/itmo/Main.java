package ru.itmo;

import ru.itmo.task1.FoodItem;
import ru.itmo.task1.GenericItem;
import ru.itmo.task2.Array;

import java.util.ArrayList;
import java.util.List;

import static ru.itmo.task1.ItemCategory.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");
	    task1();

        System.out.println("Task 2");
	    task2();

        System.out.println("Task 3");
	    task3();
    }

    private static void task1() {
        var item1 = new GenericItem("Item1", 10, GENERAL);
        var item2 = new GenericItem("Item2", 20, DRESS);
        var item3 = new GenericItem("Item3", 30, item2, DRESS);
        var item4 = new FoodItem("food1", 1,  (short) 10);
        var item5 = new FoodItem("food2", 2,  (short) 20);

        List<GenericItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.forEach(System.out::println);

        System.out.println("Equals: " + item1.equals(item2));

        var cloned = item4.clone();
        System.out.println("Cloned equals: " + cloned.equals(item4));

        var cloned2 = item1.clone();
        System.out.println("Cloned2 equals: " + cloned2.equals(item1));
    }

    private static void task2() {
        Integer[] integerArray = {10, 20, 15};
        Array<Integer> integerNumberArray = new Array<>(integerArray);

        Float[] floatArray = new Float[3];
        for (int i = 0; i < 3; i++) {
            floatArray[i] = (float) Math.random() * 100;
        }

        Array<Float> floatNumberArray = new Array<>(floatArray);

        System.out.println(integerNumberArray.sum());
        System.out.println(floatNumberArray.sum());
    }

    private static void task3() {
        String data = "Конфеты 'Маска';45;120";
        String[] fields = data.split(";");

        try {
            String name = fields[0];
            float price = Float.parseFloat(fields[1]);
            short expires = Short.parseShort(fields[2]);
            FoodItem item = new FoodItem(name, price, expires);
            System.out.println(item.toString());
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
