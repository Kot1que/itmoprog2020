package ru.itmo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory implements ConnectionFactory {
    @Override
    public Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/catalog?user=root&password=5pxCVX");
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to Mysql database");
        }

        return connection;
    }
}
