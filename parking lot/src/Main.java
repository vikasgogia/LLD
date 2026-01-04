import parking.ParkingSpot;
import parking.Ticket;
import vehicle.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();

        // 2 small spots.
        parkingLot.addSpot(new ParkingSpot(VehicleSize.SMALL));
        parkingLot.addSpot(new ParkingSpot(VehicleSize.SMALL));

        // 2 medium spots.
        parkingLot.addSpot(new ParkingSpot(VehicleSize.MEDIUM));
        parkingLot.addSpot(new ParkingSpot(VehicleSize.MEDIUM));

        Map<Vehicle, Ticket> vehicles = new ConcurrentHashMap<>();

        // 1 large spot.
        parkingLot.addSpot(new ParkingSpot(VehicleSize.LARGE));

        // Bikes.
        Vehicle b1 = new Bike("b1", VehicleSize.SMALL);

        // Park b1.
        Ticket t = parkingLot.parkVehicle(b1);

        if(t != null) {
            System.out.println("Vehicle " + b1.getLicensePlate() + " is successfully parked at spot " + t.getParkingSpot().getSpotID());
        } else {
            System.out.println("Vehicle " + b1.getLicensePlate() + " is could not be parked anywhere.");
        }

        Thread.sleep(2000);

        // Unpark b1.
        System.out.println("Vehicle " + b1.getLicensePlate() + " is unparked and cost = " + parkingLot.unparkVehicle(t.getTicketID()));
    }
}
