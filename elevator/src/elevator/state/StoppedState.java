package elevator.state;

import elevator.lift.Elevator;

public class StoppedState implements State {
    @Override
    public void pushButton(int floor, Elevator elevator) {
    }

    @Override
    public void handleArrival(int floor, Elevator elevator) {
        elevator.setCurrentState(new DoorOpenState());
    }
}
