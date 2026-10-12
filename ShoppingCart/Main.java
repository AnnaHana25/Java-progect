package ShoppingCart;

import java.util.Scanner;

/**
 * Console menu for the Shopping Cart System.
 * All user input is read as text and parsed, so wrong input
 * (letters instead of numbers, etc.) gives a clear message instead of a crash.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    /** Prompts until the user types a valid double; returns it. */
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: please enter a number (e.g. 12.5).");
            }
        }
    }

    /** Prompts until the user types a valid whole number; returns it. */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: please enter a whole number.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nShopping Cart System:");
        System.out.println("1. Add Item (Name, Price)");
        System.out.println("2. Add Item (Name, Price, Quantity)");
        System.out.println("3. Add Item (Name, Price, Quantity, Discount)");
        System.out.println("4. View Cart");
        System.out.println("5. Calculate Total");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        Shoppingcart cart = new Shoppingcart();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1: {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    double price = readDouble("Enter price: ");
                    cart.addItem(name, price);                       // overload 1
                    break;
                }
                case 2: {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    double price = readDouble("Enter price: ");
                    int qty = readInt("Enter quantity: ");
                    cart.addItem(name, price, qty);                  // overload 2
                    break;
                }
                case 3: {
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    double price = readDouble("Enter price: ");
                    int qty = readInt("Enter quantity: ");
                    double disc = readDouble("Enter discount (%): ");
                    cart.addItem(name, price, qty, disc);            // overload 3
                    break;
                }
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    if (cart.isEmpty()) {
                        System.out.println("The cart is empty, nothing to total.");
                    } else {
                        System.out.println("Total: $" + String.format("%.2f", cart.calculateTotal()));
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option: choose a number from 1 to 6.");
            }
        }
        scanner.close();
    }
}
