// Question 1: Product class with showDetails() method
// Demonstrates basic reflection to load class, instantiate object, and invoke method

public class Product {
    private String productName;
    private double price;
    private int quantity;

    public Product() {
        this.productName = "Default Product";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void showDetails() {
        System.out.println("=== Product Details ===");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("======================");
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
