# 🏨 Hotel Booking System

> A terminal-based Java application built as a final group project for BITS College — demonstrating all 7 core OOP chapters in one integrated system.

---

## 👥 Team

| Name | Role | Contribution |
|------|------|-------------|
| Ashenafi  Teame  | `Main.java`, `Room.java`, project structure |
| Dagam mathewos | Developer | `Customer.java`, `Booking.java` |
| Dagm direba | Developer | `SingleRoom.java`, `DoubleRoom.java`, `SuiteRoom.java` |
| ayoub | Developer | `RoomNotFoundException.java`, `PaymentException.java`, `FileManager.java` |
| abdiyu | Developer | `DatabaseManager.java` |

---

## 📚 OOP Chapters Coverage

| Chapter | Concept | Where Applied |
|---------|---------|--------------|
| Ch 1 | Classes & Objects | `Room`, `Customer`, `Booking` — constructors, fields, methods |
| Ch 2 | Encapsulation | Private fields + getters/setters in all model classes |
| Ch 3 | Inheritance | `SingleRoom`, `DoubleRoom`, `SuiteRoom` extend `Room` |
| Ch 4 | Polymorphism | `displayInfo()` overridden per room type, overloaded `search()` |
| Ch 5 | Abstraction & Interfaces | `Room` is abstract, implements `Serializable` interface |
| Ch 6 | Exception Handling | `RoomNotFoundException`, `PaymentException`, try/catch in `Main` |
| Ch 7 | File I/O, Serialization & JDBC | `FileManager` saves to `.dat`, `DatabaseManager` saves to SQLite |

---

## ✨ Features

- 🔍 Search rooms by **location**
- 💰 Search rooms by **max price**
- 📊 **Compare prices** across all room types
- 📋 **Book a room** with customer details and simulated payment
- 💾 Bookings saved to **file** (`bookings.dat`) and **SQLite database** (`hotels.db`)
- 🏙️ Rooms available in **Addis Ababa**, **Hawassa**, and **Dire Dawa**

---

## 🗂️ Project Structure

```
HotelBookingSystem/
├── src/
│   ├── Main.java                          # App entry point (Team Lead)
│   ├── models/
│   │   ├── Room.java                      # Abstract base class
│   │   ├── SingleRoom.java                # Extends Room ($50/night)
│   │   ├── DoubleRoom.java                # Extends Room ($90/night)
│   │   ├── SuiteRoom.java                 # Extends Room ($200/night)
│   │   ├── Customer.java                  # Customer model
│   │   └── Booking.java                   # Booking model
│   ├── exceptions/
│   │   ├── RoomNotFoundException.java     # Custom exception
│   │   └── PaymentException.java          # Custom exception
│   └── services/
│       ├── FileManager.java               # File I/O & Serialization
│       └── DatabaseManager.java           # JDBC + SQLite
├── lib/
│   └── sqlite-jdbc-3.45.1.0.jar          # SQLite driver
├── out/                                   # Compiled .class files
├── bookings.dat                           # Serialized bookings file
├── hotels.db                              # SQLite database
└── README.md
```

---

## ⚙️ Setup & Run

### Prerequisites
- Java JDK 17 or higher
- SQLite JDBC driver (included in `/lib`)

### Compile

```powershell
javac -cp "lib/sqlite-jdbc-3.45.1.0.jar" -d out src/exceptions/*.java src/models/*.java src/services/*.java src/Main.java
```

### Run

```powershell
java -cp "out;lib/sqlite-jdbc-3.45.1.0.jar" Main
```

> **Linux/Mac:** replace `;` with `:` in the `-cp` argument

---

## 🖥️ App Menu

```
=== Hotel Booking System ===
1. Search Rooms by Location
2. Search Rooms by Max Price
3. Compare Room Prices
4. Book a Room
5. View All Bookings
6. Exit
```

---

## 🧠 Key OOP Concepts Demonstrated

```java
// Inheritance
public class SingleRoom extends Room { ... }

// Polymorphism — method overriding
@Override
public void displayInfo() { ... }

// Polymorphism — method overloading
public static void search(String location) { ... }
public static void search(double maxPrice) { ... }
public static void search(String location, double maxPrice) { ... }

// Abstraction
public abstract class Room implements Serializable { ... }

// Custom Exception Handling
throw new RoomNotFoundException("Room not found!");
throw new PaymentException("Invalid card number!");

// File Serialization
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bookings.dat"));

// JDBC
Connection conn = DriverManager.getConnection("jdbc:sqlite:hotels.db");
```

---

## 📅 Deadline

**June 25, 2026** — BITS College Final Project

---

## 📄 License

This project was created for educational purposes at BITS College, Ethiopia.