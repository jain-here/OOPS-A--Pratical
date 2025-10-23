// Generic Box class for college project utility library
// Demonstrates type safety and code reusability with generics

class Box<T> {
    private T content;
    
    // Set method
    public void set(T content) {
        this.content = content;
    }
    
    // Get method
    public T get() {
        return content;
    }
    
    // Display method
    public void display() {
        if (content != null) {
            System.out.println("Box contains: " + content + " (Type: " + content.getClass().getSimpleName() + ")");
        } else {
            System.out.println("Box is empty");
        }
    }
}

public class GenericBoxDemo {
    
    // Generic method to compare two boxes
    public static <T> boolean compareBoxes(Box<T> b1, Box<T> b2) {
        if (b1.get() == null && b2.get() == null) {
            return true;
        }
        if (b1.get() == null || b2.get() == null) {
            return false;
        }
        return b1.get().equals(b2.get());
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║        GENERIC BOX UTILITY LIBRARY                         ║");
        System.out.println("║        Demonstrating Type Safety and Reusability           ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Test 1: Box with Integer
        System.out.println("═══ Test 1: Box<Integer> ═══");
        Box<Integer> intBox1 = new Box<>();
        Box<Integer> intBox2 = new Box<>();
        
        intBox1.set(100);
        intBox2.set(100);
        
        intBox1.display();
        intBox2.display();
        System.out.println("Are both boxes equal? " + compareBoxes(intBox1, intBox2));
        
        intBox2.set(200);
        intBox2.display();
        System.out.println("Are both boxes equal now? " + compareBoxes(intBox1, intBox2));
        System.out.println();
        
        // Test 2: Box with Double
        System.out.println("═══ Test 2: Box<Double> ═══");
        Box<Double> doubleBox1 = new Box<>();
        Box<Double> doubleBox2 = new Box<>();
        
        doubleBox1.set(99.99);
        doubleBox2.set(99.99);
        
        doubleBox1.display();
        doubleBox2.display();
        System.out.println("Are both boxes equal? " + compareBoxes(doubleBox1, doubleBox2));
        System.out.println();
        
        // Test 3: Box with String
        System.out.println("═══ Test 3: Box<String> ═══");
        Box<String> stringBox1 = new Box<>();
        Box<String> stringBox2 = new Box<>();
        
        stringBox1.set("Hello Java");
        stringBox2.set("Hello Java");
        
        stringBox1.display();
        stringBox2.display();
        System.out.println("Are both boxes equal? " + compareBoxes(stringBox1, stringBox2));
        
        stringBox2.set("Hello World");
        stringBox2.display();
        System.out.println("Are both boxes equal now? " + compareBoxes(stringBox1, stringBox2));
        System.out.println();
        
        // Test 4: Box with custom object
        System.out.println("═══ Test 4: Box<Student> ═══");
        class Student {
            String name;
            int rollNo;
            
            Student(String name, int rollNo) {
                this.name = name;
                this.rollNo = rollNo;
            }
            
            @Override
            public String toString() {
                return name + " (Roll No: " + rollNo + ")";
            }
            
            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Student) {
                    Student s = (Student) obj;
                    return this.rollNo == s.rollNo;
                }
                return false;
            }
        }
        
        Box<Student> studentBox1 = new Box<>();
        Box<Student> studentBox2 = new Box<>();
        
        studentBox1.set(new Student("Alice", 101));
        studentBox2.set(new Student("Alice", 101));
        
        studentBox1.display();
        studentBox2.display();
        System.out.println("Are both boxes equal? " + compareBoxes(studentBox1, studentBox2));
        System.out.println();
        
        // Test 5: Empty boxes
        System.out.println("═══ Test 5: Empty Boxes ═══");
        Box<String> emptyBox1 = new Box<>();
        Box<String> emptyBox2 = new Box<>();
        
        emptyBox1.display();
        emptyBox2.display();
        System.out.println("Are both empty boxes equal? " + compareBoxes(emptyBox1, emptyBox2));
        System.out.println();
        
        System.out.println("=".repeat(60));
        System.out.println("\n📖 HOW GENERICS PROMOTE TYPE SAFETY AND REUSABILITY:\n");
        System.out.println("1. TYPE SAFETY:");
        System.out.println("   • Compile-time type checking prevents runtime errors");
        System.out.println("   • No need for explicit type casting");
        System.out.println("   • Eliminates ClassCastException at runtime");
        System.out.println();
        System.out.println("2. CODE REUSABILITY:");
        System.out.println("   • Single Box<T> class works with any type");
        System.out.println("   • No need to create IntegerBox, StringBox, etc.");
        System.out.println("   • Generic method compareBoxes() works with any type");
        System.out.println();
        System.out.println("3. BENEFITS:");
        System.out.println("   ✓ Eliminates code duplication");
        System.out.println("   ✓ Stronger type checking at compile time");
        System.out.println("   ✓ Enables algorithms to work with different types");
        System.out.println("   ✓ Improves code readability and maintainability");
    }
}
