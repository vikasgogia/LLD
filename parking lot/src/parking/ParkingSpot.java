package parking;

import vehicle.Vehicle;
import vehicle.VehicleSize;

import java.util.UUID;

public class ParkingSpot {
    protected final String spotID;
    protected Vehicle vehicle;
    protected final VehicleSize spotSize;

    // Constructor.
    public ParkingSpot(VehicleSize spotSize) {
        this.spotID = UUID.randomUUID().toString();
        this.spotSize = spotSize;
        this.vehicle = null;
    }

    // Getter.
    public String getSpotID() {
        return spotID;
    }

    // Getter.
    public Vehicle getVehicle() {
        return vehicle;
    }

    // Getter.
    public VehicleSize getSpotSize() {
        return spotSize;
    }

    // Checks if the spot is occupied.
    public boolean isOccupied() {
        return (this.vehicle != null);
    }

    // Parks a vehicle if it fits into the spot.
    public synchronized boolean park(Vehicle vehicle) {
        // TODO(Fix this fit logic)
        if(vehicle.getSize() != this.getSpotSize()) {
            return false;
        }
        this.vehicle = vehicle;
        return true;
    }

    // Clears the parking spot.
    public synchronized void unpark() {
        this.vehicle = null;
    }
}
