package Technical.Test.Upbiker.models;

import java.util.*;

/**
 * Inventory class for managing products by category.
 */
public class Inventory {
    private Map<String, List<Product>> productsByCategory;

    public Inventory() {
        this.productsByCategory = new HashMap<>();
    }

    /**
     * Adds a new product to the inventory.
     *
     * @param name     The name of the product.
     * @param price    The price of the product.
     * @param category The category of the product.
     */
    // Add product to inventory
    public void addProduct(String name, double price, String category) {
        Product newProduct = new Product(name, price, category);
        productsByCategory.putIfAbsent(category, new ArrayList<>());
        productsByCategory.get(category).add(newProduct);
    }

    /**
     * Removes a product from the inventory by name and category.
     *
     * @param name     The name of the product.
     * @param category The category of the product.
     */
    // Remove product from inventory
    public void removeProduct(String name, String category) {
        if (productsByCategory.containsKey(category)) {
            productsByCategory.get(category).removeIf(product -> product.getName().equals(name));
        }
    }

    /**
     * Lists all products under a specific category.
     *
     * @param category The category of the products to retrieve.
     * @return A list of products in the specified category.
     */
    // List products by category
    public List<Product> listProductsByCategory(String category) {
        return productsByCategory.getOrDefault(category, new ArrayList<>());
    }

    /**
     * Calculates the total value of all products in the inventory.
     *
     * @return The total value of the inventory.
     */
    // Calculate total value of inventory
    public double calculateTotalValue() {
        return productsByCategory.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }
}