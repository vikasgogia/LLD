package elevator.state;

import elevator.lift.Elevator;

public class DoorOpenState implements State {
    @Override
    public void pushButton(int floor, Elevator elevator) {

    }

    @Override
    public void handleArrival(int floor, Elevator elevator) {
        // No-op: we are already at the floor with doors open.
    }
}
