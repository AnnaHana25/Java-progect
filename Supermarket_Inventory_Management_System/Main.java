package Supermarket_Inventory_Management_System;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
 
    private static final List<Product> inventory = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
 
    // The product that "Restock" applies to: the most recently added one.
    private static Product current = null;
 
    public static void main(String[] args) {
        boolean running = true;
 
        while (running) {
            printMenu();
            int command = readInt("Enter command (1-5): ");
 
            switch (command) {
                case 1:
                    addPerishable();
                    break;
                case 2:
                    addNonPerishable();
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    restockCurrent();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Please enter a number from 1 to 5.");
            }
            System.out.println();
        }
    }
 
    // Menu 
    private static void printMenu() {
        System.out.println("Supermarket Inventory System");
        System.out.println("1. Add Perishable Product");
        System.out.println("2. Add Non-Perishable Product");
        System.out.println("3. Display Product Info");
        System.out.println("4. Restock Product");
        System.out.println("5. Exit");
    }
 
    //  Command 1 
    private static void addPerishable() {
        try {
            String id = readLine("Enter Product ID: ");
            String name = readLine("Enter Product Name: ");
            double price = readDouble("Enter Price: ");
            int quantity = readInt("Enter Quantity: ");
            String expiry = readLine("Enter Expiry Date (YYYY-MM-DD): ");
 
            Product p = new PerishableProduct(id, name, price, quantity, expiry);
            inventory.add(p);
            current = p;
        } catch (IllegalArgumentException e) {
            // Thrown by the validation in the setters
            System.out.println("Could not add product: " + e.getMessage());
        }
    }
 
    //  Command 2 
    private static void addNonPerishable() {
        try {
            String id = readLine("Enter Product ID: ");
            String name = readLine("Enter Product Name: ");
            double price = readDouble("Enter Price: ");
            int quantity = readInt("Enter Quantity: ");
            String warranty = readLine("Enter Warranty Period: ");
 
            Product p = new NonPerishableProduct(id, name, price, quantity, warranty);
            inventory.add(p);
            current = p;
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add product: " + e.getMessage());
        }
    }
 
    //  Command 3 
    private static void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in the inventory yet.");
            return;
        }
        for (Product p : inventory) {
            System.out.println(p.getProductInfo()); 
        }
    }
 
    // Command 4
    private static void restockCurrent() {
        if (current == null) {
            System.out.println("No product to restock. Add a product first.");
            return;
        }
        int amount = readInt("Enter Restock Amount: ");
        try {
            current.restock(amount);
            System.out.println("Restocked " + amount + " units. Total quantity: "
                    + current.getQuantity());
        } catch (IllegalArgumentException e) {
            System.out.println("Could not restock: " + e.getMessage());
        }
    }
 
    // Input helpers (re-ask until the input is valid) 
    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
 
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
 
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            try {
                return Double.parseDouble(text);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }
}
 