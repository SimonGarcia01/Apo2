package model;

import structures.CircularList;

public class Person {

    private String name;
    private String id;

    private CircularList<Pet> pets;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
        this.pets = new CircularList<>();
    }

    public void addPet(String name){
        Pet pet = new Pet(name);
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
