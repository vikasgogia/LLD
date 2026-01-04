package fare;

import parking.Ticket;

public interface FareStrategy {
    double calculateFare(Ticket ticket);
}
