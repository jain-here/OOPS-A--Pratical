// Product Inventory Management System using ArrayList
// Demonstrates set(), add(), clear(), for-each loop, and sum calculation

import java.util.ArrayList;

public class ProductInventoryManager {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║        PRODUCT INVENTORY MANAGEMENT SYSTEM                 ║");
        System.out.println("║        Using ArrayList for Quantity Tracking               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Create ArrayList to store product quantities
        ArrayList<Integer> productQuantities = new ArrayList<>();
        ArrayList<String> productNames = new ArrayList<>();
        
        // Demonstration 1: add() - Add initial inventory
        System.out.println("═══ 1. Adding Initial Product Quantities ═══");
        productNames.add("Laptop");
        productNames.add("Mouse");
        productNames.add("Keyboard");
        productNames.add("Monitor");
        productNames.add("Headphones");
        
        productQuantities.add(50);
        productQuantities.add(120);
        productQuantities.add(85);
        productQuantities.add(30);
        productQuantities.add(95);
        
        displayInventory(productNames, productQuantities);
        System.out.println();
        
        // Demonstration 2: set() - Update quantity at specific index
        System.out.println("═══ 2. Updating Product Quantities (set method) ═══");
        System.out.println("Updating Mouse quantity from " + productQuantities.get(1) + " to 150");
        productQuantities.set(1, 150);
        
        System.out.println("Updating Monitor quantity from " + productQuantities.get(3) + " to 45");
        productQuantities.set(3, 45);
        
        displayInventory(productNames, productQuantities);
        System.out.println();
        
        // Demonstration 3: Iteration using for-each loop
        System.out.println("═══ 3. Iterating with For-Each Loop ═══");
        System.out.println("All product quantities:");
        int index = 0;
        for (Integer quantity : productQuantities) {
            System.out.println("  " + productNames.get(index) + ": " + quantity + " units");
            index++;
        }
        System.out.println();
        
        // Demonstration 4: Calculate total quantity
        System.out.println("═══ 4. Calculating Total Inventory ═══");
        int totalQuantity = 0;
        for (Integer quantity : productQuantities) {
            totalQuantity += quantity;
        }
        System.out.println("Total products in inventory: " + totalQuantity + " units");
        
        // Calculate average
        double averageQuantity = (double) totalQuantity / productQuantities.size();
        System.out.println("Average quantity per product: " + String.format("%.2f", averageQuantity) + " units");
        System.out.println();
        
        // Demonstration 5: Find products with low stock
        System.out.println("═══ 5. Low Stock Alert (Quantity < 50) ═══");
        boolean lowStockFound = false;
        for (int i = 0; i < productQuantities.size(); i++) {
            if (productQuantities.get(i) < 50) {
                System.out.println("  ⚠ " + productNames.get(i) + ": " + productQuantities.get(i) + " units (LOW STOCK)");
                lowStockFound = true;
            }
        }
        if (!lowStockFound) {
            System.out.println("  ✓ All products are adequately stocked");
        }
        System.out.println();
        
        // Demonstration 6: Find products with high stock
        System.out.println("═══ 6. High Stock Products (Quantity > 100) ═══");
        for (int i = 0; i < productQuantities.size(); i++) {
            if (productQuantities.get(i) > 100) {
                System.out.println("  • " + productNames.get(i) + ": " + productQuantities.get(i) + " units");
            }
        }
        System.out.println();
        
        // Demonstration 7: Add new products
        System.out.println("═══ 7. Adding New Products ═══");
        productNames.add("Webcam");
        productQuantities.add(60);
        System.out.println("Added Webcam with quantity: 60");
        
        displayInventory(productNames, productQuantities);
        System.out.println();
        
        // Demonstration 8: Simulate selling products (decrease quantity)
        System.out.println("═══ 8. Simulating Sales ═══");
        System.out.println("Selling 20 Laptops...");
        int laptopIndex = 0;
        int currentQuantity = productQuantities.get(laptopIndex);
        productQuantities.set(laptopIndex, currentQuantity - 20);
        
        System.out.println("Selling 30 Keyboards...");
        int keyboardIndex = 2;
        currentQuantity = productQuantities.get(keyboardIndex);
        productQuantities.set(keyboardIndex, currentQuantity - 30);
        
        displayInventory(productNames, productQuantities);
        System.out.println();
        
        // Demonstration 9: clear() - Clear all inventory (backup first)
        System.out.println("═══ 9. Creating Backup and Clearing Inventory ═══");
        ArrayList<Integer> backupQuantities = new ArrayList<>(productQuantities);
        ArrayList<String> backupNames = new ArrayList<>(productNames);
        
        System.out.println("Backup created. Size: " + backupQuantities.size());
        System.out.println("Clearing inventory...");
        
        productQuantities.clear();
        productNames.clear();
        
        System.out.println("Inventory cleared. Size: " + productQuantities.size());
        System.out.println();
        
        // Demonstration 10: Restore from backup
        System.out.println("═══ 10. Restoring from Backup ═══");
        productQuantities.addAll(backupQuantities);
        productNames.addAll(backupNames);
        
        System.out.println("Inventory restored. Size: " + productQuantities.size());
        displayInventory(productNames, productQuantities);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n📖 ARRAYLIST METHODS DEMONSTRATED:\n");
        System.out.println("• add(element): Adds new product quantity");
        System.out.println("• set(index, element): Updates quantity at specific position");
        System.out.println("• get(index): Retrieves quantity at specific position");
        System.out.println("• clear(): Removes all elements from the list");
        System.out.println("• size(): Returns number of products");
        System.out.println("• for-each loop: Iterates through all quantities");
        System.out.println("• addAll(): Adds all elements from another list");
        
        System.out.println("\n✓ Practical Applications:");
        System.out.println("  • Real-time inventory tracking");
        System.out.println("  • Automated reorder alerts");
        System.out.println("  • Sales analytics");
        System.out.println("  • Stock level monitoring");
    }
    
    // Helper method to display inventory
    private static void displayInventory(ArrayList<String> names, ArrayList<Integer> quantities) {
        System.out.println("Current Inventory:");
        System.out.println("-".repeat(40));
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("  %-15s : %4d units\n", names.get(i), quantities.get(i));
        }
        System.out.println("-".repeat(40));
        System.out.println("Total Products: " + names.size());
    }
}
