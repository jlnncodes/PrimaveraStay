package primaverastay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // LOGIN
    public User login(String username, String password) {

        String sql = "SELECT * FROM users "
                   + "WHERE username = ? AND password = ? AND status = 'Active'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setContactNumber(rs.getString("contact_number"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }   
        // REGISTER CLIENT
public boolean registerClient(String fullName, String email,
        String contactNumber, String username, String password) {

    String sql = "INSERT INTO users "
            + "(full_name, email, contact_number, username, password, role, status) "
            + "VALUES (?, ?, ?, ?, ?, 'CLIENT', 'Active')";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, fullName);
        stmt.setString(2, email);
        stmt.setString(3, contactNumber);
        stmt.setString(4, username);
        stmt.setString(5, password);

        int rowsInserted = stmt.executeUpdate();

        return rowsInserted > 0;

    } catch (SQLException e) {
        System.out.println("Registration error: " + e.getMessage());
        return false;
    }
    }
    
    // CHECK IF USERNAME ALREADY EXISTS
public boolean usernameExists(String username) {

    String sql = "SELECT user_id FROM users WHERE username = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);

        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}


// CHECK IF EMAIL ALREADY EXISTS
public boolean emailExists(String email) {

    String sql = "SELECT user_id FROM users WHERE email = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);

        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next();
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}


// REGISTER A NEW CLIENT
public boolean registerClient(User user) {

    String sql = "INSERT INTO users "
            + "(full_name, email, contact_number, username, password, role, status) "
            + "VALUES (?, ?, ?, ?, ?, 'CLIENT', 'Active')";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, user.getFullName());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getContactNumber());
        stmt.setString(4, user.getUsername());
        stmt.setString(5, user.getPassword());

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}

// LOGIN FOR CLIENTS ONLY
public User loginClient(String email, String password) {

    String sql = "SELECT * FROM users "
            + "WHERE email = ? AND password = ? "
            + "AND role = 'CLIENT' AND status = 'Active'";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);
        stmt.setString(2, password);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setContactNumber(rs.getString("contact_number"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));

                return user;
            }
        }

    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Client login error: " + e.getMessage()
        );
    }

    return null;
}

// UPDATE CLIENT PROFILE
public boolean updateClientProfile(User user) {

    String sql = "UPDATE users SET "
            + "full_name = ?, "
            + "username = ?, "
            + "email = ?, "
            + "contact_number = ? "
            + "WHERE user_id = ? "
            + "AND role = 'CLIENT' AND status = 'Active'";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, user.getFullName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getContactNumber());
        stmt.setInt(5, user.getUserId());

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Profile update error: " + e.getMessage());
        return false;
    }
}

// CHANGE CLIENT PASSWORD
public boolean changeClientPassword(
        int userId,
        String currentPassword,
        String newPassword) {

    String sql = "UPDATE users SET password = ? "
            + "WHERE user_id = ? "
            + "AND password = ? "
            + "AND role = 'CLIENT' "
            + "AND status = 'Active'";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, newPassword);
        stmt.setInt(2, userId);
        stmt.setString(3, currentPassword);

        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        System.out.println("Change password error: " + e.getMessage());
        return false;
    }
}

// GET CLIENT INFORMATION BY ID
public User getClientById(int clientId) {

    String sql = "SELECT user_id, full_name, email, "
            + "contact_number, username, role, status "
            + "FROM users "
            + "WHERE user_id = ? "
            + "AND role = 'CLIENT' "
            + "AND status = 'Active'";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, clientId);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setContactNumber(rs.getString("contact_number"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));

                return user;
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

    
}