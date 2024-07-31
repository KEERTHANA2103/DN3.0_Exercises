package SingletonPatternExample;
public class Logger {
    // Create a private static instance of Logger
    private static Logger instance;

    // Make the constructor private to prevent instantiation
    private Logger() {
        // Initialization code, if needed
    }

    // Provide a public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            // Synchronized block to remove overhead
            synchronized (Logger.class) {
                if (instance == null) {
                    // if instance is null, initialize
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}