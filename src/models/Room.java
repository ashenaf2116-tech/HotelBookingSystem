package models;
import java.io.Serializable;

public abstract class Room implemets Serializable{
    private int roomNumber;
    private double pricePerNight;
    private boolean isAvailable;
    private String location;
    

    public Room(int roomNumber,double pricePerNight, String location)
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true
        this.location = location;
    
  } 
  public int getRoomNumber(){return roomNumber;}
  public double getPricePerNight(){return pricePerNight;}
  public boolean isAvailable(){return isAvailable;}
  public String getLocation(){return location}
  public void setAvailable(boolean available) {isAvailable = available;}
  public void setPricePerNight(double price) {this.pricePerNight = price;}
  
  public abstract String getRoomType();
  public abstract void displayInfo();

  public static void search(String location) {
    system.out.println("searching by location:" + location);
  }
  public static void search (double maxPrice) {
    System.out.println("searching by max price:$" + maxPrice);
  }
  public static void search(String location, double maxPrice);{
    system.out.println("searching: + location + under $" + maxPrice);
  }
