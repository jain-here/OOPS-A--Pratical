// Reflection Reader for APIDescription annotation
// Demonstrates how to read custom annotations using Reflection API

import java.lang.reflect.Method;

public class APIDocumentationReader {
    public static void main(String[] args) {
        try {
            // Load the class
            Class<?> clazz = AuthenticationService.class;
            
            System.out.println("=== API Documentation Generator ===");
            System.out.println("Organization: Tech Solutions Inc.");
            System.out.println("Purpose: Extract embedded API documentation from source code\n");
            
            // Check if class has APIDescription annotation
            if (clazz.isAnnotationPresent(APIDescription.class)) {
                APIDescription classAnnotation = clazz.getAnnotation(APIDescription.class);
                System.out.println("Class: " + clazz.getSimpleName());
                System.out.println("Description: " + classAnnotation.description());
                System.out.println("\n" + "=".repeat(60) + "\n");
            }
            
            // Get all methods and check for APIDescription annotation
            System.out.println("Available API Methods:\n");
            Method[] methods = clazz.getDeclaredMethods();
            int methodCount = 0;
            
            for (Method method : methods) {
                if (method.isAnnotationPresent(APIDescription.class)) {
                    methodCount++;
                    APIDescription methodAnnotation = method.getAnnotation(APIDescription.class);
                    
                    System.out.println("Method #" + methodCount + ": " + method.getName() + "()");
                    System.out.println("Description: " + methodAnnotation.description());
                    
                    // Display parameter types
                    System.out.print("Parameters: ");
                    Class<?>[] paramTypes = method.getParameterTypes();
                    if (paramTypes.length == 0) {
                        System.out.println("None");
                    } else {
                        for (int i = 0; i < paramTypes.length; i++) {
                            System.out.print(paramTypes[i].getSimpleName());
                            if (i < paramTypes.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println();
                    }
                    
                    // Display return type
                    System.out.println("Return Type: " + method.getReturnType().getSimpleName());
                    System.out.println("-".repeat(60));
                }
            }
            
            System.out.println("\nTotal API Methods Documented: " + methodCount);
            
            System.out.println("\n=== Benefits of Annotation-Based Documentation ===");
            System.out.println("1. Documentation lives with the code (always in sync)");
            System.out.println("2. Can be extracted programmatically for tooling");
            System.out.println("3. Improves code maintainability and readability");
            System.out.println("4. Enables automated documentation generation");
            System.out.println("5. Reduces documentation drift from implementation");
            
        } catch (Exception e) {
            System.err.println("Error reading annotations: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
