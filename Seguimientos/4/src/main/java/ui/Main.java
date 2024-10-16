package ui;

import controller.Cop16;
import model.Conference;

public class Main {
    public static void main(String[] args) {
        Cop16 conference = new Cop16("Conference1");

        System.out.println(conference.registerAttendee("Attendee2", "Albania"));
        System.out.println(conference.registerAttendee("Attendee2", "Albania"));
        System.out.println(conference.registerAttendee("Attendee1", "Colombia"));
        System.out.println(conference.registerAttendee("Attendee3", "Usa"));
        System.out.println(conference.registerAttendee("Attendee4", "Usa"));
        System.out.println(conference.registerAttendee("Attendee5", "Denmark"));

        System.out.println(conference.searchAttendee("Attendee5"));

        System.out.println(conference.listAttendee());
    }
}
