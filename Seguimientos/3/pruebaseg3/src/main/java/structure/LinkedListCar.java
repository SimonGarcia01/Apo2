package structure;

import model.Car;

public class LinkedListCar {

    private NodeCar first;

    public void add(Car car){
        NodeCar temp = new NodeCar(car);

        if(first == null){
            first = temp;
        } else {
            NodeCar current = first;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
        }
    }

    @Override
    public String toString() {
        String message = "";

        NodeCar current = first;
        int counter = 1;

        while(current != null) {
            message += counter + ". " + current.getCar().toString() + "\n";
            current = current.getNext();
            counter++;
        }

        return message;
    }

    //When checking for current.getNext() it will not check the last element.
    public NodeCar search(int id){
        NodeCar found = null;
        NodeCar current = first;
        boolean isFound = false;

        while(current != null && !isFound) {
            if(current.getCar().getId() == id){
                found = current;
                isFound = true;
            }
            current = current.getNext();
        }
        return found;
    }

    public LinkedListCar() {
    }

    public NodeCar getFirst() {
        return first;
    }

    public void setFirst(NodeCar first) {
        this.first = first;
    }
}
