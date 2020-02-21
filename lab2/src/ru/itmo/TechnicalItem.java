package ru.itmo;

public class TechnicalItem extends GenericItem {
    private short warrantyTime;

    public TechnicalItem(int id,
                         String name,
                         float price,
                         GenericItem analog,
                         ItemCategory category,
                         short warrantyTime
    ) {
        super(id, name, price, analog, category);
        this.warrantyTime = warrantyTime;
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", price=" + getPrice() +
                ", analog=" + (getAnalog() != null ? getAnalog().getId() : null) +
                ", category" + getCategory() +
                ", warrantyTime=" + warrantyTime +
                "} ";
    }

    public TechnicalItem clone() {
        return new TechnicalItem(getId(), getName(), getPrice(), getAnalog(), getCategory(), getWarrantyTime());
    }

}
