package structures;

import model.Person;

public class SimpleLinkedListPerson {

    private NodePerson first;

    public void add(String id, Person value){
        NodePerson node = new NodePerson(id, value);

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
                NodePerson current = first.getNext();
                while(current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
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

    //To serialize an entire list
    public NodePerson getFirst(){
        return first;
    }

}
