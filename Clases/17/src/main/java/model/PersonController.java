package model;

import structures.CircularList;

public class PersonController {

    //Generic is replaced by the person type
    private CircularList<Person> people;

    public PersonController(){
        this.people = new CircularList<>();
    }

    public void addPerson(String name, String id){
        Person person = new Person(name, id);
        people.add(person);
    }

    public String printPeople(){
        return people.printList();
    }

    public String alternativePrint(){
        return people.getFirst().printList();
    }
}
