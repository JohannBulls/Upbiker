package Technical.Test.Upbiker.services;

import Technical.Test.Upbiker.models.Inventory;
import Technical.Test.Upbiker.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing inventory operations.
 */
@Service
public class InventoryService {
    private final Inventory inventory = new Inventory();

    /**
     * Adds a new product to the inventory.
     *
     * @param name     The name of the product.
     * @param price    The price of the product.
     * @param category The category of the product.
     */
    public void addProduct(String name, double price, String category) {
        inventory.addProduct(name, price, category);
    }

    /**
     * Removes a product from the inventory by name and category.
     *
     * @param name     The name of the product.
     * @param category The category of the product.
     */
    public void removeProduct(String name, String category) {
        inventory.removeProduct(name, category);
    }

    /**
     * Lists all products under a specific category.
     *
     * @param category The category of the products to retrieve.
     * @return A list of products in the specified category.
     */
    public List<Product> listProductsByCategory(String category) {
        return inventory.listProductsByCategory(category);
    }

    /**
     * Calculates the total value of all products in the inventory.
     *
     * @return The total value of the inventory.
     */
    public double calculateTotalValue() {
        return inventory.calculateTotalValue();
    }
}
