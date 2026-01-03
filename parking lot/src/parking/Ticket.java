package parking;

import vehicle.Vehicle;

import java.util.Date;

public class Ticket {
    private final String ticketID;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long entryTime;
    private long exitTime;

    // Constructor.
    public Ticket(String ticketID, Vehicle vehicle, ParkingSpot parkingSpot, long entryTime) {
        this.ticketID = ticketID;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = entryTime;
    }

    // Getter.
    public String getTicketID() {
        return ticketID;
    }

    // Getter.
    public long getExitTime() {
        return exitTime;
    }

    // Getter.
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Getter.
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    // Getter.
    public long getEntryTime() {
        return entryTime;
    }

    // Setter.
    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }
}
