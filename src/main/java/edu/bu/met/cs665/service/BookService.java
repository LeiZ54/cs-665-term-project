package edu.bu.met.cs665.service;

import edu.bu.met.cs665.dao.BookDAO;
import edu.bu.met.cs665.dao.BookDAOImpl;
import edu.bu.met.cs665.entity.Book;

import java.util.List;

/**
 * Service class for managing bookings.
 * This class integrates the functionality of the UserService, MtResortService, and BookDAO
 * to handle booking-related operations.
 */
public class BookService {

    // Dependency on the DAO layer for database operations
    private final BookDAO bookDAO;

    // Dependencies on other services
    private final UserService userService;
    private final MtResortService mtResortService;

    /**
     * Constructor for BookService.
     *
     * @param userService     An instance of UserService to retrieve user information.
     * @param mtResortService An instance of MtResortService to retrieve resort information.
     */
    public BookService(UserService userService, MtResortService mtResortService) {
        this.userService = userService;
        this.mtResortService = mtResortService;
        this.bookDAO = new BookDAOImpl(); // Direct instantiation of BookDAOImpl
    }

    /**
     * Adds a new booking for a user and a resort.
     *
     * @param userId   The ID of the user making the booking.
     * @param resortId The ID of the resort being booked.
     */
    public void addBook(int userId, int resortId) {
        // Retrieve the user's name and resort's name
        String userName = userService.getUserById(userId).getName();
        String resortName = mtResortService.getMtResortById(resortId).getName();

        // Check if both user and resort exist
        if (userName != null && resortName != null) {
            Book book = new Book(userName, resortName);
            bookDAO.addBook(book); // Add booking to the database
            System.out.println("Book added for user: " + userName + " and resort: " + resortName);
        } else {
            // Handle case where user or resort is not found
            System.out.println("Failed to add book. User or Resort not found.");
        }
    }

    /**
     * Retrieves a list of all bookings.
     *
     * @return A list of all Book objects stored in the database.
     */
    public List<Book> getAllBooks() {
        return bookDAO.getBooks();
    }
}
