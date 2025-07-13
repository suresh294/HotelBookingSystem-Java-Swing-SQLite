import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    public static Connection connect() {
        Connection conn;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:hotel.db");
            System.out.println("Connected to SQLite");

            // Auto-create tables
            Statement stmt = conn.createStatement();

            String createReservations = "CREATE TABLE IF NOT EXISTS reservations (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "room_no TEXT)";
            stmt.execute(createReservations);

            String createCheckins = "CREATE TABLE IF NOT EXISTS checkins (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "room_no TEXT," +
                    "status TEXT)";
            stmt.execute(createCheckins);

            String createBills = "CREATE TABLE IF NOT EXISTS bills (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "amount REAL)";
            stmt.execute(createBills);

            return conn;

        } catch (Exception e) {
            System.out.println("SQLite Connection Failed");
            System.err.println(e.getMessage());
            return null;
        }
    }
}
