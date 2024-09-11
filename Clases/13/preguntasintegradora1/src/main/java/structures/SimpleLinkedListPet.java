package structures;

import model.Pet;

public class SimpleLinkedListPet {

    private NodePet first;

    public void add(String id, Pet value){
        NodePet node = new NodePet(id, value);

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
                NodePet current = first.getNext();
                while(current.getNext() != null){
                    current = current.getNext();
                }
                current.setNext(node);
            }
        }

    }

    public NodePet search(String value){
        NodePet found = null;

        //Base case
        if(first.getValue().equals(value)){
            found = first;
        }
        //Iterative case
        else {
            NodePet current = first;
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
