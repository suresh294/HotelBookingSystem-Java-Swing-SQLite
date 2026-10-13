# Hotel Booking System — Java Swing + SQLite

A desktop learning project built with Java Swing and SQLite. The GUI supports room booking, check-in recording, billing entries, a booking list, and a combined history viewer.

## Features

- Book a room by recording a guest name and room number.
- Record check-in events.
- Save billing entries.
- View reservations and combined booking/check-in/billing history.
- Create the SQLite tables automatically when the application connects.

## Technology Stack

- Java (compatible with Java 8 or newer)
- Java Swing
- SQLite
- SQLite JDBC via Maven

## Run Locally

Prerequisites: JDK and Maven installed.

From the repository root:

```bash
cd HotelBookingSystem
mvn clean compile exec:java
```

The application creates or opens `hotel.db` in the `HotelBookingSystem` directory. Keep that file if you want to preserve local sample data; delete it only if you intentionally want to reset the database.

## Project Structure

- `src/HotelBookingApp.java` — Swing application entry point
- `src/DBConnection.java` — SQLite connection and table initialization
- `src/ReservationManager.java` — booking, check-in, and reservation history actions
- `src/BillingManager.java` — billing entry creation
- `src/HistoryViewer.java` — combined history display
- `pom.xml` — Maven build and SQLite JDBC dependency
- `hotel.db` — local SQLite database file

## Scope and Limitations

This is a basic desktop prototype, not a complete hotel reservation platform. It does not currently implement room availability checks, overlapping-booking prevention, customer authentication, rate plans, or integrated billing calculations. Billing amounts are entered manually.

## Repository

[View the source on GitHub](https://github.com/suresh294/HotelBookingSystem-Java-Swing-SQLite)
