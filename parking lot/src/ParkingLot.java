import fare.BaseFareStrategy;
import fare.FareStrategy;
import parking.ParkingSpot;
import parking.Ticket;
import vehicle.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSpot> spots;
    private final Map<String, Ticket> tickets;
    private FareStrategy fareStrategy;

    private ParkingLot() {
        this.fareStrategy = new BaseFareStrategy();
        this.tickets = new ConcurrentHashMap<>();
        this.spots = new CopyOnWriteArrayList<>();
    }

    // Singleton pattern.
    public static synchronized ParkingLot getInstance() {
        if(instance == null) {
            return new ParkingLot();
        }
        return instance;
    }

    // Setter.
    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    // Setter.
    public void addSpot(ParkingSpot spot) {
        this.spots.add(spot);
    }

    // Park a vehicle.
    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : this.spots) {
            if(!spot.isOccupied()) {
                boolean isParked = spot.park(vehicle);
                if(!isParked) {
                    continue;
                }
                Ticket ticket = new Ticket(vehicle, spot);
                tickets.put(ticket.getTicketID(), ticket);
                return ticket;
            }
        }
        return null;
    }

    // Unpark the vehicle and frees up the spot.
    // Returns the total fee or fare.
    public synchronized Optional<Double> unparkVehicle(String ticketID) {
        if(ticketID == null) {
            return Optional.empty();
        }
        Ticket ticket = this.tickets.get(ticketID);
        if(ticket == null) {
            return Optional.empty();
        }
        ticket.setExitTime();
        ticket.getParkingSpot().unpark();
        return Optional.of(this.fareStrategy.calculateFare(ticket));
    }
}
