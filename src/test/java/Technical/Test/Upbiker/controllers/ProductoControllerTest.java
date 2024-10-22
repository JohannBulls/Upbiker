package Technical.Test.Upbiker.controllers;

import Technical.Test.Upbiker.models.Product;
import Technical.Test.Upbiker.services.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductoControllerTest {

    @InjectMocks
    private ProductoController productoController;

    @Mock
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {
        String name = "Producto1";
        double price = 100.0;
        String category = "Categoría1";

        String response = productoController.addProduct(name, price, category);

        verify(inventoryService, times(1)).addProduct(name, price, category);
        assertEquals("Product added successfully!", response);
    }

    @Test
    void testRemoveProduct() {
        String name = "Producto1";
        String category = "Categoría1";

        String response = productoController.removeProduct(name, category);

        verify(inventoryService, times(1)).removeProduct(name, category);
        assertEquals("Product removed successfully!", response);
    }

    @Test
    void testListProductsByCategory() {
        String category = "Categoría1";
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Producto1", 100.0, category));
        
        when(inventoryService.listProductsByCategory(category)).thenReturn(productList);

        List<Product> response = productoController.listProductsByCategory(category);
        
        verify(inventoryService, times(1)).listProductsByCategory(category);
        assertEquals(productList, response);
    }

    @Test
    void testCalculateTotalValue() {
        when(inventoryService.calculateTotalValue()).thenReturn(500.0);

        double totalValue = productoController.calculateTotalValue();
        
        verify(inventoryService, times(1)).calculateTotalValue();
        assertEquals(500.0, totalValue);
    }
}
