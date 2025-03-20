package controller;

import exception.EmptySaleException;
import objects.Product;
import objects.Sale;

public class SaleController {

    public void saleLaunch() {

        Sale sale = new Sale();

        System.out.println("\nWe try to calculate the total price, but we don't have any products yet:");
        try {
            sale.calculateTotal();
        } catch(EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        sale.addProduct(new Product("Nice product", 10_000));
        sale.addProduct(new Product("Normal product", 120.50));
        sale.addProduct(new Product("Bad product", 0.90));

        System.out.println("\nWe try to calculate the total price, we now have some products:");
        try {
            sale.calculateTotal();
        } catch(EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nWe try to reach the 2nd element:");
        try {
            System.out.println(sale.getProduct(1));
        } catch(IndexOutOfBoundsException e) {
            System.out.println("This product does not even exist!");
        }

        System.out.println("\nWe try to reach the 35th element in the sale list, yet we have only 3:");
        try {
            sale.getProduct(34);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("This product does not even exist!");
        }
    }
}
