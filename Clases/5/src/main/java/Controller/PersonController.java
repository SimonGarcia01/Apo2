package Controller;

import java.util.ArrayList;

import exceptions.PersonNegativeAgeException;
import exceptions.PersonNegativeAgeRunTimeException;
import model.Person;

public class PersonController {

    private ArrayList<Person> people;

    public PersonController() {
        this.people = new ArrayList<Person>(5);
    }

    public void addPerson(String name, String id, int age) throws PersonNegativeAgeException{
        Person p = new Person(name,id,age);
        if(age < 0){
            throw new PersonNegativeAgeException("The age can't be negative");
        }
        people.add(p);
    }

    public void addPerson2(String name, String id, int age) {
        Person p = new Person(name, id, age);

        if(age < 0) {
            throw new PersonNegativeAgeRunTimeException("RunTime: Age can't be negative");
        }
        people.add(p);
    }

}
