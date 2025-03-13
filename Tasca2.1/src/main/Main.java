package main;

import exception.EmptySaleException;
import objects.Product;
import objects.Sale;

public class Main {
    public static void main(String[] args) {

        Sale sale = new Sale();
        Product product1 = new Product("NiceProduct1", 0.01);
        sale.addProduct(product1);

        try {
            sale.calculateTotal();

        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        Product product2 = new Product("NiceProduct", 0.01);
        sale.addProduct(product2);

        try {
            sale.getProduct(1);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("This product is out of reach!");
        }
    }
}
