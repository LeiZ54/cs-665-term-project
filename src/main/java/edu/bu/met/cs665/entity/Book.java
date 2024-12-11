package edu.bu.met.cs665.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The Book class represents a booking record that associates a user with a resort.
 * It contains details about the booking, including the ID, user name (bookName),
 * and the resort name.
 */
@Data
@AllArgsConstructor
public class Book {

    /**
     * The unique identifier for the booking.
     */
    private int id;

    /**
     * The name of the user who made the booking.
     */
    private String bookName;

    /**
     * The name of the resort associated with the booking.
     */
    private String resortName;

    /**
     * Constructor to create a Book object without an ID.
     * This is used when adding a new booking to the database
     * where the ID is auto-generated.
     *
     * @param bookName   the name of the user who made the booking.
     * @param resortName the name of the resort associated with the booking.
     */
    public Book(String bookName, String resortName) {
        this.bookName = bookName;
        this.resortName = resortName;
    }

    /**
     * Provides a string representation of the Book object.
     *
     * @return a string that represents the booking details.
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", resortName='" + resortName + '\'' +
                '}';
    }
}
