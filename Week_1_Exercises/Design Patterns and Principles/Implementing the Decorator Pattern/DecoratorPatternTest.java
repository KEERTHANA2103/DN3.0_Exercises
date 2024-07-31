package DecoratorPatternExample;
public class DecoratorPatternTest {
    public static void main(String[] args) {
        //Create a basic notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate the basic notifier with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Further decorate with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a notification via multiple channels
        slackNotifier.send("This is a test notification.");

        // Test with different combinations
        System.out.println("\n--- Sending with Email and SMS ---");
        Notifier emailAndSmsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSmsNotifier.send("This is a test notification for Email and SMS.");

        System.out.println("\n--- Sending with only Slack ---");
        Notifier onlySlackNotifier = new SlackNotifierDecorator(new EmailNotifier());
        onlySlackNotifier.send("This is a test notification for Slack only.");
    }
}