// Program to calculate the area and circumference of a circle
package first_project;

import java.util.Scanner;

public class Question11 {
	public static void main (String args[]) {
		final double pie = 3.14159;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your radius");
		double radius = sc.nextDouble();
		System.out.println("Area " + (pie * radius * radius) +"\n"  + "Circumference  : " + (2 * pie * radius) );
	}
}
