package edu.bu.met.cs665.dao;

import edu.bu.met.cs665.entity.Book;

import java.util.List;

/**
 * Interface representing the Data Access Object (DAO) for Book entities.
 * This interface defines the standard operations to be performed on the Book entity.
 */
public interface BookDAO {

    /**
     * Adds a new Book to the database.
     *
     * @param book The Book entity to be added.
     */
    void addBook(Book book);

    /**
     * Retrieves a list of all Books from the database.
     *
     * @return A list of all Book entities.
     */
    List<Book> getBooks();
}
