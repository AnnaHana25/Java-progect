package Supermarket_Inventory_Management_System;

public class PerishableProduct extends Product {

    private String expiryDate;  // kept as a String, as required by the assignment

    public PerishableProduct(String productId, String name, double price,
                             int quantity, String expiryDate) {
        super(productId, name, price, quantity);   // reuse parent constructor + validation
        setExpiryDate(expiryDate);
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        if (expiryDate == null || expiryDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Expiry date cannot be empty.");
        }
        this.expiryDate = expiryDate.trim();
    }

    //      Implements the abstract method: common info plus the expiry date.
    @Override
    public String getProductInfo() {
        return "Perishable Product [" + baseInfo()
                + ", Expiry Date: " + expiryDate + "]";
    }
}