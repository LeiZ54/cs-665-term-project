package edu.bu.met.cs665.service;

import edu.bu.met.cs665.dao.MtResortDAO;
import edu.bu.met.cs665.entity.MtResort;

import java.util.List;

/**
 * Service class for managing MtResort entities.
 * This class provides a layer of abstraction between the controller and the DAO (Data Access Object).
 * It handles business logic and delegates database operations to the MtResortDAO.
 */
public class MtResortService {

    // Dependency on MtResortDAO to perform database operations
    private final MtResortDAO mtResortDAO;

    /**
     * Constructor for MtResortService.
     *
     * @param mtResortDAO An implementation of the MtResortDAO interface.
     */
    public MtResortService(MtResortDAO mtResortDAO) {
        this.mtResortDAO = mtResortDAO;
    }

    /**
     * Adds a new mountain resort to the database.
     *
     * @param name        The name of the mountain resort.
     * @param address     The address of the mountain resort.
     * @param ticketPrice The ticket price of the mountain resort.
     */
    public void addMtResort(String name, String address, double ticketPrice) {
        MtResort mtResort = new MtResort(name, address, ticketPrice);
        mtResortDAO.addMtResort(mtResort);
        System.out.println("Resort added: " + mtResort.getName());
    }

    /**
     * Retrieves a mountain resort by its ID.
     *
     * @param id The ID of the mountain resort to retrieve.
     * @return The MtResort object corresponding to the specified ID.
     */
    public MtResort getMtResortById(int id) {
        return mtResortDAO.getMtResortById(id);
    }

    /**
     * Retrieves a list of all mountain resorts from the database.
     *
     * @return A list of MtResort objects.
     */
    public List<MtResort> getAllMtResorts() {
        return mtResortDAO.getMtResorts();
    }

    /**
     * Updates the details of an existing mountain resort in the database.
     *
     * @param id          The ID of the mountain resort to update.
     * @param name        The new name of the mountain resort.
     * @param address     The new address of the mountain resort.
     * @param ticketPrice The new ticket price of the mountain resort.
     */
    public void updateMtResort(int id, String name, String address, double ticketPrice) {
        MtResort mtResort = new MtResort(id, name, address, ticketPrice);
        mtResortDAO.updateMtResort(mtResort);
        System.out.println("Resort updated: " + mtResort.getName());
    }

    /**
     * Deletes a mountain resort by its ID.
     *
     * @param id The ID of the mountain resort to delete.
     */
    public void deleteMtResort(int id) {
        mtResortDAO.deleteMtResort(id);
        System.out.println("Resort deleted with ID: " + id);
    }

    public void deleteAllMtResorts() {
        mtResortDAO.deleteAllMtResorts();
    }
}
