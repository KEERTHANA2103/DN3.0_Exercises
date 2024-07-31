package AdapterPatternExample;
public class StripeGateway {
    public void performPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}