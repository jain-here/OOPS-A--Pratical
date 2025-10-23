// Sample class for runtime inspection
// Demonstrates various fields and methods for reflection analysis

public class DebugSampleClass {
    // Fields with different access modifiers
    private String privateField = "Private Data";
    public int publicField = 100;
    protected double protectedField = 99.99;
    String defaultField = "Package-Private";
    
    private static final String CONSTANT = "CONSTANT_VALUE";
    
    // Constructor
    public DebugSampleClass() {
        System.out.println("DebugSampleClass instance created");
    }
    
    // Public method
    public void publicMethod() {
        System.out.println("Public method called");
    }
    
    // Private method
    private String privateMethod(String input) {
        return "Private: " + input;
    }
    
    // Protected method
    protected int protectedMethod(int a, int b) {
        return a + b;
    }
    
    // Package-private method
    void defaultMethod() {
        System.out.println("Default method called");
    }
    
    // Static method
    public static void staticMethod() {
        System.out.println("Static method called");
    }
    
    // Method with multiple parameters
    public String complexMethod(String str, int num, boolean flag) {
        return String.format("str=%s, num=%d, flag=%b", str, num, flag);
    }
    
    // Getter and Setter
    public String getPrivateField() {
        return privateField;
    }
    
    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }
}
