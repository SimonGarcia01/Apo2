package model;

public class SimpleLinkedList {

    private Node first;

    public void add(String id, String value){
        Node node = new Node(id, value);

        //Base case -> Empty List
        if(first == null){
            first = node;
        }
        //Base case -> Not empty list
        else {
            if(first.getNext() == null){
                first.setNext(node);
            }
            //Iterative case
            else {
                Node current = first.getNext();
                while(current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
            }
        }

    }

    public Node search(String value){
        Node found = null;

        //Base case
        if(first.getValue().equals(value)){
            found = first;
        }
        //Iterative case
        else {
            Node current = first;
            boolean isFound = false;
            while(current.getNext() != null && !isFound){
                if(current.getValue().equals(value)){
                    found = current;
                    isFound = true;
                }
                current = current.getNext();
            }
        }


        return found;
    }

}
