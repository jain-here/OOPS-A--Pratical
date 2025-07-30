package first_project;

import java.util.Scanner;



public class Question11 {
	public static void main (String args[]) {
		
		final double pie = 3.14159;   // final variable by the name of "pie" is declared he
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter your radius");
		
		
		double radius = sc.nextDouble();
		
		System.out.println("Area " + (pie * radius * radius) +"\n"  + "Circumference  : " + (2 * pie * radius) );
		
		
	}
}
