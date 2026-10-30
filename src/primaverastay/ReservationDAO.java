/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primaverastay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Potpot
 */
public class ReservationDAO {
      public int getUpcomingReservations() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM reservations "
                   + "WHERE check_in > NOW() "
                   + "AND reservation_status IN ('Pending', 'Confirmed') "
                   + "AND is_archived = FALSE";

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
      
      public void loadReservations(DefaultTableModel model) {

    model.setRowCount(0);

    String sql = "SELECT r.reservation_id, r.guest_name, "
            + "r.contact_number, u.unit_number, "
            + "r.check_in, r.check_out, "
            + "r.number_of_guests, r.total_amount, "
            + "r.reservation_status "
            + "FROM reservations r "
            + "JOIN units u ON r.unit_id = u.unit_id "
            + "WHERE r.is_archived = FALSE "
            + "ORDER BY r.check_in DESC";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getInt("reservation_id"),
                rs.getString("guest_name"),
                rs.getString("contact_number"),
                rs.getString("unit_number"),
                rs.getTimestamp("check_in"),
                rs.getTimestamp("check_out"),
                rs.getInt("number_of_guests"),
                rs.getBigDecimal("total_amount"),
                rs.getString("reservation_status")
            });
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
      }
      
      public java.util.Map<String, Object> getReservationById(int reservationId) {
    String sql = "SELECT reservation_id, guest_name, contact_number, "
            + "unit_id, check_in, check_out, number_of_guests, "
            + "price_per_night, total_amount, required_deposit, "
            + "reservation_status "
            + "FROM reservations "
            + "WHERE reservation_id = ? AND is_archived = FALSE";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, reservationId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                java.util.Map<String, Object> data = new java.util.HashMap<>();

                data.put("guestName", rs.getString("guest_name"));
                data.put("contactNumber", rs.getString("contact_number"));
                data.put("unitId", rs.getInt("unit_id"));
                data.put("checkIn", rs.getTimestamp("check_in").toLocalDateTime());
                data.put("checkOut", rs.getTimestamp("check_out").toLocalDateTime());
                data.put("numberOfGuests", rs.getInt("number_of_guests"));
                data.put("pricePerNight", rs.getDouble("price_per_night"));
                data.put("totalAmount", rs.getDouble("total_amount"));
                data.put("requiredDeposit", rs.getDouble("required_deposit"));
                data.put("status", rs.getString("reservation_status"));

                return data;
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
      
      public boolean addReservation(
        String guestName,
        String contactNumber,
        int unitId,
        java.time.LocalDateTime checkIn,
        java.time.LocalDateTime checkOut,
        int numberOfGuests,
        double pricePerNight,
        double totalAmount,
        double requiredDeposit,
        int createdBy) {

    String sql = "INSERT INTO reservations "
            + "(guest_name, contact_number, unit_id, check_in, check_out, "
            + "number_of_guests, price_per_night, total_amount, "
            + "required_deposit, reservation_status, created_by, is_archived) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'Pending', ?, FALSE)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, guestName);
        stmt.setString(2, contactNumber);
        stmt.setInt(3, unitId);
        stmt.setTimestamp(4, java.sql.Timestamp.valueOf(checkIn));
        stmt.setTimestamp(5, java.sql.Timestamp.valueOf(checkOut));
        stmt.setInt(6, numberOfGuests);
        stmt.setDouble(7, pricePerNight);
        stmt.setDouble(8, totalAmount);
        stmt.setDouble(9, requiredDeposit);
        stmt.setInt(10, createdBy);

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
      public boolean isUnitAvailable(
        int unitId,
        java.time.LocalDateTime checkIn,
        java.time.LocalDateTime checkOut) {

    String sql = "SELECT COUNT(*) FROM reservations "
            + "WHERE unit_id = ? "
            + "AND is_archived = FALSE "
            + "AND reservation_status NOT IN ('Cancelled', 'Rejected') "
            + "AND check_in < ? "
            + "AND check_out > ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, unitId);
        stmt.setTimestamp(2, java.sql.Timestamp.valueOf(checkOut));
        stmt.setTimestamp(3, java.sql.Timestamp.valueOf(checkIn));

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}
      public boolean updateReservation(
        int reservationId,
        String guestName,
        String contactNumber,
        int unitId,
        java.time.LocalDateTime checkIn,
        java.time.LocalDateTime checkOut,
        int numberOfGuests,
        double pricePerNight,
        double totalAmount,
        double requiredDeposit) {

    String sql = "UPDATE reservations SET "
            + "guest_name = ?, contact_number = ?, "
            + "unit_id = ?, check_in = ?, check_out = ?, "
            + "number_of_guests = ?, price_per_night = ?, "
            + "total_amount = ?, required_deposit = ? "
            + "WHERE reservation_id = ? AND is_archived = FALSE";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, guestName);
        stmt.setString(2, contactNumber);
        stmt.setInt(3, unitId);
        stmt.setTimestamp(4, java.sql.Timestamp.valueOf(checkIn));
        stmt.setTimestamp(5, java.sql.Timestamp.valueOf(checkOut));
        stmt.setInt(6, numberOfGuests);
        stmt.setDouble(7, pricePerNight);
        stmt.setDouble(8, totalAmount);
        stmt.setDouble(9, requiredDeposit);
        stmt.setInt(10, reservationId);

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
      
      public boolean isUnitAvailableForEdit(
        int unitId,
        java.time.LocalDateTime checkIn,
        java.time.LocalDateTime checkOut,
        int reservationId) {

    String sql = "SELECT COUNT(*) FROM reservations "
            + "WHERE unit_id = ? "
            + "AND reservation_id <> ? "
            + "AND is_archived = FALSE "
            + "AND reservation_status NOT IN ('Cancelled', 'Rejected') "
            + "AND check_in < ? "
            + "AND check_out > ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, unitId);
        stmt.setInt(2, reservationId);
        stmt.setTimestamp(3, java.sql.Timestamp.valueOf(checkOut));
        stmt.setTimestamp(4, java.sql.Timestamp.valueOf(checkIn));

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}
      
      public boolean cancelReservation(int reservationId) {

    String sql = "UPDATE reservations "
            + "SET reservation_status = 'Cancelled' "
            + "WHERE reservation_id = ? "
            + "AND is_archived = FALSE "
            + "AND reservation_status NOT IN ('Cancelled', 'Rejected')";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, reservationId);

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
} 
      
     // LOAD RESERVATIONS FOR LOGGED-IN CLIENT
public void loadClientReservations(
        DefaultTableModel model, int clientId) {

    model.setRowCount(0);

    String sql = "SELECT r.reservation_id, "
            + "u.unit_number, r.check_in, r.check_out, "
            + "r.total_amount, r.reservation_status "
            + "FROM reservations r "
            + "JOIN units u ON r.unit_id = u.unit_id "
            + "WHERE r.client_id = ? "
            + "AND r.is_archived = FALSE "
            + "ORDER BY r.check_in DESC";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, clientId);

        try (ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("reservation_id"),
                    rs.getString("unit_number"),
                    rs.getTimestamp("check_in"),
                    rs.getTimestamp("check_out"),
                    rs.getBigDecimal("total_amount"),
                    rs.getString("reservation_status")
                });
            }
        }

    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error loading client reservations: "
                + e.getMessage()
        );
    }
} 

    public java.util.Map<String, Object> getClientReservationDetails(
        int reservationId, int clientId) {

    String sql = "SELECT guest_name, check_in, check_out, "
            + "total_amount, reservation_status "
            + "FROM reservations "
            + "WHERE reservation_id = ? AND client_id = ? "
            + "AND is_archived = FALSE";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, reservationId);
        stmt.setInt(2, clientId);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                java.util.Map<String, Object> details =
                        new java.util.HashMap<>();

                details.put("guestName", rs.getString("guest_name"));
                details.put("checkIn", rs.getTimestamp("check_in"));
                details.put("checkOut", rs.getTimestamp("check_out"));
                details.put("totalAmount", rs.getBigDecimal("total_amount"));
                details.put("status", rs.getString("reservation_status"));

                return details;
            }
        }

    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error loading reservation details: " + e.getMessage()
        );
    }

    return null;
}
    
    
public boolean cancelClientReservation(
        int reservationId, int clientId) {

    String sql = "UPDATE reservations "
            + "SET reservation_status = 'Cancelled' "
            + "WHERE reservation_id = ? "
            + "AND client_id = ? "
            + "AND is_archived = FALSE "
            + "AND reservation_status = 'Pending' "
            + "AND check_in > NOW()";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, reservationId);
        stmt.setInt(2, clientId);

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Cancellation error: " + e.getMessage()
        );
        return false;
    }
}

public boolean addClientReservation(
        int clientId,
        String guestName,
        String contactNumber,
        int unitId,
        java.time.LocalDateTime checkIn,
        java.time.LocalDateTime checkOut,
        int numberOfGuests) {

    if (clientId <= 0 || unitId <= 0
            || guestName == null || guestName.trim().isEmpty()
            || contactNumber == null || contactNumber.trim().isEmpty()
            || checkIn == null || checkOut == null
            || !checkOut.isAfter(checkIn)
            || numberOfGuests < 1
            || !checkIn.isAfter(java.time.LocalDateTime.now())) {
        return false;
    }

    String lockUnit = "SELECT capacity, price_per_night "
            + "FROM units WHERE unit_id = ? "
            + "AND status = 'Active' AND is_archived = FALSE "
            + "FOR UPDATE";

    String checkOverlap = "SELECT COUNT(*) FROM reservations "
            + "WHERE unit_id = ? AND is_archived = FALSE "
            + "AND reservation_status IN "
            + "('Pending', 'Confirmed', 'Checked In') "
            + "AND check_in < ? AND check_out > ?";

    String insert = "INSERT INTO reservations "
            + "(client_id, guest_name, contact_number, unit_id, "
            + "check_in, check_out, number_of_guests, "
            + "price_per_night, total_amount, required_deposit, "
            + "reservation_status, created_by, is_archived) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            + "'Pending', ?, FALSE)";

    try (Connection conn = DatabaseConnection.getConnection()) {

        conn.setAutoCommit(false);

        try {
            int capacity;
            java.math.BigDecimal nightlyRate;

            try (PreparedStatement ps = conn.prepareStatement(lockUnit)) {
                ps.setInt(1, unitId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        conn.rollback();
                        return false;
                    }

                    capacity = rs.getInt("capacity");
                    nightlyRate = rs.getBigDecimal("price_per_night");
                }
            }

            if (numberOfGuests > capacity) {
                conn.rollback();
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(checkOverlap)) {
                ps.setInt(1, unitId);
                ps.setTimestamp(2, java.sql.Timestamp.valueOf(checkOut));
                ps.setTimestamp(3, java.sql.Timestamp.valueOf(checkIn));

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        conn.rollback();
                        return false;
                    }
                }
            }

            long nights = java.time.temporal.ChronoUnit.DAYS.between(
                    checkIn.toLocalDate(), checkOut.toLocalDate());

            if (nights < 1) {
                conn.rollback();
                return false;
            }

            java.math.BigDecimal total = nightlyRate.multiply(
                    java.math.BigDecimal.valueOf(nights));

            java.math.BigDecimal deposit = total.multiply(
                    new java.math.BigDecimal("0.30"))
                    .setScale(2, java.math.RoundingMode.HALF_UP);

            try (PreparedStatement ps = conn.prepareStatement(insert)) {
                ps.setInt(1, clientId);
                ps.setString(2, guestName.trim());
                ps.setString(3, contactNumber.trim());
                ps.setInt(4, unitId);
                ps.setTimestamp(5, java.sql.Timestamp.valueOf(checkIn));
                ps.setTimestamp(6, java.sql.Timestamp.valueOf(checkOut));
                ps.setInt(7, numberOfGuests);
                ps.setBigDecimal(8, nightlyRate);
                ps.setBigDecimal(9, total);
                ps.setBigDecimal(10, deposit);
                ps.setInt(11, clientId);

                if (ps.executeUpdate() != 1) {
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            conn.rollback();
            throw e;
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(
                null, "Booking error: " + e.getMessage());
        return false;
    }
}

}
 
