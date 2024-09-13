package model;

public class Product {

    private String name;
    private double price;
    private int quantity;

    @Override
    public String toString(){
        return this.name + ": Price " + this.price + ", Amount: " + this.quantity + "\n";
    }

    public Product(String productName, double price, int amount) {
        this.name = productName;
        this.price = price;
        this.quantity = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
