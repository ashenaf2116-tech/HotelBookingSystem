package services;

import models.Booking;
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE = "bookings.dat";

    public static void saveBooking(Booking booking) {
        List<Booking> all = loadBookings();
        all.add(booking);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(all);
            System.out.println("Booking saved to file.");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static List<Booking> loadBookings() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            return (List<Booking>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
