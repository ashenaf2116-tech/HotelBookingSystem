import models.*;
import exceptions.*;
import services.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static List<Room> rooms = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int bookingIdCounter = 1;

    public static void main(String[] args) {
        setupRooms();
        while (true) {
            System.out.println("\n=== Hotel Booking System ===");
            System.out.println("1. Search Rooms by Location");
            System.out.println("2. Search Rooms by Max Price");
            System.out.println("3. Compare Room Prices");
            System.out.println("4. Book a Room");
            System.out.println("5. View All Bookings");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> searchByLocation();
                    case 2 -> searchByPrice();
                    case 3 -> comparePrices();
                    case 4 -> bookRoom();
                    case 5 -> viewBookings();
                    case 6 -> { System.out.println("Goodbye!"); return; }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (RoomNotFoundException | PaymentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void setupRooms() {
        rooms.add(new SingleRoom(101, "Addis Ababa"));
        rooms.add(new DoubleRoom(102, "Addis Ababa"));
        rooms.add(new SuiteRoom(103, "Addis Ababa"));
        rooms.add(new SingleRoom(201, "Hawassa"));
        rooms.add(new DoubleRoom(202, "Hawassa"));
        rooms.add(new SuiteRoom(203, "Dire Dawa"));
    }

    static void searchByLocation() {
        System.out.print("Enter location: ");
        String loc = scanner.nextLine();
        Room.search(loc);
        rooms.stream()
            .filter(r -> r.getLocation().equalsIgnoreCase(loc) && r.isAvailable())
            .forEach(Room::displayInfo);
    }

    static void searchByPrice() {
        System.out.print("Enter max price: ");
        double max = scanner.nextDouble();
        Room.search(max);
        rooms.stream()
            .filter(r -> r.getPricePerNight() <= max && r.isAvailable())
            .forEach(Room::displayInfo);
    }

    static void comparePrices() {
        System.out.println("--- Price Comparison ---");
        rooms.stream()
            .sorted(Comparator.comparingDouble(Room::getPricePerNight))
            .forEach(Room::displayInfo);
    }

    static void bookRoom() throws RoomNotFoundException, PaymentException {
        System.out.print("Your name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Room number: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine();

        Room selected = rooms.stream()
            .filter(r -> r.getRoomNumber() == roomNum)
            .findFirst()
            .orElseThrow(() -> new RoomNotFoundException("Room " + roomNum + " not found!"));

        if (!selected.isAvailable())
            throw new RoomNotFoundException("Room " + roomNum + " is not available!");

        System.out.print("Card number (16 digits): ");
        String card = scanner.nextLine();
        if (card.length() != 16)
            throw new PaymentException("Invalid card number!");

        Customer customer = new Customer(bookingIdCounter, name, email, phone);
        Booking booking = new Booking(bookingIdCounter++, customer, selected,
            LocalDate.now(), LocalDate.now().plusDays(1));
        selected.setAvailable(false);
        bookings.add(booking);

        FileManager.saveBooking(booking);
        DatabaseManager.saveBooking(booking);

        System.out.println("Booking confirmed!");
        booking.displayInfo();
    }

    static void viewBookings() {
        if (bookings.isEmpty()) { System.out.println("No bookings yet."); return; }
        bookings.forEach(Booking::displayInfo);
    }
}