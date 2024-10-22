package Technical.Test.Upbiker.models;

/**
 * Represents a product in the inventory.
 */
public class Product {
    private String name;
    private double price;
    private String category;

    /**
     * Constructor for Product.
     *
     * @param name     The name of the product.
     * @param price    The price of the product.
     * @param category The category of the product.
     */
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Gets the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the category of the product.
     *
     * @return The category of the product.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     *
     * @param category The category of the product.
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
