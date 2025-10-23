// Calculator Test Class
// Contains test methods annotated with @TestCase

public class CalculatorTest {
    
    @TestCase(description = "Test addition of two positive numbers")
    public void testAddition() {
        int result = 5 + 3;
        int expected = 8;
        
        if (result == expected) {
            System.out.println("    ✓ PASSED: Addition test (5 + 3 = 8)");
        } else {
            System.out.println("    ✗ FAILED: Expected " + expected + " but got " + result);
        }
    }
    
    @TestCase(description = "Test subtraction of two numbers")
    public void testSubtraction() {
        int result = 10 - 4;
        int expected = 6;
        
        if (result == expected) {
            System.out.println("    ✓ PASSED: Subtraction test (10 - 4 = 6)");
        } else {
            System.out.println("    ✗ FAILED: Expected " + expected + " but got " + result);
        }
    }
    
    @TestCase(description = "Test multiplication of two numbers")
    public void testMultiplication() {
        int result = 7 * 6;
        int expected = 42;
        
        if (result == expected) {
            System.out.println("    ✓ PASSED: Multiplication test (7 × 6 = 42)");
        } else {
            System.out.println("    ✗ FAILED: Expected " + expected + " but got " + result);
        }
    }
    
    @TestCase(description = "Test division of two numbers")
    public void testDivision() {
        double result = 20.0 / 4.0;
        double expected = 5.0;
        
        if (result == expected) {
            System.out.println("    ✓ PASSED: Division test (20 ÷ 4 = 5)");
        } else {
            System.out.println("    ✗ FAILED: Expected " + expected + " but got " + result);
        }
    }
    
    @TestCase(description = "Test division by zero handling", enabled = false)
    public void testDivisionByZero() {
        try {
            int result = 10 / 0;
            System.out.println("    ✗ FAILED: Should have thrown ArithmeticException");
        } catch (ArithmeticException e) {
            System.out.println("    ✓ PASSED: Correctly threw ArithmeticException");
        }
    }
    
    @TestCase(description = "Test modulus operation")
    public void testModulus() {
        int result = 17 % 5;
        int expected = 2;
        
        if (result == expected) {
            System.out.println("    ✓ PASSED: Modulus test (17 % 5 = 2)");
        } else {
            System.out.println("    ✗ FAILED: Expected " + expected + " but got " + result);
        }
    }
    
    @TestCase(description = "Test negative number addition")
    public void testNegativeAddition() {
        int result = -5 + (-3);
        int expected = -8;
        
        if (result == expected) {
            System.out.println("    ✓ PASSED: Negative addition test (-5 + -3 = -8)");
        } else {
            System.out.println("    ✗ FAILED: Expected " + expected + " but got " + result);
        }
    }
    
    @TestCase(description = "Test zero multiplication")
    public void testZeroMultiplication() {
        int result = 100 * 0;
        int expected = 0;
        
        if (result == expected) {
            System.out.println("    ✓ PASSED: Zero multiplication test (100 × 0 = 0)");
        } else {
            System.out.println("    ✗ FAILED: Expected " + expected + " but got " + result);
        }
    }
    
    // Method without @TestCase annotation - should not be executed
    public void helperMethod() {
        System.out.println("This is a helper method, not a test case");
    }
}
