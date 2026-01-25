package elevator.state;

import elevator.lift.Direction;
import elevator.lift.Elevator;

public class IdleState implements State {
    @Override
    public void pushButton(int floor, Elevator elevator) {
        // Elevator is idle, and receives a elevator.request to go to floor.

        if (floor > elevator.getCurrentFloor()) {
            // Go up.
            elevator.setDirection(Direction.UP);
        } else if (floor < elevator.getCurrentFloor()) {
            // Go down.
            elevator.setDirection(Direction.DOWN);
        } else {
            // Already on the floor.
            elevator.setCurrentState(new DoorOpenState());
            return;
        }

        elevator.setCurrentState(new MovingState());

        // Simulates physical movement.
        elevator.setCurrentFloor(floor);
    }

    @Override
    public void handleArrival(int floor, Elevator elevator) {
        // No-op: we must already be at a floor.
    }
}
