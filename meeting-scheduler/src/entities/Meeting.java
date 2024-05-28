package entities;

public class Meeting {
    private int startTime, endTime;
    private int capacity;
    private Room room;

    public Meeting(int startTime, int endTime, int capacity, Room room) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.room = room;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
