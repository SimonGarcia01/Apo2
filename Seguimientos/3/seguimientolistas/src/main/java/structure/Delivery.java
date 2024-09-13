package structure;

import model.Product;

public class Delivery {
    private int totalProducts;
    private NodeProduct first;

    public void add(Product Product){
        NodeProduct temp = new NodeProduct(Product);

        if(first == null){
            first = temp;
        } else {
            NodeProduct current = first;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
            totalProducts++;
        }
    }

    @Override
    public String toString() {
        String message = "";

        NodeProduct current = first;
        int counter = 1;

        while(current != null) {
            message += counter + ". " + current.getProduct().toString() + "\n";
            current = current.getNext();
            counter++;
        }

        return message;
    }

    //When checking for current.getNext() it will not check the last element.
    public NodeProduct search(String name){
        NodeProduct found = null;
        NodeProduct current = first;
        boolean isFound = false;

        while(current != null && !isFound) {
            if(current.getProduct().getName().equals(name)){
                found = current;
                isFound = true;
            }
            current = current.getNext();
        }
        return found;
    }

    public Delivery() {

    }

    public NodeProduct getFirst() {
        return first;
    }

    public void setFirst(NodeProduct first) {
        this.first = first;
    }
}
