package controller;

import model.Attendee;
import model.Conference;

public class Cop16 {

    private Conference conference;

    public Cop16(String name){
        conference = new Conference(name);
    }

    public boolean registerAttendee(String name, String country){
        return conference.addAttendee(new Attendee(name, country));
    }

    public Attendee searchAttendee(String name){
        return conference.searchAttendee(name);
    }

    public String listAttendee(){
        return conference.attendeesInOrder();
    }
}
