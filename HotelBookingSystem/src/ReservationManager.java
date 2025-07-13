import java.sql.*;
import javax.swing.*;

public class ReservationManager {
    public static void bookRoom() {
        String name = JOptionPane.showInputDialog("Enter Name:");
        String room = JOptionPane.showInputDialog("Enter Room No:");
        String sql = "INSERT INTO reservations(name, room_no) VALUES (?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, room);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "✅ Room Booked!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    /**
     * 
     */
    public static void checkIn() {
        String room = JOptionPane.showInputDialog("Enter Room No:");
        String status = "Checked-In";
        String sql = "INSERT INTO checkins(room_no, status) VALUES (?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room);
            stmt.setString(2, status);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Check-In Done");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    public static void viewBookings() {
    StringBuilder bookings = new StringBuilder();
    String sql = "SELECT * FROM reservations";

    try (Connection conn = DBConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            bookings.append("ID: ").append(rs.getInt("id"))
                    .append(", Name: ").append(rs.getString("name"))
                    .append(", Room No: ").append(rs.getString("room_no"))
                    .append("\n");
        }

        if (bookings.length() == 0) {
            bookings.append("No bookings found.");
        }

        JOptionPane.showMessageDialog(null, bookings.toString());

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "❌ Failed to fetch bookings");
    }
}

}
