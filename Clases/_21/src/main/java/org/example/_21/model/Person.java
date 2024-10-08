package org.example._21.model;

public class Person {

    private String name;
    private String code;

    public Person(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
