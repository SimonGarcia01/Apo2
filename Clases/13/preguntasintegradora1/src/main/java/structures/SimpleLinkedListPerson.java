package structures;

import model.Person;

public class SimpleLinkedListPerson {

    public static int MAX_SIZE = 10;
    private NodePerson first;
    private int size;

    public void add(String id, Person value){
        NodePerson node = new NodePerson(id, value, 0);

        //if(this.size <= MAX_SIZE){
            //Add node or throw exception
        //}

        //Base case -> Empty List
        if(first == null){
            first = node;
            size++;
        }
        //Base case -> Not empty list
        else {
            if(first.getNext() == null){
                first.setNext(node);
                //Update index and add to the size of the list
                first.getNext().setIdx(1);
                this.size++;
            }
            //Iterative case
            else {
                //Current node
                NodePerson current = first.getNext();
                while(current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
                this.size++;
                current.getNext().setIdx(size-1);
            }
        }

    }

    //Search by the name of the person in each node
    public NodePerson search(String value){
        NodePerson found = null;

        //Base case
        if(first.getValue().getName().equals(value)){
            found = first;
        }
        //Iterative case
        else {
            NodePerson current = first;
            boolean isFound = false;
            while(current.getNext() != null && !isFound){
                if(current.getValue().getName().equals(value)){
                    found = current;
                    isFound = true;
                }
                current = current.getNext();
            }
        }


        return found;
    }

    public NodePerson get(int idx){
        NodePerson found = null;

        //Base case
        if(first.getIdx() == idx){
            found = first;
        }
        //Iterative case
        else {
            NodePerson current = first;
            boolean isFound = false;
            while(current.getNext() != null && !isFound){
                if(current.getIdx() == idx){
                    found = current;
                    isFound = true;
                }
                current = current.getNext();
            }
        }


        return found;
    }

    //To serialize an entire list
    public NodePerson getFirst(){
        return first;
    }

    public int getSize() {
        return size;
    }
}
