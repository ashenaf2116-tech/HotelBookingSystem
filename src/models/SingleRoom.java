package models;

public class SingleRoom extends Room {
    public SingleRoom(int roomNumber, String location) {
        super(roomNumber, 50.0, location);
    }
     
    @Override
    public String getRoomType() { return "Single Room"; }

    @Override
    public void displayInfo() {
        System.out.println("Single Room #" + getRoomNumber()
            + " | Location: " + getLocation()
            + " | Price: $" + getPricePerNight()
            + " | Available: " + isAvailable());
    }

}