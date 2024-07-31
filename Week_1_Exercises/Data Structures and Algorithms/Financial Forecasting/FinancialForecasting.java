public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        // Base case: no more years to project
        if (years == 0) {
            return currentValue;
        }
        // Recursive case: calculate value for next year
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        // Example usage
        double currentValue = 1000.0;  // Initial value
        double growthRate = 0.05;      // Annual growth rate (5%)
        int years = 10;                // Number of years to forecast

        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: $" + futureValue);
    }
}