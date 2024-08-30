package model;

public class TechWare implements Comparable<TechWare>{

    private String productName;
    private double price;
    private int amount;

    @Override
    public String toString(){
        return this.productName + ": Price " + this.price + ", Amount: " + this.amount + "\n";
    }

    @Override
    public int compareTo(TechWare o) {
        return this.productName.compareTo(o.getProductName());
    }

    public TechWare(String productName, double price, int amount) {
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
