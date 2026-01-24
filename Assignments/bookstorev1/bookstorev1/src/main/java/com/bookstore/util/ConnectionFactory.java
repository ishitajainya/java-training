package com.bookstore.util;
import java.sql.*;

public class ConnectionFactory {

    private static final String URL =
            "jdbc:mysql://localhost:3306/ymsli26?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private ConnectionFactory() {
        
    }

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
