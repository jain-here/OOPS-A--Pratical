// Program to demonstrate the use of the final keyword
package first_project;

import java.util.Scanner;

public class Question12 {

	public static void main(String[] args) {
		final double pie = 3.14159;
		// pie = 12; // This will cause an error because pie is a final variable
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your radius");
		double radius = sc.nextDouble();
		System.out.println("Area " + (pie * radius * radius) +"\n"  + "Circumference  : " + (2 * pie * radius) );
	}
}