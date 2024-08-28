package ui;

import controller.CarController;
import model.Car;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        CarController controller = new CarController();

        controller.addCar("AAA005", "E", 2005);
        controller.addCar("AAA003", "C", 2003);
        controller.addCar("AAA004", "D", 2004);
        controller.addCar("AAA002", "B", 2002);
        controller.addCar("AAA001", "A", 2001);

        System.out.println(controller.getCars());
        System.out.println("****************************");

        // ArrayList<Car> sorted = controller.selectionSort(controller.getCars());
        ArrayList<Car> sorted = controller.insertionSort(controller.getCars());
        System.out.println(sorted);
    }

}
