public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product product1 = new Product("P1", "Mouse", 10, 999.99);
        Product product2 = new Product("P2", "Laptop", 50, 499.99);
        Product product3 = new Product("P3", "Tablet", 30, 299.99);

        // Add products
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        // Display all products
        System.out.println("All Products:");
        inventory.displayProducts();

        // Update a product
        Product updatedProduct = new Product("P1", "Smartphone", 15, 1099.99);
        inventory.updateProduct(updatedProduct);
        
        // Display all products after update
        System.out.println("\nAfter Update:");
        inventory.displayProducts();

        // Delete a product
        inventory.deleteProduct("P2");

        // Display all products after deletion
        System.out.println("\nAfter Deletion:");
        inventory.displayProducts();
    }
}
