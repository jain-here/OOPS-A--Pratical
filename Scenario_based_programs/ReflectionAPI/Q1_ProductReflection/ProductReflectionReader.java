// Reflection Reader for Product class
// Demonstrates how to use Reflection API to dynamically load class,
// instantiate object, and invoke methods at runtime

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ProductReflectionReader {
    public static void main(String[] args) {
        try {
            // Step 1: Load the class dynamically using Reflection
            System.out.println("Step 1: Loading the Product class using Reflection...");
            Class<?> productClass = Class.forName("Product");
            System.out.println("Class loaded: " + productClass.getName());
            System.out.println();

            // Step 2: Get the default constructor
            System.out.println("Step 2: Getting the default constructor...");
            Constructor<?> constructor = productClass.getDeclaredConstructor();
            System.out.println("Constructor found: " + constructor);
            System.out.println();

            // Step 3: Create an instance of Product using reflection
            System.out.println("Step 3: Creating an instance of Product...");
            Object productInstance = constructor.newInstance();
            System.out.println("Instance created: " + productInstance.getClass().getName());
            System.out.println();

            // Step 4: Set values using setter methods
            System.out.println("Step 4: Setting product details using reflection...");
            Method setNameMethod = productClass.getMethod("setProductName", String.class);
            Method setPriceMethod = productClass.getMethod("setPrice", double.class);
            Method setQuantityMethod = productClass.getMethod("setQuantity", int.class);
            
            setNameMethod.invoke(productInstance, "Laptop");
            setPriceMethod.invoke(productInstance, 899.99);
            setQuantityMethod.invoke(productInstance, 15);
            System.out.println("Product details set successfully!");
            System.out.println();

            // Step 5: Invoke the showDetails() method dynamically
            System.out.println("Step 5: Invoking showDetails() method using reflection...");
            Method showDetailsMethod = productClass.getMethod("showDetails");
            showDetailsMethod.invoke(productInstance);
            System.out.println();

            // Step 6: Display all methods of the class
            System.out.println("Step 6: Listing all methods of Product class:");
            Method[] methods = productClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("  - " + method.getName() + "()");
            }
            System.out.println();

            System.out.println("=== Explanation ===");
            System.out.println("Reflection enables runtime introspection and manipulation of classes.");
            System.out.println("We successfully loaded the Product class, created an instance,");
            System.out.println("set its properties, and invoked the showDetails() method");
            System.out.println("all dynamically at runtime without direct class references!");

        } catch (Exception e) {
            System.err.println("Error occurred during reflection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
