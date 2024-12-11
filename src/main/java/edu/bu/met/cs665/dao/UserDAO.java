package edu.bu.met.cs665.dao;

import edu.bu.met.cs665.entity.User;

import java.util.List;

/**
 * Interface Name: UserDAO
 * Description:
 * This interface defines the CRUD (Create, Read, Update, Delete) operations
 * for managing `User` objects in the database. Implementing classes must
 * provide the logic for interacting with the database.
 */
public interface UserDAO {

    /**
     * Method: addUser
     * Description:
     * Adds a new user to the database.
     *
     * @param user The User object containing the name and email to be added to the database.
     */
    void addUser(User user);

    /**
     * Method: getAllUsers
     * Description:
     * Retrieves all users from the database.
     *
     * @return A list of Users representing all users in the table.
     */
    List<User> getAllUsers();

    User getUserById(int id);

    /**
     * Method: updateUser
     * Description:
     * Updates the details (name and email) of an existing user in the database.
     *
     * @param user The User object containing the updated details.
     */
    void updateUser(User user);

    /**
     * Method: deleteUser
     * Description:
     * Deletes a user from the database based on their unique ID.
     *
     * @param id The unique ID of the user to be deleted.
     */
    void deleteUser(int id);

    /**
     * Method: deleteAllUsers
     * Description:
     * Deletes all users from the database and optionally resets the auto-increment
     * counter for the primary key.
     */
    void deleteAllUsers();
}
