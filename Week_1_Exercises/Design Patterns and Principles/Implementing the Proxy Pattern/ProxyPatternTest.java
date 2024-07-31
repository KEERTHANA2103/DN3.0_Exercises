package ProxyPatternExample;
public class ProxyPatternTest {
    public static void main(String[] args) {
        // Create proxy instances
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Display images
        System.out.println("Displaying image1 for the first time:");
        image1.display();  // Loads and displays image1

        System.out.println("\nDisplaying image1 for the second time:");
        image1.display();  // Only displays image1, no loading

        System.out.println("\nDisplaying image2 for the first time:");
        image2.display();  // Loads and displays image2
    }
}