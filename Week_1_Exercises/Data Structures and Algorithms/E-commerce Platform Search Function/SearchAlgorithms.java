//Implement Linear Search and Binary Search Algorithms
import java.util.Arrays;

public class SearchAlgorithms {

    // Linear search algorithm
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search algorithm (Assumes the array is sorted by productName)
    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(productName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample products
        Product[] products = {
            new Product("P1", "Mouse", "Electronics"),
            new Product("P2", "Laptop", "Electronics"),
            new Product("P3", "Tablet", "Electronics"),
            new Product("P4", "Headphones", "Accessories"),
            new Product("P5", "Charger", "Accessories")
        };

        // Sort products by productName for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

        // Linear search
        String searchName = "Tablet";
        Product result = linearSearch(products, searchName);
        System.out.println("Linear Search Result: " + result);

        // Binary search
        result = binarySearch(products, searchName);
        System.out.println("Binary Search Result: " + result);
    }
}