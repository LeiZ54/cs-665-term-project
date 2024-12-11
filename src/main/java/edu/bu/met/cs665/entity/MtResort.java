package edu.bu.met.cs665.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MtResort {
    private int id;
    private String name;
    private String address;
    private double ticketPrice;

    public MtResort(String name, String address, double ticketPrice) {
        this.name = name;
        this.address = address;
        this.ticketPrice = ticketPrice;
    }
}
