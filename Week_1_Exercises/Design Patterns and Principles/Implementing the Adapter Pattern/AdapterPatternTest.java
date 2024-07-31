package AdapterPatternExample;
public class AdapterPatternTest {
    public static void main(String[] args) {
        //Create instances of the adaptees
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();
        SquareGateway squareGateway = new SquareGateway();

        // Create adapter instances
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        PaymentProcessor squareAdapter = new SquareAdapter(squareGateway);

        //Process payments using adapters
        payPalAdapter.processPayment(100.00);
        stripeAdapter.processPayment(200.00);
        squareAdapter.processPayment(300.00);
    }
}