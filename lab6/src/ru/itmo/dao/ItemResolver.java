package ru.itmo.dao;

import ru.itmo.models.FoodItem;
import ru.itmo.models.GenericItem;
import ru.itmo.models.ItemCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ItemResolver {
    public GenericItem retrieveOne(ResultSet resultSet) throws SQLException {
        switch (resultSet.getString("category")) {
            case "FOOD":
                return getFoodItem(resultSet);

            case "GENERAL":
                return getGenericItem(resultSet);

            default:
                throw new RuntimeException("Unreachable statement");
        }
    }

    private GenericItem getGenericItem(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        float price = resultSet.getFloat("price");
        int id = resultSet.getInt("id");

        return new GenericItem(id, name, price, null, ItemCategory.GENERAL);
    }

    private FoodItem getFoodItem(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        float price = resultSet.getFloat("price");
        int id = resultSet.getInt("id");
        short expire = resultSet.getShort("expire");
        int incomeTimestamp = resultSet.getInt("incomeTimestamp");
        Date incomeDate = new Date((long) incomeTimestamp * 1000);

        return new FoodItem(id, name, price,null, ItemCategory.FOOD, incomeDate, expire);
    }
}
