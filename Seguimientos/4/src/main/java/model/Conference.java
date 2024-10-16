package model;

import java.util.Arrays;

public class Conference {
    private String name;
    private Attendee root;

    public Conference(String name) {
        this.name = name;
        this.root = null;
    }

    public boolean addAttendee(Attendee newAttendee){
        boolean added = false;

        if(searchAttendee(newAttendee.getName()) == null){
            if(root == null){
                root = newAttendee;
                added = true;
            } else {
                added = addAttendee(root, newAttendee);
            }
        } else {
            //Already exists so it won't be added
        }

        return added;
    }

    private boolean addAttendee(Attendee current, Attendee newAttendee){
        boolean added = false;

        if(newAttendee.getName().compareTo(current.getName()) < 0){
            if(current.getLeft() == null){
                current.setLeft(newAttendee);
                added = true;
            } else {
                added = addAttendee(current.getLeft(), newAttendee);
            }
        } else if(newAttendee.getName().compareTo(current.getName()) > 0){
            if(current.getRight() == null){
                current.setRight(newAttendee);
                added = true;
            } else {
                added = addAttendee(current.getRight(), newAttendee);
            }
        } else {
            //If two nodes are the same, it won't be added and return false
        }

        return added;
    }

    public String attendeesInOrder() {
        String message = "";

        if (root == null) {
            message = "The conference is empty.";
        } else {

            message = attendeesInOrder(root, message);

            String[] attendees = message.split(",");

            Arrays.sort(attendees);

            message = String.join("\n", attendees);
        }

        return message;
    }

    private String attendeesInOrder(Attendee current, String message) {

        if (current != null) {
            message = attendeesInOrder(current.getLeft(), message);  //Paste everything to the left
            message += current.getCountry() + " " + current.getName() + ",";  // Add the middle one
            message = attendeesInOrder(current.getRight(), message);  //Paste everything to the right
        }

        return message;
    }

    public Attendee searchAttendee(String name){
        return searchAttendee(root, name);
    }

    private Attendee searchAttendee(Attendee current, String name){
        Attendee found = null;

        if(current != null){
            if(current.getName().compareTo(name) == 0){
                found = current;
            } else if(name.compareTo(current.getName()) < 0){
                found = searchAttendee(current.getLeft(), name);
            } else {
                found = searchAttendee(current.getRight(), name);
            }
        }

        return found;
    }
}
