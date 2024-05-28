package entities;

import utils.MeetingComparator;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNo;
    private List<Meeting> meetings;

    public Room(int roomNo) {
        this.roomNo = roomNo;
        this.meetings = new ArrayList<>();
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public Meeting book(int start, int end, int cap) {
        meetings.sort(new MeetingComparator());
        for(Meeting meeting: meetings) {
            if(meeting.getStartTime() < end && meeting.getEndTime() > start) {
                return null;
            }
        }
        Meeting meeting = new Meeting(start, end, cap, this);
        meetings.add(meeting);
        return meeting;
    }
}
