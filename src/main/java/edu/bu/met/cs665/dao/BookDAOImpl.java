package edu.bu.met.cs665.dao;

import edu.bu.met.cs665.config.JDBCConfig;
import edu.bu.met.cs665.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the BookDAO interface for performing CRUD operations on the "books" table.
 * This class uses JDBC for database interaction and Log4j for logging.
 */
public class BookDAOImpl implements BookDAO {

    // Logger instance for logging information and error messages
    private static final Logger logger = LogManager.getLogger(BookDAOImpl.class);

    /**
     * Adds a new book record to the database.
     *
     * @param book The Book object containing the details to be added to the database.
     */
    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (book_name, resort_name) VALUES (?, ?)"; // SQL query to insert a new book
        try (Connection conn = JDBCConfig.getConnection();  // Obtain a database connection
             PreparedStatement stmt = conn.prepareStatement(sql)) {  // Prepare the SQL statement

            // Set the parameters for the prepared statement
            stmt.setString(1, book.getBookName()); // Set the book name
            stmt.setString(2, book.getResortName()); // Set the associated resort name

            // Execute the update
            stmt.executeUpdate();
            logger.info("Book added successfully: " + book.getBookName()); // Log success message

        } catch (SQLException e) {
            // Log error if the database operation fails
            logger.error("Error adding book to the database.", e);
        }
    }

    /**
     * Retrieves all book records from the database.
     *
     * @return A list of Book objects retrieved from the database.
     */
    @Override
    public List<Book> getBooks() {
        String sql = "SELECT * FROM books"; // SQL query to fetch all records from the "books" table
        List<Book> books = new ArrayList<>(); // List to store the retrieved Book objects
        try (Connection conn = JDBCConfig.getConnection();  // Obtain a database connection
             Statement stmt = conn.createStatement();  // Create a statement to execute the query
             ResultSet rs = stmt.executeQuery(sql)) {  // Execute the query and get the result set

            // Iterate through the result set and create Book objects
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),  // Retrieve the book ID
                        rs.getString("book_name"),  // Retrieve the book name
                        rs.getString("resort_name")  // Retrieve the associated resort name
                );
                books.add(book); // Add the book to the list
            }

        } catch (SQLException e) {
            // Log error if the database operation fails
            logger.error("Error retrieving books from the database.", e);
        }
        return books; // Return the list of books
    }
}
