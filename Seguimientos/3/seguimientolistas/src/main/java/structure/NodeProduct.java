package structure;

import model.Product;

public class NodeProduct {

    private Product Product;
    private NodeProduct next;

    public NodeProduct(Product Product) {
        this.Product = Product;
    }

    @Override
    public String toString() {
        return Product.toString();
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product Product) {
        this.Product = Product;
    }

    public NodeProduct getNext() {
        return next;
    }

    public void setNext(NodeProduct next) {
        this.next = next;
    }
}
