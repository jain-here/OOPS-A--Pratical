// Role-Based Access Control using Reflection
// Simulates checking access rights before method invocation

import java.lang.reflect.Method;

public class RoleBasedAccessControl {
    
    // Simulates the current user's role
    private static String currentUserRole = "USER";
    
    // Check if user has permission to invoke a method
    public static boolean checkAccess(Method method) {
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
            String requiredRole = annotation.role();
            
            if (currentUserRole.equals(requiredRole)) {
                return true;
            } else {
                System.out.println("❌ ACCESS DENIED: Method '" + method.getName() + 
                    "' requires role '" + requiredRole + 
                    "' but current user has role '" + currentUserRole + "'");
                return false;
            }
        }
        
        // Method without annotation is public (accessible to all)
        return true;
    }
    
    // Simulate method invocation with access check
    public static void invokeMethodSafely(UserService service, String methodName, Class<?>[] paramTypes, Object[] args) {
        try {
            Method method = UserService.class.getMethod(methodName, paramTypes);
            
            System.out.println("\n→ Attempting to invoke: " + methodName + "()");
            
            if (checkAccess(method)) {
                System.out.println("✓ ACCESS GRANTED");
                method.invoke(service, args);
            }
            
        } catch (Exception e) {
            System.out.println("Error invoking method: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║      ROLE-BASED ACCESS CONTROL SYSTEM                        ║");
        System.out.println("║      Using Custom @RoleAllowed Annotation                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");
        
        UserService service = new UserService();
        
        // Scenario 1: User with USER role
        System.out.println("═══ SCENARIO 1: User with 'USER' Role ═══");
        currentUserRole = "USER";
        System.out.println("Current User Role: " + currentUserRole + "\n");
        
        invokeMethodSafely(service, "viewProfile", new Class[]{int.class}, new Object[]{101});
        invokeMethodSafely(service, "updateProfile", new Class[]{int.class, String.class, String.class}, 
            new Object[]{101, "John Doe", "john@email.com"});
        invokeMethodSafely(service, "deleteUser", new Class[]{int.class}, new Object[]{999});
        invokeMethodSafely(service, "publicMethod", new Class[]{}, new Object[]{});
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Scenario 2: User with ADMIN role
        System.out.println("═══ SCENARIO 2: User with 'ADMIN' Role ═══");
        currentUserRole = "ADMIN";
        System.out.println("Current User Role: " + currentUserRole + "\n");
        
        invokeMethodSafely(service, "createUser", new Class[]{String.class, String.class}, 
            new Object[]{"alice", "alice@email.com"});
        invokeMethodSafely(service, "deleteUser", new Class[]{int.class}, new Object[]{999});
        invokeMethodSafely(service, "modifyUserPermissions", new Class[]{int.class, String.class}, 
            new Object[]{101, "READ,WRITE,DELETE"});
        invokeMethodSafely(service, "banUser", new Class[]{int.class, String.class}, 
            new Object[]{500, "Spam"});
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Scenario 3: User with MODERATOR role
        System.out.println("═══ SCENARIO 3: User with 'MODERATOR' Role ═══");
        currentUserRole = "MODERATOR";
        System.out.println("Current User Role: " + currentUserRole + "\n");
        
        invokeMethodSafely(service, "banUser", new Class[]{int.class, String.class}, 
            new Object[]{750, "Inappropriate content"});
        invokeMethodSafely(service, "reviewContent", new Class[]{int.class}, new Object[]{2345});
        invokeMethodSafely(service, "deleteUser", new Class[]{int.class}, new Object[]{888});
        invokeMethodSafely(service, "publicMethod", new Class[]{}, new Object[]{});
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // Display all methods with their required roles
        System.out.println("📋 METHOD ACCESS CONTROL LIST:\n");
        Method[] methods = UserService.class.getDeclaredMethods();
        
        for (Method method : methods) {
            String roleName = "PUBLIC (No restriction)";
            
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                roleName = annotation.role();
            }
            
            System.out.printf("  • %-30s → Required Role: %s\n", 
                method.getName() + "()", roleName);
        }
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n📖 HOW REFLECTION ENABLES ROLE-BASED ACCESS:\n");
        System.out.println("1. @RoleAllowed annotation marks methods with required roles");
        System.out.println("2. Before method invocation, reflection checks for annotation");
        System.out.println("3. Current user's role is compared with required role");
        System.out.println("4. Method is invoked only if access is granted");
        System.out.println("5. This pattern is used in enterprise frameworks like Spring Security\n");
        
        System.out.println("✓ Benefits:");
        System.out.println("  • Declarative security (annotation-based)");
        System.out.println("  • Centralized access control logic");
        System.out.println("  • Easy to audit which methods require which roles");
        System.out.println("  • Can be extended with multiple roles per method");
        System.out.println("  • Prevents unauthorized access at runtime");
    }
}
