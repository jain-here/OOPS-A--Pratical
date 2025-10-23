// Validation Utility using Reflection
// Detects and reports empty values for fields annotated with @NotEmpty

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationUtility {
    
    // Validates an object for @NotEmpty constraints
    public static List<String> validate(Object obj) {
        List<String> warnings = new ArrayList<>();
        
        if (obj == null) {
            warnings.add("Cannot validate null object");
            return warnings;
        }
        
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotEmpty.class)) {
                NotEmpty annotation = field.getAnnotation(NotEmpty.class);
                
                try {
                    // Make field accessible to read private fields
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    
                    // Check if field is empty
                    boolean isEmpty = false;
                    if (value == null) {
                        isEmpty = true;
                    } else if (value instanceof String) {
                        isEmpty = ((String) value).trim().isEmpty();
                    }
                    
                    if (isEmpty) {
                        String warning = String.format("⚠ WARNING: Field '%s' - %s", 
                            field.getName(), 
                            annotation.message());
                        warnings.add(warning);
                    }
                    
                } catch (IllegalAccessException e) {
                    warnings.add("Error accessing field: " + field.getName());
                }
            }
        }
        
        return warnings;
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║   E-COMMERCE PLATFORM - CUSTOMER VALIDATION SYSTEM         ║");
        System.out.println("║   Using Custom @NotEmpty Annotation with Reflection       ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Test Case 1: Valid customer with all fields
        System.out.println("Test Case 1: Valid Customer");
        System.out.println("-".repeat(60));
        Customer validCustomer = new Customer(
            "John Doe",
            "john.doe@email.com",
            "+1-555-1234",
            "123 Main St, New York, NY"
        );
        validCustomer.setCustomerId(1001);
        validCustomer.setMembershipLevel("Gold");
        
        List<String> warnings1 = validate(validCustomer);
        if (warnings1.isEmpty()) {
            System.out.println("✓ Validation Passed: All required fields are filled");
            System.out.println("  Customer: " + validCustomer.getName());
            System.out.println("  Email: " + validCustomer.getEmail());
        } else {
            System.out.println("✗ Validation Failed:");
            warnings1.forEach(System.out::println);
        }
        System.out.println();
        
        // Test Case 2: Customer with empty name
        System.out.println("Test Case 2: Customer with Empty Name");
        System.out.println("-".repeat(60));
        Customer invalidCustomer1 = new Customer(
            "",  // Empty name
            "jane.smith@email.com",
            "+1-555-5678",
            "456 Oak Ave, Boston, MA"
        );
        
        List<String> warnings2 = validate(invalidCustomer1);
        if (warnings2.isEmpty()) {
            System.out.println("✓ Validation Passed");
        } else {
            System.out.println("✗ Validation Failed:");
            warnings2.forEach(System.out::println);
        }
        System.out.println();
        
        // Test Case 3: Customer with multiple empty fields
        System.out.println("Test Case 3: Customer with Multiple Empty Fields");
        System.out.println("-".repeat(60));
        Customer invalidCustomer2 = new Customer(
            "Alice Brown",
            "",      // Empty email
            "",      // Empty phone
            "789 Pine Rd, Chicago, IL"
        );
        
        List<String> warnings3 = validate(invalidCustomer2);
        if (warnings3.isEmpty()) {
            System.out.println("✓ Validation Passed");
        } else {
            System.out.println("✗ Validation Failed:");
            warnings3.forEach(System.out::println);
        }
        System.out.println();
        
        // Test Case 4: Customer with all empty fields
        System.out.println("Test Case 4: Customer with All Empty Fields");
        System.out.println("-".repeat(60));
        Customer invalidCustomer3 = new Customer("", "", "", "");
        
        List<String> warnings4 = validate(invalidCustomer3);
        if (warnings4.isEmpty()) {
            System.out.println("✓ Validation Passed");
        } else {
            System.out.println("✗ Validation Failed:");
            warnings4.forEach(System.out::println);
        }
        System.out.println();
        
        // Test Case 5: Customer with null fields
        System.out.println("Test Case 5: Customer with Null Fields");
        System.out.println("-".repeat(60));
        Customer invalidCustomer4 = new Customer(null, null, null, null);
        
        List<String> warnings5 = validate(invalidCustomer4);
        if (warnings5.isEmpty()) {
            System.out.println("✓ Validation Passed");
        } else {
            System.out.println("✗ Validation Failed:");
            warnings5.forEach(System.out::println);
        }
        System.out.println();
        
        System.out.println("=".repeat(60));
        System.out.println("\n📖 HOW REFLECTION-BASED VALIDATION WORKS:\n");
        System.out.println("1. The @NotEmpty annotation marks fields requiring validation");
        System.out.println("2. Reflection API scans all fields at runtime");
        System.out.println("3. For annotated fields, validation logic checks for empty values");
        System.out.println("4. Warnings are generated for constraint violations");
        System.out.println("5. This approach is used by frameworks like Hibernate Validator\n");
        
        System.out.println("✓ Benefits:");
        System.out.println("  • Declarative validation rules (annotation-based)");
        System.out.println("  • Centralized validation logic");
        System.out.println("  • Easy to extend with new validation types");
        System.out.println("  • Reduces boilerplate validation code");
        System.out.println("  • Consistent validation across the application");
    }
}
