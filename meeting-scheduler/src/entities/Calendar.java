package entities;

import utils.MeetingComparator;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private List<Meeting> allMeetings;

    public Calendar() {
        this.allMeetings = new ArrayList<>();
    }

    public List<Meeting> getAllMeetings() {
        allMeetings.sort(new MeetingComparator());
        return allMeetings;
    }

    public void addMeeting(Meeting meeting) {
        this.allMeetings.add(meeting);
    }
}
