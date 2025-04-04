package objects;

public class Product {

    private final String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "You reached for " + this.name + " that costs " + this.price + " money units.";
    }
}
