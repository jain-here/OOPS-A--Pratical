import java.util.Scanner;

/*
1. Divide by Zero
Write a program that takes two numbers from the user and divides them. 
Handle the case when the denominator is zero using exception handling.
*/

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Attempt to divide the two numbers
            int result = numerator / denominator;

            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            // Handle the case where the denominator is zero
            System.out.println("Error: Cannot divide by zero.");
        } catch (Exception e) {
            // Handle other potential exceptions, like non-integer input
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Close the scanner to prevent resource leaks
            scanner.close();
        }
    }
}
