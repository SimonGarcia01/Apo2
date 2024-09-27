package structures;

public class BinarySearchTree<T extends Comparable<T>>{

    private Node<T> root;

    public String inOrder(){
        String message = "";

        if(root == null){
            message = "Empty Tree";
        }

        else{
            message = inOrder(root, message);
        }

        return message;
    }

    private String inOrder(Node<T> current, String message){

        if(current == null){
            message += "";
        }
        else{
            //Check method
            message += inOrder(current.getLeft(), message) + current.getValue() + inOrder(current.getRight(), message);
        }

        return message;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);

        //Base Case
        if(root == null){
            root = node;
        }
        //Recursive case
        else {
            //Auxiliary recursive method
            add(node, root);
        }

    }

    private void add(Node<T> node, Node<T> current){
        //Add to the left
        if(node.getValue().compareTo(current.getValue()) < 0) {
            if(current.getLeft() == null){
                current.setLeft(node);
            }
            else{
                //Recursive case
                add(node, current.getLeft());
            }
        }

        //Add to the right
        else if(node.getValue().compareTo(current.getValue()) > 0){
            if(current.getRight() == null){
                current.setRight(node);
            } else {
                //Recursive case
                add(node, current.getRight());
            }
        }

        //When two nodes are the same
        else{
            //Do nothing so nothing is added
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
