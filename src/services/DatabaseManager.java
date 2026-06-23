package services;

import models.Booking;
import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:hotels.db";

    public static void saveBooking(Booking booking) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);

            String create = "CREATE TABLE IF NOT EXISTS bookings (" +
                "id INTEGER PRIMARY KEY," +
                "customer TEXT," +
                "room INTEGER," +
                "total REAL)";
            conn.createStatement().execute(create);

            String insert = "INSERT INTO bookings VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, booking.getBookingId());
            ps.setString(2, booking.getCustomer().getName());
            ps.setInt(3, booking.getRoom().getRoomNumber());
            ps.setDouble(4, booking.getTotalPrice());
            ps.executeUpdate();

            System.out.println("Booking saved to database.");
            conn.close();
        } catch (Exception e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }

    public static void loadBookings() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(URL);

            String query = "SELECT * FROM bookings";
            ResultSet rs = conn.createStatement().executeQuery(query);

            System.out.println("--- Bookings from Database ---");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("Booking #" + rs.getInt("id") +
                    " | Customer: " + rs.getString("customer") +
                    " | Room: " + rs.getInt("room") +
                    " | Total: $" + rs.getDouble("total"));
            }
            if (!found) System.out.println("No bookings found in database.");
            conn.close();
        } catch (Exception e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }
}