import models.*;
import exceptions.*;
import services.*;
import java.time.LocalDate;
import java.util.*;

public class Main{
    static Scanner scanner = new Scanner(System.in);
    static List<Room> rooms = new ArrayList<>();
    static List<Booking> booking = new ArrayList<>()
    static int bookingcounter = 1;


    public static void main(String[] args) {
        setupRooms();
        while (true){
            System.out.println("\n === HOTEL BOOKING SYTEM====");
            System.out.println("1.Search Rooms");
            System.out.println("2.Compare prices");
            System.out.println("3.Book a Room");
            System.out.println("4.View My Bookings");
            System.out.println("5.Exit");
            System.out.println("Choose");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> searchRooms();
                case 2 -> comparePrices();
                case 3 -> bookRoom();
                case 4 -> viewBooking();
                case 5 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);

                }
                default ->System.out.println("invalid choice.");

            }
        }
    }
 static void stupRooms(){
    rooms.add(new SingleRoom(101,"Addis Ababa "));
    rooms.add(new SingleRoom(101,"Hawassa "));
    rooms.add(new DoubleRoom(201,"Addis Ababa"));
    rooms.add(new DoubleRoom(202,"Bahir Dar"));
    rooms.add(new SuiteRoom(301,"Addis Ababa"));
    rooms.add(new SuiteRoom(302,"Hawassa"));
    
 }

 static void searchRooms() {
    System.out.print("Enter location(Addis Ababa / Hawassa/ Bahir Dar): ");
    String location = scanner.nextLine();
    Room.search(location);
    boolean found = false;
    for (Room r : rooms){
        if (r.getLocation().equalsIgnoreCase(location) && r.isAvailable()) {
                r.displayInfo();
                found = true;
       }
    }
    if (!found) System.out.println("no available rooms in" + location);

 }

 static void comparePrices() {
    System.out.println("\n--- price Comparison---");
    for (Room r :rooms) {
        if (r.isAvailable()) r.displayInfo();

    }
 }
 static void bookRoom() {
    try {
        System.out.print("your name :");
        String name = scanner.nextLine();
        System.out.print("Email:")
        String email = scanner.nextLine();
        System.out.print("phone:");
        String phone = scanner.nextLine();
        System.out.print("Room number:");
        int roomNum = scanner.nextInt();
        scanner.nextLine();

        Room selected = null;
        for (Room r : rooms){
            if(r.getRoomNumber() == roomNum) {
                selcted = r;
                break;

            }
        }
        if (selected == null) throw new RoomNotFoundException("Room " + roomNum + " not found!");
        if (!selected.isAvailable()) throw new RoomNotFoundException("Room " + roomNum + " not available!");

        System.out.print("Card number(16 digist):");
        String card = scanner.nextLine();
        if (card.length () !=16) throw new PaymentException("invalid card number ! ");

        Customer customer = new Customer (bookingCounter , name , email, phone );
        Booking booking = new Booking(bookingCounter++, customer, selected,
            LocalDate.now(), LocalDate.now().plusDays(1));
        
            
        selected.setAvailable(false);
        booking.add(booking);
        FileManager.savebooking(booking);
        DatabaseManager.saveBooking(booking);
        
        
        System.out.println("booking confrimed!");
        booking.displayInfo();
    
    } catch(RoomNotFoundException | PaymentException e){
        System.out.println("Error: " + e.getMessage());

    }
 }

 static void viewBookings(){
    if (bookings.isEmpty()){
        System.out.println("no booking yet");
        return;

    }
    for(Booking b : bookings) b.displayInfo();

 }
}



