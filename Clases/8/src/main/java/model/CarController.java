package model;

import java.util.ArrayList;

public class CarController {

    private ArrayList<Car> cars;

    public void addCar(String licensePlate, String model, int year){
        cars.add(new Car(licensePlate, model, year));
    }

    public CarController() {
        this.cars = new ArrayList<Car>();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
