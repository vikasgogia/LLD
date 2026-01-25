package elevator;

import elevator.lift.Direction;
import elevator.lift.Elevator;
import elevator.request.Request;

import java.util.Collections;
import java.util.PriorityQueue;

public class ElevatorController {
    private Elevator elevator;
    private PriorityQueue<Integer> upMinQueue;
    private PriorityQueue<Integer> downMaxQueue;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
        this.upMinQueue = new PriorityQueue<>();
        this.downMaxQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addRequest(Request request) {
        int targetFloor = request.getTargetFloor();
        int currentFloor = elevator.getCurrentFloor();

        if(currentFloor < targetFloor) {
            downMaxQueue.offer(targetFloor);
        } else if (currentFloor > targetFloor) {
            upMinQueue.offer(targetFloor);
        } else {
            // Tell elevator to open doors.
            elevator.reach(targetFloor);
        }

        // Start processing requests if elevator.lift is not moving.
        if (elevator.getDirection() == Direction.IDLE) {
            controlElevator();
        }
    }

    private void controlElevator() {
        while (!upMinQueue.isEmpty() || !downMaxQueue.isEmpty()) {
            if (elevator.getDirection() == Direction.UP || elevator.getDirection() == Direction.IDLE) {
                processRequests(upMinQueue, Direction.UP);
                processRequests(downMaxQueue, Direction.DOWN);
            } else {
                processRequests(downMaxQueue, Direction.DOWN);
                processRequests(upMinQueue, Direction.UP);
            }
        }
        elevator.setDirection(Direction.IDLE);
    }

    private void processRequests(PriorityQueue<Integer> queue, Direction dir) {
        elevator.setDirection(dir);
        while (!queue.isEmpty()) {
            int nextFloor = queue.poll();
            // Move to next floor and perform handleArrival()
            elevator.setCurrentFloor(nextFloor);
            elevator.reach(nextFloor);
        }
    }
}
