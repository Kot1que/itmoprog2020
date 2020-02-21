package ru.itmo.catalog;

import ru.itmo.exceptions.CatalogLoadException;

public interface CatalogLoader {
    void load(ItemCatalog catalog) throws CatalogLoadException;
}
