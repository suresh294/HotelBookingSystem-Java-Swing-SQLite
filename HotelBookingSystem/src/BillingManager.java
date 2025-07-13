
import java.sql.*;
import javax.swing.*;

public class BillingManager {
    public static void generateBill() {
        String name = JOptionPane.showInputDialog("Enter Customer Name:");
        String amount = JOptionPane.showInputDialog("Enter Amount:");
        String sql = "INSERT INTO bills(name, amount) VALUES (?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, Double.parseDouble(amount));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bill Generated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
