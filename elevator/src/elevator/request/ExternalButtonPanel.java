package elevator.request;

import elevator.ElevatorController;
import elevator.lift.Direction;

public class ExternalButtonPanel {
    private int floorLevel;
    private ElevatorController controller;

    public ExternalButtonPanel(int floorLevel, ElevatorController controller) {
        this.floorLevel = floorLevel;
        this.controller = controller;
    }

    public void pressUp() {
        controller.addRequest(new Request(floorLevel, Direction.UP));
    }

    public void pressDown() {
        controller.addRequest(new Request(floorLevel, Direction.DOWN));
    }
}
