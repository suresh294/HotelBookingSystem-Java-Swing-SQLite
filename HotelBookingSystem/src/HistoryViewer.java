import java.sql.*;
import javax.swing.*;

public class HistoryViewer {
    public static void showFullHistory() {
        StringBuilder history = new StringBuilder();

        try (Connection conn = DBConnection.connect()) {

            // --- Bookings ---
            history.append("📌 Bookings:\n");
            String sql1 = "SELECT * FROM reservations";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sql1);
            while (rs1.next()) {
                history.append("ID: ").append(rs1.getInt("id"))
                        .append(", Name: ").append(rs1.getString("name"))
                        .append(", Room: ").append(rs1.getString("room_no")).append("\n");
            }

            // --- Check-ins ---
            history.append("\n📌 Check-Ins:\n");
            String sql2 = "SELECT * FROM checkins";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);
            while (rs2.next()) {
                history.append("ID: ").append(rs2.getInt("id"))
                        .append(", Room: ").append(rs2.getString("room_no"))
                        .append(", Status: ").append(rs2.getString("status")).append("\n");
            }

            // --- Bills ---
            history.append("\n📌 Bills:\n");
            String sql3 = "SELECT * FROM bills";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(sql3);
            while (rs3.next()) {
                history.append("ID: ").append(rs3.getInt("id"))
                        .append(", Name: ").append(rs3.getString("name"))
                        .append(", Amount: ₹").append(rs3.getDouble("amount")).append("\n");
            }

        } catch (Exception e) {
            history.append("\n❌ Failed to load full history: ").append(e.getMessage()).append("\n");
        }

        // Show in scrollable text area
        JTextArea textArea = new JTextArea(history.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "📜 Booking History", JOptionPane.INFORMATION_MESSAGE);
    }
}
