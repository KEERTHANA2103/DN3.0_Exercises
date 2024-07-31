import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Method to update a product
    public void updateProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found");
        }
    }

    // Method to delete a product
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product not found");
        }
    }

    // Method to display all products
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}