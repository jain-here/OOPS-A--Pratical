// Version Tracker using Reflection
// Retrieves and displays version information from classes

public class VersionTracker {
    
    public static void displayVersionInfo(Class<?> clazz) {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              VERSION INFORMATION                           ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        if (clazz.isAnnotationPresent(Version.class)) {
            Version versionInfo = clazz.getAnnotation(Version.class);
            
            System.out.println("Class: " + clazz.getSimpleName());
            System.out.println("Full Name: " + clazz.getName());
            System.out.println("-".repeat(60));
            System.out.println("Version Number: " + versionInfo.number());
            System.out.println("Release Date: " + versionInfo.releaseDate());
            System.out.println("Author: " + versionInfo.author());
            System.out.println("-".repeat(60));
            
            // Additional class information
            System.out.println("\nAdditional Information:");
            System.out.println("  • Package: " + (clazz.getPackage() != null ? clazz.getPackage().getName() : "default"));
            System.out.println("  • Methods: " + clazz.getDeclaredMethods().length);
            System.out.println("  • Fields: " + clazz.getDeclaredFields().length);
            System.out.println("  • Constructors: " + clazz.getDeclaredConstructors().length);
            
        } else {
            System.out.println("❌ No version information available for class: " + clazz.getSimpleName());
            System.out.println("The class is not annotated with @Version");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║        SOFTWARE VERSION TRACKING SYSTEM                      ║");
        System.out.println("║        Using @Version Annotation with Reflection             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        // Display version information for ReportGenerator class
        displayVersionInfo(ReportGenerator.class);
        
        // Create an instance and test functionality
        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("TESTING REPORT GENERATOR FUNCTIONALITY");
        System.out.println("=".repeat(60) + "\n");
        
        ReportGenerator generator = new ReportGenerator();
        
        System.out.println("Test 1: Sales Report");
        System.out.println("-".repeat(60));
        generator.generateSalesReport("Q4 2025");
        
        System.out.println("\nTest 2: Inventory Report");
        System.out.println("-".repeat(60));
        generator.generateInventoryReport();
        
        System.out.println("\nTest 3: Financial Report");
        System.out.println("-".repeat(60));
        generator.generateFinancialReport("3");
        
        System.out.println("\nTest 4: Export Operations");
        System.out.println("-".repeat(60));
        System.out.println(generator.exportToPDF("Monthly_Sales_Report"));
        System.out.println(generator.exportToExcel("Inventory_Summary"));
        
        // Version comparison example
        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("VERSION HISTORY");
        System.out.println("=".repeat(60) + "\n");
        
        System.out.println("Version 1.0 (2025-08-01):");
        System.out.println("  • Initial release");
        System.out.println("  • Basic report generation");
        
        System.out.println("\nVersion 1.1 (2025-09-15):");
        System.out.println("  • Added PDF export functionality");
        System.out.println("  • Improved report formatting");
        
        System.out.println("\nVersion 1.2 (2025-10-15) [CURRENT]:");
        System.out.println("  • Added Excel export functionality");
        System.out.println("  • Enhanced financial reporting");
        System.out.println("  • Performance optimizations");
        
        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("\n📖 HOW REFLECTION-BASED VERSION TRACKING WORKS:\n");
        System.out.println("1. @Version annotation embeds version metadata in the class");
        System.out.println("2. Reflection API reads the annotation at runtime");
        System.out.println("3. Version information is displayed without hardcoding");
        System.out.println("4. Easy to track which version of a class is running\n");
        
        System.out.println("✓ Benefits:");
        System.out.println("  • Version information lives with the code");
        System.out.println("  • Can be extracted programmatically for reports");
        System.out.println("  • Helps in debugging and support");
        System.out.println("  • Useful for dependency management");
        System.out.println("  • Can verify compatibility at runtime");
        System.out.println("  • Assists in rolling back to previous versions");
        
        System.out.println("\n✓ Real-World Applications:");
        System.out.println("  • API versioning in microservices");
        System.out.println("  • Library version management");
        System.out.println("  • Plugin systems with version requirements");
        System.out.println("  • Software update mechanisms");
        System.out.println("  • License management based on versions");
    }
}
