package objects;

import exception.EmptySaleException;

import java.util.ArrayList;

public class Sale {

    private ArrayList<Product> products;
    private double total;

    public Sale() {
        this.products = new ArrayList<>();
        this.total = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void getProduct(int index) {
        System.out.println(products.get(index).toString());
    }

    public void calculateTotal() throws EmptySaleException {

        if (products.isEmpty()) {
            throw new EmptySaleException();
        } else {
            for (Product product: products) {
                this.total += product.getPrice();
            }
        } System.out.println("Total: " + this.total + " money units.");
    }
}
