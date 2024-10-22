package Technical.Test.Upbiker.controllers;

import Technical.Test.Upbiker.models.Product;
import Technical.Test.Upbiker.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API for Product Inventory Management.
 * Base URL: /api/inventario
 */
@RestController
@RequestMapping("/api/inventario")
public class ProductoController {

    @Autowired
    private InventoryService InventoryService;

    /**
     * POST /add
     * Adds a new product to the inventory.
     *
     * @param name The name of the product.
     * @param price The price of the product.
     * @param category The category of the product.
     * @return A message confirming the product was added successfully.
     */
    @PostMapping("/add")
    public String addProduct(@RequestParam String name, @RequestParam double price, @RequestParam String category) {
        InventoryService.addProduct(name, price, category);
        return "Product added successfully!";
    }

    /**
     * DELETE /remove
     * Removes a product from the inventory by name and category.
     *
     * @param name The name of the product.
     * @param category The category of the product.
     * @return A message confirming the product was removed successfully.
     */
    @DeleteMapping("/remove")
    public String removeProduct(@RequestParam String name, @RequestParam String category) {
        InventoryService.removeProduct(name, category);
        return "Product removed successfully!";
    }

    /**
     * GET /list
     * Retrieves all products under a specific category.
     *
     * @param category The category of the products to retrieve.
     * @return A list of products in the specified category.
     */
    @GetMapping("/list")
    public List<Product> listProductsByCategory(@RequestParam String category) {
        return InventoryService.listProductsByCategory(category);
    }

    /**
     * GET /totalValue
     * Calculates the total value of all products in the inventory.
     *
     * @return The total value of the inventory.
     */
    @GetMapping("/totalValue")
    public double calculateTotalValue() {
        return InventoryService.calculateTotalValue();
    }
}
