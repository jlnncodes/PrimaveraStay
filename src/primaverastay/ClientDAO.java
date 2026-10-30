
package primaverastay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClientDAO {

    public void loadClients(DefaultTableModel model) {

        model.setRowCount(0);

        String sql = "SELECT user_id, full_name, email, "
                + "contact_number, username, status, created_at "
                + "FROM users "
                + "WHERE role = 'CLIENT' "
                + "ORDER BY user_id DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("user_id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("contact_number"),
                    rs.getString("username"),
                    rs.getString("status"),
                    rs.getTimestamp("created_at")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error loading clients: " + e.getMessage()
            );
        }
    }
    public String getClientBookings(int clientId) {

    String sql = "SELECT reservation_id, guest_name, "
            + "check_in, check_out, total_amount, "
            + "reservation_status "
            + "FROM reservations "
            + "WHERE client_id = ? "
            + "ORDER BY check_in DESC";

    StringBuilder bookings = new StringBuilder();

    try (java.sql.Connection conn =
            DatabaseConnection.getConnection();
         java.sql.PreparedStatement stmt =
            conn.prepareStatement(sql)) {

        stmt.setInt(1, clientId);

        try (java.sql.ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                bookings.append("Reservation ID: ")
                        .append(rs.getInt("reservation_id"))
                        .append("\nGuest: ")
                        .append(rs.getString("guest_name"))
                        .append("\nCheck-In: ")
                        .append(rs.getTimestamp("check_in"))
                        .append("\nCheck-Out: ")
                        .append(rs.getTimestamp("check_out"))
                        .append("\nTotal: PHP ")
                        .append(rs.getBigDecimal("total_amount"))
                        .append("\nStatus: ")
                        .append(rs.getString("reservation_status"))
                        .append("\n--------------------------\n");
            }
        }

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error loading bookings: " + e.getMessage()
        );
        return null;
    }

    if (bookings.length() == 0) {
        return "No bookings found for this client.";
    }

    return bookings.toString();
}
}