package structures;

import model.Person;

public class NodePerson {
    private String id;
    private int idx;
    private Person value;

    //Association to the next node
    private NodePerson next;

    public NodePerson(String id, Person value, int idx) {
        this.id = id;
        this.value = value;
        this.idx= idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getValue() {
        return value;
    }

    public void setValue(Person value) {
        this.value = value;
    }

    public NodePerson getNext() {
        return next;
    }

    public void setNext(NodePerson next) {
        this.next = next;
    }

    @Override
    public String toString(){
        return "Name: " + value.getName() + "\n" +
                "Age: " + value.getAge();
    }
}
