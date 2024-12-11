package edu.bu.met.cs665.service;

import edu.bu.met.cs665.dao.UserDAO;
import edu.bu.met.cs665.entity.User;

import java.util.List;

/**
 * Service class for managing User entities.
 * This class provides a layer of abstraction between the controller and the DAO (Data Access Object).
 * It handles business logic and delegates database operations to the UserDAO.
 */
public class UserService {

    // Dependency on UserDAO to perform database operations
    private final UserDAO userDAO;

    /**
     * Constructor for UserService.
     *
     * @param userDAO An implementation of the UserDAO interface.
     */
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Adds a new user to the database.
     *
     * @param name  The name of the user.
     * @param email The email address of the user.
     */
    public void addUser(String name, String email) {
        userDAO.addUser(new User(name, email));
    }

    /**
     * Deletes a user from the database by their ID.
     *
     * @param id The ID of the user to be deleted.
     */
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    /**
     * Deletes all users from the database.
     */
    public void deleteAllUsers() {
        userDAO.deleteAllUsers();
    }

    /**
     * Updates the details of an existing user in the database.
     *
     * @param id    The ID of the user to be updated.
     * @param name  The new name of the user.
     * @param email The new email address of the user.
     */
    public void updateUser(int id, String name, String email) {
        userDAO.updateUser(new User(id, name, email));
    }

    /**
     * Retrieves a list of all users from the database.
     *
     * @return A list of User objects.
     */
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * Retrieves a user by their ID from the database.
     *
     * @param id The ID of the user to retrieve.
     * @return The User object corresponding to the specified ID.
     */
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
