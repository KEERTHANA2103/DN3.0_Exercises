package ObserverPatternExample;
public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create the stock market
        StockMarket stockMarket = new StockMarket("AAPL", 150.00);

        // Create observers
        Observer mobileApp1 = new MobileApp("App1");
        Observer mobileApp2 = new MobileApp("App2");
        Observer webApp1 = new WebApp("Web1");

        //Register observers
        stockMarket.register(mobileApp1);
        stockMarket.register(mobileApp2);
        stockMarket.register(webApp1);

        //  Change stock price and notify observers
        System.out.println("Changing stock price to $155.00");
        stockMarket.setStockPrice(155.00);

        // Deregister an observer
        stockMarket.deregister(mobileApp1);

        //  Change stock price again and notify remaining observers
        System.out.println("Changing stock price to $160.00");
        stockMarket.setStockPrice(160.00);
    }
}