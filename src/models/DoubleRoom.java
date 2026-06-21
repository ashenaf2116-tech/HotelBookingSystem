package models;

public class DoubleRoom extends Room {
    public DoubleRoom(int roomNumber, String location) {
        super(roomNumber, 90.0, location);

    }

    @Override
    public String getRoomType() {return "Double Room"; }

    @Override
    public void displayInfo() {
        System.out.println("Double Room #" + getRoomNumber()
            + " | Location: " + getLocation()
            + " | Price: $" + getPricePerNight()
            + " | Available: " + isAvailable());
    }
}