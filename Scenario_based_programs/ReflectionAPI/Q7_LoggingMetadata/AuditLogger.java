// Audit Logger using Reflection
// Automatically logs method calls based on @Loggable annotation

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditLogger {
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    // Log and invoke a method if it has @Loggable annotation
    public static Object invokeWithLogging(Object target, String methodName, Class<?>[] paramTypes, Object[] args) {
        try {
            Method method = target.getClass().getMethod(methodName, paramTypes);
            
            // Check if method has @Loggable annotation
            if (method.isAnnotationPresent(Loggable.class)) {
                Loggable annotation = method.getAnnotation(Loggable.class);
                
                // Print log message before execution
                String timestamp = dateFormat.format(new Date());
                System.out.println("\n[" + timestamp + "] AUDIT LOG");
                System.out.println("Message: " + annotation.message());
                System.out.println("Method: " + methodName + "()");
                System.out.println("User: System Admin");  // Could be dynamic
                System.out.println("Status: Executing...");
                System.out.println("-".repeat(60));
            }
            
            // Invoke the actual method
            Object result = method.invoke(target, args);
            
            // Log completion if method was loggable
            if (method.isAnnotationPresent(Loggable.class)) {
                System.out.println("-".repeat(60));
                System.out.println("Status: Completed successfully");
                System.out.println();
            }
            
            return result;
            
        } catch (Exception e) {
            System.err.println("Error invoking method: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║        BANKING SYSTEM - AUDIT LOGGING FRAMEWORK                ║");
        System.out.println("║        Using @Loggable Annotation with Reflection             ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        AccountService service = new AccountService();
        
        System.out.println("\n════════════════ Banking Operations ════════════════\n");
        
        // Test various banking operations with automatic logging
        invokeWithLogging(service, "deposit", 
            new Class[]{String.class, double.class}, 
            new Object[]{"ACC123456", 500.00});
        
        invokeWithLogging(service, "withdraw", 
            new Class[]{String.class, double.class}, 
            new Object[]{"ACC123456", 200.00});
        
        invokeWithLogging(service, "transfer", 
            new Class[]{String.class, String.class, double.class}, 
            new Object[]{"ACC123456", "ACC789012", 300.00});
        
        invokeWithLogging(service, "checkBalance", 
            new Class[]{String.class}, 
            new Object[]{"ACC123456"});
        
        invokeWithLogging(service, "calculateInterest", 
            new Class[]{String.class, double.class}, 
            new Object[]{"ACC123456", 3.5});
        
        invokeWithLogging(service, "closeAccount", 
            new Class[]{String.class, String.class}, 
            new Object[]{"ACC987654", "Customer request"});
        
        // Method without @Loggable annotation
        System.out.println("\n[Method without @Loggable annotation]");
        System.out.println("-".repeat(60));
        invokeWithLogging(service, "internalCheck", 
            new Class[]{}, 
            new Object[]{});
        System.out.println("-".repeat(60));
        
        // Display all loggable methods
        System.out.println("\n\n════════════════ Audit Configuration ════════════════\n");
        System.out.println("Methods configured for audit logging:\n");
        
        Method[] methods = AccountService.class.getDeclaredMethods();
        int loggableCount = 0;
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Loggable.class)) {
                loggableCount++;
                Loggable annotation = method.getAnnotation(Loggable.class);
                System.out.printf("%d. %-25s - %s\n", 
                    loggableCount, 
                    method.getName() + "()", 
                    annotation.message());
            }
        }
        
        System.out.println("\nTotal loggable methods: " + loggableCount);
        System.out.println("Total methods: " + methods.length);
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n📖 HOW REFLECTION-BASED LOGGING WORKS:\n");
        System.out.println("1. @Loggable annotation marks methods requiring audit logs");
        System.out.println("2. Before method execution, reflection checks for annotation");
        System.out.println("3. If present, audit log is written with timestamp and details");
        System.out.println("4. Method executes normally");
        System.out.println("5. Completion status is logged after execution\n");
        
        System.out.println("✓ Benefits:");
        System.out.println("  • Declarative audit logging (annotation-based)");
        System.out.println("  • No code clutter in business logic");
        System.out.println("  • Centralized logging mechanism");
        System.out.println("  • Easy to enable/disable logging per method");
        System.out.println("  • Meets compliance requirements (SOX, PCI-DSS)");
        System.out.println("  • Similar to Spring AOP @Audited functionality");
        
        System.out.println("\n✓ Use Cases:");
        System.out.println("  • Banking transactions (deposits, withdrawals, transfers)");
        System.out.println("  • Healthcare systems (patient record access)");
        System.out.println("  • E-commerce (order processing, payment handling)");
        System.out.println("  • Government systems (citizen data access)");
        System.out.println("  • Any system requiring audit trails for compliance");
    }
}
