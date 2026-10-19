package Supermarket_Inventory_Management_System;


public class NonPerishableProduct extends Product {

    private String warrantyPeriod;  // kept as a String, as required by the assignment

    public NonPerishableProduct(String productId, String name, double price,
                                int quantity, String warrantyPeriod) {
        super(productId, name, price, quantity);   // reuse parent constructor + validation
        setWarrantyPeriod(warrantyPeriod);
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        if (warrantyPeriod == null || warrantyPeriod.trim().isEmpty()) {
            throw new IllegalArgumentException("Warranty period cannot be empty.");
        }
        this.warrantyPeriod = warrantyPeriod.trim();
    }

    // Implements the abstract method: common info plus the warranty period.
    @Override
    public String getProductInfo() {
        return "Non-Perishable Product [" + baseInfo()
                + ", Warranty Period: " + warrantyPeriod + "]";
    }
}