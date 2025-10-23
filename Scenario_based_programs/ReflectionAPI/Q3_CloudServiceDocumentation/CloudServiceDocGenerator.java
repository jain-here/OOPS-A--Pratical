// Cloud Service Documentation Generator
// Uses Reflection to extract API endpoint information from annotated methods

import java.lang.reflect.Method;
import java.util.*;

public class CloudServiceDocGenerator {
    public static void main(String[] args) {
        try {
            Class<?> apiClass = UserAPI.class;
            
            System.out.println("╔════════════════════════════════════════════════════════════╗");
            System.out.println("║     CLOUD SERVICE PROVIDER - API DOCUMENTATION             ║");
            System.out.println("║     Auto-generated from Source Code                        ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝\n");
            
            System.out.println("Service: " + apiClass.getSimpleName());
            System.out.println("Generated: " + new Date());
            System.out.println("\n" + "=".repeat(70) + "\n");
            
            // Get all methods
            Method[] methods = apiClass.getDeclaredMethods();
            
            // Group endpoints by HTTP method
            Map<String, List<String>> endpointsByMethod = new TreeMap<>();
            
            int endpointCount = 0;
            for (Method method : methods) {
                if (method.isAnnotationPresent(APIInfo.class)) {
                    APIInfo apiInfo = method.getAnnotation(APIInfo.class);
                    endpointCount++;
                    
                    String httpMethod = apiInfo.method();
                    String endpoint = apiInfo.endpoint();
                    
                    endpointsByMethod
                        .computeIfAbsent(httpMethod, k -> new ArrayList<>())
                        .add(endpoint);
                }
            }
            
            // Display endpoints grouped by HTTP method
            System.out.println("AVAILABLE API ENDPOINTS:\n");
            
            for (Map.Entry<String, List<String>> entry : endpointsByMethod.entrySet()) {
                String httpMethod = entry.getKey();
                List<String> endpoints = entry.getValue();
                
                System.out.println("┌─ " + httpMethod + " Methods (" + endpoints.size() + ")");
                for (String endpoint : endpoints) {
                    System.out.println("│  → " + httpMethod + " " + endpoint);
                }
                System.out.println("└" + "─".repeat(65) + "\n");
            }
            
            // Display detailed endpoint information
            System.out.println("\n" + "=".repeat(70));
            System.out.println("DETAILED ENDPOINT DOCUMENTATION:\n");
            
            int index = 1;
            for (Method method : methods) {
                if (method.isAnnotationPresent(APIInfo.class)) {
                    APIInfo apiInfo = method.getAnnotation(APIInfo.class);
                    
                    System.out.println(index + ". Endpoint: " + apiInfo.endpoint());
                    System.out.println("   HTTP Method: " + apiInfo.method());
                    System.out.println("   Handler: " + method.getName() + "()");
                    
                    // Display parameters
                    Class<?>[] paramTypes = method.getParameterTypes();
                    System.out.print("   Parameters: ");
                    if (paramTypes.length == 0) {
                        System.out.println("None");
                    } else {
                        System.out.print("[");
                        for (int i = 0; i < paramTypes.length; i++) {
                            System.out.print(paramTypes[i].getSimpleName());
                            if (i < paramTypes.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                    }
                    
                    System.out.println("   Return Type: " + method.getReturnType().getSimpleName());
                    System.out.println();
                    index++;
                }
            }
            
            System.out.println("=".repeat(70));
            System.out.println("\nSUMMARY:");
            System.out.println("  • Total Endpoints: " + endpointCount);
            System.out.println("  • HTTP Methods Used: " + endpointsByMethod.keySet());
            System.out.println("  • Service Class: " + apiClass.getName());
            
            System.out.println("\n=== Benefits of Reflection-Based Documentation ===");
            System.out.println("✓ Documentation generated directly from code");
            System.out.println("✓ Always synchronized with actual implementation");
            System.out.println("✓ Reduces manual documentation effort");
            System.out.println("✓ Can be integrated into CI/CD pipelines");
            System.out.println("✓ Enables automatic API client generation");
            
        } catch (Exception e) {
            System.err.println("Error generating documentation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
