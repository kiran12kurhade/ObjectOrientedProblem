package com.account;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = scanner.nextInt();

        // Loop to read stock details and add to the portfolio
        for (int i = 0; i < numberOfStocks; i++) {
            System.out.printf("Enter details for Stock %d:%n", i + 1);
            System.out.print("Stock Name: ");
            String stockName = scanner.next();
            System.out.print("Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Share Price: ");
            double sharePrice = scanner.nextDouble();

            // Creating a new stock and adding it to the portfolio
            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            portfolio.addStock(stock);
        }

        // Displaying the stock report
        portfolio.displayStockReport();
    }
}


// Stock class to represent each stock with its name, number of shares, and share price
class Stock {
    private String stockName;
    private int numberOfShares;
    private double sharePrice;

    // Constructor to initialize stock details
    public Stock(String stockName, int numberOfShares, double sharePrice) {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    // Method to calculate the total value of the stock
    public double getStockValue() {
        return numberOfShares * sharePrice;
    }

    // Method to get the stock name
    public String getStockName() {
        return stockName;
    }

    // Method to display stock information
    public void displayStockInfo() {
        System.out.printf("Stock Name: %s, Number of Shares: %d, Share Price: %.2f, Total Value: %.2f%n",
                stockName, numberOfShares, sharePrice, getStockValue());
    }
}
// StockPortfolio class to manage multiple stocks
class StockPortfolio {
    private ArrayList<Stock> stocks;

    // Constructor to initialize an empty list of stocks
    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    // Method to add a stock to the portfolio
    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    // Method to calculate the total value of all stocks
    public double getTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.getStockValue();
        }
        return totalValue;
    }

    // Method to display the stock report
    public void displayStockReport() {
        System.out.println("Stock Report:");
        for (Stock stock : stocks) {
            stock.displayStockInfo();
        }
        System.out.printf("Total Portfolio Value: %.2f%n", getTotalPortfolioValue());
    }
}
