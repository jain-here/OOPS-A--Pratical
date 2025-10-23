// To-Do List Manager using ArrayList
// Demonstrates add(), remove(), get(), isEmpty(), and Collections.sort()

import java.util.ArrayList;
import java.util.Collections;

public class ToDoListManager {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              TO-DO LIST MANAGER                            ║");
        System.out.println("║              Using ArrayList Operations                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Create ArrayList for tasks
        ArrayList<String> todoList = new ArrayList<>();
        
        // Demonstration 1: add() - Add tasks
        System.out.println("═══ 1. Adding Tasks ═══");
        todoList.add("Complete Java assignment");
        todoList.add("Buy groceries");
        todoList.add("Read chapter 5 of textbook");
        todoList.add("Call dentist for appointment");
        todoList.add("Prepare presentation slides");
        todoList.add("Exercise for 30 minutes");
        
        displayTodoList(todoList);
        System.out.println();
        
        // Demonstration 2: get() - Retrieve task by index
        System.out.println("═══ 2. Accessing Specific Tasks (get method) ═══");
        System.out.println("First task: " + todoList.get(0));
        System.out.println("Third task: " + todoList.get(2));
        System.out.println("Last task: " + todoList.get(todoList.size() - 1));
        System.out.println();
        
        // Demonstration 3: Mark task as completed (remove)
        System.out.println("═══ 3. Marking Tasks as Completed (remove method) ═══");
        String completedTask1 = todoList.remove(1);  // Remove "Buy groceries"
        System.out.println("✓ Completed: " + completedTask1);
        
        String completedTask2 = "Exercise for 30 minutes";
        if (todoList.remove(completedTask2)) {
            System.out.println("✓ Completed: " + completedTask2);
        }
        
        displayTodoList(todoList);
        System.out.println();
        
        // Demonstration 4: isEmpty() - Check if list is empty
        System.out.println("═══ 4. Checking List Status (isEmpty method) ═══");
        System.out.println("Is the to-do list empty? " + todoList.isEmpty());
        System.out.println("Number of pending tasks: " + todoList.size());
        System.out.println();
        
        // Demonstration 5: Add more tasks
        System.out.println("═══ 5. Adding More Tasks ═══");
        todoList.add("Submit expense report");
        todoList.add("Attend team meeting at 3 PM");
        todoList.add("Review code for project");
        
        displayTodoList(todoList);
        System.out.println();
        
        // Demonstration 6: Sort tasks alphabetically
        System.out.println("═══ 6. Sorting Tasks Alphabetically (Collections.sort) ═══");
        System.out.println("Before sorting:");
        displayTodoList(todoList);
        
        Collections.sort(todoList);
        
        System.out.println("\nAfter sorting:");
        displayTodoList(todoList);
        System.out.println();
        
        // Demonstration 7: Search for a specific task
        System.out.println("═══ 7. Searching for Tasks ═══");
        String searchTask = "Complete Java assignment";
        int index = todoList.indexOf(searchTask);
        if (index != -1) {
            System.out.println("Found '" + searchTask + "' at position " + (index + 1));
        } else {
            System.out.println("Task '" + searchTask + "' not found");
        }
        
        String searchTask2 = "Buy groceries";
        if (todoList.contains(searchTask2)) {
            System.out.println("Task '" + searchTask2 + "' is in the list");
        } else {
            System.out.println("Task '" + searchTask2 + "' is not in the list (already completed)");
        }
        System.out.println();
        
        // Demonstration 8: Display tasks with priority numbers
        System.out.println("═══ 8. Tasks with Priority Numbers ═══");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println("Priority " + (i + 1) + ": " + todoList.get(i));
        }
        System.out.println();
        
        // Demonstration 9: Complete multiple tasks
        System.out.println("═══ 9. Completing Multiple Tasks ═══");
        System.out.println("Marking first 3 tasks as completed...");
        for (int i = 0; i < 3; i++) {
            String task = todoList.remove(0);  // Always remove first task
            System.out.println("✓ Completed: " + task);
        }
        
        displayTodoList(todoList);
        System.out.println();
        
        // Demonstration 10: Check if ready to clear all tasks
        System.out.println("═══ 10. Final Status Check ═══");
        if (todoList.isEmpty()) {
            System.out.println("🎉 Congratulations! All tasks completed!");
        } else {
            System.out.println("You still have " + todoList.size() + " pending task(s):");
            for (String task : todoList) {
                System.out.println("  • " + task);
            }
        }
        
        // Clear all remaining tasks
        System.out.println("\nCompleting all remaining tasks...");
        todoList.clear();
        System.out.println("All tasks completed!");
        System.out.println("Is the list empty now? " + todoList.isEmpty());
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n📖 ARRAYLIST METHODS DEMONSTRATED:\n");
        System.out.println("• add(element): Adds new task to the list");
        System.out.println("• remove(index): Removes task at specific position");
        System.out.println("• remove(object): Removes specific task");
        System.out.println("• get(index): Retrieves task at specific position");
        System.out.println("• isEmpty(): Checks if all tasks are completed");
        System.out.println("• size(): Returns number of pending tasks");
        System.out.println("• Collections.sort(): Sorts tasks alphabetically");
        System.out.println("• indexOf(): Finds position of a task");
        System.out.println("• contains(): Checks if task exists");
        System.out.println("• clear(): Removes all tasks");
        
        System.out.println("\n✓ Real-World Applications:");
        System.out.println("  • Task management applications");
        System.out.println("  • Project planning tools");
        System.out.println("  • Daily planner apps");
        System.out.println("  • Productivity trackers");
    }
    
    // Helper method to display the to-do list
    private static void displayTodoList(ArrayList<String> list) {
        System.out.println("📝 Current To-Do List:");
        System.out.println("-".repeat(60));
        if (list.isEmpty()) {
            System.out.println("  (No pending tasks)");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + list.get(i));
            }
        }
        System.out.println("-".repeat(60));
        System.out.println("Total tasks: " + list.size());
    }
}
