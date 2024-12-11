package edu.bu.met.cs665.dao;

import edu.bu.met.cs665.config.JDBCConfig;
import edu.bu.met.cs665.entity.MtResort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the MtResortDAO interface.
 * This class handles all database operations related to the MtResort entity.
 */
public class MtResortDAOImpl implements MtResortDAO {
    private static final Logger logger = LogManager.getLogger(MtResortDAOImpl.class);

    /**
     * Adds a new MtResort to the database.
     *
     * @param mt The MtResort object to be added.
     */
    @Override
    public void addMtResort(MtResort mt) {
        String sql = "INSERT INTO mt_resorts (name, address, ticket_price) VALUES (?, ?, ?)";
        try (Connection conn = JDBCConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mt.getName());
            stmt.setString(2, mt.getAddress());
            stmt.setDouble(3, mt.getTicketPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error adding MtResort to the database.", e);
        }
    }

    /**
     * Retrieves a list of all MtResorts from the database.
     *
     * @return A list of MtResort objects.
     */
    @Override
    public List<MtResort> getMtResorts() {
        String sql = "SELECT * FROM mt_resorts";
        List<MtResort> resorts = new ArrayList<>();
        try (Connection conn = JDBCConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MtResort resort = new MtResort(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("ticket_price")
                );
                resorts.add(resort);
            }

        } catch (SQLException e) {
            logger.error("Error retrieving MtResorts from the database.", e);
        }
        return resorts;
    }

    /**
     * Retrieves a MtResort by its ID.
     *
     * @param id The ID of the MtResort to retrieve.
     * @return The MtResort object if found, otherwise null.
     */
    @Override
    public MtResort getMtResortById(int id) {
        String query = "SELECT * FROM mt_resorts WHERE id = ?";
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;

        try {
            conn = JDBCConfig.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                MtResort mtResort = new MtResort();
                mtResort.setId(rs.getInt("id"));
                mtResort.setName(rs.getString("name"));
                mtResort.setAddress(rs.getString("address"));
                mtResort.setTicketPrice(rs.getDouble("ticket_price"));
                return mtResort;
            }
        } catch (SQLException e) {
            logger.error("Failed to retrieve MtResort with ID: {}", id, e);
        }
        return null;
    }

    /**
     * Updates an existing MtResort in the database.
     *
     * @param mt The MtResort object containing updated information.
     */
    @Override
    public void updateMtResort(MtResort mt) {
        String sql = "UPDATE mt_resorts SET name = ?, address = ?, ticket_price = ? WHERE id = ?";
        try (Connection conn = JDBCConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mt.getName());
            stmt.setString(2, mt.getAddress());
            stmt.setDouble(3, mt.getTicketPrice());
            stmt.setInt(4, mt.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating MtResort in the database.", e);
        }
    }

    /**
     * Deletes a MtResort from the database by its ID.
     *
     * @param mtResortId The ID of the MtResort to delete.
     */
    @Override
    public void deleteMtResort(int mtResortId) {
        String sql = "DELETE FROM mt_resorts WHERE id = ?";
        try (Connection conn = JDBCConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mtResortId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting MtResort from the database.", e);
        }
    }

    @Override
    public void deleteAllMtResorts() {
        String deleteSql = "DELETE FROM mt_resorts";
        String resetSql = "ALTER TABLE mt_resorts AUTO_INCREMENT = 1";

        try (Connection connection = JDBCConfig.getConnection();
             PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
             PreparedStatement resetStmt = connection.prepareStatement(resetSql)) {

            // Execute delete and reset queries
            deleteStmt.executeUpdate();
            resetStmt.executeUpdate();

            System.out.println("Table has been cleaned.");

        } catch (SQLException e) {
            logger.error("Error deleting all resorts and resetting the table.", e);
        }
    }

}
