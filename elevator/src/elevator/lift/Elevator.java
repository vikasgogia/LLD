package elevator.lift;

import elevator.state.IdleState;
import elevator.state.State;

public class Elevator {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private State currentState;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.currentState = new IdleState();
    }

    // Delegate the button press to the current elevator.state.
    public void pressButton(int floor) {
        currentState.pushButton(floor, this);
    }

    // When the elevator.lift reaches a particular floor.
    public void reach(int floor) {
        currentState.handleArrival(floor, this);
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
