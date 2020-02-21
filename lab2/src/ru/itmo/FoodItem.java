package ru.itmo;

import java.util.Date;

public class FoodItem extends GenericItem {
    private Date dateOfIncome;
    private short expire;

    public FoodItem(int id,
                    String name,
                    float price,
                    GenericItem analog,
                    ItemCategory category,
                    Date dateOfIncome,
                    short expire
    ) {
        super(id, name, price, analog, category);
        this.dateOfIncome = dateOfIncome;
        this.expire = expire;
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public short getExpire() {
        return expire;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", price=" + getPrice() +
                ", analog=" + (getAnalog() != null ? getAnalog().getId() : null) +
                ", category=" + getCategory() +
                ", dateOfIncome=" + dateOfIncome +
                ", expire=" + expire +
                "} ";
    }

    public FoodItem clone() {
        return new FoodItem(
                getId(),
                getName(),
                getPrice(),
                getAnalog(),
                getCategory(),
                new Date(getDateOfIncome().getTime()),
                getExpire()
        );
    }
}
