package ru.itmo.catalog;

import ru.itmo.models.GenericItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<>();
    private ArrayList<GenericItem> arrayListCatalog = new ArrayList<>();

    public void addItem(GenericItem item) {
        catalog.put(item.getId(), item);
        arrayListCatalog.add(item);
    }

    public GenericItem findById(int id) {
        if (catalog.containsKey(id)) {
            return catalog.get(id);
        }

        return null;
    }

    public GenericItem findByIdInArrayList(int id) {
        for (GenericItem elem : arrayListCatalog) {
            if (elem.getId() == id) {
                return elem;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Items:" + System.lineSeparator() +
                arrayListCatalog.stream()
                        .map(GenericItem::toString)
                        .collect(Collectors.joining("," + System.lineSeparator()));
    }
}
