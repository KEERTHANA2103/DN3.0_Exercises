package StrategyPatternExample;
public class StrategyPatternTest {
    public static void main(String[] args) {
        // Create payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");

        // Create context with a strategy
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        System.out.println("Using Credit Card Payment Strategy:");
        paymentContext.executePayment(150.00);

        // Change strategy to PayPal and execute payment
        paymentContext.setPaymentStrategy(payPalPayment);
        System.out.println("\nUsing PayPal Payment Strategy:");
        paymentContext.executePayment(200.00);
    }
}