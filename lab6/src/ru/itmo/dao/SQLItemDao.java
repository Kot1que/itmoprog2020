package ru.itmo.dao;

import ru.itmo.models.FoodItem;
import ru.itmo.models.GenericItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLItemDao implements ItemDao {
    private Connection connection;
    private ItemResolver itemResolver;

    public SQLItemDao(Connection connection, ItemResolver itemResolver) {
        this.connection = connection;
        this.itemResolver = itemResolver;
    }

    @Override
    public List<GenericItem> findAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from `items`;");
        ResultSet resultSet = statement.executeQuery();

        List<GenericItem> items = new ArrayList<>();
        while (resultSet.next()) {
            items.add(this.itemResolver.retrieveOne(resultSet));
        }

        return items;
    }

    @Override
    public GenericItem findById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from `items` WHERE `id`=?");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        return this.itemResolver.retrieveOne(resultSet);
    }

    @Override
    public void update(GenericItem item) throws SQLException {
        if (item instanceof FoodItem) {
            updateFoodItem((FoodItem) item);
        } else {
            updateGenericItem(item);
        }
    }

    private void updateGenericItem(GenericItem item) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("UPDATE items SET `name`=?, `price`=? WHERE `id`=?");

        statement.setString(1, item.getName());
        statement.setFloat(2, item.getPrice());
        statement.setInt(3, item.getId());

        statement.executeUpdate();
        connection.commit();

        statement.close();
    }

    private void updateFoodItem(FoodItem item) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("UPDATE `items` SET `name`=?, `price`=?, `expire`=?, `incomeTimestamp`=? " +
                        "WHERE `id`=?");
        statement.setString(1, item.getName());
        statement.setFloat(2, item.getPrice());
        statement.setShort(3, item.getExpire());
        statement.setInt(4, (int) (item.getDateOfIncome().getTime() / 1000));
        statement.setInt(5, item.getId());

        statement.executeUpdate();
        connection.commit();

        statement.close();
    }
}
