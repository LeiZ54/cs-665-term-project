/**
 * Name: LEI ZHU
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/01/2024
 * File Name: Main.java
 * Description:
 * This is the main entry point of the program. It demonstrates the usage of the UserService
 * class to perform CRUD (Create, Read, Update, Delete) operations on user data stored
 * in a database.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.dao.MtResortDAOImpl;
import edu.bu.met.cs665.dao.UserDAOImpl;
import edu.bu.met.cs665.service.BookService;
import edu.bu.met.cs665.service.MtResortService;
import edu.bu.met.cs665.service.UserService;

/**
 * This is the Main class. It serves as the entry point for the program, demonstrating
 * the usage of the UserService and UserDAOImpl classes to interact with user data.
 */
public class Main {

    /**
     * A main method to run examples.
     * You may use this method for development purposes as you start building your
     * assignments/final project.  This could prove convenient to test as you are developing.
     * However, please note that every assignment/final projects requires JUnit tests.
     */
    public static void main(String[] args) {
        UserService userService = new UserService(new UserDAOImpl());
        MtResortService mtResortService = new MtResortService(new MtResortDAOImpl());
        BookService bookService = new BookService(userService, mtResortService);
        // Clean up the tables.
        userService.deleteAllUsers();
        mtResortService.deleteAllMtResorts();

        // Step 1: Add new users to the database
        userService.addUser("lei", "lei@bu.edu");
        userService.addUser("bob", "bob@bu.edu");
        mtResortService.addMtResort("Killington", "VT-05751", 120.0);
        mtResortService.addMtResort("Stowe", "VT-05672", 150.0);

        // Step 2: Display all users and resorts
        System.out.println("All Users:");
        userService.getAllUsers().forEach(System.out::println);
        System.out.println("All Resorts:");
        mtResortService.getAllMtResorts().forEach(System.out::println);

        // Step 3: Book a resort for User 1
        bookService.addBook(1, 1);
        System.out.println("All Books:");
        bookService.getAllBooks().forEach(System.out::println);
    }
}
