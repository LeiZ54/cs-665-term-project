package edu.bu.met.cs665.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Name: User
 * Description:
 * This class represents a user entity with attributes `id`, `name`, and `email`.
 * Usage:
 * Instances of this class can be used to represent user data in the application
 * and can be easily persisted to or retrieved from the database.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * The unique ID of the user.
     */
    private int id;

    /**
     * The name of the user.
     */
    private String name;

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * Constructor: User
     * Description:
     * Creates a User object without an `id`. This is useful for creating new users
     * before they are persisted to the database.
     *
     * @param name  The name of the user.
     * @param email The email address of the user.
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Method: toString
     * Description:
     * Returns a string representation of the User object, including its `id`, `name`, and `email`.
     *
     * @return A string representation of the User object.
     */
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
