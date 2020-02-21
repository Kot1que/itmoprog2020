package ru.itmo.models;

import java.util.Objects;

public class GenericItem {
    static int currentId = 0;

    private int id;
    private String name;
    private float price;
    private GenericItem analog;
    private ItemCategory category;

    protected GenericItem(int id, String name, float price, GenericItem analog, ItemCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analog, ItemCategory category) {
        this(name, price, category);
        this.analog = analog;
    }

    public GenericItem(String name, float price, ItemCategory category) {
        this(getNextId(), name, price, null, category);
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this(getNextId(), name, price, analog, ItemCategory.GENERAL);
    }

    public GenericItem() {
        this(getNextId(), "Unknown", 0, null, ItemCategory.GENERAL);
    }

    protected static int getNextId() {
        return currentId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public ItemCategory getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericItem that = (GenericItem) o;
        return name.equals(that.name) && Float.compare(price, that.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "GenericItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogId=" + (analog != null ? analog.getId() : null) +
                ", category=" + category +
                '}';
    }

    public GenericItem clone() {
        return new GenericItem(
                this.id,
                this.name,
                this.price,
                (this.analog != null ? this.analog.clone() : null),
                this.category
        );
    }
}
