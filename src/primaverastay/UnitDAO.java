/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primaverastay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitDAO {
    
    private int lastInsertedUnitId = -1;
    
public ArrayList<Unit> getAllActiveUnits() {

        ArrayList<Unit> units = new ArrayList<>();

        String sql = "SELECT * FROM units "
                   + "WHERE status = 'Active' AND is_archived = FALSE";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Unit unit = new Unit(
                        rs.getInt("unit_id"),
                        rs.getString("unit_number"),
                        rs.getString("unit_type"),
                        rs.getInt("capacity"),
                        rs.getDouble("price_per_night"),
                        rs.getString("status")
                );

                units.add(unit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return units;
    }

public ArrayList<Unit> getAvailableUnits(
        java.time.LocalDateTime checkIn,
        java.time.LocalDateTime checkOut) {

    ArrayList<Unit> units = new ArrayList<>();

    String sql = "SELECT u.* FROM units u "
            + "WHERE u.status = 'Active' "
            + "AND u.is_archived = FALSE "
            + "AND NOT EXISTS ("
            + "    SELECT 1 FROM reservations r "
            + "    WHERE r.unit_id = u.unit_id "
            + "    AND r.is_archived = FALSE "
            + "    AND r.reservation_status IN "
            + "        ('Pending', 'Confirmed', 'Checked In') "
            + "    AND r.check_in < ? "
            + "    AND r.check_out > ?"
            + ")";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setTimestamp(
                1,
                java.sql.Timestamp.valueOf(checkOut)
        );

        stmt.setTimestamp(
                2,
                java.sql.Timestamp.valueOf(checkIn)
        );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Unit unit = new Unit(
                    rs.getInt("unit_id"),
                    rs.getString("unit_number"),
                    rs.getString("unit_type"),
                    rs.getInt("capacity"),
                    rs.getDouble("price_per_night"),
                    rs.getString("status")
            );

            units.add(unit);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return units;
}

  public int getTotalUnits() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM units "
                   + "WHERE is_archived = FALSE";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

public int getAvailableUnitsToday() {

    int available = 0;

    String sql = "SELECT COUNT(*) FROM units u "
            + "WHERE u.status = 'Active' "
            + "AND u.is_archived = FALSE "
            + "AND NOT EXISTS ("
            + "SELECT 1 FROM reservations r "
            + "WHERE r.unit_id = u.unit_id "
            + "AND r.is_archived = FALSE "
            + "AND r.reservation_status IN ('Pending', 'Confirmed', 'Checked In') "
            + "AND NOW() >= r.check_in "
            + "AND NOW() < r.check_out"
            + ")";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
            available = rs.getInt(1);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return available;
}

public boolean addUnit(String unitNumber, String unitType,
                       int capacity, double pricePerNight,
                       String status, String description,
                       String amenities) {

    String sql = "INSERT INTO units "
            + "(unit_number, unit_type, capacity, price_per_night, "
            + "status, description, amenities) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(
                sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, unitNumber);
        stmt.setString(2, unitType);
        stmt.setInt(3, capacity);
        stmt.setDouble(4, pricePerNight);
        stmt.setString(5, status);
        stmt.setString(6, description);
        stmt.setString(7, amenities);

        int rowsInserted = stmt.executeUpdate();

        lastInsertedUnitId = -1;

if (rowsInserted > 0) {
    try (ResultSet rs = stmt.getGeneratedKeys()) {
        if (rs.next()) {
            lastInsertedUnitId = rs.getInt(1);
        }
    }
}

return rowsInserted > 0 && lastInsertedUnitId > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean updateUnit(int unitId, String unitNumber, String unitType,
                          int capacity, double pricePerNight,
                          String status) {

    String sql = "UPDATE units SET "
            + "unit_number = ?, "
            + "unit_type = ?, "
            + "capacity = ?, "
            + "price_per_night = ?, "
            + "status = ? "
            + "WHERE unit_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, unitNumber);
        stmt.setString(2, unitType);
        stmt.setInt(3, capacity);
        stmt.setDouble(4, pricePerNight);
        stmt.setString(5, status);
        stmt.setInt(6, unitId);

        int rowsUpdated = stmt.executeUpdate();

        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean archiveUnit(int unitId) {

    String sql = "UPDATE units SET is_archived = TRUE "
            + "WHERE unit_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, unitId);

        int rowsUpdated = stmt.executeUpdate();

        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public ArrayList<Unit> getArchivedUnits() {

    ArrayList<Unit> units = new ArrayList<>();

    String sql = "SELECT * FROM units "
            + "WHERE is_archived = TRUE "
            + "ORDER BY unit_number";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            Unit unit = new Unit(
                    rs.getInt("unit_id"),
                    rs.getString("unit_number"),
                    rs.getString("unit_type"),
                    rs.getInt("capacity"),
                    rs.getDouble("price_per_night"),
                    rs.getString("status")
            );

            units.add(unit);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return units;
}

public boolean restoreUnit(int unitId) {

    String sql = "UPDATE units SET is_archived = FALSE "
            + "WHERE unit_id = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, unitId);

        int rowsUpdated = stmt.executeUpdate();

        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public ArrayList<Unit> getAllUnits() {

    ArrayList<Unit> units = new ArrayList<>();

    String sql = "SELECT * FROM units "
            + "WHERE is_archived = FALSE "
            + "ORDER BY unit_number";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            Unit unit = new Unit(
                    rs.getInt("unit_id"),
                    rs.getString("unit_number"),
                    rs.getString("unit_type"),
                    rs.getInt("capacity"),
                    rs.getDouble("price_per_night"),
                    rs.getString("status")
            );

            units.add(unit);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return units;
}

public int getLastInsertedUnitId() {
    return lastInsertedUnitId;
}

public boolean addUnitPhoto(int unitId, String photoPath, int displayOrder) {

    String sql = "INSERT INTO unit_photos "
            + "(unit_id, photo_path, display_order) "
            + "VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, unitId);
        stmt.setString(2, photoPath);
        stmt.setInt(3, displayOrder);

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}