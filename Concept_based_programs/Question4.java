// Program to demonstrate narrowing type casting
package first_project;
import java.util.Scanner;

public class Question4 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a double value: ");
	        double d = sc.nextDouble();
	        int i = (int) d; // Narrowing: double to int (explicit cast)

	        System.out.println("Double: " + d);
	        System.out.println("Int: " + i);

	        sc.close();
	    }
	}
