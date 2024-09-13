package model;

public class Car {

    private int id;
    private String model;

    public Car(int id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("id: %d, model: %s", id, model);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
