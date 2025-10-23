// Student Name Management System using ArrayList
// Demonstrates add(), add(index, element), remove(), contains(), and size() methods

import java.util.ArrayList;

public class StudentNameManager {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║        STUDENT NAME MANAGEMENT SYSTEM                      ║");
        System.out.println("║        Using ArrayList Methods                             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Create ArrayList to store student names
        ArrayList<String> students = new ArrayList<>();
        
        // Demonstration 1: add() method - Add students to the end
        System.out.println("═══ 1. Adding Students (add method) ═══");
        students.add("Alice Johnson");
        students.add("Bob Smith");
        students.add("Charlie Brown");
        students.add("Diana Prince");
        
        System.out.println("Students added: " + students);
        System.out.println("Total students: " + students.size());
        System.out.println();
        
        // Demonstration 2: add(index, element) - Insert at specific position
        System.out.println("═══ 2. Inserting at Specific Index ═══");
        System.out.println("Inserting 'Eve Wilson' at index 2...");
        students.add(2, "Eve Wilson");
        
        System.out.println("After insertion: " + students);
        System.out.println("Total students: " + students.size());
        System.out.println();
        
        // Demonstration 3: contains() - Check if student exists
        System.out.println("═══ 3. Checking Student Presence (contains method) ═══");
        String searchName1 = "Bob Smith";
        String searchName2 = "John Doe";
        
        System.out.println("Is '" + searchName1 + "' in the list? " + students.contains(searchName1));
        System.out.println("Is '" + searchName2 + "' in the list? " + students.contains(searchName2));
        System.out.println();
        
        // Demonstration 4: get() - Access student by index
        System.out.println("═══ 4. Accessing Students by Index ═══");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Student at index " + i + ": " + students.get(i));
        }
        System.out.println();
        
        // Demonstration 5: remove() - Remove a student
        System.out.println("═══ 5. Removing Students ═══");
        String removedStudent = students.remove(1);  // Remove by index
        System.out.println("Removed student at index 1: " + removedStudent);
        System.out.println("List after removal: " + students);
        
        boolean removed = students.remove("Diana Prince");  // Remove by object
        System.out.println("Removed 'Diana Prince': " + removed);
        System.out.println("List after removal: " + students);
        System.out.println("Total students: " + students.size());
        System.out.println();
        
        // Demonstration 6: Display all students
        System.out.println("═══ 6. Final Student List ═══");
        System.out.println("Current students in the class:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + students.get(i));
        }
        System.out.println("\nTotal number of students: " + students.size());
        
        // Additional operations
        System.out.println("\n═══ 7. Additional Operations ═══");
        
        // Check if list is empty
        System.out.println("Is the list empty? " + students.isEmpty());
        
        // Get first and last students
        if (!students.isEmpty()) {
            System.out.println("First student: " + students.get(0));
            System.out.println("Last student: " + students.get(students.size() - 1));
        }
        
        // indexOf() - Find position of a student
        String findStudent = "Eve Wilson";
        int position = students.indexOf(findStudent);
        if (position != -1) {
            System.out.println("Position of '" + findStudent + "': " + position);
        } else {
            System.out.println("'" + findStudent + "' not found in the list");
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n📖 ARRAYLIST METHODS DEMONSTRATED:\n");
        System.out.println("• add(element): Adds element to the end of the list");
        System.out.println("• add(index, element): Inserts element at specified position");
        System.out.println("• remove(index): Removes element at specified position");
        System.out.println("• remove(object): Removes first occurrence of the object");
        System.out.println("• contains(object): Checks if element exists in the list");
        System.out.println("• size(): Returns the number of elements");
        System.out.println("• get(index): Retrieves element at specified position");
        System.out.println("• isEmpty(): Checks if list is empty");
        System.out.println("• indexOf(object): Returns the position of the element");
        
        System.out.println("\n✓ Benefits of ArrayList:");
        System.out.println("  • Dynamic sizing (grows as needed)");
        System.out.println("  • Fast random access by index");
        System.out.println("  • Easy to use with many built-in methods");
        System.out.println("  • Type-safe with generics");
    }
}
