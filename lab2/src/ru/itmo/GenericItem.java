package ru.itmo;

import java.util.Objects;

public class GenericItem {
    private int id;
    private String name;
    private float price;
    private GenericItem analog;
    private ItemCategory category;

    public GenericItem(int id, String name, float price, GenericItem analog, ItemCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.analog = analog;
        this.category = category;
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
        return id == that.id && name.equals(that.name) && Float.compare(price, that.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
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
