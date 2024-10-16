package model;

public class Attendee implements Comparable<Attendee>{

    private String name;
    private String country;

    private Attendee right;
    private Attendee left;

    @Override
    public int compareTo(Attendee attendee2){
        int comparison = country.compareTo(attendee2.getCountry());

        if(comparison == 0){
            comparison = name.compareTo(attendee2.getName());
        }

        return comparison;
    }

    public Attendee(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Attendee getRight() {
        return right;
    }

    public void setRight(Attendee right) {
        this.right = right;
    }

    public Attendee getLeft() {
        return left;
    }

    public void setLeft(Attendee left) {
        this.left = left;
    }
}
