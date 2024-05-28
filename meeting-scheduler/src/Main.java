import entities.Room;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room(1));
        roomList.add(new Room(2));
        roomList.add(new Room(3));

        MeetingScheduler scheduler = new MeetingScheduler(roomList);

        System.out.println(scheduler.bookMeeting(9, 10, 2));
        System.out.println(scheduler.bookMeeting(9, 10, 5));
        System.out.println(scheduler.bookMeeting(9, 10, 4));
        System.out.println(scheduler.bookMeeting(9, 10, 1));
        System.out.println(scheduler.bookMeeting(11, 12, 2));
        System.out.println(scheduler.bookMeeting(11, 12, 3));
        System.out.println(scheduler.bookMeeting(11, 12, 4));
        System.out.println(scheduler.bookMeeting(10, 12, 1));
    }
}