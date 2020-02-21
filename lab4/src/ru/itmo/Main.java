package ru.itmo;

import ru.itmo.catalog.CatalogLoader;
import ru.itmo.catalog.CatalogStubLoader;
import ru.itmo.catalog.ItemCatalog;
import ru.itmo.models.FoodItem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        task1();
        System.out.println("Task 2");
        task2();
    }

    private static void task1() {
        ItemCatalog catalog = new ItemCatalog();

        for (int i = 0; i < 1000; i++) {
            catalog.addItem(new FoodItem("Item" + i));
        }

        long start = System.currentTimeMillis();
        catalog.findById(500);
        long end = System.currentTimeMillis() - start;
        System.out.println(String.format("One element find time: %d millis", end));

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            catalog.findByIdInArrayList(500);
        }

        end = System.currentTimeMillis() - start;
        System.out.println(String.format("1.000.000 elements find time: %d millis", end));

        /*
            One element search: 0ms
            1.000.000 elements search: 400ms
         */

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            catalog.findById(500);
        }

        end = System.currentTimeMillis() - start;
        System.out.println(String.format("1.000.000 elements find time hashmap: %d millis", end));

        /*
            1.000.000 elements search: 20ms
         */
    }

    private static void task2() {
        ItemCatalog catalog = new ItemCatalog();

        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);

        System.out.println(catalog);
    }
}
