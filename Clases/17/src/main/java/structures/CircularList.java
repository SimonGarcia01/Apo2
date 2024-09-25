package structures;

public class CircularList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T value){
        Node<T> node = new Node<>(value, 0);

        //Base case -> Empty List
        if(first == null){
            first = node;
            //Circular list with reference to the last element
            last = node;
            this.size ++;
        }
        //Base case -> Not empty list
        else {
            if(first.getNext() == null){
                first.setNext(node);

                //Double linked list
                first.getNext().setPrevious(first);
                last = first.getNext();

                //Circular list additional
                first.setPrevious(last);
                last.setNext(first);
                //Update the index and increment list size
                first.getNext().setPosition(1);
                this.size++;
            }
            //Iterative case
            else {
                //Add new node at the end of the list
                last.setNext(node);

                //update associations of the new node
                node.setPrevious(last);

                //Update pointer to last element
                last = node;

                //Update circular list associations
                last.setNext(first);
                first.setPrevious(last);

                //Update size and position
                last.setPosition(size-1);
                this.size++;

                //Looping to get the next null element becomes unnecessary
//                Node<T> current = first.getNext();
//                while(current.getNext() != null){
//                    current = current.getNext();
//                }
//                current.setNext(node);
//                this.size++;
//                current.getNext().setPosition(size-1);
            }
        }

    }

    public String printList(){
        String message = "";

        Node<T> current = first;
        if(current != null){
            message += first + " ";
        }

        while(current.getNext() != null && current != last){
            message += current.getNext() + " ";
            current = current.getNext();
        }


        return message;
    }

    //Left with the default empty constructor

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
