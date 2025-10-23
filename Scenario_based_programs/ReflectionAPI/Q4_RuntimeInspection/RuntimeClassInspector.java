// Runtime Class Inspector
// Demonstrates using Reflection API for debugging and logging class details

import java.lang.reflect.*;

public class RuntimeClassInspector {
    public static void main(String[] args) {
        try {
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║        RUNTIME CLASS INSPECTOR - Debugging Tool               ║");
            System.out.println("║        Using Java Reflection API                              ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
            
            // Dynamically load the class
            String className = "DebugSampleClass";
            System.out.println("Loading class: " + className + "...\n");
            Class<?> clazz = Class.forName(className);
            
            System.out.println("✓ Class loaded successfully!");
            System.out.println("Class Name: " + clazz.getName());
            System.out.println("Simple Name: " + clazz.getSimpleName());
            System.out.println("Package: " + clazz.getPackage());
            System.out.println("\n" + "=".repeat(70) + "\n");
            
            // Inspect all declared fields
            System.out.println("📋 DECLARED FIELDS:\n");
            Field[] fields = clazz.getDeclaredFields();
            
            if (fields.length == 0) {
                System.out.println("  No fields declared.");
            } else {
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    String modifiers = Modifier.toString(field.getModifiers());
                    String type = field.getType().getSimpleName();
                    String name = field.getName();
                    
                    System.out.printf("  %d. %-25s %-15s %s\n", 
                        (i + 1), 
                        modifiers.isEmpty() ? "default" : modifiers, 
                        type, 
                        name);
                }
            }
            
            System.out.println("\n  Total Fields: " + fields.length);
            System.out.println("\n" + "=".repeat(70) + "\n");
            
            // Inspect all declared methods
            System.out.println("🔧 DECLARED METHODS:\n");
            Method[] methods = clazz.getDeclaredMethods();
            
            if (methods.length == 0) {
                System.out.println("  No methods declared.");
            } else {
                for (int i = 0; i < methods.length; i++) {
                    Method method = methods[i];
                    String modifiers = Modifier.toString(method.getModifiers());
                    String returnType = method.getReturnType().getSimpleName();
                    String name = method.getName();
                    
                    // Get parameter types
                    Class<?>[] paramTypes = method.getParameterTypes();
                    StringBuilder params = new StringBuilder();
                    for (int j = 0; j < paramTypes.length; j++) {
                        params.append(paramTypes[j].getSimpleName());
                        if (j < paramTypes.length - 1) {
                            params.append(", ");
                        }
                    }
                    
                    System.out.printf("  %d. %-25s %-15s %s(%s)\n", 
                        (i + 1), 
                        modifiers.isEmpty() ? "default" : modifiers,
                        returnType,
                        name,
                        params.toString());
                }
            }
            
            System.out.println("\n  Total Methods: " + methods.length);
            System.out.println("\n" + "=".repeat(70) + "\n");
            
            // Inspect constructors
            System.out.println("🏗️  CONSTRUCTORS:\n");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            
            for (int i = 0; i < constructors.length; i++) {
                Constructor<?> constructor = constructors[i];
                String modifiers = Modifier.toString(constructor.getModifiers());
                
                Class<?>[] paramTypes = constructor.getParameterTypes();
                StringBuilder params = new StringBuilder();
                for (int j = 0; j < paramTypes.length; j++) {
                    params.append(paramTypes[j].getSimpleName());
                    if (j < paramTypes.length - 1) {
                        params.append(", ");
                    }
                }
                
                System.out.printf("  %d. %s %s(%s)\n", 
                    (i + 1),
                    modifiers,
                    clazz.getSimpleName(),
                    params.toString());
            }
            
            System.out.println("\n  Total Constructors: " + constructors.length);
            System.out.println("\n" + "=".repeat(70) + "\n");
            
            // Additional class information
            System.out.println("ℹ️  ADDITIONAL CLASS INFORMATION:\n");
            System.out.println("  Is Interface: " + clazz.isInterface());
            System.out.println("  Is Abstract: " + Modifier.isAbstract(clazz.getModifiers()));
            System.out.println("  Is Final: " + Modifier.isFinal(clazz.getModifiers()));
            System.out.println("  Superclass: " + clazz.getSuperclass().getSimpleName());
            
            System.out.println("\n" + "=".repeat(70) + "\n");
            
            // Explanation
            System.out.println("📖 HOW REFLECTION ENABLES RUNTIME INTROSPECTION:\n");
            System.out.println("1. Class Loading:");
            System.out.println("   → Class.forName() loads classes dynamically without compile-time reference");
            System.out.println();
            
            System.out.println("2. Structure Discovery:");
            System.out.println("   → getDeclaredFields() reveals all fields regardless of access modifier");
            System.out.println("   → getDeclaredMethods() exposes all methods including private ones");
            System.out.println("   → getDeclaredConstructors() shows all available constructors");
            System.out.println();
            
            System.out.println("3. Metadata Access:");
            System.out.println("   → getModifiers() provides access level information (public/private/etc)");
            System.out.println("   → getType() and getReturnType() reveal data types");
            System.out.println("   → getParameterTypes() shows method signatures");
            System.out.println();
            
            System.out.println("4. Use Cases:");
            System.out.println("   ✓ Debugging tools that inspect object state");
            System.out.println("   ✓ Logging frameworks that track method calls");
            System.out.println("   ✓ Testing frameworks that discover test methods");
            System.out.println("   ✓ Serialization libraries that access private fields");
            System.out.println("   ✓ Dependency injection containers that wire objects");
            System.out.println("   ✓ ORM frameworks that map objects to database tables");
            System.out.println();
            
            System.out.println("5. Advantages:");
            System.out.println("   ✓ Enables generic, reusable code that works with any class");
            System.out.println("   ✓ Allows runtime adaptation based on class structure");
            System.out.println("   ✓ Powers many popular Java frameworks (Spring, Hibernate, JUnit)");
            System.out.println("   ✓ Facilitates plugin architectures and extensibility");
            
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found - " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during inspection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
