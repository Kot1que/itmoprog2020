package ru.itmo.catalog;

import ru.itmo.models.FoodItem;

public class CatalogStubLoader implements CatalogLoader {
    @Override
    public void load(ItemCatalog catalog) {
        for (int i = 0; i < 10; i++) {
            catalog.addItem(new FoodItem("Item" + i));
        }
    }
}
