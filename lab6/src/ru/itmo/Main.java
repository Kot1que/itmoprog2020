package ru.itmo;

import ru.itmo.dao.*;
import ru.itmo.models.GenericItem;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConnectionFactory mySQLConnectionFactory = new MySQLConnectionFactory();
        ConnectionFactory h2InMemoryConnectionFactory = new H2InMemoryConnectionFactory();

        Connection mysqlConnection = mySQLConnectionFactory.getConnection();
        Connection h2Connection = h2InMemoryConnectionFactory.getConnection();

        ItemResolver itemResolver = new ItemResolver();

        ItemDao mysqlDao = new SQLItemDao(mysqlConnection, itemResolver);
        ItemDao h2Dao = new SQLItemDao(h2Connection, itemResolver);

        try {
            System.out.println("H2 fetch:");
            System.out.println(h2Dao.findById(2));

            System.out.println("MySQL fetch:");
            System.out.println(mysqlDao.findById(4));

            GenericItem item = h2Dao.findById(2);
            item.setName("item2 modified");
            h2Dao.update(item);

            System.out.println("H2 fetch updated:");
            System.out.println(h2Dao.findById(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
