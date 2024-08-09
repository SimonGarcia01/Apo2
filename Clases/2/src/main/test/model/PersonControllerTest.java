package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonControllerTest {
    private PersonController controller;

    private void setups1(){
        this.controller = new PersonController();
    }

    private void setup2(){
        this.controller = new PersonController();
        controller.addPerson("Name0", 10, "A0", 60);
    }

    @Test
    public void testAddPerson(){
        //init
        setups1(); //Arraylist is empty

        //act
        controller.addPerson("NameA", 10, "A0", 60.7);

        //Assert
        assertFalse(controller.getPeople().isEmpty());
    }

    @Test
    public void testAddPerson2(){
        //init
        setups1();

        //act
        String name = "NameA";
        int age = 10;
        String cc = "A0";
        double weight = 60.7;

        controller.addPerson(name, age, cc, weight);

        //assert
        assertEquals(name, controller.getPeople().get(0).getName());
        assertEquals(age, controller.getPeople().get(0).getAge());
        assertEquals(cc, controller.getPeople().get(0).getCc());
        assertEquals(weight, controller.getPeople().get(0).getWeight(), 0.3);

    }
}
