package ru.itmo.catalog;

import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.models.FoodItem;

public class CatalogStubLoader implements CatalogLoader {
    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        for (int i = 0; i < 10; i++) {
            try {
                catalog.addItem(new FoodItem("Item" + i));
            } catch (ItemAlreadyExistsException ex) {
                throw new CatalogLoadException(ex);
            }
        }
    }
}
