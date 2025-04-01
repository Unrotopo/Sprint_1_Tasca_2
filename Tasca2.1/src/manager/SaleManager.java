package manager;

import exception.EmptySaleException;
import objects.Sale;

public class SaleManager {

    public void calculateTotal(Sale sale) {
        try {
            sale.calculateTotal();

        } catch(EmptySaleException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reachElement(Sale sale, int index) {
        try {
            sale.getProduct(index);

        } catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
