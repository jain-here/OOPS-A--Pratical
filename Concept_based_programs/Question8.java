// Program to perform arithmetic operations
package first_project;
import java.util.Scanner;

public class Question8 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter two numbers: ");
	        double a = sc.nextDouble();
	        double b = sc.nextDouble();

	        System.out.println("Addition: " + (a + b));
	        System.out.println("Subtraction: " + (a - b));
	        System.out.println("Multiplication: " + (a * b));
	        System.out.println("Division: " + (b != 0 ? a / b : "Cannot divide by zero"));
	        System.out.println("Modulus: " + (b != 0 ? a % b : "Cannot divide by zero"));

	        sc.close();
	    }
	}
