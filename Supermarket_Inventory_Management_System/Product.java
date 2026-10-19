package Supermarket_Inventory_Management_System;

public abstract class Product {

    // Fields
    private String productId;   
    private String name;        
    private double price;       
    private int quantity;    

    // Constructor
    public Product(String productId, String name, double price, int quantity) {
        setProductId(productId);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    // Abstract method 
    public abstract String getProductInfo();

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters (with validation)
    public void setProductId(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be empty.");
        }
        this.productId = productId.trim();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.name = name.trim();
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    // Other concrete behaviour 

    public void restock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Restock amount must be greater than 0.");
        }
        this.quantity += amount;
    }

    protected String baseInfo() {
        return "ID: " + productId
                + ", Name: " + name
                + ", Price: " + price
                + ", Quantity: " + quantity;
    }

    @Override
    public String toString() {
        return getProductInfo();
    }
}