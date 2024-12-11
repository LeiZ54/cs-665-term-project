package edu.bu.met.cs665.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The MtResort class represents a mountain resort entity.
 * It includes details about the resort such as its ID, name, address, and ticket price.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MtResort {

    /**
     * The unique identifier for the resort.
     */
    private int id;

    /**
     * The name of the mountain resort.
     */
    private String name;

    /**
     * The address of the mountain resort.
     */
    private String address;

    /**
     * The ticket price for accessing the mountain resort.
     */
    private double ticketPrice;

    /**
     * Constructor to create an MtResort object without an ID.
     * This is typically used when adding a new resort to the database where the ID is auto-generated.
     *
     * @param name        the name of the resort.
     * @param address     the address of the resort.
     * @param ticketPrice the ticket price for the resort.
     */
    public MtResort(String name, String address, double ticketPrice) {
        this.name = name;
        this.address = address;
        this.ticketPrice = ticketPrice;
    }

    /**
     * Provides a string representation of the MtResort object.
     *
     * @return a string that represents the resort details.
     */
    @Override
    public String toString() {
        return "MtResort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
