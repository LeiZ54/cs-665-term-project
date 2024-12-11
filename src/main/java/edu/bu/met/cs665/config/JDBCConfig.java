package edu.bu.met.cs665.config;

import java.sql.*;

/**
 * Class Name: JDBCConfig
 * Description:
 * This class is responsible for managing database connections.
 * Usage:
 * Call the static method `getConnection()` to obtain a `Connection` object.
 * Note:
 * Ensure that the database URL, username, and password are correctly configured for your local MySQL.
 */
public class JDBCConfig {

    // JDBC URL for connecting to the database
    private static final String URL = "jdbc:mysql://localhost:3306/dao_show";

    // Username for the database connection
    private static final String USERNAME = "root";

    // Password for the database connection
    private static final String PASSWORD = "@Zl954954";

    /**
     * Method: getConnection
     * Description:
     * Establishes and returns a connection to the MySQL database.
     *
     * @return A `Connection` object for interacting with the database.
     * @throws SQLException If a database access error occurs or the connection fails.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
