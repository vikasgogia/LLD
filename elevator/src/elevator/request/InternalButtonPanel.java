package elevator.request;

import elevator.ElevatorController;
import elevator.lift.Direction;

public class InternalButtonPanel {
    private ElevatorController controller;

    public InternalButtonPanel(ElevatorController controller) {
        this.controller = controller;
    }

    public void pressFloor(int floor) {
        controller.addRequest(new Request(floor, Direction.IDLE)); // Dummy direction for now.
    }
}
