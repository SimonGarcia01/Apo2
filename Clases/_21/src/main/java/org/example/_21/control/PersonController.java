package org.example._21.control;

import org.example._21.exceptions.PersonAlreadyCreatedException;
import org.example._21.model.Person;

import java.util.ArrayList;

public class PersonController {

    private ArrayList<Person> people;

    public PersonController(){
        people = new ArrayList<>();
    }

    public void addPerson(String name, String code) throws PersonAlreadyCreatedException {
        Person person = new Person(name, code);
        people.add(person);
        if(name.equalsIgnoreCase("exit")){
            throw new PersonAlreadyCreatedException("Persona ya creada.");
        }
    }

    public String printPeople(){
        String message = "";
        for(Person person : people){
            message += person + "\n";
        }
        return message;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }
}
