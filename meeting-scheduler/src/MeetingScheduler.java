import entities.Calendar;
import entities.Meeting;
import entities.Room;

import java.util.List;

public class MeetingScheduler {
    private Calendar calendar;
    private List<Room> rooms;

    public MeetingScheduler(List<Room> rooms) {
        this.rooms = rooms;
        this.calendar = new Calendar();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    int bookMeeting(int start, int end, int cap) {
        for(Room room: rooms) {
            Meeting meeting = room.book(start, end, cap);
            if(meeting != null) {
                calendar.addMeeting(meeting);
                return meeting.getRoom().getRoomNo();
            }
        }
        return -1;
    }
}
