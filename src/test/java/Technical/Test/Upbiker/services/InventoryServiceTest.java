package Technical.Test.Upbiker.services;

import Technical.Test.Upbiker.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
    }

    @Test
    void testAddProduct() {
        String name = "Producto1";
        double price = 100.0;
        String category = "Categoría1";

        inventoryService.addProduct(name, price, category);
        List<Product> products = inventoryService.listProductsByCategory(category);

        assertEquals(1, products.size());
        assertEquals(name, products.get(0).getName());
    }

    @Test
    void testRemoveProduct() {
        String name = "Producto1";
        double price = 100.0;
        String category = "Categoría1";

        inventoryService.addProduct(name, price, category);
        inventoryService.removeProduct(name, category);
        List<Product> products = inventoryService.listProductsByCategory(category);

        assertEquals(0, products.size());
    }

    @Test
    void testListProductsByCategory() {
        String category = "Categoría1";
        inventoryService.addProduct("Producto1", 100.0, category);
        inventoryService.addProduct("Producto2", 200.0, category);

        List<Product> products = inventoryService.listProductsByCategory(category);
        
        assertEquals(2, products.size());
    }

    @Test
    void testCalculateTotalValue() {
        inventoryService.addProduct("Producto1", 100.0, "Categoría1");
        inventoryService.addProduct("Producto2", 200.0, "Categoría2");

        double totalValue = inventoryService.calculateTotalValue();

        assertEquals(300.0, totalValue);
    }
}
