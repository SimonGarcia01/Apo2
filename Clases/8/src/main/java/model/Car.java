package model;

public class Car implements Comparable<Car>{
    private String licensePlate;
    private String model;
    private int year;

    @Override
    public String toString(){
        return "License Plate: " + licensePlate+ "\n" +
                "Model: " + model + "\n" +
                "Production Year: " + year;
    }

    @Override
    //Method must return a negative, 0 or positive number
    public int compareTo(Car o) {
        //First comparison criteria
        int difference = this.year - o.year;

        //Second comparison criteria
        if (difference == 0) {
            difference = this.licensePlate.compareTo(o.licensePlate);
        }

        return difference;
    }

    public Car(String licensePlate, String model, int year) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
