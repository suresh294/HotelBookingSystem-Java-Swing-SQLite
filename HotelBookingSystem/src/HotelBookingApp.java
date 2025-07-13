import javax.swing.*;

public class HotelBookingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hotel Booking System");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton bookBtn = new JButton("Book Room");
        JButton checkInBtn = new JButton("Check-In");
        JButton billBtn = new JButton("Generate Bill");
        JButton viewBookingsBtn = new JButton("View Bookings");
viewBookingsBtn.setBounds(100, 200, 200, 30);
frame.add(viewBookingsBtn);
JButton viewHistoryBtn = new JButton("View Full History");
viewHistoryBtn.setBounds(100, 250, 200, 30);
frame.add(viewHistoryBtn);

viewHistoryBtn.addActionListener(e -> HistoryViewer.showFullHistory());

// Add action listener
viewBookingsBtn.addActionListener(e -> ReservationManager.viewBookings());


        bookBtn.setBounds(100, 50, 200, 30);
        checkInBtn.setBounds(100, 100, 200, 30);
        billBtn.setBounds(100, 150, 200, 30);

        frame.add(bookBtn);
        frame.add(checkInBtn);
        frame.add(billBtn);

        bookBtn.addActionListener(e -> ReservationManager.bookRoom());
        checkInBtn.addActionListener(e -> ReservationManager.checkIn());
        billBtn.addActionListener(e -> BillingManager.generateBill());

        frame.setVisible(true);
    }
}
