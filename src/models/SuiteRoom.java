package models;

public class SuiteRoom extends Room {
    public SuiteRoom(int roomNumber, String location) {
        super(roomNumber, 200.0, location);
    }

    @Override
    public String getRoomType() { return "Suite Room";}

    @Override
    public void displayInfo() {
        System.out.println("Suite Room #" + getRoomNumber()
            + " | Location: " + getLocation()
            + " | Price: $" + getPricePerNight()
            + " | Available: " + isAvailable());
    }
}