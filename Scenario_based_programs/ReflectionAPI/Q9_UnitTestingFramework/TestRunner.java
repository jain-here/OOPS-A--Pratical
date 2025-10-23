// Mini Testing Framework using Reflection
// Automatically discovers and executes methods annotated with @TestCase

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    
    private static class TestResult {
        String methodName;
        String description;
        boolean executed;
        boolean skipped;
        String skipReason;
        long executionTime;
        
        TestResult(String methodName, String description) {
            this.methodName = methodName;
            this.description = description;
            this.executed = false;
            this.skipped = false;
        }
    }
    
    public static void runTests(Class<?> testClass) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              MINI TESTING FRAMEWORK                            ║");
        System.out.println("║              Using @TestCase Annotation                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Running tests from: " + testClass.getSimpleName());
        System.out.println("=".repeat(70) + "\n");
        
        List<TestResult> results = new ArrayList<>();
        int passed = 0;
        int failed = 0;
        int skipped = 0;
        long totalTime = 0;
        
        try {
            // Create an instance of the test class
            Object testInstance = testClass.getDeclaredConstructor().newInstance();
            
            // Get all methods
            Method[] methods = testClass.getDeclaredMethods();
            
            // Find and execute test methods
            int testNumber = 0;
            for (Method method : methods) {
                if (method.isAnnotationPresent(TestCase.class)) {
                    testNumber++;
                    TestCase annotation = method.getAnnotation(TestCase.class);
                    TestResult result = new TestResult(method.getName(), annotation.description());
                    
                    // Check if test is enabled
                    if (!annotation.enabled()) {
                        result.skipped = true;
                        result.skipReason = "Test disabled";
                        skipped++;
                        
                        System.out.println(testNumber + ". " + method.getName() + "()");
                        System.out.println("   Description: " + annotation.description());
                        System.out.println("   ⊘ SKIPPED: Test is disabled");
                        System.out.println();
                        
                        results.add(result);
                        continue;
                    }
                    
                    System.out.println(testNumber + ". " + method.getName() + "()");
                    System.out.println("   Description: " + annotation.description());
                    
                    try {
                        long startTime = System.nanoTime();
                        method.invoke(testInstance);
                        long endTime = System.nanoTime();
                        
                        result.executed = true;
                        result.executionTime = (endTime - startTime) / 1_000_000; // Convert to milliseconds
                        totalTime += result.executionTime;
                        passed++;
                        
                        System.out.println("   Execution Time: " + result.executionTime + " ms");
                        
                    } catch (Exception e) {
                        failed++;
                        System.out.println("    ✗ EXCEPTION: " + e.getCause().getClass().getSimpleName());
                        System.out.println("    Message: " + e.getCause().getMessage());
                    }
                    
                    System.out.println();
                    results.add(result);
                }
            }
            
            // Print summary
            System.out.println("=".repeat(70));
            System.out.println("\n📊 TEST EXECUTION SUMMARY\n");
            System.out.println("Total Tests Found: " + (passed + failed + skipped));
            System.out.println("Tests Executed: " + (passed + failed));
            System.out.println("  ✓ Passed: " + passed);
            System.out.println("  ✗ Failed: " + failed);
            System.out.println("  ⊘ Skipped: " + skipped);
            System.out.println("\nTotal Execution Time: " + totalTime + " ms");
            
            // Calculate success rate
            if (passed + failed > 0) {
                double successRate = (passed * 100.0) / (passed + failed);
                System.out.println("Success Rate: " + String.format("%.2f", successRate) + "%");
            }
            
            // List all tests
            System.out.println("\n" + "=".repeat(70));
            System.out.println("\n📋 DETAILED TEST LIST\n");
            
            int index = 1;
            for (TestResult result : results) {
                String status = result.skipped ? "⊘ SKIPPED" : 
                               result.executed ? "✓ EXECUTED" : "✗ FAILED";
                
                System.out.printf("%d. %-30s [%s]\n", index++, result.methodName + "()", status);
                System.out.println("   Description: " + result.description);
                if (result.executed) {
                    System.out.println("   Time: " + result.executionTime + " ms");
                }
                if (result.skipped) {
                    System.out.println("   Reason: " + result.skipReason);
                }
                System.out.println();
            }
            
        } catch (Exception e) {
            System.err.println("Error running tests: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("=".repeat(70));
        System.out.println("\n📖 HOW THE TESTING FRAMEWORK WORKS:\n");
        System.out.println("1. @TestCase annotation marks methods as test cases");
        System.out.println("2. TestRunner uses reflection to discover annotated methods");
        System.out.println("3. Each test method is invoked automatically");
        System.out.println("4. Execution time and results are tracked");
        System.out.println("5. Tests can be enabled/disabled via annotation property\n");
        
        System.out.println("✓ Benefits:");
        System.out.println("  • Automatic test discovery (no manual registration)");
        System.out.println("  • Declarative test configuration via annotations");
        System.out.println("  • Easy to add new tests (just annotate the method)");
        System.out.println("  • Similar to JUnit's @Test annotation");
        System.out.println("  • Can be extended with more features (@Before, @After, etc.)");
        
        System.out.println("\n✓ Real-World Testing Frameworks Using This Pattern:");
        System.out.println("  • JUnit (uses @Test, @Before, @After annotations)");
        System.out.println("  • TestNG (uses @Test, @BeforeMethod annotations)");
        System.out.println("  • Mockito (uses reflection for mocking)");
        System.out.println("  • Spring Test (uses @SpringBootTest, @WebMvcTest)");
    }
    
    public static void main(String[] args) {
        runTests(CalculatorTest.class);
    }
}
