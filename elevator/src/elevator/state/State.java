package elevator.state;

import elevator.lift.Elevator;

public interface State {
    void pushButton(int floor, Elevator elevator);
    void handleArrival(int floor, Elevator elevator);
}
