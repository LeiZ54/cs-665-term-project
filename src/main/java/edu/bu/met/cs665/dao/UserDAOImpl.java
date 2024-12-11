package edu.bu.met.cs665.dao;

import edu.bu.met.cs665.config.JDBCConfig;
import edu.bu.met.cs665.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Name: UserDAOImpl
 * Description:
 * This class provides the implementation for the UserDAO interface. It performs CRUD (Create, Read, Update, Delete) operations on the "users" table in the database using JDBC.
 */
public class UserDAOImpl implements UserDAO {

    // Logger instance for logging messages and errors
    private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

    /**
     * Method: addUser
     * Description:
     * Adds a new user to the "users" table.
     *
     * @param user The User object containing the name and email to be added.
     */
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = JDBCConfig.getConnection().prepareStatement(sql)) {

            // Set the parameters for the query
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());

            // Execute the query
            stmt.executeUpdate();

        } catch (SQLException e) {
            logger.error("Error adding user to the database.", e);
        }
    }

    /**
     * Method: getAllUsers
     * Description:
     * Retrieves all users from the "users" table in the database.
     *
     * @return A list of User objects representing all users in the database.
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = JDBCConfig.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            // Iterate over the result set and create User objects
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),          // Parse ID
                        resultSet.getString("name"),     // Get name
                        resultSet.getString("email")     // Get email
                );
                users.add(user);
            }

        } catch (SQLException e) {
            logger.error("Error retrieving all users from the database.", e);
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCConfig.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            logger.error("Failed to retrieve user with ID: {}", id, e);
        }
        return null;
    }


    /**
     * Method: deleteUser
     * Description:
     * Deletes a user with the specified ID from the "users" table in the database.
     *
     * @param id The ID of the user to be deleted.
     */
    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = JDBCConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the ID parameter for the query
            statement.setInt(1, id);

            // Execute the query
            statement.executeUpdate();

            System.out.println("User with ID " + id + " removed.");

        } catch (SQLException e) {
            logger.error("Error deleting user with ID {}", id, e);
        }
    }

    /**
     * Method: deleteAllUsers
     * Description:
     * Deletes all users from the "users" table and resets the AUTO_INCREMENT counter.
     */
    @Override
    public void deleteAllUsers() {
        String deleteSql = "DELETE FROM users";
        String resetSql = "ALTER TABLE users AUTO_INCREMENT = 1";

        try (Connection connection = JDBCConfig.getConnection();
             PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
             PreparedStatement resetStmt = connection.prepareStatement(resetSql)) {

            // Execute delete and reset queries
            deleteStmt.executeUpdate();
            resetStmt.executeUpdate();

            System.out.println("Table has been cleaned.");

        } catch (SQLException e) {
            logger.error("Error deleting all users and resetting the table.", e);
        }
    }

    /**
     * Method: updateUser
     * Description:
     * Updates the name and email of an existing user in the "users" table.
     *
     * @param user The User object containing the updated data.
     */
    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (Connection connection = JDBCConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the parameters for the query
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());

            // Execute the update query
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User with ID " + user.getId() + " updated successfully.");
            } else {
                System.out.println("No user found with ID " + user.getId() + ".");
            }

        } catch (SQLException e) {
            logger.error("Error updating user with ID {}", user.getId(), e);
        }
    }
}
