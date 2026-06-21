package models;
import java.io.Serializable;
import java.time.LocalDate;

public class Booking implements Serializable {
    private int bookingId;
    private Customer customer;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalPrice;

    public Booking(int bookingId, Customer customer, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = room.getPricePerNight() * (checkOut.toEpochDay() - checkIn.toEpochDay());
    }

    public int getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public double getTotalPrice() { return totalPrice; }

    public void displayInfo() {
        System.out.println("Booking #" + bookingId + " | " + customer.getName() +
            " | Room " + room.getRoomNumber() + " | Total: $" + totalPrice);
    }
}
