package ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart.java
 * Holds the items and demonstrates METHOD OVERLOADING:
 * three methods called addItem with different parameter lists.
 */
public class Shoppingcart {

    private final List<Item> items = new ArrayList<>();

    /**
     * Overload 1: name and price only.
     * Quantity defaults to 1 and discount to 0%.
     */
    public boolean addItem(String name, double price) {
        return addItem(name, price, 1, 0.0);   // delegate to the most detailed version
    }

    /**
     * Overload 2: name, price and quantity.
     * Discount defaults to 0%.
     */
    public boolean addItem(String name, double price, int quantity) {
        return addItem(name, price, quantity, 0.0);
    }

    /**
     * Overload 3: name, price, quantity and discount percentage.
     * Validates all input and stores the item. Returns true on success.
     */
    public boolean addItem(String name, double price, int quantity, double discount) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: item name cannot be empty.");
            return false;
        }
        if (price < 0) {
            System.out.println("Error: price cannot be negative.");
            return false;
        }
        if (quantity <= 0) {
            System.out.println("Error: quantity must be at least 1.");
            return false;
        }
        if (discount < 0 || discount > 100) {
            System.out.println("Error: discount must be between 0 and 100.");
            return false;
        }
        items.add(new Item(name.trim(), price, quantity, discount));
        System.out.println("Item added: " + name.trim() + ", Quantity: " + quantity
                + ", Discount: " + discount + "%");
        return true;
    }

    /** Prints every item in the cart. */
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }

    /** Sums the line totals (price * quantity, minus discount). */
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getLineTotal();
        }
        return total;
    }

    public boolean isEmpty() { return items.isEmpty(); }
}
