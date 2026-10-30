package primaverastay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ClientPaymentDAO {

    public void loadClientPayments(
            int clientId,
            DefaultTableModel model) {

        model.setRowCount(0);

        String sql =
            "SELECT r.reservation_id, r.total_amount, "
          + "COALESCE(SUM(CASE WHEN p.payment_status = 'Verified' "
          + "THEN p.amount ELSE 0 END), 0) AS amount_paid, "
          + "GREATEST(r.total_amount - "
          + "COALESCE(SUM(CASE WHEN p.payment_status = 'Verified' "
          + "THEN p.amount ELSE 0 END), 0), 0) AS balance, "
          + "MAX(CASE WHEN p.payment_status = 'Verified' "
          + "THEN p.payment_method END) AS payment_method "
          + "FROM reservations r "
          + "LEFT JOIN payments p "
          + "ON r.reservation_id = p.reservation_id "
          + "WHERE r.client_id = ? "
          + "GROUP BY r.reservation_id, r.total_amount "
          + "ORDER BY r.reservation_id DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, clientId);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {

                    double total = rs.getDouble("total_amount");
                    double paid = rs.getDouble("amount_paid");
                    double balance = rs.getDouble("balance");

                    String method = rs.getString("payment_method");

                    String status;

                    if (paid >= total) {
                        status = "Paid";
                    } else if (paid > 0) {
                        status = "Partial";
                    } else {
                        status = "Pending";
                    }

                    model.addRow(new Object[]{
                        rs.getInt("reservation_id"),
                        String.format("₱%,.2f", total),
                        String.format("₱%,.2f", paid),
                        String.format("₱%,.2f", balance),
                        method == null ? "N/A" : method,
                        status
                    });
                }
            }

        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error loading client payments: " + e.getMessage()
            );
        }
    }
public boolean submitClientPayment(
        int clientId,
        int reservationId,
        double amount,
        String paymentMethod,
        String referenceNumber) {

    if (clientId <= 0 || reservationId <= 0
            || !Double.isFinite(amount) || amount <= 0
            || paymentMethod == null || paymentMethod.trim().isEmpty()
            || referenceNumber == null || referenceNumber.trim().isEmpty()) {
        return false;
    }

    String checkReservation =
        "SELECT r.reservation_id, r.total_amount, "
      + "COALESCE(SUM(CASE WHEN p.payment_status = 'Verified' "
      + "THEN p.amount ELSE 0 END), 0) AS verified_paid, "
      + "COALESCE(SUM(CASE WHEN p.payment_status = 'Pending' "
      + "THEN p.amount ELSE 0 END), 0) AS pending_paid "
      + "FROM reservations r "
      + "LEFT JOIN payments p ON r.reservation_id = p.reservation_id "
      + "WHERE r.reservation_id = ? AND r.client_id = ? "
      + "AND r.reservation_status IN ('Pending', 'Confirmed') "
      + "AND r.is_archived = 0 "
      + "GROUP BY r.reservation_id, r.total_amount";

    String insertPayment =
        "INSERT INTO payments "
      + "(reservation_id, amount, payment_type, payment_method, "
      + "reference_number, payment_status) "
      + "VALUES (?, ?, 'Deposit', ?, ?, 'Pending')";

    try (Connection conn = DatabaseConnection.getConnection()) {

        conn.setAutoCommit(false);

        try {
            java.math.BigDecimal total;
            java.math.BigDecimal verified;
            java.math.BigDecimal pending;

            // Lock the reservation to serialize payment submissions.
            try (PreparedStatement lock = conn.prepareStatement(
                    "SELECT reservation_id FROM reservations "
                  + "WHERE reservation_id = ? AND client_id = ? FOR UPDATE")) {

                lock.setInt(1, reservationId);
                lock.setInt(2, clientId);

                try (ResultSet rs = lock.executeQuery()) {
                    if (!rs.next()) {
                        conn.rollback();
                        return false;
                    }
                }
            }

            try (PreparedStatement pst =
                    conn.prepareStatement(checkReservation)) {

                pst.setInt(1, reservationId);
                pst.setInt(2, clientId);

                try (ResultSet rs = pst.executeQuery()) {
                    if (!rs.next()) {
                        conn.rollback();
                        return false;
                    }

                    total = rs.getBigDecimal("total_amount");
                    verified = rs.getBigDecimal("verified_paid");
                    pending = rs.getBigDecimal("pending_paid");
                }
            }

            java.math.BigDecimal submitted =
                java.math.BigDecimal.valueOf(amount)
                    .setScale(2, java.math.RoundingMode.HALF_UP);

            if (submitted.compareTo(
                    total.subtract(verified).subtract(pending)) > 0) {
                conn.rollback();
                return false;
            }

            try (PreparedStatement pst =
                    conn.prepareStatement(insertPayment)) {

                pst.setInt(1, reservationId);
                pst.setBigDecimal(2, submitted);
                pst.setString(3, paymentMethod.trim());
                pst.setString(4, referenceNumber.trim());

                if (pst.executeUpdate() != 1) {
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
            null,
            "Payment submission error: " + e.getMessage()
        );
        return false;
    }
}

}

