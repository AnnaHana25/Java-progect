package ShoppingCart;

/**
 * Represents a single line in the shopping cart:
 * a product name, its unit price, the quantity and a discount percentage.
 */
public class Item {

    private final String name;      
    private final double price;     
    private final int quantity;     
    private final double discount;  


//      Creates a new cart item

    public Item(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public String getName()      { return name; }
    public double getPrice()     { return price; }
    public int getQuantity()     { return quantity; }
    public double getDiscount()  { return discount; }

 
//   Total cost of this line
   
    public double getLineTotal() {
        return price * quantity * (1 - discount / 100.0);
    }

   
//    "View Cart"
   
    @Override
    public String toString() {
        return String.format("Item: %s, Price: %.2f, Quantity: %d, Discount: %.2f%%",
                name, price, quantity, discount);
    }
}