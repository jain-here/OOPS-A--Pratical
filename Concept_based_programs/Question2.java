// Program to take student details as input and display them
package first_project;

import java.util.Scanner;
public class Question2 {

	public static void main(String[] args) {
		
		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter name: ");
		        String name = sc.nextLine();
		        
		        System.out.print("Enter roll number: ");
		        int roll = sc.nextInt();
		        
		        System.out.print("Enter age: ");
		        int age = sc.nextInt();
		        
		        System.out.print("Enter gender  ");
		        char gender = sc.next().charAt(0);
		        
		        System.out.print("Enter percentage: ");
		        double percentage = sc.nextDouble();

		        // Display using formatted output
		        System.out.printf("\nStudent Details:%n");
		        System.out.printf("Name: %s%n", name);
		        System.out.printf("Roll Number: %d%n", roll);
		        System.out.printf("Age: %d%n", age);
		        System.out.printf("Gender: %c%n", gender);
		        System.out.printf("Percentage: %.2f%%%n", percentage);

		        sc.close();
		    }
}
