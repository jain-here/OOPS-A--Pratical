// Program to calculate the average of three numbers
package first_project;
import java.util.Scanner;

public class Question7 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter three numbers: ");
	        double a = sc.nextDouble();
	        double b = sc.nextDouble();
	        double c = sc.nextDouble();

	        double average = (a + b + c) / 3.0; // Single expression
	        System.out.printf("Average: %.2f%n", average);

	        sc.close();
	    }
	}
