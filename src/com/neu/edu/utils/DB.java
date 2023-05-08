package com.neu.edu.utils;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DB {
    public final static Connection getConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javaweb?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            connection = DriverManager.getConnection(url, "root", "huangdianbei2017");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load database driver", e);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
        return connection;
    }

}
