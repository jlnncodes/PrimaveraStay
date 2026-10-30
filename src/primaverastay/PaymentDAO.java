/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class PaymentDAO {

    public void loadPayments(
            javax.swing.table.DefaultTableModel model) {

        model.setRowCount(0);

        String sql =
                "SELECT p.payment_id, p.reservation_id, "
                + "r.guest_name, r.total_amount, "
                + "r.required_deposit, "
                + "COALESCE(v.amount_paid, 0) AS amount_paid, "
                + "GREATEST(r.total_amount - "
                + "COALESCE(v.amount_paid, 0), 0) AS balance, "
                + "p.payment_method, p.payment_status "
                + "FROM payments p "
                + "JOIN reservations r "
                + "ON p.reservation_id = r.reservation_id "
                + "LEFT JOIN ( "
                + "SELECT reservation_id, SUM(amount) AS amount_paid "
                + "FROM payments "
                + "WHERE payment_status = 'Verified' "
                + "GROUP BY reservation_id "
                + ") v ON r.reservation_id = v.reservation_id "
                + "ORDER BY p.payment_date DESC, p.payment_id DESC";

        try (java.sql.Connection conn =
                     DatabaseConnection.getConnection();
             java.sql.PreparedStatement stmt =
                     conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("payment_id"),
                    rs.getInt("reservation_id"),
                    rs.getString("guest_name"),
                    rs.getBigDecimal("total_amount"),
                    rs.getBigDecimal("required_deposit"),
                    rs.getBigDecimal("amount_paid"),
                    rs.getBigDecimal("balance"),
                    rs.getString("payment_method"),
                    rs.getString("payment_status")
                });
            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Unable to load payments: " + e.getMessage(),
                    "Database Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public boolean savePayment(
        int reservationId,
        java.math.BigDecimal amount,
        String paymentType,
        String paymentMethod,
        String referenceNumber,
        int receivedBy) {

    String sql = "INSERT INTO payments "
            + "(reservation_id, amount, payment_type, "
            + "payment_method, reference_number, "
            + "payment_status, received_by) "
            + "VALUES (?, ?, ?, ?, ?, 'Pending', ?)";

    try (java.sql.Connection conn =
            DatabaseConnection.getConnection();
         java.sql.PreparedStatement stmt =
            conn.prepareStatement(sql)) {

        stmt.setInt(1, reservationId);
        stmt.setBigDecimal(2, amount);
        stmt.setString(3, paymentType);
        stmt.setString(4, paymentMethod);

        if (referenceNumber == null
                || referenceNumber.trim().isEmpty()) {
            stmt.setNull(5, java.sql.Types.VARCHAR);
        } else {
            stmt.setString(5, referenceNumber.trim());
        }

        stmt.setInt(6, receivedBy);

        return stmt.executeUpdate() > 0;

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error saving payment: " + e.getMessage()
        );
        return false;
    }
}
    public boolean verifyPayment(int paymentId) {

    String sql = "UPDATE payments "
            + "SET payment_status = 'Verified', "
            + "verified_at = NOW() "
            + "WHERE payment_id = ? "
            + "AND payment_status = 'Pending'";

    try (java.sql.Connection conn =
            DatabaseConnection.getConnection();
         java.sql.PreparedStatement stmt =
            conn.prepareStatement(sql)) {

        stmt.setInt(1, paymentId);

        return stmt.executeUpdate() > 0;

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error verifying payment: " + e.getMessage()
        );
        return false;
    }
}
    public String getPaymentDetails(int paymentId) {

    String sql =
            "SELECT p.*, r.guest_name, r.total_amount, "
            + "u.full_name AS received_by_name "
            + "FROM payments p "
            + "JOIN reservations r "
            + "ON p.reservation_id = r.reservation_id "
            + "LEFT JOIN users u ON p.received_by = u.user_id "
            + "WHERE p.payment_id = ?";

    try (java.sql.Connection conn =
            DatabaseConnection.getConnection();
         java.sql.PreparedStatement stmt =
            conn.prepareStatement(sql)) {

        stmt.setInt(1, paymentId);

        try (java.sql.ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                return "PAYMENT DETAILS\n\n"
                        + "Payment ID: " + rs.getInt("payment_id")
                        + "\nReservation ID: " + rs.getInt("reservation_id")
                        + "\nGuest Name: " + rs.getString("guest_name")
                        + "\nTotal Reservation: PHP " + rs.getBigDecimal("total_amount")
                        + "\nPayment Amount: PHP " + rs.getBigDecimal("amount")
                        + "\nPayment Type: " + rs.getString("payment_type")
                        + "\nPayment Method: " + rs.getString("payment_method")
                        + "\nReference Number: " + rs.getString("reference_number")
                        + "\nPayment Status: " + rs.getString("payment_status")
                        + "\nPayment Date: " + rs.getTimestamp("payment_date")
                        + "\nVerified At: " + rs.getTimestamp("verified_at")
                        + "\nReceived By: " + rs.getString("received_by_name");
            }
        }

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error loading payment details: " + e.getMessage()
        );
    }

    return null;
}
}
