package controller;

import model.Car;

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

    public ArrayList<Car> selectionSort(ArrayList<Car> toSort){
        int n = toSort.size();
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(toSort.get(i).compareTo(toSort.get(j)) > 0){
                    Car prev = toSort.get(i);
                    Car current = toSort.get(j);

                    //Set receives on position and an element
                    //It will change the element in that position with the given element
                    toSort.set(i, current);
                    toSort.set(j, prev);
                }
            }
        }

        return toSort;
    }

    public ArrayList<Car> insertionSort(ArrayList<Car> toSort){
        int n = toSort.size();
        for(int i = 1; i < n; i++){
            Car current = toSort.get(i);
            int j = i - 1;
            while(j >= 0 && current.compareTo(toSort.get(j)) < 0){
                toSort.set(j + 1, toSort.get(j));
                j--;
            }
            toSort.set(j + 1, current);
        }

        return toSort;
    }
}
