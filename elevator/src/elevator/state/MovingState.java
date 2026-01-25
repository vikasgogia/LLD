package elevator.state;

import elevator.lift.Elevator;

public class MovingState implements State {
    @Override
    public void pushButton(int floor, Elevator elevator) {
        // No-op: we are already moving!
    }

    @Override
    public void handleArrival(int floor, Elevator elevator) {
        elevator.setCurrentFloor(floor);

        elevator.setCurrentState(new StoppedState());
        elevator.reach(floor);
    }
}
