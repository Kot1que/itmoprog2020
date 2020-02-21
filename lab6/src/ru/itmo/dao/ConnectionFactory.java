package ru.itmo.dao;

import java.sql.Connection;

public interface ConnectionFactory {
    Connection getConnection();
}
