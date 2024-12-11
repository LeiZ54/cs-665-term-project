package edu.bu.met.cs665.dao;

import edu.bu.met.cs665.entity.MtResort;

import java.util.List;

/**
 * MtResortDAO interface defines the CRUD operations for the MtResort entity.
 * It serves as the Data Access Object (DAO) for interacting with the MtResort-related data in the database.
 */
public interface MtResortDAO {

    /**
     * Adds a new MtResort to the database.
     *
     * @param MtResort the MtResort object to be added.
     */
    void addMtResort(MtResort MtResort);

    /**
     * Retrieves all MtResorts from the database.
     *
     * @return a list of MtResorts.
     */
    List<MtResort> getMtResorts();

    /**
     * Retrieves a MtResort by its ID.
     *
     * @param id the ID of the MtResort.
     * @return the MtResort object if found, null otherwise.
     */
    MtResort getMtResortById(int id);

    /**
     * Updates an existing MtResort in the database.
     *
     * @param MtResort the MtResort object containing updated information.
     */
    void updateMtResort(MtResort MtResort);

    /**
     * Deletes a MtResort from the database by its ID.
     *
     * @param MtResortId the ID of the MtResort to be deleted.
     */
    void deleteMtResort(int MtResortId);
    void deleteAllMtResorts();
}
