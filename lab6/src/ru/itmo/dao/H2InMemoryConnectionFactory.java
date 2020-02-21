package ru.itmo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2InMemoryConnectionFactory implements ConnectionFactory {
    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find H2 driver");
        }

        Connection connection;
        try {
            connection = DriverManager
                    .getConnection("jdbc:h2:mem:");
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to H2 in-memory database");
        }

        try {
            this.initInMemoryDB(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to initialize H2 in-memory DB");
        }

        return connection;
    }

    private void initInMemoryDB(Connection connection) throws SQLException {
        /*
    CREATE TABLE `items` (
	`id` INT NOT NULL,
	`name` VARCHAR(50) NULL DEFAULT NULL,
	`price` FLOAT NULL DEFAULT NULL,
	`category` VARCHAR(50) NULL DEFAULT NULL,
	`expire` INT NULL DEFAULT NULL,
	`incomeTimestamp` INT NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) VALUES (1, 'item1', 10, 'FOOD', 120, 1582311198);
INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) VALUES (2, 'item2', 20, 'FOOD', 120, 1582311198);
INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) VALUES (3, 'item3', 30, 'FOOD', 120, 1582311198);
INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) VALUES (4, 'item4', 40, 'GENERAL', 120, 1582311198);
         */

        PreparedStatement createTableStatement = connection.prepareStatement(
                "CREATE TABLE items (`id` int not null," +
                        " `name` varchar(50) null default null," +
                        " `price` float null default null," +
                        " `category` varchar(50) null default null," +
                        "`expire` int null default null," +
                        "`incomeTimestamp` int null default null," +
                        "primary key (`id`))"
        );

        createTableStatement.executeUpdate();

        PreparedStatement createItems = connection.prepareStatement(
                "INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) " +
                        "VALUES (1, 'item1', 10, 'FOOD', 120, 1582311198);" +
                    "INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) " +
                        "VALUES (2, 'item2', 20, 'FOOD', 120, 1582311198);" +
                    "INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) " +
                        "VALUES (3, 'item3', 30, 'FOOD', 120, 1582311198);" +
                    "INSERT INTO `items` (`id`, `name`, `price`, `category`, `expire`, `incomeTimestamp`) " +
                        "VALUES (4, 'item4', 40, 'GENERAL', 120, 1582311198);"
        );

        createItems.executeUpdate();
    }
}
