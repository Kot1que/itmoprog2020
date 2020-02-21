package ru.itmo.catalog;

import ru.itmo.dao.ItemDao;
import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;
import ru.itmo.models.GenericItem;

import java.sql.SQLException;
import java.util.List;

public class CatalogDBLoader implements CatalogLoader {
    private ItemDao itemDao;

    @Override
    public void load(ItemCatalog catalog) throws CatalogLoadException {
        try {
            List<GenericItem> items = itemDao.findAll();
            for (GenericItem item : items) {
                catalog.addItem(item);
            }
        } catch (SQLException | ItemAlreadyExistsException e) {
            throw new CatalogLoadException(e);
        }
    }
}
