import manager.SaleManager;
import objects.Product;
import objects.Sale;

public class Main {
        public static void main(String[] args) {

        SaleManager saleManager = new SaleManager();
        Sale emptySale = new Sale();
        Sale sale = new Sale();

        sale.addProduct(new Product("Product1", 12_000));
        sale.addProduct(new Product("Product2", 31));
        sale.addProduct(new Product("Product3", 89.99));

        System.out.println("\nWe try to calculate total from an empty sale.");
        saleManager.calculateTotal(emptySale);

        System.out.println("\nWe try to calculate total from a sale.");
        saleManager.calculateTotal(sale);

        System.out.println("\nWe try to reach an existing product.");
        saleManager.reachElement(sale, 2);

        System.out.println("\nWe try to reach a non existing product.");
        saleManager.reachElement(sale, 21);
}
}
