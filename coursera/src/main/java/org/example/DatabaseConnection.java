package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/coursera"; // Replace "shop1" with your database name
    private static final String DB_USERNAME = "root"; // Your database username
    private static final String DB_PASSWORD = ""; // Your database password

    // Function to establish a connection to the database
    public Connection connect() {
        try {
            // Attempting to establish a connection
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            // If the connection fails, print the error message and return null
            e.printStackTrace();
            return null;
        }
    }
}