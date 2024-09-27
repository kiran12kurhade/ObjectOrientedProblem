package com.account;

import java.util.Scanner;

public class Account {
    private double balance; // account balance

    // Constructor to initialize balance
    public Account(double initialBalance) {
        // ensure the initial balance is greater than 0.0; if not, balance is set to 0.0
        if (initialBalance > 0.0) {
            balance = initialBalance;
        }
    }

    // Method to deposit an amount to the account
    public void credit(double amount) {
        balance += amount; // add amount to balance
    }

    // Method to withdraw an amount from the account
    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
            System.out.printf("Successfully debited: %.2f%n", amount);
        }
    }

    // Method to return the account balance
    public double getBalance() {
        return balance;
    }
}
 class AccountTest {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         // Create Account object with an initial balance
         System.out.print("Enter initial balance for the account: ");
         double initialBalance = scanner.nextDouble();
         Account account = new Account(initialBalance);

         // Display the initial balance
         System.out.printf("Initial balance: %.2f%n", account.getBalance());

         // Test crediting the account
         System.out.print("Enter an amount to deposit: ");
         double depositAmount = scanner.nextDouble();
         account.credit(depositAmount);
         System.out.printf("New balance after deposit: %.2f%n", account.getBalance());

         // Test debiting the account
         System.out.print("Enter an amount to withdraw (debit): ");
         double debitAmount = scanner.nextDouble();
         account.debit(debitAmount);  // Call the debit method
         System.out.printf("New balance after debit: %.2f%n", account.getBalance());
     }
 }
