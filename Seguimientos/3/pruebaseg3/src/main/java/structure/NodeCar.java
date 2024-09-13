package structure;

import model.Car;

public class NodeCar {

    private Car car;
    private NodeCar next;

    public NodeCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return car.toString();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public NodeCar getNext() {
        return next;
    }

    public void setNext(NodeCar next) {
        this.next = next;
    }
}
