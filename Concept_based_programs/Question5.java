// Program to convert a character to its ASCII value
package first_project;
import java.util.Scanner;

public class Question5 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a character: ");
	        char c = sc.next().charAt(0);

	        int ascii = (int) c; // Convert char to ASCII (int)
	        System.out.println("Character: " + c);
	        System.out.println("ASCII Value: " + ascii);
	        System.out.println("As Integer: " + ascii); // Same as ASCII

	        sc.close();
	    }
	}

