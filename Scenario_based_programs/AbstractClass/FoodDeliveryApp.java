/*
Scenario: Online Food Delivery App

You are designing a system for a food delivery app (like Zomato or Swiggy).
Create an abstract class FoodOrder with:
- Abstract method calculateTotal()
- Concrete method generateBill() that prints the bill.
Subclasses: RestaurantOrder (ordered from a restaurant) and CloudKitchenOrder (from a cloud kitchen).
*/

// Abstract class representing a generic food order
abstract class FoodOrder {
    protected double itemPrice;
    protected double deliveryCharge;

    public FoodOrder(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    // 1. Which methods should be abstract and why?
    // `calculateTotal()` should be abstract because the logic for calculating the total
    // bill can vary significantly between different types of orders. For example,
    // a restaurant might have taxes and service charges, while a cloud kitchen
    // might have different pricing structures or delivery fees. Making it abstract
    // forces each subclass to provide its own specific implementation.
    public abstract double calculateTotal();

    // 3. What common features will stay in the abstract class?
    // Common features like generating the final bill, which follows a standard
    // format, can be kept in the abstract class. The `generateBill()` method
    // uses the result from the abstract `calculateTotal()` method, ensuring that
    // the final bill is always displayed in a consistent way, regardless of
    // how the total was calculated.
    public void generateBill() {
        System.out.println("--- Generating Bill ---");
        System.out.println("Item Price: $" + itemPrice);
        System.out.println("Total Bill: $" + calculateTotal());
        System.out.println("-----------------------");
    }
}

// Subclass for orders from a traditional restaurant
class RestaurantOrder extends FoodOrder {
    private double serviceTax; // Unique to restaurant orders

    public RestaurantOrder(double itemPrice, double deliveryCharge, double serviceTax) {
        super(itemPrice);
        this.deliveryCharge = deliveryCharge;
        this.serviceTax = serviceTax;
    }

    // 2. How will you handle the fact that both orders calculate the bill differently?
    // By implementing the `calculateTotal()` method in each subclass.
    // The `RestaurantOrder` includes a service tax in its calculation,
    // whereas the `CloudKitchenOrder` might have a simpler calculation.
    // This allows each class to have its own unique logic for bill calculation.
    @Override
    public double calculateTotal() {
        return itemPrice + deliveryCharge + serviceTax;
    }
}

// Subclass for orders from a cloud kitchen
class CloudKitchenOrder extends FoodOrder {

    public CloudKitchenOrder(double itemPrice, double deliveryCharge) {
        super(itemPrice);
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    public double calculateTotal() {
        // Cloud kitchens might have a simpler pricing model without extra taxes
        return itemPrice + deliveryCharge;
    }
}

// Main class to demonstrate the concept
public class FoodDeliveryApp {
    public static void main(String[] args) {
        System.out.println("Processing a Restaurant Order:");
        FoodOrder restaurantOrder = new RestaurantOrder(500, 50, 25);
        restaurantOrder.generateBill();

        System.out.println("\nProcessing a Cloud Kitchen Order:");
        FoodOrder cloudKitchenOrder = new CloudKitchenOrder(300, 40);
        cloudKitchenOrder.generateBill();
    }
}
