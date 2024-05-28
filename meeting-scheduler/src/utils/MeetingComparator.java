package utils;

import entities.Meeting;

import java.util.Comparator;

public class MeetingComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if(o1.getStartTime() == o2.getStartTime()) {
            return o1.getEndTime() < o2.getEndTime() ? -1 : 1;
        }
        return o1.getStartTime() < o2.getStartTime() ? -1 : 1;
    }
}
