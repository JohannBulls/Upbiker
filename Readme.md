# Upbiker Inventory Management

## Overview
The Upbiker project is a RESTful API for managing product inventory. It allows users to add, remove, and list products by category, as well as calculate the total value of the inventory. The application is built using Spring Boot and follows a service-oriented architecture.

## Technologies Used
- **Java**: Programming language
- **Spring Boot**: Framework for building the application
- **Maven**: Dependency management
- **JUnit**: Testing framework
- **Mockito**: Mocking framework for unit tests

## Architecture
- **CRM**: Exposes services for the ERP to consume, allowing product management.
- **ERP**: Integrates with the CRM through HTTP requests, utilizing the exposed API methods.


## Class

### Product
Represents a product in the inventory with attributes for the name, price, and category. It includes getter and setter methods for these attributes.

### Inventory
Manages products by category. It allows adding, removing, and listing products, as well as calculating the total value of all products in the inventory.

### InventoryService
Service class that acts as an intermediary between the controller and the inventory. It contains methods to add and remove products, list products by category, and calculate the total inventory value.

### ProductoController
REST controller that exposes API endpoints for managing the product inventory. It handles incoming HTTP requests and interacts with the `InventoryService` to perform operations.

## API Endpoints

### Add a Product
- **URL**: `/api/inventario/add`
- **Method**: `POST`
- **Parameters**:
  - `name`: The name of the product
  - `price`: The price of the product
  - `category`: The category of the product
- **Response**: Confirmation message

### Remove a Product
- **URL**: `/api/inventario/remove`
- **Method**: `DELETE`
- **Parameters**:
  - `name`: The name of the product
  - `category`: The category of the product
- **Response**: Confirmation message

### List Products by Category
- **URL**: `/api/inventario/list`
- **Method**: `GET`
- **Parameters**:
  - `category`: The category of products to retrieve
- **Response**: List of products in the specified category

### Calculate Total Value
- **URL**: `/api/inventario/totalValue`
- **Method**: `GET`
- **Response**: Total value of the inventory

## Testing with Postman

You can test the API using Postman by following these steps:

1. **Add a Product**:
   - Set the request method to `POST`.
   - Enter the URL: `http://localhost:8080/api/inventario/add`.
   - Go to the **Body** tab, select **x-www-form-urlencoded**, and add the following parameters:
     - `name`: Product name (e.g., "Product1")
     - `price`: Product price (e.g., 100.0)
     - `category`: Product category (e.g., "Category1")
   - Click **Send**.

2. **Remove a Product**:
   - Set the request method to `DELETE`.
   - Enter the URL: `http://localhost:8080/api/inventario/remove`.
   - Go to the **Body** tab, select **x-www-form-urlencoded**, and add the following parameters:
     - `name`: Product name to remove (e.g., "Product1")
     - `category`: Product category (e.g., "Category1")
   - Click **Send**.

3. **List Products by Category**:
   - Set the request method to `GET`.
   - Enter the URL: `http://localhost:8080/api/inventario/list?category=Category1`.
   - Click **Send** to see the list of products in the specified category.

4. **Calculate Total Value**:
   - Set the request method to `GET`.
   - Enter the URL: `http://localhost:8080/api/inventario/totalValue`.
   - Click **Send** to see the total value of the inventory.

## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Use Maven to build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Testing
To run the tests, use the following command:
```bash
mvn test
```



## License
This project is licensed under the MIT License.